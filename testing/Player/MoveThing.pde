public class MoveThing{
  float x,y;
  public MoveThing(){
    x = width/2;
    y = height/2;
  }
  void display(){
    ellipse(x,y,40,40);
  }
  void keyPressed(){
    if(keyCode == 'W' || keyCode == 'w'){
      y+=1;
    }
    if(keyCode == 'S' || keyCode == 's'){
      y++;
    }
    if(keyCode == 'A' || keyCode == 'a'){
      x--;
    }
    if(keyCode == 'D' || keyCode == 'd'){
      x++;
    }
  }
}
