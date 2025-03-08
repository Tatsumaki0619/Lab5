import java.io.*;
import java.util.Scanner;
/**
 * Write a description of class GradeProcssungScratchPaper here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GradeProcssungScratchPaper
{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int i = 0;
        while(i != -1){
            int grade = keyboard.nextInt();
            i = grade;
            if(grade != -1){
                System.out.println( grade );
            }
        }
    }
    public static void processFile(String inFile, String outFile) throws IOException{
        int grade = 1,sum = 0, A = 0, B =0, C = 0,
        D = 0, F = 0, high = 0, low = 100, num = 0;
        String line;
        double average;
        File myFile = new File(inFile);
        Scanner inputFile = new Scanner(myFile);
        inputFile.useDelimiter("//D");
        while(inputFile.hasNext()){
            line = inputFile.nextLine();
            Scanner lineScanner = new Scanner(line);
            while(lineScanner.hasNextInt() && lineScanner.nextInt() != -1){
                grade = lineScanner.nextInt(); 
                sum += grade;
                num++;
                if(high >= grade){
                    high = grade;
                }

                if(low <= grade){
                    low = grade;
                }

                if(grade >= 90){
                    A++;
                }
                else if(grade >= 80){
                    B++;
                }
                else if(grade >= 70){
                    C++;
                }
                else if(grade >= 60){
                    D++;
                }
                else{
                    F++;
                }
            }
        }
        inputFile.close();
        PrintWriter outputFile = new PrintWriter(outFile);
        if(sum == -1){
            outputFile.println("No grades to average.");    
        }
        else{
            average = (double)sum / num;
            outputFile.println("Number of As: " + A);
            outputFile.println("Number of Bs: " + B);
            outputFile.println("Number of Cs: " + C);
            outputFile.println("Number of Ds: " + D);
            outputFile.println("Number of Fs: " + F);
            outputFile.println("The high score was: " + high);
            outputFile.println("The low score was: " + low);
            outputFile.println("The average score is: " + average);
        }
    }
}
