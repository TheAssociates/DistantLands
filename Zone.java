import java.util.*;
import java.io.*;

public class Zone{
	
	public Biome biome;
	public ArrayList<Attribute> features;
	public int spiralLoc;
	public int[] relLoc;
	public Region region;
	public ArrayList<Zone> theList;
	
	public Zone(ArrayList<Zone> theList){
		
		this.features = new ArrayList<Attribute>();
		this.spiralLoc = theList.size();
		this.relLoc = spTC(this.spiralLoc);
		this.biome = Biome.ranBiome(DistantLands.rand,this);
		
		theList.add(this);
		
	}
	
	public String toString(){
		return ""+biome + " " + spiralLoc + " " + Arrays.toString(relLoc);
	}
	
	private static final int lastSquare(int num){
		int out = 0;
		while(num > out*out){
			out++;
		}
		--out;
		return out*out;
	}
	
	private static final int nextSquare(int num){
		int out = 0;
		while(num > out*out){
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
		int sideLen = (int)Math.sqrt(nextSquare(finishedList.size())) + 2;
		Zone[][] out = new Zone[sideLen][sideLen];
		int[] origin = {sideLen/2 + 1,sideLen/2 + 1};
		int[] locdat = new int[2];
		for(Zone x : finishedList){
			locdat = relLocToAbsLoc(x.relLoc,origin);
			System.out.println(x.toString());
			System.out.println(out[locdat[0]][locdat[1]]);
			out[locdat[0]][locdat[1]] = x; 
		}
		return out;
	}
	
	public final void setRegion(Region reg){
		this.region = reg;
	}
	
	public Zone[] neighbors(){
		ArrayList<Zone> temp = new ArrayList<Zone>();
		Dir[] neighborDirs = {Dir.NORTH,Dir.SOUTH,Dir.EAST,Dir.WEST};
		for(Dir x : neighborDirs ){
			
			try{
				temp.add(theList.get(cTSP(x.go(this.relLoc))));
			} catch (NullPointerException g){
				
			}
			
		}
		Zone[] typecast = new Zone[0];
		Zone[] out = temp.toArray(typecast);
		return out;
	}
	
	public static int cTSP(int[] loc){
		int ring;
		char onring;
		int base;
		int out;
		if(Math.abs(loc[0]) > Math.abs(loc[1])){
			ring = Math.abs((int)loc[0]);
			onring = 'x';
			
			if(loc[0] >= 0){
				base = loc[0]*(4*loc[0] + 3);
			} else {
				base = loc[0]*(4*loc[0] - 1);
			}
			out = base + loc[1];
				
		} else {
			ring = (int)Math.abs(loc[1]);
			onring = 'y';
			
			if(loc[1] >= 0){
				base = loc[0]*(4*loc[0] - 3);
			} else {
				base = loc[0]*(4*loc[0] + 1);
			}	
			out = base + loc[0];	
		}
		
		return out;
	}
		
	
	
	private static int largest(int[] set){
		int i = set[0];
		for(int x : set){
			if(x > i){
				i = x;
			}
		}
		return i;
	}
	
	private static int smallest(int[] set){
		int i = set[0];
		for(int x : set){
			if(x < i){
				i = x;
			}
		}
		return i;
	}
	
	
	public static int[] spTC(int n){
		Complex i = new Complex(0,1);
		int p = (int)Math.sqrt(4*n + 1);
		int q = n - (int)(p*p/4);
		
		Complex t1 = new Complex(0,1);
		for(int j = 1; j < p; j++){
			t1 = t1.times(i);
		}
		t1 = t1.times(new Complex(q,0));
		
		int t2 = (int)((p+2)/4);
		int t3 = (int)((p+1)/4);
		
		Complex t4 = (new Complex(t3,0)).times(i);
		
		Complex t5 = (new Complex(t2,0)).minus(t4);
		
		Complex t6 = new Complex(0,1);
		for(int j = 1; j < p-1; j++){
			t6 = t6.times(i);
		}
		
		Complex t7 = t5.times(t6);
		
		Complex total = t7.plus(t1);
		
		int[] out = {(int)total.im(), (int)total.re()};
		return out;
		
	}
	
	
	
}