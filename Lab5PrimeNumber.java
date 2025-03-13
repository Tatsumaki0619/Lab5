import java.util.Scanner;

/**
 * This is a program that can test if the number is prime based on the user's input number;
 * if the number is prime, it will print "The number is prime", if not, it will print"The number is not prime."
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 3/11/2025
 */
public class Lab5PrimeNumber
{
    public static void main(String[] args){
        int number;
        boolean isPrime;
        String playAgain;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a whole number>2 (ie:19) to test if prime:");
        number = keyboard.nextInt();
        do{
            isPrime = testForPrime(number);
            if(isPrime){
                System.out.println(number + " is prime.");
            }
            else{
                System.out.println(number + " is not prime.");
            }

            System.out.print("Enter 'yes' to start again: ");
            playAgain = keyboard.next().toLowerCase();
        }while(playAgain.equals("yes"));
    }

    /**
     * This method will test whether the number provided by the user is a prime number or not.
     * @param intNumber this is the number need to be tested.
     * @return a boolean if it is a prime number, return "yes".If not it will return "false".
     */
    private static boolean testForPrime(int intNumber){
        int intNumberSqRt;
        intNumberSqRt = (int)Math.sqrt(intNumber);
        boolean isPrimeMeth = true;
        for(int i = 2; i <= intNumberSqRt; i++){
            if (intNumber % i == 0){
                isPrimeMeth = false;
            }
        }
        return isPrimeMeth;
    }
}
