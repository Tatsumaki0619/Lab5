import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

/**
 * This is a program that helps the users to calculate their grades based on a file(file can have mutiple lines with grades and use "-1" as a terminal) the user created.
 * The user need to enter the file's name that contains grades and give a name for the output file, whitch will
 * be generated by the computer.
 *
 * @author Qianyi Li
 * @version v1.0
 * @since 3/8/2025
 */
public class Lab5GradeProcessing
{
    public static void main(String[] args) throws IOException{
        String inputFile = getlnLine();
        if(inputFile.equals("The file does not exist.")){
            JOptionPane.showMessageDialog(null,"The input file does not exist.");
        }
        else{
            String outputFile = getOutLine();
            processFile(inputFile, outputFile);
        }

        System.exit(0);
    }

    /**
     * This method can get the file with grades in it, and will also test whether the file exists or not.
     * @return the name/path of the file will return if it exist or 
     * will return "The file does not exist." if it dosn't.
     */
    public static String getlnLine() throws IOException{
        String temp;
        temp = JOptionPane.showInputDialog("Please provide the path/file name: ");
        File file = new File (temp);

        if(file.exists()){
            return temp;
        }
        else{
            return "The file does not exist.";
        }
    }

    /**This method allows the user to create the name for the output file.
     * @return It will return the name of the outputfile based on the user's input.
     */
    public static String getOutLine() throws IOException{
        String outPutFile;

        outPutFile = JOptionPane.showInputDialog("Please provide the" + 
            "path/file name for output file: ");
        return outPutFile;
    }

    /**
     * This method will calculate the user's grades including the number of grades(A-F), highest, lowest score and average.
     * @param inFile It is the first file's name/path with user's grades.
     * @param outFile It is the second file's name/path crated by the user.
     */
    public static void processFile(String inFile, String outFile) throws IOException{
        int lineNumber = 0;
        double average;
        File myFile = new File(inFile);//convert the string of the input file name to a real file so we can scan
        Scanner inputFile = new Scanner(myFile);//scan the input file(with grades on it) 

        PrintWriter outputFile = new PrintWriter(outFile);//write a new file as our output file.

        while(inputFile.hasNextLine()){//hasNextLine is a test like a boolean
            int grade = -2,sum = 0, A = 0, B =0, C = 0,
            D = 0, F = 0, high = 0, low = 100, num = 0;
            Scanner lineScanner = new Scanner(inputFile.nextLine());//nextLine() will actually start reading the line
            lineNumber ++;

            while(lineScanner.hasNextInt()){//same to hasNextLine() just test not reading
                grade = lineScanner.nextInt();

                if(grade != -1){
                    sum += grade;
                    num++;

                    if(grade >= high){
                        high = grade;
                    }

                    if(grade <= low ){
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
                else{
                    sum = sum - 1;        
                }
            }

            outputFile.println("Set " + lineNumber + " of grades calculated.");

            if(sum == -1){
                outputFile.println("No grades to average.");
                outputFile.println();
            }
            else{
                average = (double)(sum + 1) / num;
                outputFile.println("Number of As: " + A);
                outputFile.println("Number of Bs: " + B);
                outputFile.println("Number of Cs: " + C);
                outputFile.println("Number of Ds: " + D);
                outputFile.println("Number of Fs: " + F);
                outputFile.println("The high score was: " + high);
                outputFile.println("The low score was: " + low);
                outputFile.printf("The average score is: %.1f.\n", average);
                outputFile.println();
            }

            lineScanner.close();
        }
        outputFile.close();
        inputFile.close();
    }
}
