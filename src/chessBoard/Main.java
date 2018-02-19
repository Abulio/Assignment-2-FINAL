package chessBoard;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;

public class Main {
    static Board chessBoard;


    public static void main(String[] args) {

        Board chessBoard = new Board();//create the chess board
    }

    public static void scores()
    {//this is the score panel that is displayed after the game is finished
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Date Date = new Date();
        String currentDate=dateFormat.format(Date);

        Font myFont = new Font("SansSerif", Font.BOLD, 25);

        JLabel Name = new JLabel("Player Name");//variables to be added to the panes
        JLabel Score = new JLabel("Score");
        JLabel Colour = new JLabel("Piece Colour");
        JLabel Name2 = new JLabel("Player Name");
        JLabel Score2 = new JLabel("Score");
        JLabel Colour2 = new JLabel("Piece Colour");

        Name.setFont(myFont);
        Score.setFont(myFont);
        Colour.setFont(myFont);
        Name2.setFont(myFont);
        Score2.setFont(myFont);
        Colour2.setFont(myFont);



        JFrame Scores = new JFrame("High Scores");//creating the frame
        Scores.setLayout(new BorderLayout());
        Scores.setSize(850, 950);
        Scores.setVisible(true);
        Scores.setLocationRelativeTo(null);
        Scores.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();//made highscore frame into a tabbed pane frame, easy switching between the two
        JPanel allTime = new JPanel();
        allTime.setLayout(new GridLayout(0,3));//neat three column grid
        allTime.add(Name2);
        allTime.add(Score2);
        allTime.add(Colour2);
        tabbedPane.addTab("All-time Scores", allTime);
        JPanel pDay = new JPanel();
        pDay.setLayout(new GridLayout(0,3));
        pDay.add(Name);
        pDay.add(Score);
        pDay.add(Colour);
        tabbedPane.addTab("Past 24 hrs", pDay);

        Scores.add(tabbedPane);//add the tabbed pane to the frame

        ArrayList temp=addScore.read();//array list full of the records from the txt file
        for (int i=0;i<temp.size();i++)//for loop to go through the array list and manipulate the data
        {
            String record = String.valueOf(temp.get(i));
            String[] words = record.split("\\s+");//split the sentence by spaces to separate all the values
            JLabel name = new JLabel(words[0]);//first word is the name of the player
            JLabel score = new JLabel(words[1]);//second word is the number of moves it took
            JLabel player = new JLabel(words[2]);//third word is the colour piece they played
            if (words[3].equals(currentDate))//compare the timeStamp of the recorded to present and add the score to the correct panel
            {
                pDay.add(name);
                pDay.add(score);
                pDay.add(player);
            }
            else
            {
                allTime.add(name);
                allTime.add(score);
                allTime.add(player);
            }
        }
    }

}