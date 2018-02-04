public class Recursion{
  public Recursion(){

  }
  public int fact(int n){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 0){
      return 1;
    }
    return fact(n-1) * n;
  }
  public int fib(int n){
    return fibHelp(n,1,2,1);
  }
  public int fibHelp(int n, int number, int counter, int last){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 1){
      return 1;
    }
    if(n == 0){
        return 0;
    }
    if(counter == n){
      return number;
    }
    return fibHelp(n,last + number,counter + 1, number);
  }
  public double sqrt(double n){
    return sqrtHelp(n, 1.0);
  }
  public double sqrtHelp(double n, double guess){
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 0){
      return 0;
    }
    if((java.lang.Math.abs((guess * guess - n) / n) * 100) < 0.000001){
      return guess;
    }
    return sqrtHelp(n, (n / guess + guess) / 2);

  }
  public static void main(String[] args){
    Recursion r = new Recursion();
    System.out.println(r.fact(5));
    // System.out.println(r.fib(-1));
    System.out.println(r.fib(0));
    System.out.println(r.fib(1));
    System.out.println(r.fib(2));
    System.out.println(r.fib(3));
    System.out.println(r.sqrt(0));
    System.out.println(r.sqrt(4));
    System.out.println(r.sqrt(16));
    System.out.println(r.sqrt(100));

  }
}
