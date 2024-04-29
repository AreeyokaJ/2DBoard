import java.util.InputMismatchException;
import java.util.Scanner;



class Board2DTest{
    public static void main(String[] args) {


        try{
            //create Board2D object 
            Board2D createBoard = new Board2D();
        }

        catch(InvalidInputException e){
            System.out.println(e.getMessage());
        }

        catch(InputMismatchException e){
            System.out.println("Please enter only integers for rows and columns");
        }


    }

  

}