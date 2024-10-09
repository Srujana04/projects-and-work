package projectzz;

import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range: ");
        int lower = sc.nextInt();
        int upper = sc.nextInt();
        int n = 10;
        int systemNumber = (int) (Math.random() * (upper - lower)) + lower;
        System.out.print("Enter a number in the range " + lower + " to " + upper + ": ");
        int userNumber = sc.nextInt();
        while (n != 0) {
            if (userNumber > upper || userNumber < lower) {
                System.out.print("You're going out of bound! Try again within the range " + lower + " to " + upper + ": ");
                userNumber = sc.nextInt();
            }
            else {
                if (userNumber == systemNumber) {
                    System.out.println("Congratulations! You guessed it right!");
                    break;
                }
                else if (userNumber > systemNumber) {
                    System.out.print("Too high! Try again! Enter your guess: ");
                    userNumber = sc.nextInt();
                }
                else {
                    System.out.print("Too low! Try again! Enter your guess: ");
                    userNumber = sc.nextInt();
                }
            }
            if (n == 1) {
                System.out.println("Sorry, you've exhausted all your trials! :(");
            }
            n--;
        }
    }
}
