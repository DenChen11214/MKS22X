import java.util.*;
import java.io.*;
public class USACO{
    public static int bronze(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int r = in.nextInt();
	    int c = in.nextInt();
	    int e = in.nextInt();
	    int n = in.nextInt();
	    int[][] lake = new int[r][c];
	    for(int row = 0; row < r; row++){
		for(int col = 0; col < c; c++){
		    lake[row][col] = in.nextInt();
		}
	    }
	    int[][] stomp = new int[n][3];
	    for(int row = 0; row < r; row++){
		for(int col = 0; col < c; c++){
		    stomp[row][col] = in.nextInt();
		}
	    }
	    for(n; n > 0; n--){
		for(
	}
			    
	return 0;
    }
    public static int silver(String filename){
	return 0;
    }
}
