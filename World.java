public class World{
	
	public ArrayList<Zone> TheZones;
	public ArrayList<Region> TheRegions;
	
	
	public World(int TileCount){
		
		this.TheZones = new ArrayList<Zone>();
		this.TheRegions = new ArrayList<Region>();
		
		for(int i = 0; i < TileCount; i++){
			new Zone(TheZones);
		}
		
		
	}
	
}