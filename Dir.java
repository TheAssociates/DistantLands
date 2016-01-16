import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public enum Dir { //direction enumerator class 
	//the directions and their corresponding coridinate change in (y,x) starting from the upper left
	NORTH (1,0), SOUTH (-1,0), EAST (0,1), WEST (0,-1);
	
	private final int deltaY;
	private final int deltaX;
	
	Dir(int dY, int dX){
		this.deltaY = dY;
		this.deltaX = dX;
	}
	
	int[] go(int[] loc0){ //returns the location that is in the cardinal direction;
		int[] loc1 = new int[2];
		loc1[0] = loc0[0] + this.deltaY;
		loc1[1] = loc0[1] + this.deltaX;
		return loc1;
	}
}