import net.slashie.libjcsi.CSIColor;
import java.util.*;
import java.io.*;

public enum Biome{
	
	SEA  ("ALL 0 SEA 8 COAST 2"),
	COAST ("ALL 1 COAST 2 SEA 5"),
	PLAIN ("ALL 1 PLAIN 5 SEA 0"),
	DESERT ("ALL 1 DESERT 5 SEA 0"),
	FOREST ("ALL 1 FOREST 3 SEA 0"),
	JUNGLE ("ALL 1 SEA 0 JUNGLE 3"),
	HILL ("ALL 1 SEA 0 HILL 5 MOUNTAIN 2"),
	MOUNTAIN ("ALL 1 MOUNTAIN 5 HILL 2"),
	TUNDRA ("ALL 0 MOUNTAIN 1 TUNDRA 8 TAIGA 3 COAST 1"),
	TAIGA ("ALL 0 MOUNTAIN 1 TUNDRA 4");
	
	private HashMap<String,Integer> NeighborChance;
	

	
	Biome(String ChanceList){
		String[] biomes = { "SEA","COAST","PLAIN","DESERT","FOREST","JUNGLE","HILL","MOUNTAIN","TUNDRA","TAIGA"};
		Scanner chances = new Scanner(ChanceList);
		this.NeighborChance = new HashMap<String,Integer>();
		String temp = "";
		int temp1 = 0;
		while(chances.hasNext()){
			temp = chances.next();
			temp1 = chances.nextInt();
			if(temp.equals("ALL")){
				for(String x : biomes){
					NeighborChance.put(x,new Integer(temp1));
				}
			}
			else{
				NeighborChance.put(temp,new Integer(temp1));
			}
		}
	}
	
	public static Biome trueRanBiome(Random rand){
		return Biome.values()[DistantLands.random(rand,0,Biome.values().length-1)];
	}
	
	public static Biome ranBiome(Random rand,Zone y){
		ArrayList<String> temp = new ArrayList<String>();
		int t = 0;
		try{
			for(Zone x : y.neighbors()){
				HashMap<String,Integer> tmap = x.biome.getNC();
				for(String z : tmap.keySet()){
					t = tmap.get(z);
					for(int i = 0; i < t; i++){
						temp.add(z);

					}
				}
				
			}
			String out = temp.get(DistantLands.random(rand,0,temp.size()-1));
			return valueOf(out);
		} catch (IndexOutOfBoundsException g){
			System.out.println("DEFAULTING TO TRUE RANDOM");
			return trueRanBiome(rand);
		}
		
	}
	
	
	public HashMap<String,Integer> getNC(){
		return NeighborChance;
	}
	
	//get Final fields below

	
	
	
	//utility 
}