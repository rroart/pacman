package roart.pacman.game;

public interface Constants {
	int I61440 = 61440;
	int I4095 = 4095;
	int I1000 = 1000;
	int I400 = 400;
	int I600 = 600;
	int I800 = 800;
	int I250 = 250;
	int I50 = 50;
	int I32 = 32;
	int I25 = 25;
	int I20 = 20;
	int I17 = 17;
	int I16 = 16;
	int I14 = 14;
	int I13 = 13;
	int I11 = 11;
	int I10 = 10;
	int I8 = 8;
	int I7 = 7;
	int I5 = 5;
	int I4 = 4;
	int BONUS_SCORE = 5000;
	int START_LIVES = 3;
	int BONUS_DEC = 5;
	int START_GHOSTS = 4;
	int GHOSTS_DIV = 4;
	//number of ghosts and initial coodinates for all
	int GHOSTS = 8;
	int[] GHOSTX = new int[] { 15, 17, 15, 17, 15, 17, 15, 17 };
	int[] GHOSTY = new int[] { 9, 9, 11, 11, 9, 9, 11, 11 };
	/*
	int GHOST1X = 15;
	int GHOST1Y = 9;
	int GHOST2X = 17;
	int GHOST2Y = 9;
	int GHOST3X = 15;
	int GHOST3Y = 11;
	int GHOST4X = 17;
	int GHOST4Y = 11;
	*/
	int PACX = 16;
	int PACY = 17;
	int BONUSX = 16;
	int BONUSY = 15;
	int LEVELS = 16;
	int SUPERTIME = 50;	//the time pacman is super after eating superfood
	int DEADTIME = 25;	//the time a ghost stays dead
	int BONUSTIME = 50;	//the time the bonus is available
	int FOODSCORE = 10;	//the score you get for eating food
	int GHOSTSCORE = 100;	//the score you get for the first ghost you eat
	int BONUSSCORE = 1000;	//the score you get when you eat each bonuspoint
}