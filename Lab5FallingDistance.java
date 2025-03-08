import java.util.Scanner;

/**
 * This program can calculate the falling distance based on the user's input value as
 * falling time. the program will print out the distance as time passed by.
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 3/6/2025
 */
public class Lab5FallingDistance
{
    public static void main(String[] args){
        int time;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter how many seconds to compute: ");
        time = keyboard.nextInt();
        System.out.println("Time(secs)\tDistance(m)");
        System.out.println("=========\t===========");
        for(int i = 1; i <= time; i++){
            getDistance(i);
        }
    }
    
    /**
     * Provide an integer as time to compute distance.
     * @param tem The falling time.
     * @return The distance based on the falling time.
     */
    public static void getDistance(int tem){
        final double ACCELERATION = 9.8;
        double distance = 0.5 * Math.pow(tem, 2) * ACCELERATION;//Math.pow(base, exponent)
        System.out.printf("%d\t\t%.2f\n", tem, distance);//System.out.printf("%-16d%-16.2f\n", tem, distance);
    }
}
