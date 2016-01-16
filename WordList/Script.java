import java.util.Scanner; 
import java.util.*; 
import java.io.*;

public class Script {
	
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File(args[0]);
		Scanner console = new Scanner(f);
		int i = 0;
		while(console.hasNext()){
			if(i++%4 == 0) System.out.println(console.next());
			else console.next();
			
		}
		
	}
}