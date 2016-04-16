import java.util.*;
import java.io.*;

public class Zone{
	
	public Biome biome;
	public ArrayList<Attribute> features;
	public int spiralLoc;
	public int[] relLoc;
	public Region region;
	public ArrayList<Zone> theList;
	public UmalHandler sph;
	
	public Zone(ArrayList<Zone> theList, UmalHandler sph1){
		this.sph = sph1;
		this.theList = theList;
		this.features = new ArrayList<Attribute>();
		this.spiralLoc = theList.size();
		this.relLoc = sph.spTC(this.spiralLoc);
		this.biome = Biome.ranBiome(DistantLands.rand,this);
		
		if(spiralLoc == 0){
			this.biome = Biome.SEA;
			System.out.println("DEFAULT SEA");
		}
		
		theList.add(this);
		
	}
	
	public String toString(){
		return ""+biome + " " + spiralLoc + " " + Arrays.toString(relLoc);
	}
	
	
	
	private static final int[] relLocToAbsLoc(int[] relLoc, int[] origin){
		int[] out = new int[2];
		out[0] = relLoc[0] + origin[0];
		out[1] = relLoc[1] + origin[1];
		return out;
		
	}
	
	public static final Zone[][] spiralToArray(ArrayList<Zone> finishedList){
		int sideLen = (int)Math.sqrt(nextSquare(finishedList.size())) + 2;
		System.out.println("SideLen: " + sideLen);
		System.out.println("fL: " + finishedList.size());
		System.out.println("nxtSqr " + nextSquare(finishedList.size()));
		Zone[][] out = new Zone[sideLen][sideLen];
		int[] origin = {sideLen/2 + 1,sideLen/2 + 1};
		int[] locdat = new int[2];
		for(Zone x : finishedList){
			locdat = relLocToAbsLoc(x.relLoc,origin);
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
				temp.add(this.theList.get(sph.cTSP(x.go(sph.spTC(this.spiralLoc)))));
			} catch(Exception e){
				
			}
				
			
		}
		Zone[] typecast = new Zone[0];
		Zone[] out = temp.toArray(typecast);
		if(out.length == 0){System.out.println("NO NEIGHBORS");}
		return out;
	}
	
	
	private static int nextSquare(int x){
		int j = 0;
		for(int i = 1; i*i < x; i++){
			j = i;
		}
		j++;
		return j*j;
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

	
	
	
}