import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    //the first part of this statement only creates a reference to a address in ram
  
    Calculator calc = new Calculator();
    //System.out.println(calc.opt);
    Scanner in = new Scanner(System.in);


    while (true){
      System.out.println("Please Enter an Expression");
      System.out.print(": ");
      String response = in.nextLine();
      while (!ParseResponse(response, calc)) {
        System.out.println("invalid expression");
        System.out.println("Please Enter a VALID Expression");
        System.out.print(": ");
        response = in.nextLine();
      }
      Calculate(calc);
      System.out.println("Another expression?");
      if (!yesNoGetter(in)) {
        break;
      }
    }
    System.out.println("shutting down...");
  }

  public static Boolean yesNoGetter(Scanner in) {
    System.out.print("(Y/N): ");
    String input = in.nextLine();

    input = input.toUpperCase();
    while ( input.charAt(0) != 'Y' && input.charAt(0) != 'N') {
      System.out.print("(Y/N): ");
      input = in.nextLine();
      input = input.toUpperCase();
    }

    return input.charAt(0) == 'Y';
  }

  public static Boolean ParseResponse(String input, Calculator myCalc) {
    String placeholder = "";
    boolean invalid = false;
    int previous = 0;


    for (int i=0; i < input.length(); i++) {
      //check if the character we are currently looking at is digit...
      //LUCKILY There is a function for this
      //Character.isDigit( str.charAt(i) )
      //System.out.println("letter: "+input.charAt(i));
      if (Character.isDigit(input.charAt(i))) { 
        
      //BUT now you have to stich together the number, "" + char
      // "" + '3' + '2' + '3' --> "323" --> Integer.valueOf("323") --> 323

      // add the character to the blank string, when you find that there isn't a digit.... then convert that string into a integer

        placeholder = placeholder + input.charAt(i);
        //System.out.println("place:"+placeholder);
      } else {
        
        //System.out.println("not digit");

        if (input.charAt(i) != ' ') {

          //System.out.println("not space");

            //System.out.println("setNum1");
            //myCalc.setNum1(Integer.valueOf(placeholder));
            //stuff = String.valueOf( input.charAt(i) );
            
            myCalc.addOperator(input.charAt(i) );
            if (placeholder != "") {
            myCalc.addNum(Integer.valueOf(placeholder));
            placeholder = "";
            } else {
              invalid = true;
            }

        } else {
          //here is where the character we are looking at is a space...
        }

       
      }
      
        
      //    if (charAt(i) == 'x' || charAt(i) == '*'){

      //    } 
      //    {
      //       if (charAt(i) == '/')
      //    } else if {
      //       if (charAt(i) == '+')
      //    } else if {
      //      if (charAt(i) == '-')
      // }

    }
    if (placeholder != "") {
      myCalc.addNum(Integer.valueOf(placeholder));
    }
    // Scanner parser = new Scanner(input);
    // myCalc.setNum1(parser.nextInt());
    // String stuff = parser.next();
    
    // myCalc.setNum2(parser.nextInt());
    //we can assume that we are in the number 'operator' number sequence

    //Check that the amount of numbers is one more than characters,
    //create a var to toggle on and off when more that one number or operator is added before the other.

    // 2 numbers for each operator, 
    // 5 + 2 * 6 - 9 - 10
    // 5  * * 7 9
    
    if (invalid) {
      return false;
    }
    else {
      if ( myCalc.getOptSize()+1 == myCalc.getNumsSize()){
        return true;
      } else {
        myCalc.clearNums();
        myCalc.clearOpts();
        return false;
      }
    }

    //assume all numbers are integers for now...
    // nextInt --> ignores whitespace
    // next --> ignores whitespace
    
    } 


  public static int doOperation(String opt, int index , Calculator calc) {
    int result = 0;

        //see if ar[k] contains "ADD"
        if (opt.contains("+")) {

            //run the function and print results
            result = calc.add(index);
             //usually is used to break out of the enclosing scope...
        } else if (opt.contains("-")) {

            //run the function and print results
            result = calc.subtract(index);
             //usually is used to break out of the enclosing scope...

        } else if (opt.contains("*") || opt.contains("x")) {

            //run the function and print results
            result = calc.multiplication(index);
             //usually is used to break out of the enclosing scope...
        } else if (opt.contains("/")) {

            //run the function and print results
            result = calc.division(index);
             //usually is used to break out of the enclosing scope...
        }
    return result;
  }



  public static void Calculate(Calculator calc){
    while (calc.getOptSize() != 0) {    
      int index = Integer.MAX_VALUE;
      String opt = "";
      if (calc.findOpt('x') != -1 || calc.findOpt('*') != -1 || calc.findOpt('/') != -1) {
        //if a index found for any of these is not -1, but the lowest value, then it must be run first...
        if (calc.findOpt('x') != -1){
          index = calc.findOpt('x');
          opt = "x";
        } 
        if (calc.findOpt('*') != -1 && calc.findOpt('*') < index){
          index = calc.findOpt('*');
          opt = "*";
        } 
        if (calc.findOpt('/') != -1 && calc.findOpt('/') < index) {
          index = calc.findOpt('/');
          opt = "/";
        }
      }  else  {
        if (calc.findOpt('+') != -1 ) {
          index = calc.findOpt('+');
          opt = "+";
        }
        if ( calc.findOpt('-') != -1 && calc.findOpt('-') < index) {
          index = calc.findOpt('-');
          opt = "-";
        }
      } 

      int result = doOperation(opt, index , calc);
      //lets remove the operator first
      calc.removeOperator(index);
      calc.removeNum(index);
      calc.removeNum(index);
      calc.addNum(result , index);
    }
    System.out.println(calc.getNum(0));
    System.out.print("Is nums empty?");
    System.out.println(calc.getNumsSize() == 0);
    calc.removeNum(0);
    System.out.print("How about now?");
    System.out.println(calc.getNumsSize() == 0);




    //after here, check the size of calc opt, to see if its empty, if it is break the loop...
    //while loop 150 through 178







     //Arraylist can remove at a specific index, and add at a specific index...

    //first goal is to make a way to do PEMDAS with the new fancy function we made for the Calculator
    // (* x and /)
    // then( + and - ) 
  }
}
//create a function called "Calculate"

