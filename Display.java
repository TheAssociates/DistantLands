import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import java.util.Properties;


public class Display{
	
	private Zone[][] worldMap;
	private World theWorld;
	
	public Display(Zone[][] wM){
		this.worldMap = wM;
		Properties text = new Properties();
		text.setProperty("fontSize","10");
		text.setProperty("font", "DEFAULT");
		WSwingConsoleInterface csi = null;
		try{
			csi = new WSwingConsoleInterface(theWorld.name, text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		
		
		int x = 3;
		int y = 3;
		boolean stop = false;
		
		String[][] overlaybackup = zoneToString(worldMap);
		
		String[][] overlay = overlaybackup;
		
		
		printArray(csi,3,3,zoneToString(worldMap),CSIColor.BLACK,zoneToBColor(worldMap));
		
		
		while(!stop){
			csi.cls();
			overlay[x][y] = "X";
			printArray(csi,3,3,overlay,CSIColor.BLACK,zoneToBColor(worldMap));
			csi.refresh();
			overlay = overlaybackup;
			CharKey dir = csi.inkey();
			if(dir.isUpArrow()&& (y-1 >= 0)){
				y--;
			}
			if(dir.isDownArrow() && (y+1 < 25)){
				y++;
			}
			if(dir.isLeftArrow() && (x-1 >= 0)){
				x--;
			}
			if(dir.isRightArrow() && (x+1 < 80)){
				x++;
			}
			if(dir.code == CharKey.Q){
				stop = true;
			}
		}
		System.exit(0);
		
	}
	
	public void printArray(WSwingConsoleInterface csi, int xUpL, int yUpL, String[][] strings, CSIColor FColor, CSIColor[][] BColor){
		for(int i = 0; i < worldMap.length; i++){
			for(int j = 0; j < worldMap.length; j++){
				csi.print( xUpL + i , yUpL + j , strings[i][j] , FColor ,BColor[i][j] );
			}
		}
	}
 	
	public CSIColor[][] zoneToBColor(Zone[][] map){
		CSIColor[][] output = new CSIColor[map.length][map.length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				switch(map[i][j].biome){
					case SEA : output[i][j] = CSIColor.BLUE; break;
					case COAST: output[i][j] = CSIColor.YELLOW;break;
					case PLAIN : output[i][j] = CSIColor.LIGHTGREEN;break;
					case DESERT : output[i][j] = CSIColor.TAN;break;
					case FOREST : output[i][j] = CSIColor.OLIVE;break;
					case JUNGLE : output[i][j] = CSIColor.GREEN;break;
					case HILL : output[i][j] = CSIColor.BROWN;break;
					case MOUNTAIN : output[i][j] = CSIColor.GRAY;break;
					case TUNDRA : output[i][j] = CSIColor.WHITE;break;
					case TAIGA : output[i][j] = CSIColor.STEEL_BLUE;break;
					default : output[i][j] = CSIColor.BLACK; break;
				}
			}
		}
		return output;
	}
	
	public String[][] zoneToString(Zone[][] map){
		String[][] output = new String[map.length][map.length];
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map.length; j++){
				output[i][j] = " ";
			}
		}
		return output;
	}
	
	
	
	
	
	
	
	
	public static void main(String[]args){
		//makes the window
		Properties text = new Properties();
		text.setProperty("fontSize","30");
		text.setProperty("font", "DEFAULT");
		WSwingConsoleInterface csi = null;
		try{
			csi = new WSwingConsoleInterface("COLOR TEST", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		csi.print(0,0,"Call me Frankenstein, bitches",CSIColor.BLUE,CSIColor.WHITE);
	}
	
	
	
	
}