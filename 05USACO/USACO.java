import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
	try{
	    int r = 0;
	    int c = 0;
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    while(in.hasNextLine()){
		String line = in.nextLine();
		if(r == 0){
		    for(int i = 0; i < line.length() ; i++){
			while(line.charAt(i) != ' '){
			}
		    }
		}
	    }
	}
			    
	return 0;
    }
    public static int silver(String filename){
	return 0;
    }
}
