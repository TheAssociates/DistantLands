import java.util.*;
import java.io.*;

public class DistantLands{
	
	public static void main(String[] args){
		
	}
	
	public static int random(Random rand,int num1,int num2){  //returns a random value between num1 and num2 (inclusive)
		return(num1 -1 + (int)Math.ceil(rand.nextDouble()*(num2-num1+1)));
	}
	
	
}