import java.util.Scanner;

/**
 * Write a description of class Lab5FallingDistance here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab5FallingDistance
{
    public static void main(String[] args){
        int time;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter how many seconds to compute: ");
        time = keyboard.nextInt();
        System.out.println("Time(secs)   Distance(m)");
        System.out.println("=========    ===========");
        for(int i = 1; i <= time; i++){
            getDistance(i);
        }
    }
    
    /**
     * 
     */
    public static void getDistance(int tem){
        final double ACCELERATION = 9.8;
        double distance = 0.5 * Math.pow(tem, 2) * ACCELERATION;
        System.out.printf("%-13d%-13.2f\n", tem, distance);
    }
}
