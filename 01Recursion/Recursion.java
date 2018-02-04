public class Recursion{
  public static int fact(int n){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 0){
      return 1;
    }
    return fact(n-1) * n;
  }
  public int fib(int n){
    return 0;
  }
  public double sort(double n){
    return 0;
  }
  public static void main(String[] args){
    //System.out.println(fact(-2));
    System.out.println(fact(0));
    System.out.println(fact(1));
    System.out.println(fact(5));
  }
}
