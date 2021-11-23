import java.io.*;
import java.util.*;

public class Main {

    private static String getFileName(String[] args){
        if(args.length == 1) return args[0];
        System.out.println("enter input filename");
        return new java.util.Scanner(System.in).next();
    }

    public static void main(String[] args) throws IOException {

        LL1 parser = null;
        try{
        String filename = getFileName(args);
        parser = new LL1(filename);

        System.out.println(parser.firstsToString());
        System.out.println(parser.followsToString());

        System.out.println(parser.run()); //-->parse table

        System.out.println("\n");
        System.out.println("RHS table: ");
        parser.grammer.printRHS();





        }catch(Exception e){
            System.out.println("file does not exist");
        }

    }

}
