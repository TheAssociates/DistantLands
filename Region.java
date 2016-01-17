public class Region {
	
	public ArrayList<Zone> region;
	public Biome biome;
	public String name;
	
	
	public Region(Zone start){
		if(start.region == null){
			this.region = new ArrayList<Zone>();
			
			start.setRegion(this);
			this.region.add(start);
			this.biome = start.biome;
			
			
			
			
		}
	}
	
	
}