import java.util.Scanner;

/**
 * Write a description of class Lab5PrimeNumbers here.
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 3/6/2025
 */
public class Lab5PrimeNumbers
{
    public static void main(String[] args){
        int number;
        Scanner keyboard = new Scanner(System.in);
        
        do{
            System.out.print("Please input an integer(ie: 19),"+
                " and the program can test if it is a prime number.");
            number = keyboard.nextInt();
            if(primeTest(number) == true){
                System.out.printf("%d is a prime.\n", number);
            }
            else{
                System.out.printf("%d is not a prime.\n", number);
            }
            System.out.print("enter 'yes' to test another number:");
            
        }while(keyboard.next().equalsIgnoreCase("yes"));
    }

    /**
     *@param test The number need to be tested whether it is a prime number or not.
     *@return The result of the value's prime test.
     */
    public static boolean primeTest(int test){
        int half = test/2, testValue = 0;

        if(test == 2){
            testValue = testValue;
        }
        else{
            for(int i = 1; i <= half; i++){
                if(test % i == 0){
                    testValue++;
                }
                else{
                    testValue = testValue;
                }
            }
        }
        
        if(testValue == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
