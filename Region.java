import java.util.*;
import java.lang.*;
import java.io.*;

public class Region {
	
	public ArrayList<Zone> region;
	public Biome biome;
	public String name;
	public int[] loc0;
	
	
	public Region(Zone start){
		if(start.region == null){
			this.region = new ArrayList<Zone>();
			
			start.setRegion(this);
			this.region.add(start);
			this.biome = start.biome;
			this.loc0 = start.relLoc;
			
			
		}
	}
	
	public defineRegion() {
		int y = loc0[0];
		int x = loc0[1];
		Arraylist<Point> used = new ArrayList<Point>();
		Point a = new Point(x,y);
		used.add(a);
		//iterate through all tiles using two arraylists to check where you are and have been
	}
}