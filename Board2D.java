import java.util.Scanner; 

public class Board2D {

    //2D array to store user input of board
    String[][] board; 

    //this is the word that the user is looking for 
    String targetWord; 

    //this stores the boolean value of whether or not the word exists in the 2DBoard
    boolean exists; 

    //this scanner is for user input 
    Scanner input = new Scanner(System.in);

    //default constructor that will run all parts of the program 
    Board2D() throws InvalidInputException{

        //This method will prompt the user for the 2D board as well as the target word
        promptUser();

        //Display the results to the user 
        displayResults();
        
        
    }

    //This method prompts the user for the 2D board as well as the target word
    public void promptUser() throws InvalidInputException{

        //Ask user for the number of rows they would like 
        System.out.print("Enter the number of rows you would like in your 2D board, the number must be between 1 and 1000 [integers only ie. 3]: ");

        //stores the user input of # of rows in 2D board
        int rows = input.nextInt(); 
        
        //Ask user for the number of columns they would like 
        System.out.print("Enter the number of columns you would like in your 2D board, the number must be between 1 and 1000 [integers only ie. 3]: ");

        //stores the user input of # of columns in 2D board 
        int columns = input.nextInt();
       
        //if rows/columns are not between 1 and 1000 throw invalid input exception 
        if(rows <= 1 || rows >= 1000){
            throw new InvalidInputException("The number of rows should be between the values 1 and 1000");
        }

        if(columns <= 1 || rows >= 1000){
            throw new InvalidInputException("The number of columns should be between the values 1 and 1000");
        }

        //instantiate 2D array 
        board = new String[rows][columns];

        //Prompt the user for the board they would like 
        System.out.println("\nEnter " + rows + " rows and " + columns +  " columns of the letters you would like in your 2D board");
        System.out.println("Make sure that each letter is seperated by a space, hit enter after the completion of one row.");
        System.out.println("The number of letters in each row should be equal to the number of columns that you entered");
        System.out.println("Each letter should be capitalized"); 
        System.out.println("Board: ");
   
        //Store it all to the 2D Array 
        for(int i = 0; i < board.length; i++){
            for( int j = 0; j < board[i].length; j++){
                board[i][j] = input.next();

                //if current element is not a capital letter throw invalid input exception 
                if(! Character.isUpperCase(board[i][j].charAt(0))){
                    throw new InvalidInputException("Only upper case letters allowed in 2D board");
                }
            }
        }



        //Ask user for target word 
        System.out.print("\nEnter the word you would like to search: "); 
      
        targetWord = input.next(); 
        
        //make sure target word is capitalized
        targetWord = targetWord.toUpperCase();
    }

    //this method will check if the target word exists within the board 
    public boolean exists(){
        //set value of exists boolean variable to true 
        exists = true;

        for (int i =0; i < targetWord.length(); i++){
            String letter = targetWord.substring(i, i+1); 

            //check the number of occurences of the letter at the current index of targetWord 
            int occurencesWord = occurencesWord(targetWord, letter);

            //check number of occurences of the letter at the current index in the 2DArray/board
            int occurencesBoard = occurencesBoard(board, letter);

            /*if the occurences of the letter in the word is greater than the occurences of
             the letter in the board therefore the word does not exist,  
             therefore the exists value should be changed to false and loop should be exited*/
             if(occurencesWord > occurencesBoard){
                exists = false; 
                break;
             }
        }

        return exists;
    }

    //This method will display whether or not the word exists in the 2D board. 
    public void displayResults(){

        System.out.println("It is " + exists() + " that the word " + targetWord + " exists in the 2D board.");


    }


    //this method will return the number of times a given letter occurs within a string 
    public int occurencesWord(String word, String letter){
        int occurences = 0; 

        //for each letter
        for(int i = 0; i < word.length(); i++){

            //if letter/char at current index is equal to the letter character value increment occurences
            if(word.charAt(i) == letter.charAt(0)){
                occurences++;
            }
        }

        //return # of occurences
        return occurences;
    }

    //this method will return the number of times a given letter occurs in a 2D array 
    public static int occurencesBoard(String[][] array, String letter){
      
        int occurences = 0; 

        //nested for loop to cycle through each element in 2D array 
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                
                //if current element in 2D array is equal to the value of the letter increment occurences
                if(array[i][j].equals(letter)){
                    occurences++;
                }
            }
        }

        //return # of occurences
        return occurences; 
    }
    
}
