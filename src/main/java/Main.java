import java.util.Scanner;
/**
 * Created by iyasuwatts on 10/17/17.
 */
/*      Write a guessing game which prompts a user to guess a mystery number within some range.
        After every guess the program should display some variation of "too large", "too small", "correct guess", respectively.
        Upon termination, the program should display the number of guesses before successfully guessing correctly.
        A number that is input consecutively, should register as a single guess.
 */
public class Main {
    public static void main(String[] args){

        Scanner scanObj = new Scanner(System.in); //create scanner obj

        int userInput;      //declare variable to store users' input
        int count = 0;      //counts user attempts
        int min = 1;        //stores for random number range
        int max = 100;      //stores random number range
        int lastUserInput = (min-123);  //used for later, stores users' last entry
        boolean isCorrect = false;

        int randNum = (int) ((max+1) * Math.random());
            //Math.random   generates long decimal number between 0.00 and 0.99
            //max           multiples to increase the range to max value (Ex. range is 0-99.99)
            //+1            includes the "round up" number (Ex. range is 0-100.99)
            //(int)         "casts" the decimal as an int, and drops the decimal value
        System.out.println("Random number: " +randNum);

        while (isCorrect == false) {
            System.out.print("Enter a number between " + min + "-" + max + ": ");
            userInput = scanObj.nextInt(); //takes and stores users' int input

            if(userInput == lastUserInput) {
                System.out.println("Your number was your last entry!");
            } else {
                if (userInput == randNum) {
                    count++;
                    System.out.println("Congrats! You have entered the correct number on attempt #" + count);
                    isCorrect = true;
                }
                if (userInput > randNum && userInput < max + 1) {
                    count++;
                    System.out.println("Your number is too high! This is attempt #" + count);
                    lastUserInput = userInput;
                }
                if (userInput < randNum && userInput > (min - 1)) {
                    count++;
                    System.out.println("Your number is too low! This is attempt #" + count);
                    lastUserInput = userInput;
                }
                if (userInput > max || userInput < min) {
                    System.out.println("Your number is out of range!");
                }
            }
        }

    }


}
