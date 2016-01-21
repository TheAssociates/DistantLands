import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import java.util.Properties;


public class Display{
	
	private Zone[][] worldMap;
	
	public Display(Zone[][] wM){
		this.worldMap = wM;
		Properties text = new Properties();
		text.setProperty("fontSize","10");
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