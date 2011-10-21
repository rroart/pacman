package roart.pacman.game;

import java.util.Date;

public class Timing {
    private long time;
    public long getTime() {
		return time;
	}
    public void setTime(long time) {
		this.time = time;
	}
    
    public void timingstart() {			//initialize timing
	Date date = new Date();
	time = date.getTime();
    }

// ----------------

    /*synchronized*/ public void timing(boolean isSuper){         	//do timing/synchronization
	int superDiv = 1;
	if (isSuper) {
	    superDiv++;
	}
	//if (!super_) Pacman.pacexit("super zero");	//if would then be division be zero

	Date date = new Date();
	long newtime = date.getTime();
	long totalTime = newtime - time;
	while (totalTime<(Constants.I250/superDiv)) { 		//if time interval not yet used up
	    date = new Date();
	    newtime = date.getTime();
	    totalTime = newtime - time;
	}
// 	if (tot_tid<(250/super_)) { 		//if time interval not yet used up
// 	    try {
// 		wait(250/super_ - tot_tid);
// 	    } catch (Exception e) {
// 		System.out.println("Exception " + (250/super_ - tot_tid) + " " + e);
// 	    }
// 	    date = new Date();
// 	}
	time = date.getTime();
    }
}


