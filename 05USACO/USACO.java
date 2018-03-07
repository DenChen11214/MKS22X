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
            System.out.println(max);
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
      
    }
    catch(FileNotFoundException e){
      System.out.println("No such file exists");
    }
    return 0;
  }
  public static int silver(String filename){
    return 0;
  }
  public static void main(String[] args){
    bronze("LakeMake1.txt");
  }
}
