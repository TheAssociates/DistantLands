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
		this.relLoc = theList.get(theList.size()-1).relLoc;
		int ls = lastSquare(spiralLoc);
		theList.add(this);
		
		if( ls % 2 == 0){
			if(spiralLoc < ls + Math.sqrt(ls)){
				this.relLoc = Dir.EAST.go(relLoc);
			}
			else {
				this.relLoc = Dir.NORTH.go(relLoc);
			}
		}
		if(lastSquare(spiralLoc) % 2 == 1){
			if(spiralLoc < ls + Math.sqrt(ls)){
				this.relLoc = Dir.WEST.go(relLoc);
			}
			else {
				this.relLoc = Dir.SOUTH.go(relLoc);
			}
		}
		
		
	}
	
	private static final int lastSquare(int num){
		int out = 0;
		while(num < out*out){
			out++;
		}
		--out;
		return out*out;
	}
	
	private static final int nextSquare(int num){
		int out = 0;
		while(num < out*out){
			out++;
		}
		return out*out;
	}
	
	private static final int[] relLocToAbsLoc(int[] relLoc, int[] origin){
		int[] out = new int[2];
		out[0] = relLoc[0] + origin[0];
		out[1] = relLoc[1] + origin[1];
		return out;
		
	}
	
	public static final Zone[][] spiralToArray(ArrayList<Zone> finishedList){
		int sideLen = (int)Math.sqrt(nextSquare(finishedList.size()));
		Zone[][] out = new Zone[sideLen][sideLen];
		int[] origin = {sideLen/2 + 1,sideLen/2 + 1};
		Arrays.fill(out,null);
		int[] locdat = new int[2];
		for(Zone x : finishedList){
			locdat = relLocToAbsLoc(x.relLoc,origin);
			out[locdat[0]][locdat[1]] = x; 
		}
		return out;
	}
	
}