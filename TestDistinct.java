// TestDistinct.java
// Testing function for distinct elements counter
// awirth for COMP90056
// Aug 2017,8
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class TestDistinct{
	
	public static void main(String []args) throws FileNotFoundException, IOException{
	
		
		int i =0;
		if (args.length != 1){
		    System.err.println("Should be only one argument, the filename.\n");
		    System.exit(1);
		}
		String filename = args[0]; 

		 BufferedReader br = new BufferedReader(new FileReader(filename)) ;
		    String line;
		    Distinct a = new AMS(0x0001ffff,10);
			Distinct b = new BJKST1(0x0001ffff,1);
		    while ((line = br.readLine()) != null) {
		    	b.add(line);
		    	a.add(line);
		    	i++;}
		    	
		
		
	
		
		System.out.format("Estimate: %6.0f%n",(a.distinct()+b.distinct()/2));
	}
}


