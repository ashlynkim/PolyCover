
public class Points {

	  private int x; 
	  private int y;
	  
	public Points(int x, int y){
		this.x = x; 
		this.y = y;
	}
	
	Points(){};
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	} 
	
	public String toString(){
		return "("+x+","+y+")";
	}
}
