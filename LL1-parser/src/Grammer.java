import java.io.*;
import java.util.*;
import java.nio.file.*;
import java.util.stream.*;

public class Grammer{

  final public List <ProductionRule> prodRules;
  final public List <Stack<Word>> RHS; //---->stack of Words to store each rule's right hand side
  final public Word startSymbol;

  public Grammer(String filename) throws IOException {

    //--->read the file line by line and construct production rules


    prodRules = Files.lines(Paths.get(filename))
    .map(ProductionRule::new)
    .collect( Collectors.toList() );
    this.startSymbol = this.prodRules.get(0).leftSide;

    RHS = createRHS();
  }


  //-----> method to assemble the rhs table
  public List<Stack<Word>> createRHS(){
    List <Stack<Word>> tempRHS = new ArrayList<>();

    for (ProductionRule pr : prodRules) {
      Stack<Word> stack = new Stack<>();

      String[] temp = pr.rule[1].trim().split(" ");
      for (int i = temp.length - 1; i >= 0 ; i--) {
        stack.push( new Word(temp[i]) );
      }
      tempRHS.add(stack);
    }
    return tempRHS;
  }

  public void printRHS(){

    for (Stack<Word> x : RHS) {
      for (Word str: x) {
        System.out.print(str+" , ");
      }
      System.out.println();
    }
  }

}
