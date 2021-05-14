import java.util.ArrayList;

class Calculator {
  private ArrayList<Integer> nums;
  private ArrayList<Character> opt;



  //Then Default Constructor.... to be explained how its used later.
  public Calculator() {
    //this is the object that is being created in this case.
        //Normally, this means the object that is calling the function...
    this.nums = new ArrayList<Integer>();
    this.opt = new ArrayList<Character>();
    System.out.println("The Constructor has run");
  }
  
  //Polymorphism --> many changes to a single entity....
  public void addNum(int num) {
    this.nums.add(num);
  }

  public void addNum(int num, int index) {
    this.nums.add(index , num);
  }

  //when you use one function name to accomplish two different actions, this is know as function overloading

  public void addOperator(char opt) {
    this.opt.add(opt);
  }

  public boolean removeOperator(int index) {
    try {
      this.opt.remove(index);
    } catch(Exception e) {
      System.out.println(e);
      return false;
    }
    return true;
  }
  
  public boolean removeNum(int index) {
    try {
      this.nums.remove(index);
    } catch(Exception e) {
      System.out.println(e);
      return false; 
    }
    return true;
  }

  public int getNumsSize() {
    return this.nums.size();
  }

  public int getOptSize() {
    return this.opt.size();
  } 

  public void printNums() {
    for (int i=0; i < this.nums.size(); i++) {
        System.out.println(this.nums.get(i));
    }
  }
  
  public void printOpt() {
    for (int i=0; i < this.opt.size(); i++) {
        System.out.println(this.opt.get(i));
    }
  }


  public int findOpt(char toFind) {
    for (int i=0; i < this.opt.size(); i++) {
      if (this.opt.get(i) == toFind) {
        return i;
      } 
      //check if the chararter inside opt at i, is equal to toFind
    }
    return -1;
  }

  public void clearNums() {
    this.nums.clear();
  }

  public void clearOpts() {
    this.opt.clear();
  }

  // public void setNum1(int num) {
  //   this.num1 = num;
  // }

  // public void setNum2(int num) {
  //   this.num2 = num;
  // }

  public char getOpt(int index) {
    return this.opt.get(index);
  }

  public int getNum(int index) {
    return this.nums.get(index);
  }

  //lets create functions for add, sub, mult, and div
  public int add(int index) {
    return this.nums.get(index) + this.nums.get(index+1);
  }

  public int subtract(int index) {
    return this.nums.get(index) - this.nums.get(index+1);
  }

  public int multiplication(int index) {
    return this.nums.get(index) * this.nums.get(index+1);
  }

  public int division(int index) {
    return this.nums.get(index) / this.nums.get(index+1);
  }
}
