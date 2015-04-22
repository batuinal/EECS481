package guiDesign;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Vector;


/**
 * @author Dancing with Ara EECS481 - Group 4 Ruifu Zhang, Raj Vir, Oliver Tang, Batu Inal
 */
//dev/tty.*

public class Serial implements SerialPortEventListener, Runnable {
  
    public static class Global {
        
         //   public int[] data = new int[100];
            public static int data = -99;
            
        }
  

    SerialPort serialPort = null;

    private static final String PORT_NAMES[] = { 
        "/dev/tty.usbmodem", // Mac OS X
        "/dev/tty.usbserial-A8008Ifx",
        "/dev/tty.usbserial-A8008HtU",
        "COM0",
        "COM1",
        "COM2",
        "COM3",
        "COM4",
        "COM5",
        "COM6",
        "COM7",
        "COM8",
        "COM9",
        "COM10",
        "COM11",
        "COM12",
        
//        "/dev/usbdev", // Linux
//        "/dev/tty", // Linux
//        "/dev/serial", // Linux
        "COM3", // Windows
    };
    
    private String appName;
    private BufferedReader input;
    private OutputStream output;
    private static int gridnumTap;
    private static int strengthTap;
    
    private static final int TIME_OUT = 1000; // Port open timeout
    private static final int DATA_RATE = 9600; // Arduino serial port

    public boolean initialize() {
        try {
            CommPortIdentifier portId = null;
            Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

            // Enumerate system ports and try connecting to Arduino over each
            //
            System.out.println( "Trying:");
            while (portId == null && portEnum.hasMoreElements()) {
                // Iterate through your host computer's serial port IDs
                //
                CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
                System.out.println( "   port" + currPortId.getName() );
                for (String portName : PORT_NAMES) {
                    if ( currPortId.getName().equals(portName) 
                      || currPortId.getName().startsWith(portName)) {

                        // Try to connect to the Arduino on this port
                        //
                        // Open serial port
                        serialPort = (SerialPort)currPortId.open(appName, TIME_OUT);
                        portId = currPortId;
                        System.out.println( "Connected on port" + currPortId.getName() );
                        break;
                    }
                }
            }
        
            if (portId == null || serialPort == null) {
                System.out.println("Oops... Could not connect to Arduino");
                return false;
            }
        
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);

            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

            // Give the Arduino some time
            try { Thread.sleep(2000); } catch (InterruptedException ie) {}
            
            return true;
        }
        catch ( Exception e ) { 
            e.printStackTrace();
        }
        return false;
    }
    
    private void sendData(String data) {
        try {
            System.out.println("Sending data: '" + data +"'");
            
            // open the streams and send the "y" character
            output = serialPort.getOutputStream();
            output.write( data.getBytes() );
        } 
        catch (Exception e) {
            System.err.println(e.toString());
            System.exit(0);
        }
    }

    //
    // This should be called when you stop using the port
    //
    public synchronized void close() {
        if ( serialPort != null ) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    //
    // Handle serial port event
    //
    public synchronized void serialEvent(SerialPortEvent oEvent) {
        //System.out.println("Event received: " + oEvent.toString());
      
      //int i = 0;
        try {
            switch (oEvent.getEventType() ) {
                case SerialPortEvent.DATA_AVAILABLE: 
                    if ( input == null ) {
                        input = new BufferedReader(
                            new InputStreamReader(
                                    serialPort.getInputStream()));
                    }
                    String inputLine = input.readLine();
                    //System.out.println(inputLine);
                   
                    Global.data = Integer.parseInt(inputLine);
                   // Globals.data[i & 100] = Integer.parseInt(inputLine);
                   // ++i;
                    break;

                default:
                    break;
            }
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public Serial() {
        appName = getClass().getName();
    }
    
    
    public void run() {
        Serial test = new Serial();
       
        if ( test.initialize() ) {
          //WRITE THE MAIN HERE
            while(true){
              int inputline_Int = Global.data;
              gridnumTap = -1;
              if(inputline_Int > 0){
                gridnumTap = inputline_Int / 10;
                strengthTap = inputline_Int % 10;
                System.out.println(strengthTap);
              }
              //System.out.println(Serial.gridnumTap+ " " +Animation.arrow.getgridNum());
              if((gridnumTap == Animation.getgirdNum_HoldOn()) && (Animation.getScorestatus() == true)){//Animation.arrow.getgridNum()){
                if(strengthTap == 0 && Animation.getgridColor_HoldOn().equals("green")){
                  Game.updateScore(50);
                }else if(strengthTap == 1 && Animation.getgridColor_HoldOn().equals("yellow")){
                  Game.updateScore(50);
                }else if(strengthTap == 2 && Animation.getgridColor_HoldOn().equals("red")){
                  Game.updateScore(50);
                }else if(strengthTap == 0 && Animation.getgridColor_HoldOn().equals("yellow")){
                  Game.updateScore(20);
                }else if(strengthTap == 1){
                  Game.updateScore(20);
                }else if(strengthTap == 2 && Animation.getgridColor_HoldOn().equals("yellow")){
                  Game.updateScore(20);
                }else{
                  Game.updateScore(20);
                }
                Animation.updategetScore(false);
              }
              Game.updateScoreboard();
            }
            
        }

        // Wait 5 seconds then shutdown
        //try { Thread.sleep(2000); } catch (InterruptedException ie) {}
    }
}