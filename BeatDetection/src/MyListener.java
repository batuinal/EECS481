import ddf.minim.AudioListener;
import ddf.minim.AudioSource;
import ddf.minim.analysis.BeatDetect;

public class MyListener implements AudioListener {

	BeatDetection myMain=null;
	BeatDetect beat;
	float kickSize, snareSize, hatSize;
	AudioSource as;
	long time=0;
	int sensitivity=300; // how many time to wait between beats in ms
	String onda="";

	long startTime = 0;
	long lastTime = 0;
	long diff = 3000;
	
	public MyListener() {
		super();
	// TODO Auto-generated constructor stub
	}

	public MyListener(BeatDetection myMain,AudioSource as) {
		super();
		this.myMain=myMain;
		beat = new BeatDetect(as.bufferSize(), as.sampleRate());
		beat.setSensitivity(sensitivity);
		beat.detectMode(beat.SOUND_ENERGY);
	
		this.as=as;
		kickSize = snareSize = hatSize = 16;
		time=System.currentTimeMillis();
		startTime = System.currentTimeMillis();
	}

	@Override
	public void samples(float[] samp) {

		// for(int i=0;i<samp.length;i++){
		// onda+=samp[i];
		// }
		//
		beat.detect(samp);
		if(System.currentTimeMillis()-time>sensitivity){
			// if(beat.isHat()){
			// System.out.println(ÒHA TÓ);
			// }
			if(beat.isOnset()){
				time=System.currentTimeMillis();
//				if(time - lastTime > diff){
//				System.out.println(time);
//				System.out.println("BEAT2");					
//				}
				lastTime = time;
			}
			if(beat.isKick()){
				time=System.currentTimeMillis();

				System.out.println("kick");
			}

			// if(beat.isSnare()){
			// System.out.println(ÒSNAREÓ);
			// }
			// for(int i=0;i<1;i++){
			System.out.println();

			// }
		}

	}

	@Override
	public void samples(float[] sampL, float[] sampR) {
		//myMain.draw();
		// String tmp=ÓÓ;
		// for(int i=0;i<sampL.length;i++){
		// onda+=sampL[i]+Ó,Ó;
		// }
		// System.out.println(onda);
		// System.out.println(System.currentTimeMillis()-time);

		// System.out.println(ÒMEAN : Ò+mean(sampL));
		beat.detect(sampL);
		if(System.currentTimeMillis()-time>sensitivity){
			// if(beat.isHat()){
			// System.out.println(ÒHATÓ);
			// }
			if(beat.isOnset()){
				time=System.currentTimeMillis();
				System.out.println(time - startTime);
//				System.out.println("BEATz");
				onda+="beat";
			}
			if(beat.isKick()){
				time=System.currentTimeMillis();

				System.out.println("kick");
			}

			// if(beat.isSnare()){
			// System.out.println(ÒSNAREÓ);
			// }
			// for(int i=0;i<1;i++){
//			System.out.println();

			// }

		}

	}

	public static float mean(float[] p) {
		float sum = 0; // sum of all the elements
		for (int i=0; i<p.length; i++) {
			sum += p[i];
		}
		return sum / p.length;
	}

}