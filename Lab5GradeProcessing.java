import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

/**
 * Write a description of class Lab5GradeProcessing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab5GradeProcessing
{
    public static void main(String[] args) throws IOException{
        String inputFile = getlnLine();
        String outputFile = getOutLine();
        processFile(inputFile, outputFile);
        /*File outFile = new File(outputFile);
        Scanner inFile = new Scanner(outFile);
        while(inFile.hasNext()){
            String ans = inFile.nextLine();
            System.out.println(ans);
        }
        inFile.close();
        */
        System.exit(0);
    }

    /**
     * 
     */
    public static String getlnLine() throws IOException{
        String temp;
        boolean test = true;
        temp = JOptionPane.showInputDialog("Please provide the path/file name: ");
        File file = new File (temp);
        if(file.exists()){
            return temp;
        }
        else{
            return "The file does not exist.";
        }
    }

    /**
     * 
     */
    public static String getOutLine() throws IOException{
        String outPutFile;
        outPutFile = JOptionPane.showInputDialog("Please provide the" + 
            "path/file name for output file: ");
        return outPutFile;
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
