import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.CSIColor;
import java.util.Properties;


public class Display{
	
	public static void main(String[]args){
		
		//makes the window
		Properties text = new Properties();
		text.setProperty("fontSize","10");
		text.setProperty("font", "DEFAULT");
		ConsoleSystemInterface csi = null;
		
		try{
			csi = new WSwingConsoleInterface("COLOR TEST", text);
		}
		catch (ExceptionInInitializerError eiie) {
			System.out.println("*** Error: Swing Console Box cannot be initialized. Exiting...");
			eiie.printStackTrace();
			System.exit(-1);
		}
		
		int a = 0;
		int b = 0;
		
		csi.print(0,0,"appke",CSIColor.BLUE,CSIColor.WHITE);
		
		
		
	
	}
	
	
	
	
}