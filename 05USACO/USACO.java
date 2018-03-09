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
	    int[][] stomp = new int[n][3];
	    int ro = 0;
	    int co = 0;
	    int r2 = 0;
	    int sumDepth = 0;
	    while(in.hasNextInt()){
		int i = in.nextInt();
		if(co == c){
		    ro++;
		    co = 0;
		}
		if(ro < r){
		    lake[ro][co] = i;
		    co+=1;
		}
		if(ro >= r){
		    if(co == 3){
			r2++;
			co = 0;
		    }
		    stomp[r2][co] = i;
		    co+=1;
		}
	    }
	    for(int a = 0; a < n; a++){
		int r3 = stomp[a][0];
		int c3 = stomp[a][1];
		int max = 0;
		for(int row = stomp[a][0] - 1; row < r3 + 2;row++){
		    for(int col =  stomp[a][1] - 1;col < c3 + 2;col++){
			if(lake[row][col] > max){
			    max = lake[row][col];
			}
		    }
		}
		for(int row = stomp[a][0] - 1; row < r3 + 2;row++){
		    for(int col =  stomp[a][1] - 1;col < c3 + 2;col++){
			if(lake[row][col] > max - stomp[a][2]){
			    lake[row][col] = max - stomp[a][2];
			}
		    }
		}
	    }
	    for(int row = 0; row < r; row++){
		for(int col = 0; col < c; col++){
		    lake[row][col] = e - lake[row][col];
		}
	    }
	    for(int row = 0; row < r; row++){
		for(int col = 0; col < c; col++){
		    if(lake[row][col] > 0){
			sumDepth += lake[row][col];
		    }
		}
	    }
	    return sumDepth * 72 * 72;

	}
	catch(FileNotFoundException e){
	    System.out.println("No such file exists");
	}
	return 0;
    }
    public static int silver(String filename){
	try{
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    int r = in.nextInt();
	    int c = in.nextInt();
	    int t = in.nextInt();
	    char[][] land = new char[r][c];
	    int ro = 0;
	    int index = 0;
	    int[] startEnd = new int[4];
	    while(in.hasNextLine()){
		String line = in.nextLine();
		if(ro <= r && ro != 0){
		    for(int col = 0; col < c;col++){
			land[ro - 1][col] = line.charAt(col);
		    }
		}
		if(ro == r + 1){
		    String rowCols = "";
		    for(int i = 0;i < line.length();i++){
			if(line.charAt(i) != ' '){
			    rowCols += line.charAt(i);
			}
			if(line.charAt(i) == ' ' || i == line.length() - 1){
			    startEnd[index] = Integer.parseInt(rowCols);
			    rowCols = "";
			    index++;
			}
		    }
		}
		ro++;
	    }
	    int[][] curPath = new int[r][c];
	    int[][] newPath = new int[r][c];
	    int[][] template = new int[r][c];
	    curPath[startEnd[0] - 1][startEnd[1] - 1] = 1;
	    for(int row = 0;row < r;row++){
		for(int col = 0;col < c;col++){
		    if(land[row][col] == '*'){
			curPath[row][col] = -1;
			newPath[row][col] = -1;
			template[row][col] = -1;
		    }
		}
	    }
	    int[] rowM = {-1,0,1,0};
	    int[] colM = {0,-1,0,1};
	    for(int i = 0; i < t;i++){
		for(int row = 0;row < r ;row++){
		    for(int col = 0;col < c ;col++){
			if(curPath[row][col] != -1){
			    if(curPath[row][col] > 0){
				newPath[row][col] = 0;
			    }
			    for(int n = 0; n < 4;n++){
				if((row  + rowM[n] < land.length) &&
				   col + colM[n]< land[0].length &&
				   row  + rowM[n] >= 0 &&
				   col + colM[n] >= 0 &&
				   curPath[row + rowM[n]][col + colM[n]] != -1){
				    newPath[row][col] += curPath[row + rowM[n]][col + colM[n]];
				}
			    }
			}
		    }
		}
		for(int row = 0;row < r;row++){
		    for(int col = 0;col < c;col++){
			curPath[row][col] = newPath[row][col];
			newPath[row][col] = template[row][col];
		    }
		}
	    }
	    return curPath[startEnd[2] - 1][startEnd[3] - 1];
	}
	catch(FileNotFoundException e){
	    System.out.println("No such file exists");
	}
	return 0;
    }
    public static void main(String[] args){
	System.out.println(silver("land1.txt"));
	System.out.println(silver("land2.txt"));
	System.out.println(silver("land3.txt"));
	System.out.println(silver("land4.txt"));
	System.out.println(silver("land5.txt"));
	System.out.println(silver("land6.txt"));
	System.out.println(silver("land7.txt"));
	System.out.println(silver("land8.txt"));
	System.out.println(silver("land9.txt"));
	System.out.println(silver("land10.txt"));
    }
}
