import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import ddf.minim.AudioInput;
import ddf.minim.AudioMetaData;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.BeatDetect;

public class BeatDetection {
	
	Minim minim;
	static AudioPlayer player;
	static AudioInput input;
	AudioMetaData meta;
	BeatDetect beat;
	boolean mic=false;
	MyListener ml;
	String filename="/Users/jayvir/Downloads/happy.wav";
				
	public BeatDetection(){
		System.out.println("test");
	}

    public static void main(String argv[]) throws IOException {
    	
		System.out.println("test2"); 
		BeatDetection mainclass = new BeatDetection();
		mainclass.setup();

    }
    
	public void setup() {
		Minim minim= new Minim(this);

		if(mic){
			input = minim.getLineIn(Minim.MONO);
			ml = new MyListener(this, input);
			input.addListener(ml);
		}
		else{
			player= minim.loadFile(filename);
			player.play();
			ml= new MyListener(this, player);
			player.addListener(ml);
		}

	}

	public void stop() {
		player.close();

		minim.stop();

	}

	public void draw() {// this function is never called
		System.out.println("NEW DRAW");
	}

	public String sketchPath(String fileName) {
		System.out.println("sketchPath: " + fileName);
		return fileName;
	}

	public InputStream createInput(String fileName) {
		System.out.println("createInput:" + fileName);
		InputStream in2;
	try {
		in2 = new FileInputStream(fileName);
		System.out.println("InputStream: created! "+ fileName);
		return in2;
	} catch (Exception ex) {
		System.out.println("Error Catch Triggered: " + ex);
		in2 = null;
	}
		return in2;
	}

}
