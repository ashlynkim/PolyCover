import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class PTR {
	

	private ArrayList<Points> sourceArray; 
	private ArrayList<Rectangle> recArray; 
	int sourceArraySize=0; 
	
	PTR(ArrayList<Points> sourceArray){
		this.setSourceArray(sourceArray); 
		this.sourceArraySize= sourceArray.size();
		
	}

	public ArrayList<Points> getSourceArray() {
		return sourceArray;
	}

	public void setSourceArray(ArrayList<Points> sourceArray) {
		this.sourceArray = sourceArray;
	}
	
	public ArrayList<Rectangle> getRecArray() {
		return recArray;
	}

	public void setRecArray(ArrayList<Rectangle> recArray) {
		this.recArray = recArray;
	}
	
	public void updateSourceArraySize(int size){
		this.sourceArraySize = size;
	}
	
	
// PTR find points Pk, Pl, Pm

//utils - update the sourceArray
private boolean removeFromArrayList(Points pp){
	boolean returnFlag = false; 
	
	Iterator<Points> it = this.sourceArray.iterator();
	while (it.hasNext()) {
		Points p = it.next();
	  if ((int)p.getX() == (int)pp.getX() && ((int)p.getY() == (int)pp.getY() ) ) {
	    it.remove();
	  //update the ArraySize variable	   
	    updateSourceArraySize(sourceArray.size());	  
	    returnFlag=true;
	    break; // assuming there are no duplicates
	  }
	  else
		  returnFlag= false; 
	}	
	return returnFlag; 
}

private void addToArrayList(Points pp){
	boolean found=false; 
	
	Iterator<Points> it = sourceArray.iterator();
	while (it.hasNext()) {
		Points p = it.next();
	  if (((int)p.getX() == (int)pp.getX()) && ((int)p.getY() == (int)pp.getY() ) ) {
	      found=true;
	      // need to remove from arraysource
	      removeFromArrayList(pp);
		  break;
	  }
	 
	}
	if(!found){
	
	 sourceArray.add(pp); 
	 
	 //update the ArraySize variable	
	  updateSourceArraySize(sourceArray.size());	
	}
	
}

private int findMinX(int Y){
	ArrayList<Integer> tempList = new ArrayList<Integer>(); 
	Iterator<Points> it = sourceArray.iterator();

	while (it.hasNext()) {
		Points p = it.next();
	  if ((int)p.getY() == Y) {
	   //add to tempArray
		  tempList.add(p.getX());
	  }	 
	}
	int tempArrayX[] = new int[tempList.size()];
	for(int j=0; j< tempList.size(); j++){			
		tempArrayX[j]=tempList.get(j);
	}
			
	//sort to find min of y
	Arrays.sort(tempArrayX);
	
	return tempArrayX[0];
	
}

private int findMinY(int X1, int X2){ // given a range of X
	ArrayList<Integer> tempList = new ArrayList<Integer>(); 
	Iterator<Points> it = sourceArray.iterator();

	//swap values of x if x2<x1 -- failsafe method in case 
	int temp=X1; 
	if(X1>X2){
		X1=X2; 
		X1=temp;
	}
	
	while (it.hasNext()) {
		Points p = it.next();
	  if ((int)p.getX() >= X1 && (int)p.getX()< X2) {
	   //add to tempArray
		  tempList.add(p.getY());
	  }	 
	}
	int tempArrayY[] = new int[tempList.size()];
	for(int j=0; j< tempList.size(); j++){			
		tempArrayY[j]=tempList.get(j);
	}
			
	//sort to find min of y
	Arrays.sort(tempArrayY);
	
	return tempArrayY[0];
}
//-------------------------------------------------------------------------	
// Pk finds the leftmost of the lowest point of Y sourceArray
	
	public Points findPk(){
		Points pointsPk; 
		
		int tempArrayX[] = new int[sourceArray.size()]; 
		int tempArrayY[] = new int[sourceArray.size()]; 
		int minX=0; 
		int minY=0; 
		int pointXk=0; 
		int pointYk=0;
		
		//array for y 
		for(int j=0; j< sourceArray.size(); j++){			
			tempArrayY[j]=sourceArray.get(j).getY();
		}
				
		//sort to find min of y
		Arrays.sort(tempArrayY);
		minY = tempArrayY[0];
		
		//array for x
		for(int j=0; j< sourceArray.size(); j++){
			tempArrayX[j]=sourceArray.get(j).getX();
			
		}
		//sort to find min of x
		Arrays.sort(tempArrayX);
		minX = tempArrayX[0];
		
		
		// find the pair with the minimum Y
		Iterator<Points> it = sourceArray.iterator();
		while (it.hasNext()) {
			Points p = it.next();
		  // get the smallest points with minX, pointYl
			if ( ((int)p.getY() == minY) && (int)p.getX()== findMinX(minY)  ) { // retrieve the smallest value near minX
				pointXk = p.getX();
				pointYk = p.getY();
			  break; // stop iterator once the minimum x has been found
		  }	
		}
		
		
		pointsPk= new Points(pointXk, pointYk);
		
	    removeFromArrayList(pointsPk);
		
		return pointsPk; 
	}
	
	// Pl finds the leftmost of the lowest point in sourceArray	
	public Points findPl(int Yk){
		Points pointsPl; 
		
		int tempArrayX[] = new int[sourceArray.size()]; 		
		int pointXl=0; 
		int pointYl=Yk; //the previous minY in findPk
		int minX=0; 
		
		
		//array for x
		for(int j=0; j< sourceArray.size(); j++){
			tempArrayX[j]=sourceArray.get(j).getX();
			
		}
		//sort to find min of x
		Arrays.sort(tempArrayX);
		minX = tempArrayX[0];
		
		
		Iterator<Points> it = sourceArray.iterator();
		while (it.hasNext()) {
			Points p = it.next();
		  // get the smallest points with minX, pointYl
			if ( ((int)p.getY() == Yk) && (int)p.getX()>= minX  ) { // retrieve the smallest value near minX
			  pointXl=p.getX();
			  break; // stop iterator once the minimum x has been found
		  }	
		}
		
		pointsPl= new Points(pointXl, pointYl);
		
		removeFromArrayList(pointsPl);
		
		return pointsPl; 		
		
	}
	
	// Pm finds the leftmost of the lowest point in sourceArray with the min Y 
	// values greater than Yk and with X coordinates in the range between Xk and Xl
	
	public Points findPm(int Xk, int Xl, int Yk){
		Points pointsPm; 
		int pointXm=0;
		int pointYm=0;
		int tempArrayY[] = new int[sourceArray.size()]; 	
		int minY=0; 
		
		//need to sort Y values in sourceArray to find the first min value > Yk
		//array for y 
				for(int j=0; j< sourceArray.size(); j++){			
					tempArrayY[j]=sourceArray.get(j).getY();
				}
						
				//sort to find min of y
				Arrays.sort(tempArrayY);
				minY = tempArrayY[0];
				
		Iterator<Points> it = sourceArray.iterator();
		while (it.hasNext()) {
			Points p = it.next();
		  // get Xk<= Xm < Xl  && get Ym > Yk but Ym must be the lowest Y value within Xk -- Xl
		//	if ( ((int)p.getX() >= Xk && ((int)p.getX() < Xl )) && (int)p.getY() > Yk ) {
			if((int)p.getY() == findMinY(Xk,Xl )){
			  pointXm=p.getX();
			  pointYm= p.getY();
			  break; //stops when the first minimum points are retrieved
		  }	
		  
		}
		
		pointsPm= new Points(pointXm, pointYm);
		
		return pointsPm; 	
	}
	//processor Method
	void startPTR(){
		int widthRect=0;
		int heightRect=0; 
		int iteration=1; 
		
		while(this.sourceArraySize>0){
			
			System.out.println("Iteration: "+ iteration);
			System.out.println("Array: "+ sourceArray.toString());
			//need to store Pk, Pl and Pm values
			Points Pk = findPk(); //leftDown coords of Rectangle
			Points Pl = findPl(Pk.getY());  //rightDown coords of Rectangle
			Points Pm = findPm(Pk.getX(), Pl.getX(), Pk.getY()); 
			
		
			System.out.println("Pk: "+ Pk.toString()); 
			System.out.println("Pl: "+ Pl.toString()); 
			System.out.println("Pm: "+ Pm.toString()); 
			
			//Find the other two upper coordinate sets of the rectangle 
			widthRect= Pl.getX()- Pk.getX();
			heightRect= Pm.getY() - Pk.getY(); 
			
		
			
			Points upLeft = new Points(Pk.getX(), Pk.getY()+heightRect);
			Points upRight = new Points(Pl.getX(), Pl.getY()+heightRect);
			
			//update the sourceArray by adding new points if not already there
			addToArrayList(upLeft); 
			addToArrayList(upRight); 
			System.out.println("Rectangle coordinates: ("+Pk.toString()+"),("+Pl.toString()+"),("+upLeft+"),("+upRight+")");
			iteration++;
		}
	}
	
	
	
}
