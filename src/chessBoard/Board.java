package chessBoard;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;


public class Board extends JFrame{

    static blackPlayer black;//instance of black player
    static whitePlayer white;//instance of white player
    static ArrayList[] validMoves;//this is populated with possible moves and emptied after every change to the board
    static ArrayList highScore= new ArrayList();//this array list is passed onto addScore class where it is added to highScores.txt
    static boolean whiteTurn=true;//Determines whos turn it is, since chess is traditionally, white player first, this is set to true
    static Boolean checkState;//Resembles the state of check, i.e. True if a player is in check
    static Boolean checkMateState;//Resembles the state of check mate, i.e. True if a player is in check mate, ends the game

    private static HashMap componentMap;//this is to be populated with all the components on the panel CBoard

    static JPanel CBoard = new JPanel();//Where the main game is added to
    JPanel studID = new JPanel();//Displays my name at the top
    JPanel info = new JPanel();//Displays the current player, and the number of moves taken
    JButton chessButton;//This is added 64 times to the panel CBoard
    Font myFont = new Font("SansSerif", Font.BOLD, 45);
    Font myFont2 = new Font("SansSerif", Font.BOLD, 15);
    JLabel displayTurn = new JLabel("White Player");
    String lastButton;//Place holder for the most recent valid button pressed
    JLabel scoreCount;//Holds the current number of moves
    public static final int squareCount = 64;//number of squares to be added to the board

    public Board() {

        white= new whitePlayer();//instance for white player
        black= new blackPlayer();//instance for black player
        displayTurn.setFont(myFont);

        Color grayColor = new Color(81,44,18);//colour for dark squares
        Color whiteColor = new Color(243,218,152);//colour for light squares


        JLabel name = new JLabel("CE203 Assignment 2, submitted by: Abul Hassan Mamodo 1604092");
        scoreCount = new JLabel("Moves Taken: 0");
        scoreCount.setFont(myFont2);


        for (int i = 1; i <= squareCount; i++)//creates the chess board
        {
            if (i % 2 == 0)//if the square to be added is even
            {
                chessButton = new JButton();
                chessButton.setBackground(grayColor);//set even squares to this colour
                chessButton.setName(String.valueOf(i));//assign name to the iteration of the loop making all squares unique
                chessButton.addActionListener(actionListener);//add action listner to thhe button
                chessButton.putClientProperty("player", "empty");//initially make the square belonging to neither player

                if(i==8)
                {
                    chessButton.setIcon(black.rook);//set image to button
                    chessButton.putClientProperty("player", "black");//this square belongs to the black player
                }

                if(i==6)
                {
                    chessButton.setIcon(black.bishop);
                    chessButton.putClientProperty("player", "black");//this square belongs to the black player
                }

                if(i==4)
                {
                    chessButton.setIcon(black.king);
                    chessButton.putClientProperty("player", "black");//this square belongs to the black player
                }

                if(i==2)
                {
                    chessButton.setIcon(black.knight);
                    chessButton.putClientProperty("player", "black");//this square belongs to the black player
                }

                if(i>8 && i<17)
                {
                    chessButton.setIcon(black.pawn);
                    chessButton.putClientProperty("player", "black");//this square belongs to the black player
                }



                if(i==64)
                {
                    chessButton.setIcon(white.rook);
                    chessButton.putClientProperty("player", "white");//this square belongs to the white player
                }

                if(i==62)
                {
                    chessButton.setIcon(white.bishop);
                    chessButton.putClientProperty("player", "white");//this square belongs to the white player
                }

                if(i==60)
                {
                    chessButton.setIcon(white.queen);
                    chessButton.putClientProperty("player", "white");//this square belongs to the white player
                }

                if(i==58)
                {
                    chessButton.setIcon(white.knight);
                    chessButton.putClientProperty("player", "white");//this square belongs to the white player
                }

                if(i>48 && i<57)
                {
                    chessButton.setIcon(white.pawn);
                    chessButton.putClientProperty("player", "white");//this square belongs to the white player

                }

                CBoard.add(chessButton);//after changing/adding proporties accordingly, add the button to the panel
            }

            else//if the square to be added is odd, same as above code apart from switching the colour of background
                {
                chessButton = new JButton();
                chessButton.setBackground(whiteColor);
                chessButton.setName(String.valueOf(i));
                chessButton.addActionListener(actionListener);
                chessButton.putClientProperty("player", "empty");

                if(i==1)
                {
                    chessButton.setIcon(black.rook);
                    chessButton.putClientProperty("player", "black");
                }

                if(i==3)
                {
                    chessButton.setIcon(black.bishop);
                    chessButton.putClientProperty("player", "black");
                }

                if(i==5)
                {
                    chessButton.setIcon(black.queen);
                    chessButton.putClientProperty("player", "black");
                }

                if(i==7)
                {
                    chessButton.setIcon(black.knight);
                    chessButton.putClientProperty("player", "black");
                }

                if(i>8 && i<17)
                {
                    chessButton.setIcon(black.pawn);
                    chessButton.putClientProperty("player", "black");
                }



                if(i==57)
                {
                    chessButton.setIcon(white.rook);
                    chessButton.putClientProperty("player", "white");
                }

                if(i==59)
                {
                    chessButton.setIcon(white.bishop);
                    chessButton.putClientProperty("player", "white");
                }

                if(i==61)
                {
                    chessButton.setIcon(white.king);
                    chessButton.putClientProperty("player", "white");
                }

                if(i==63)
                {
                    chessButton.setIcon(white.knight);
                    chessButton.putClientProperty("player", "white");
                }

                if(i>48 && i<57)
                {
                    chessButton.setIcon(white.pawn);
                    chessButton.putClientProperty("player", "white");
                }
                CBoard.add(chessButton);
            }

            if (i % 8 == 0) {//this is equivalent of a new row being created, at this point you need to switch the colours to get a checkerboard effect

                Color temp = grayColor;
                grayColor = whiteColor;
                whiteColor = temp;
            }

        }

        studID.add(name);

        info.add(scoreCount);
        info.add(displayTurn);

        CBoard.setLayout(new GridLayout(8, 8));
        CBoard.setSize(850, 850);//setting size for the chess board

        studID.setLayout(new GridBagLayout());
        info.setLayout(new GridLayout(0,3));
        this.add(CBoard);//adding board to the frame
        this.add(studID, BorderLayout.NORTH);//addding student details to the frame
        this.add(info, BorderLayout.SOUTH);//adding game info to the frame
        this.setSize(850, 950);//set frame size
        this.setVisible(true);
        this.setLocationRelativeTo(null);//set frame to appear center of the monitor
        this.setResizable(false);//disable resizing of frame
        createComponentMap();//adds all the components of CBoard to the HashMap initiated at the start


    }

    private void createComponentMap() {//adding all the components to the hashmap
        componentMap = new HashMap<String,Component>();
        Component[] components = this.CBoard.getComponents();
        for (int i=0; i < components.length; i++) {
            componentMap.put(components[i].getName(), components[i]);
        }
    }

    public static JButton getComponentByName(String name) {//return the swing object according to name provided, if this object doesnt exist, return null
        if (componentMap.containsKey(name)) {
            return (JButton) componentMap.get(name);
        }
        else return null;
    }


    ActionListener actionListener = new ActionListener() {//this action listner applies to all the buttons on the chessboard
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            if (button.getClientProperty("player").equals("black") && whiteTurn==false)//if its black players turn and they press on a button that belongs to them
            {
                rePaint();//repaints the board
                boolean pawnMove=true;
                boolean pawnStartMove=true;
                lastButton=button.getName();//set lastButton to the button just pressed
                button.setBackground(new Color(173,216,230));
                if (Integer.parseInt(button.getName())<17 && Integer.parseInt(button.getName())>8)//if the piece is on the second row
                {
                    if (getComponentByName(String.valueOf(Integer.parseInt(button.getName())+16)).getClientProperty("player").equals("white"))//if its blocked off, the pawn cannot move there
                    {
                        pawnStartMove=false;
                    }
                }
                if (Integer.parseInt(button.getName())+8<=64)
                {
                    if (getComponentByName(String.valueOf(Integer.parseInt(button.getName()) + 8)).getClientProperty("player").equals("white"))//if its blocked off, the pawn cannot move there
                    {
                        pawnMove = false;
                    }
                }

                validMoves = black.returnValidMoves(button.getIcon(),button.getName(), pawnMove, pawnStartMove);//returns all the valid moves that the black player can do
                validSquares(validMoves);//displays the possible moves to the user so they can decide where to move the piece or to move another piece
            }
            else if(button.getClientProperty("player").equals("white") && whiteTurn==true)//if its white players turn and they press on a button that belongs to them
            {//following code is the same as previous, just inverted to suit the white player
                rePaint();
                boolean pawnMove=true;
                boolean pawnStartMove=true;
                lastButton=button.getName();
                button.setBackground(new Color(173,216,230));
                if (Integer.parseInt(button.getName())<57 && Integer.parseInt(button.getName())>48)
                {
                    if (getComponentByName(String.valueOf(Integer.parseInt(button.getName())-16)).getClientProperty("player").equals("black"))
                    {
                        pawnStartMove=false;
                    }
                }
                if (Integer.parseInt(button.getName())-8>0)
                {
                    if (getComponentByName(String.valueOf(Integer.parseInt(button.getName()) - 8)).getClientProperty("player").equals("black")) {
                        pawnMove = false;
                    }
                }
                validMoves = white.returnValidMoves(button.getIcon(),button.getName(), pawnMove, pawnStartMove);
                validSquares(validMoves);
            }
            else if(button.getBackground().equals(Color.red)||button.getBackground().equals(Color.blue))//if the player decides to make a move
            {
                repaint();
                makeMove(button.getName());//move the piece to user defined location
                if (whiteTurn==true)//if its whites turn
                {
                    whiteTurn=false;//switch to black turn next
                    displayTurn.setText("Black Player");//prep the info pane to display ready for next move
                    white.moves++;//increment number of moves white player has taken
                    scoreCount.setText("Moves Taken: "+black.moves);
                    checkState=black.check();//check if the black player has just been put in check
                    checkMate();//check if the move the white player just made was a check mate
                    if(checkMateState==true)//if white player just check mated
                    {
                        String name = JOptionPane.showInputDialog("CHECK MATE! WHITE PLAYER WON!\nPlease enter your name:");//message dialog with input for name
                        DateFormat dF = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                        Date date = new Date();
                        String timeStamp = dF.format(date);//make a time stamp
                        highScore.add(name);
                        highScore.add(white.moves);
                        highScore.add("WHITE");
                        highScore.add(timeStamp);
                        addScore.write(highScore);//send the information to the addScore class to add it to the txt
                        hideBoard();//close the frame with the game on
                        Main.scores();//open the frame with high scores
                    }
                    else if (checkState==true)//if its not a check mate, but there is a check
                    {
                        JOptionPane.showMessageDialog(null, "CHECK!");//display check has been reached
                    }
                }
                else//if its black players turn
                {//following code is the same as above, just inverted to suit the black player
                    whiteTurn=true;
                    displayTurn.setText("White Player");
                    black.moves++;
                    scoreCount.setText("Moves Taken: "+white.moves);
                    checkState=white.check();
                    checkMate();
                    if(checkMateState==true)
                    {
                        String name = JOptionPane.showInputDialog("CHECK MATE! BLACK PLAYER WON!\nPlease enter your name:");
                        DateFormat dF = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
                        Date date = new Date();
                        String timeStamp = dF.format(date);
                        highScore.add(name);
                        highScore.add(white.moves);
                        highScore.add("BLACK");
                        highScore.add(timeStamp);
                        addScore.write(highScore);
                        hideBoard();
                        Main.scores();
                    }
                    else if (checkState==true)
                    {
                        JOptionPane.showMessageDialog(null, "CHECK!");
                    }
                }
            }
            else
            {
                repaint();
            }

        }
    };

    private void hideBoard()//hide the game frame
    {

        this.setVisible(false);
    }

    private void makeMove(String name)//moves the piece to the selected square, clearing the square it was previously on and transfering its properites and attributes to the new square
    {
        Icon piece =  getComponentByName(lastButton).getIcon();
        String house = (String) getComponentByName(lastButton).getClientProperty("player");
        getComponentByName(name).setIcon(piece);
        getComponentByName(name).putClientProperty("player", house);
        getComponentByName(lastButton).setIcon(null);
        getComponentByName(lastButton).putClientProperty("player", "empty");
        rePaint();
    }

    private void rePaint() {//traverses through the board repaint the background of each button to its original colour
        Color grayColor = new Color(81,44,18);
        Color whiteColor = new Color(243,218,152);
        for (int i = 1; i<=squareCount; i++)
        {
            if (i % 2 == 0)
            {
                getComponentByName(String.valueOf(i)).setBackground(grayColor);
            }
            else
            {
                getComponentByName(String.valueOf(i)).setBackground(whiteColor);
            }

            if (i % 8 == 0)
            {
                Color temp = grayColor;
                grayColor = whiteColor;
                whiteColor = temp;
            }
        }
    }

    private void checkMate() {
        checkMateState = true;//set check mate to true, if it turns to false in the call, then it has not reached check mate state yet
        for (int i = 1; i <= 64; i++) {
            if (getComponentByName(String.valueOf(i)).getClientProperty("player").equals("white")) {
                boolean pawnMove = true;
                boolean pawnStartMove = true;
                if (Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) < 57 && Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) > 48) {
                    if (getComponentByName(String.valueOf(Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) - 16)).getClientProperty("player").equals("black")) {
                        pawnStartMove = false;
                    }
                }
                if (Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) - 8 > 0) {
                    if (getComponentByName(String.valueOf(Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) - 8)).getClientProperty("player").equals("black")) {
                        pawnMove = false;
                    }
                }
                validMoves = white.returnValidMoves(getComponentByName(String.valueOf(i)).getIcon(), getComponentByName(String.valueOf(i)).getName(), pawnMove, pawnStartMove);//get all the moves the white player can take
                checkSquares(validMoves);//passes the arraylist through a function that check to see if there are any moves, if there are moves, the false flag is raised
            }
        }
        if (checkMateState == true) {
            System.out.println("white Player Check Mate");
        }
        else {//this is to see if black player is in check mate, code has same purpose as above, just suited to other player
            checkMateState = true;
            for (int i = 1; i <= 64; i++) {
                if (getComponentByName(String.valueOf(i)).getClientProperty("player").equals("black")) {
                    boolean pawnMove = true;
                    boolean pawnStartMove = true;
                    if (Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) < 17 && Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) > 8) {
                        if (getComponentByName(String.valueOf(Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) + 16)).getClientProperty("player").equals("white")) {
                            pawnStartMove = false;
                        }
                    }
                    if (Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) + 8 <= 64) {
                        if (getComponentByName(String.valueOf(Integer.parseInt(getComponentByName(String.valueOf(i)).getName()) + 8)).getClientProperty("player").equals("white")) {
                            pawnMove = false;
                        }
                    }
                    validMoves = black.returnValidMoves(getComponentByName(String.valueOf(i)).getIcon(), getComponentByName(String.valueOf(i)).getName(), pawnMove, pawnStartMove);
                    checkSquares(validMoves);
                }
            }
            if (checkMateState == true) {
                System.out.println("Black Player Check Mate");
            }

        }
    }

    private void checkSquares(ArrayList[] validMoves) {//goes through every direction of movement, to see if there are any moves at all. If there are no moves it doesnt change the value of checkMateState, ending the game
        if (validMoves.length == 0) {
            JOptionPane.showMessageDialog(this, "CHECK!");
        }
        else {

            String enemy;

            if (whiteTurn == true) {
                enemy = "black";
            } else {
                enemy = "white";
            }

            for (int i = 0; i < validMoves[0].size(); i++) {
                if (getComponentByName((String) validMoves[0].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[0].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[1].size(); i++) {
                if (getComponentByName((String) validMoves[1].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[1].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[2].size(); i++) {
                if (getComponentByName((String) validMoves[2].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[2].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[3].size(); i++) {
                if (getComponentByName((String) validMoves[3].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[3].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[4].size(); i++) {
                if (getComponentByName((String) validMoves[4].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[4].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[5].size(); i++) {
                if (getComponentByName((String) validMoves[5].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[5].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[6].size(); i++) {
                if (getComponentByName((String) validMoves[6].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[6].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }
            for (int i = 0; i < validMoves[7].size(); i++) {
                if (getComponentByName((String) validMoves[7].get(i)).getClientProperty("player") == "empty") {
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[7].get(i)).getClientProperty("player").equals(enemy)) {
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }


        }
    }

    private void validSquares(ArrayList[] validMoves) {
        if (validMoves.length == 0) {//if there are no valid moves for that piece because of check
            JOptionPane.showMessageDialog(this, "YOU'RE IN CHECK!");
        }
        else {

            String enemy;

            if (whiteTurn == true) {//sets enemy according to the current turn
                enemy = "black";
            } else {
                enemy = "white";
            }

            for (int i = 0; i < validMoves[0].size(); i++) {//check movements due north and paint square accordingly
                if (getComponentByName((String) validMoves[0].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[0].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[0].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[0].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[1].size(); i++) {//check movements due north east and paint square accordingly
                if (getComponentByName((String) validMoves[1].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[1].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[1].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[1].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[2].size(); i++) {//check movements due east and paint square accordingly
                if (getComponentByName((String) validMoves[2].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[2].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[2].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[2].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[3].size(); i++) {//check movements due south east and paint square accordingly
                if (getComponentByName((String) validMoves[3].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[3].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[3].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[3].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[4].size(); i++) {//check movements due south and paint square accordingly
                if (getComponentByName((String) validMoves[4].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[4].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[4].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[4].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[5].size(); i++) {//check movements due south west and paint square accordingly
                if (getComponentByName((String) validMoves[5].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[5].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[5].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[5].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[6].size(); i++) { //check movements due west and paint square accordingly
                if (getComponentByName((String) validMoves[6].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[6].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[6].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[6].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }

            for (int i = 0; i < validMoves[7].size(); i++) {//check movements due north west and paint square accordingly
                if (getComponentByName((String) validMoves[7].get(i)).getClientProperty("player") == "empty") {
                    getComponentByName((String) validMoves[7].get(i)).setBackground(Color.blue);
                    checkMateState=false;
                } else if (getComponentByName((String) validMoves[7].get(i)).getClientProperty("player").equals(enemy)) {
                    getComponentByName((String) validMoves[7].get(i)).setBackground(Color.red);
                    checkMateState=false;
                    break;
                } else {
                    break;
                }
            }


        }
    }

    public static void transform(String name, ImageIcon rook, ImageIcon knight, ImageIcon bishop, ImageIcon queen)
    {//this opens a frame allowing the user to promote their pawn to another player once it reaches the other side of the board
        JFrame frame2 = new JFrame();
        JPanel change = new JPanel();
        JPanel message = new JPanel();
        JLabel Display = new JLabel("Pick a piece to promote your Pawn to:");
        JButton R = new JButton();
        R.setIcon(rook);
        R.setBackground(new Color(173,216,230));
        JButton K = new JButton();
        K.setIcon(knight);
        K.setBackground(new Color(173,216,230));
        JButton B = new JButton();
        B.setIcon(bishop);
        B.setBackground(new Color(173,216,230));
        JButton Q = new JButton();
        Q.setIcon(queen);
        Q.setBackground(new Color(173,216,230));
        change.add(R);
        change.add(K);
        change.add(B);
        change.add(Q);
        change.setLayout(new GridLayout());

        message.add(Display);
        message.setLayout(new GridBagLayout());

        frame2.setVisible(true);
        frame2.setSize(500, 300);
        frame2.setLocationRelativeTo(null);
        frame2.setLayout(new GridLayout(2,1));

        frame2.add(message);
        frame2.add(change);


        R.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getComponentByName(name).setIcon(R.getIcon());
                change.removeAll();
                frame2.setVisible(false);
            }
        });//change the pawn to a rook

        K.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getComponentByName(name).setIcon(K.getIcon());
                change.removeAll();
                frame2.setVisible(false);
            }
        });//change the pawn to a knight

        B.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getComponentByName(name).setIcon(B.getIcon());
                change.removeAll();
                frame2.setVisible(false);
            }
        });//change the pawn to a bishop

        Q.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                getComponentByName(name).setIcon(Q.getIcon());
                change.removeAll();
                frame2.setVisible(false);
            }
        });//change the pawn to a queen, why would you ever pick anything else?

    }

}
