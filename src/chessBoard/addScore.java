package chessBoard;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class addScore {


    public static void write(ArrayList highScore)
    {
        String record=(String)highScore.get(0)+" "+highScore.get(1)+" "+highScore.get(2)+" "+highScore.get(3);//break down the array provided into a neat sentence to add to the txt file
        try {
            BufferedWriter file = new BufferedWriter(new FileWriter("HighScores.txt", true));
            file.write(String.valueOf(record));//write the record/highscore
            file.newLine();//add a new line after each record
            file.close();
        }catch (IOException e) {
            System.out.println("error, file does not exist");
        }
    }

    public static ArrayList read()
    {//add the records from the text file to an array. This array is then interpreted in another class to create a high score window
        Scanner s = null;
        try {
            s = new Scanner(new File("HighScores.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("error, file does not exist");
        }
        ArrayList list = new ArrayList();
        while (s.hasNextLine())
        {
            list.add(s.nextLine());
        }
        s.close();
        return list;
    }


}
