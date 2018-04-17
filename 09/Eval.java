public class Eval{
  public static double eval(String s){
    MyStack data = new MyStack();
    String operators = "+-*/%";
    String[] tokens = s.split(" ");
    for(int i = 0; i < tokens.length;i++){
      if(!operators.contains(tokens[i])){
        data.push(Double.parseDouble(tokens[i]));
      }
      else{
        if(tokens[i].equals("+")){
          data.push(data.pop() + data.pop());
        }
        if(tokens[i].equals("-")){
          data.push(- data.pop() + data.pop());
        }
        if(tokens[i].equals("*")){
          data.push(data.pop() * data.pop());
        }
        if(tokens[i].equals("/")){
          double sec = data.pop();
          double fir = data.pop();
          data.push(fir / sec);
        }
        if(tokens[i].equals("%")){
          double sec = data.pop();
          double fir = data.pop();
          data.push(fir % sec);
        }
      }
    }
    return data.pop();
  }
  public static void main(String[] args){
    System.out.println(Eval.eval("10 2.0 +"));
    System.out.println(Eval.eval("11 3 - 4 + 2.5 *"));
    System.out.println(Eval.eval("8 2 + 99 9 - * 2 + 9 -"));
    System.out.println(Eval.eval("10 2.0 /"));
    System.out.println(Eval.eval("10 2.0 %"));
  }
}
