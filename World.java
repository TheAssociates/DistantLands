import java.util.*;
import java.io.*;

public class World{
	
	public ArrayList<Zone> TheZones;
	public ArrayList<Region> TheRegions;
	public String name;
	public UmalHandler sph;
	
	
	public World(int TileCount){
		
		this.TheZones = new ArrayList<Zone>();
		this.TheRegions = new ArrayList<Region>();
		this.name = "A World";
		this.sph = new UmalHandler(TileCount);
		for(int i = 0; i < TileCount; i++){
			new Zone(TheZones,sph);
		}
		
		
		
	}
	
	
	
}