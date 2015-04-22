/**
  * This sketch demonstrates how to use the BeatDetect object song SOUND_ENERGY mode.<br />
  * You must call <code>detect</code> every frame and then you can use <code>isOnset</code>
  * to track the beat of the music.
  * <p>
  * This sketch plays an entire song, so it may be a little slow to load.
  * <p>
  * For more information about Minim and additional features, 
  * visit http://code.compartmental.net/minim/
  */
  
import ddf.minim.*;
import ddf.minim.analysis.*;

Minim minim;
AudioPlayer song;
BeatDetect beat;
long time;
long last;
long lastDiff;
boolean printed;
float eRadius;

void setup()
{
  size(200, 200, P3D);
  printed = false;
//  print(System.currentTimeMillis()-time + "\n");  
  minim = new Minim(this);
  song = minim.loadFile("/Users/jayvir/Dev/GUI/songs/medium/Who Let The Dogs Out.mp3", 2048);
  song.play();
  // a beat detection object song SOUND_ENERGY mode with a sensitivity of 10 milliseconds
  beat = new BeatDetect();
  beat.setSensitivity(100);
  time = System.currentTimeMillis();
//  beat.setSoundEnergy(100);
  
  ellipseMode(RADIUS);
  eRadius = 20;
//  print(System.currentTimeMillis()-time + "\n");  
}

void draw()
{
  background(0);
//  if(!printed){ 
//    print("first: " + (System.currentTimeMillis()-time)+ "\n");  
//    printed = true;
//  }
  
  beat.detect(song.mix);
  float a = map(eRadius, 20, 80, 60, 255);
  fill(60, 255, 0, a);
  if ( beat.isOnset() ) {
    eRadius = 80;
    last = System.currentTimeMillis()-time;
//    print(System.currentTimeMillis()-time + "\n");
  }
  ellipse(width/2, height/2, eRadius, eRadius);
  eRadius *= 0.95;
  if ( eRadius < 20 ) {
    eRadius = 20;
  } 
}

void keyPressed(){
  print(System.currentTimeMillis()-time + "\n");
}
