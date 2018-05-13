public class Location implements Comparable<Location>{
  private int x,y;
  private Location previous;
  private int distance;

  public Location(int x, int y, Location prev){
    this.x = x;
    this.y = y;
    previous = prev;
    distance = 0;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public Location getPrevious(){
    return previous;
  }
  public int getDistance(){
    return distance;
  }
  public void setDistance(int n){
    distance = n;
  }
  public int compareTo(Location loc){
    if(this.distance > loc.getDistance()){
      return 1;
    }
    if(this.distance < loc.getDistance()){
      return -1;
    }
    return 0;
  }
  public String toString(){
    return "" + x + " " + y + " " + distance;
  }
}
