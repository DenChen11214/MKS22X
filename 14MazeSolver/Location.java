public class Location{
    private int x,y;
    private Location previous;

    public Location(int x, int y, Location prev){
	this.x = x;
	this.y = y;
	previous = prev;
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
    public void setX(int x){
	this.x = x;
    }
    public void setY(int y){
	this.y = y;
    }
    public void setPrevious(Location p){
	previous = p;
    }
}
