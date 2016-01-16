import java.util.*;
import java.io.*;

public class Zone{
	
	public Biome biome;
	public ArrayList<Attribute> features;
	public int spiralLoc;
	public int[] relLoc;
	
	public Zone(ArrayList<Zone> theList){
		this.features = new ArrayList<Attribute>();
		this.spiralLoc = theList.size();
		theList.add(this);
		
	}
	
	private int lastSquare(int num){
		int out = 0;
		while(num < out*out){
			out++;
		}
		--out;
		return out*out;
	}
	
	
}