import java.util.ArrayList;


public class Test {
	
	public static void main(String args[]){
		
		ArrayList<Points> plist = new ArrayList<Points>(); 
			
		// test data
	
	/*	plist.add(new Points(1,6));
		  plist.add(new Points(3,6));
		  plist.add(new Points(2,5));
		  plist.add(new Points(3,5)); //5
		  plist.add(new Points(2,3));
		  plist.add(new Points(4,3));
		  plist.add(new Points(1,1));
		  plist.add(new Points(4,1));
		
			plist.add(new Points(3,6));
		  plist.add(new Points(5,6));
		  plist.add(new Points(1,4));
		  plist.add(new Points(3,4)); //5
		  plist.add(new Points(1,1));
		  plist.add(new Points(5,1));
		*/  
	/*	  
	  plist.add(new Points(2,3));
	  plist.add(new Points(4,3));
	  plist.add(new Points(4,5));
	  plist.add(new Points(4,6)); //5
	  plist.add(new Points(4,8));
	  plist.add(new Points(7,5));
	  plist.add(new Points(7,6));
	  plist.add(new Points(2,1)); //1
	  plist.add(new Points(9,1));
	  plist.add(new Points(9,2)); //10
	  plist.add(new Points(12,1));
	  plist.add(new Points(12,2));
	  plist.add(new Points(14,1));
	  plist.add(new Points(14,8));
	 
	*/
		plist.add(new Points(2,1));
		plist.add(new Points(2,9));
		plist.add(new Points(5,9));
		plist.add(new Points(5,10));
		plist.add(new Points(6,1));
		plist.add(new Points(6,4));
		plist.add(new Points(7,6));
		plist.add(new Points(7,7));
		plist.add(new Points(8,2));
		plist.add(new Points(8,4));
		plist.add(new Points(10,7));
		plist.add(new Points(10,10));
		plist.add(new Points(11,2));
		plist.add(new Points(11, 4));
		plist.add(new Points(12,6));
		plist.add(new Points(12, 8));
		plist.add(new Points(14,4));
		plist.add(new Points(14,7));
		plist.add(new Points(15,7));
		plist.add(new Points(15,8));
		
		
		
		
	for(int i =0; i< plist.size(); i++){
		System.out.println("plist["+i+"]: "+plist.get(i).toString());
	}
	
	PTR ptrTest = new PTR(plist);
	
	ptrTest.startPTR();
	
	for(int i =0; i< plist.size(); i++){
		System.out.println("plist["+i+"]: "+plist.get(i).toString());
	}
	
 }
}
