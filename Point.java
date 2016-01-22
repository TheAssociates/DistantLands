//Screw You, ADAM

public class Point{
	
	private int X;
	private int Y;
	
	public Point(int x, int y){
		this.X = x;
		this.Y = y;
		
	}
	
	public  void translate(int x,int y){
		X = X + x;
		Y = Y + y;
	}
	
	public  int getX(){
		return X;
	}
	
	public  int getY(){
		return Y;
	}
	
	public  void setXY(int x, int y){
		Y = y;
		X = x;
	}
	
}