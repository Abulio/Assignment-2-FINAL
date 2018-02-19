package chessBoard;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by am16476 on 07/12/2017.
 */
public class whitePlayer
{
    ImageIcon pawn = new ImageIcon("wPawn.png");//referencing the images in the folder
    ImageIcon rook = new ImageIcon("wRook.png");
    ImageIcon knight = new ImageIcon("wHorse.png");
    ImageIcon bishop = new ImageIcon("wBishop.png");
    ImageIcon queen = new ImageIcon("wQueen.png");
    ImageIcon king = new ImageIcon("wKing.png");
    Integer moves = 0;//this counts the number of moves the player has taken
    Boolean checkState=false;//resembles if the player is in check or not
    ArrayList[] validMoves;


    public ArrayList[] returnValidMoves(Icon icon, String name, Boolean pawnMove, Boolean pawnStartMove)
    {//function that returns the possible moves
        checkState=check();
        if(checkState==false)
        {
            return checkMoves(icon,name,pawnMove,pawnStartMove);
        }
        else
        {
            return checkMoves(icon,name,pawnMove,pawnStartMove);
        }
    }

    public Boolean check()//function that raises a flag if the player is in check
    {
        checkState=false;
        for (int i=1; i<=64; i++)//traverse the whole board and check every possible black player move
        {
            if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="black")
            {
                boolean pawnMove=true;
                boolean pawnStartMove=true;

                if (i<17 && i>8)
                {
                    if (Board.getComponentByName(String.valueOf(i+16)).getClientProperty("player").equals("white"))
                    {
                        pawnStartMove=false;
                    }
                }
                if ((i+8)<=64)
                {
                    if (Board.getComponentByName(String.valueOf(i+8)).getClientProperty("player").equals("white")) {
                        pawnMove = false;
                    }
                }
                Icon icon=Board.getComponentByName(String.valueOf(i)).getIcon();
                validMoves=Board.black.allMoves(icon, String.valueOf(i), pawnMove, pawnStartMove);//reference all the possible moves the black player can do
                for (int x = 0; x < validMoves[0].size(); x++)//traverse the provided list to see if any of the moves can result in the capture of the white king
                {
                    if(Board.getComponentByName((String) validMoves[0].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[0].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[0].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[0].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[1].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[1].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[1].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[1].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[1].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[2].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[2].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[2].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[2].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[2].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[3].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[3].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[3].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[3].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[3].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[4].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[4].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[4].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[4].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[4].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[5].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[5].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[5].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[5].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[5].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[6].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[6].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[6].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[6].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[6].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
                for (int x = 0; x < validMoves[7].size(); x++)
                {
                    if(Board.getComponentByName((String) validMoves[7].get(x)).getClientProperty("player").equals("black"))
                    {
                        break;
                    }
                    else if(Board.getComponentByName((String) validMoves[7].get(x)).getIcon()!=king && Board.getComponentByName((String) validMoves[7].get(x)).getClientProperty("player").equals("white"))
                    {
                        break;
                    }
                    if(Board.getComponentByName((String) validMoves[7].get(x)).getIcon()==king)
                    {
                        checkState=true;
                    }
                }
            }

        }
        return checkState;
    }


    public ArrayList[] checkMoves(Icon icon, String name, Boolean pawnMove, Boolean pawnStartMove) {//very similar to the allMoves Function, this one is used in this class to get all the moves the white player can do without putting themselves into check

        ArrayList moveListN = new ArrayList();
        ArrayList moveListNE = new ArrayList();
        ArrayList moveListE = new ArrayList();
        ArrayList moveListSE = new ArrayList();
        ArrayList moveListS = new ArrayList();
        ArrayList moveListSW = new ArrayList();
        ArrayList moveListW = new ArrayList();
        ArrayList moveListNW = new ArrayList();
        Board.getComponentByName(name).putClientProperty("player","empty");
        String temp;//these temp variables are used to imitate dummy moves on the board to check for check and check mate moves from both sides
        Icon temp2;


        if (icon==pawn)//determine what class of piece is on the button
        {
            if (Integer.parseInt(name) <= 8 && Integer.parseInt(name) > 0)
            {
                Board.transform(name, rook, knight, bishop, queen);
            }
            if (pawnMove==true && pawnStartMove==true)
            {
                if (Integer.parseInt(name) < 57 && Integer.parseInt(name) > 48)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListN.add(String.valueOf(Integer.parseInt(name) - 8));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).putClientProperty("player",temp);
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-16)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name)-16)).putClientProperty("player","white");
                    checkState=check();
                    if(checkState==false)
                    {
                        moveListN.add(String.valueOf(Integer.parseInt(name) - 16));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name)-16)).putClientProperty("player",temp);
                }
            }
            if (pawnMove==true && Integer.parseInt(name) - 8>0)
            {
                temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListN.add(String.valueOf(Integer.parseInt(name) - 8));
                }
                Board.getComponentByName(String.valueOf(Integer.parseInt(name)-8)).putClientProperty("player",temp);
            }

            if (Integer.parseInt(name)%8==0)
            {
                if (Integer.parseInt(name)-9>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player")=="black")
                    {
                        temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player");
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).putClientProperty("player","white");
                        checkState=check();
                        if (checkState==false)
                        {
                            moveListNW.add(String.valueOf(Integer.parseInt(name) - 9));
                        }
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).putClientProperty("player",temp);
                    }
                }
            }
            else if ((Integer.parseInt(name)-1)%8==0)
            {
                if (Integer.parseInt(name)-7>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player")=="black")
                    {
                        temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player");
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).putClientProperty("player","white");
                        checkState=check();
                        if (checkState==false)
                        {
                            moveListNE.add(String.valueOf(Integer.parseInt(name) - 7));
                        }
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).putClientProperty("player",temp);
                    }
                }
            }
            else
            {
                if (Integer.parseInt(name)-7>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player")=="black")
                    {
                        temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player");
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).putClientProperty("player","white");
                        checkState=check();
                        if (checkState==false)
                        {
                            moveListNE.add(String.valueOf(Integer.parseInt(name) - 7));
                        }
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).putClientProperty("player",temp);
                    }
                }
                if (Integer.parseInt(name)-9>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player")=="black")
                    {
                        temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player");
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).putClientProperty("player","white");
                        checkState=check();
                        if (checkState==false)
                        {
                            moveListNW.add(String.valueOf(Integer.parseInt(name) - 9));
                        }
                        Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).putClientProperty("player",temp);
                    }
                }

            }

        }

        else if (icon==rook)
        {
            for (int i = Integer.parseInt(name)+8;i<=64;)
            {
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListS.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+8;
            }

            for (int i = Integer.parseInt(name)-8;i>0;)
            {
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListN.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-8;
            }

            for (int i = Integer.parseInt(name)+1;i<=64;++i)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                else
                {
                    if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                    {
                        break;
                    }
                    temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListE.add(String.valueOf(i));
                    }
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                }

            }
            for (int i = Integer.parseInt(name)-1;i>0;--i)
            {
                if (i%8==0)
                {
                    break;
                }

                else
                {
                    if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                    {
                        break;
                    }
                    temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListW.add(String.valueOf(i));
                    }
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                }
            }

        }

        else if (icon==knight) {
            if (Integer.parseInt(name) % 8 == 0) {
                if (Integer.parseInt(name) - 10 > 0) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 10)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 10)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListNW.add(String.valueOf(Integer.parseInt(name) - 10));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 10)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) - 17 > 0) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) -17)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) -17)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListN.add(String.valueOf(Integer.parseInt(name) -17));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 17)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) + 6 <= 64) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) + 6)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) +6)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListSW.add(String.valueOf(Integer.parseInt(name) + 6));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) + 6)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) + 15 <=64) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) +15)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) +15)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListS.add(String.valueOf(Integer.parseInt(name) +15));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) +15)).putClientProperty("player",temp);
                }
            } else if ((Integer.parseInt(name) - 1) % 8 == 0) {
                if (Integer.parseInt(name) - 6 > 0) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 6)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 6)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListNE.add(String.valueOf(Integer.parseInt(name) - 6));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 6)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) - 15 > 0) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 15)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 15)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListW.add(String.valueOf(Integer.parseInt(name) - 15));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) - 15)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) + 10 <= 64) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) + 10)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) + 10)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListSE.add(String.valueOf(Integer.parseInt(name) + 10));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) + 10)).putClientProperty("player",temp);
                }
                if (Integer.parseInt(name) + 17 <= 64) {
                    temp= (String) Board.getComponentByName(String.valueOf(Integer.parseInt(name) +17)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) +17)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListE.add(String.valueOf(Integer.parseInt(name) +17));
                    }
                    Board.getComponentByName(String.valueOf(Integer.parseInt(name) +17)).putClientProperty("player",temp);
                }
            }
            else {

                for (int i = Integer.parseInt(name) + 8; i <= Integer.parseInt(name) + 10; i++) {
                    if (i == Integer.parseInt(name) + 10) {
                        if (i <= 64)
                        {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListSE.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }

                }

                for (int i = Integer.parseInt(name) + 8; i >= Integer.parseInt(name) + 6; i--) {
                    if (i == Integer.parseInt(name) + 6) {
                        if (i <= 64) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListSW.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if ((i - 1) % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 8; i >= Integer.parseInt(name) - 10; i--) {
                    if (i == Integer.parseInt(name) - 10) {
                        if (i > 0) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListNW.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if ((i - 1) % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 8; i <= Integer.parseInt(name) - 6; i++) {
                    if (i == Integer.parseInt(name) - 6) {
                        if (i > 0) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListNE.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i  % 8 == 0) {
                        break;
                    }
                }


                for (int i = Integer.parseInt(name) + 16; i <= Integer.parseInt(name) + 17; i++) {
                    if (i == Integer.parseInt(name) + 17) {
                        if (i <= 64) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListE.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }

                }

                for (int i = Integer.parseInt(name) + 16; i >= Integer.parseInt(name) + 15; i--) {
                    if (i == Integer.parseInt(name) + 15) {
                        if (i <= 64) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListS.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 16; i >= Integer.parseInt(name) - 17; i--) {
                    if (i == Integer.parseInt(name) - 17) {
                        if (i > 0) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListN.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 16; i <= Integer.parseInt(name) - 15; i++) {
                    if (i == Integer.parseInt(name) - 15) {
                        if (i > 0) {
                            temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                            checkState=check();
                            if (checkState==false)
                            {
                                moveListW.add(String.valueOf(i));
                            }
                            Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

            }
        }

        else if (icon==bishop)
        {
            for (int i = Integer.parseInt(name)+9; i<=64;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListSE.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+9;
            }

            for (int i = Integer.parseInt(name)+7; i<=64;)
            {
                if (i%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListSW.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+7;
            }

            for (int i = Integer.parseInt(name)-7; i>0;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListNE.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-7;
            }

            for (int i = Integer.parseInt(name)-9; i>0;)
            {
                if (i%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListNW.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-9;
            }
        }

        else if (icon==queen)
        {
            for (int i = Integer.parseInt(name)+8;i<=64;)
            {
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListS.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+8;
            }

            for (int i = Integer.parseInt(name)-8;i>0;)
            {
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListN.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-8;
            }

            for (int i = Integer.parseInt(name)+1;i<=64;++i)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                else
                {
                    if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                    {
                        break;
                    }
                    temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListE.add(String.valueOf(i));
                    }
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                }
            }
            for (int i = Integer.parseInt(name)-1;i>0;--i)
            {
                if (i%8==0)
                {
                    break;
                }
                else
                {
                    if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                    {
                        break;
                    }
                    temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListW.add(String.valueOf(i));
                    }
                    Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                }
            }
            for (int i = Integer.parseInt(name)+9; i<=64;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListSE.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+9;
            }

            for (int i = Integer.parseInt(name)+7; i<=64;)
            {
                if (i%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListSW.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i+7;
            }

            for (int i = Integer.parseInt(name)-7; i>0;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListNE.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-7;
            }

            for (int i = Integer.parseInt(name)-9; i>0;)
            {
                if (i%8==0)
                {
                    break;
                }
                if(Board.getComponentByName(String.valueOf(i)).getClientProperty("player")=="white")
                {
                    break;
                }
                temp= (String) Board.getComponentByName(String.valueOf(i)).getClientProperty("player");
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
                checkState=check();
                if (checkState==false)
                {
                    moveListNW.add(String.valueOf(i));
                }
                Board.getComponentByName(String.valueOf(i)).putClientProperty("player",temp);
                i=i-9;
            }
        }

        else if (icon==king)
        {
            Integer i=Integer.parseInt(name);
            Board.getComponentByName(String.valueOf(i)).setIcon(null);
            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","empty");

            if (i-8>0)
            {
                temp= (String) Board.getComponentByName(String.valueOf(i-8)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i-8)).getIcon();
                Board.getComponentByName(String.valueOf(i-8)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i-8)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListN.add(String.valueOf(i-8));
                }
                Board.getComponentByName(String.valueOf(i-8)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i-8)).setIcon(temp2);
            }
            if (i+8<=64)
            {
                temp= (String) Board.getComponentByName(String.valueOf(i+8)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i+8)).getIcon();
                Board.getComponentByName(String.valueOf(i+8)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i+8)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListS.add(String.valueOf(i+8));
                }
                Board.getComponentByName(String.valueOf(i+8)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i+8)).setIcon(temp2);
            }
            if (i%8==0)
            {
                temp= (String) Board.getComponentByName(String.valueOf(i-1)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i-1)).getIcon();
                Board.getComponentByName(String.valueOf(i-1)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i-1)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListW.add(String.valueOf(i-1));
                }
                Board.getComponentByName(String.valueOf(i-1)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i-1)).setIcon(temp2);
                if (i-9>0)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i-9)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i-9)).getIcon();
                    Board.getComponentByName(String.valueOf(i-9)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i-9)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListNW.add(String.valueOf(i-9));
                    }
                    Board.getComponentByName(String.valueOf(i-9)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i-9)).setIcon(temp2);
                }
                if (i+7<=64)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i+7)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i+7)).getIcon();
                    Board.getComponentByName(String.valueOf(i+7)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i+7)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListSW.add(String.valueOf(i+7));
                    }
                    Board.getComponentByName(String.valueOf(i+7)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i+7)).setIcon(temp2);
                }
            }
            else if ((i-1)%8==0)
            {
                temp= (String) Board.getComponentByName(String.valueOf(i+1)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i+1)).getIcon();
                Board.getComponentByName(String.valueOf(i+1)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i+1)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListE.add(String.valueOf(i+1));
                }
                Board.getComponentByName(String.valueOf(i+1)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i+1)).setIcon(temp2);
                if (i-7>0)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i-7)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i-7)).getIcon();
                    Board.getComponentByName(String.valueOf(i-7)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i-7)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListNE.add(String.valueOf(i-7));
                    }
                    Board.getComponentByName(String.valueOf(i-7)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i-7)).setIcon(temp2);
                }
                if (i+9<=64)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i+9)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i+9)).getIcon();
                    Board.getComponentByName(String.valueOf(i+9)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i+9)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListSE.add(String.valueOf(i+9));
                    }
                    Board.getComponentByName(String.valueOf(i+9)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i+9)).setIcon(temp2);
                }
            }
            else
            {
                temp= (String) Board.getComponentByName(String.valueOf(i+1)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i+1)).getIcon();
                Board.getComponentByName(String.valueOf(i+1)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i+1)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListE.add(String.valueOf(i+1));
                }
                Board.getComponentByName(String.valueOf(i+1)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i+1)).setIcon(temp2);

                temp= (String) Board.getComponentByName(String.valueOf(i-1)).getClientProperty("player");
                temp2= Board.getComponentByName(String.valueOf(i-1)).getIcon();
                Board.getComponentByName(String.valueOf(i-1)).putClientProperty("player","white");
                Board.getComponentByName(String.valueOf(i-1)).setIcon(king);
                checkState=check();
                if (checkState==false)
                {
                    moveListW.add(String.valueOf(i-1));
                }
                Board.getComponentByName(String.valueOf(i-1)).putClientProperty("player",temp);
                Board.getComponentByName(String.valueOf(i-1)).setIcon(temp2);

                if(i-9>0)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i-9)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i-9)).getIcon();
                    Board.getComponentByName(String.valueOf(i-9)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i-9)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListNW.add(String.valueOf(i-9));
                    }
                    Board.getComponentByName(String.valueOf(i-9)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i-9)).setIcon(temp2);
                }

                if(i-7>0)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i-7)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i-7)).getIcon();
                    Board.getComponentByName(String.valueOf(i-7)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i-7)).setIcon(king);
                    checkState=check();
                    if (checkState==false) {
                        moveListNE.add(String.valueOf(i-7));
                    }
                    Board.getComponentByName(String.valueOf(i-7)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i-7)).setIcon(temp2);
                }

                if(i+7<=64)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i+7)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i+7)).getIcon();
                    Board.getComponentByName(String.valueOf(i+7)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i+7)).setIcon(king);

                    checkState=check();
                    if (checkState==false) {
                        moveListSW.add(String.valueOf(i+7));
                    }
                    Board.getComponentByName(String.valueOf(i+7)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i+7)).setIcon(temp2);
                }

                if(i+9<=64)
                {
                    temp= (String) Board.getComponentByName(String.valueOf(i+9)).getClientProperty("player");
                    temp2= Board.getComponentByName(String.valueOf(i+9)).getIcon();
                    Board.getComponentByName(String.valueOf(i+9)).putClientProperty("player","white");
                    Board.getComponentByName(String.valueOf(i+9)).setIcon(king);
                    checkState=check();
                    if (checkState==false)
                    {
                        moveListSE.add(String.valueOf(i+9));
                    }
                    Board.getComponentByName(String.valueOf(i+9)).putClientProperty("player",temp);
                    Board.getComponentByName(String.valueOf(i+9)).setIcon(temp2);
                }
            }
            Board.getComponentByName(String.valueOf(i)).setIcon(king);
            Board.getComponentByName(String.valueOf(i)).putClientProperty("player","white");
        }//the above code adds possible moves to the list. The moves are checked if they would cause a check from the opposing side, preventing the white player from putting himself into check and adds and discards moves accordingly
        Board.getComponentByName(name).putClientProperty("player","white");
        ArrayList [] validMoves = {moveListN, moveListNE, moveListE, moveListSE, moveListS, moveListSW, moveListW, moveListNW};
        return validMoves;
    }

    public ArrayList[] allMoves(Icon icon, String name, Boolean pawnMove, Boolean pawnStartMove) {//this function is referenced by black player to see if the white player can make a move putting them in check. It is not used in this class

        ArrayList moveListN = new ArrayList();//initialise array for each direction of possible travel
        ArrayList moveListNE = new ArrayList();
        ArrayList moveListE = new ArrayList();
        ArrayList moveListSE = new ArrayList();
        ArrayList moveListS = new ArrayList();
        ArrayList moveListSW = new ArrayList();
        ArrayList moveListW = new ArrayList();
        ArrayList moveListNW = new ArrayList();



        if (icon==pawn){//determine what class of piece is on the button
            {
                if (pawnMove==true && pawnStartMove==true)
                {
                    if (Integer.parseInt(name) < 57 && Integer.parseInt(name) > 48)
                    {
                        moveListN.add(String.valueOf(Integer.parseInt(name) - 8));
                        moveListN.add(String.valueOf(Integer.parseInt(name) - 16));
                    }
                }
                if (pawnMove==true && Integer.parseInt(name) - 8>0)
                {
                    moveListN.add(String.valueOf(Integer.parseInt(name) - 8));
                }
            }
            if ((Integer.parseInt(name)-1)%8==0)
            {
                if (Integer.parseInt(name)-7>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player")=="black")
                    {
                        moveListNW.add(String.valueOf(Integer.parseInt(name) - 7));
                    }
                }
            }
            else if (Integer.parseInt(name)%8==0)
            {
                if (Integer.parseInt(name)-9>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player")=="black")
                    {
                        moveListNE.add(String.valueOf(Integer.parseInt(name) - 9));
                    }
                }
            }
            else
            {
                if (Integer.parseInt(name)-7>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-7)).getClientProperty("player")=="black")
                    {
                        moveListNW.add(String.valueOf(Integer.parseInt(name) - 7));
                    }
                }
                if (Integer.parseInt(name)-9>0)
                {
                    if(Board.getComponentByName(String.valueOf(Integer.parseInt(name)-9)).getClientProperty("player")=="black")
                    {
                        moveListNE.add(String.valueOf(Integer.parseInt(name) - 9));
                    }
                }

            }
        }

        else if (icon==rook)
        {
            for (int i = Integer.parseInt(name)+8;i<=64;)
            {
                moveListS.add(String.valueOf(i));
                i=i+8;
            }

            for (int i = Integer.parseInt(name)-8;i>0;)
            {
                moveListN.add(String.valueOf(i));
                i=i-8;
            }

            for (int i = Integer.parseInt(name)+1;i<=64;++i)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                else
                {
                    moveListE.add(String.valueOf(i));
                }
            }
            for (int i = Integer.parseInt(name)-1;i>0;--i)
            {
                if (i%8==0)
                {
                    break;
                }
                else
                {
                    moveListW.add(String.valueOf(i));
                }
            }

        }

        else if (icon==knight)
        {
            if (Integer.parseInt(name) % 8 == 0) {
                if (Integer.parseInt(name) - 10 > 0) {
                    moveListNW.add(String.valueOf(Integer.parseInt(name) - 10));
                }
                if (Integer.parseInt(name) - 17 > 0) {
                    moveListN.add(String.valueOf(Integer.parseInt(name) - 17));
                }
                if (Integer.parseInt(name) + 6 <= 64) {
                    moveListSW.add(String.valueOf(Integer.parseInt(name) + 6));
                }
                if (Integer.parseInt(name) + 15 <=64) {
                    moveListS.add(String.valueOf(Integer.parseInt(name) + 15));
                }
            } else if ((Integer.parseInt(name) - 1) % 8 == 0) {
                if (Integer.parseInt(name) - 6 > 0) {
                    moveListNE.add(String.valueOf(Integer.parseInt(name) - 6));
                }
                if (Integer.parseInt(name) - 15 > 0) {
                    moveListW.add(String.valueOf(Integer.parseInt(name) - 15));
                }
                if (Integer.parseInt(name) + 10 <=64) {
                    moveListSE.add(String.valueOf(Integer.parseInt(name) + 10));
                }
                if (Integer.parseInt(name) +17  <=64) {
                    moveListE.add(String.valueOf(Integer.parseInt(name) + 17));
                }
            } else {

                for (int i = Integer.parseInt(name) + 8; i <= Integer.parseInt(name) + 10; i++) {
                    if (i == Integer.parseInt(name) + 10) {
                        if (i <= 64) {
                            moveListSE.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }

                }

                for (int i = Integer.parseInt(name) + 8; i >= Integer.parseInt(name) + 6; i--) {
                    if (i == Integer.parseInt(name) + 6) {
                        if (i <= 64) {
                            moveListSW.add(String.valueOf(i));
                        }
                    } else if ((i-1) % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 8; i >= Integer.parseInt(name) - 10; i--) {
                    if (i == Integer.parseInt(name) - 10) {
                        if (i > 0) {
                            moveListNW.add(String.valueOf(i));
                        }
                    } else if ((i - 1) % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 8; i <= Integer.parseInt(name) - 6; i++) {
                    if (i == Integer.parseInt(name) - 6) {
                        if (i > 0) {
                            moveListNE.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }


                for (int i = Integer.parseInt(name) + 16; i <= Integer.parseInt(name) + 17; i++) {
                    if (i == Integer.parseInt(name) + 17) {
                        if (i <= 64) {
                            moveListE.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }

                }

                for (int i = Integer.parseInt(name) + 16; i >= Integer.parseInt(name) + 15; i--) {
                    if (i == Integer.parseInt(name) + 15) {
                        if (i <= 64) {
                            moveListS.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 16; i >= Integer.parseInt(name) - 17; i--) {
                    if (i == Integer.parseInt(name) - 17) {
                        if (i > 0) {
                            moveListN.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

                for (int i = Integer.parseInt(name) - 16; i <= Integer.parseInt(name) - 15; i++) {
                    if (i == Integer.parseInt(name) - 15) {
                        if (i > 0) {
                            moveListW.add(String.valueOf(i));
                        }
                    } else if (i % 8 == 0) {
                        break;
                    }
                }

            }

        }


        else if (icon==bishop)
        {
            for (int i = Integer.parseInt(name)+9; i<=64;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                moveListSE.add(String.valueOf(i));
                i=i+9;
            }

            for (int i = Integer.parseInt(name)+7; i<=64;)
            {
                if (i%8==0)
                {
                    break;
                }

                moveListSW.add(String.valueOf(i));
                i=i+7;
            }

            for (int i = Integer.parseInt(name)-7; i>0;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                moveListNE.add(String.valueOf(i));
                i=i-7;
            }

            for (int i = Integer.parseInt(name)-9; i>0;)
            {
                if (i%8==0)
                {
                    break;
                }

                moveListNW.add(String.valueOf(i));
                i=i-9;
            }
        }

        else if (icon==queen)
        {
            for (int i = Integer.parseInt(name)+8;i<=64;)
            {
                moveListS.add(String.valueOf(i));
                i=i+8;
            }

            for (int i = Integer.parseInt(name)-8;i>0;)
            {
                moveListN.add(String.valueOf(i));
                i=i-8;
            }

            for (int i = Integer.parseInt(name)+1;i<=64;++i)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                else
                {
                    moveListE.add(String.valueOf(i));
                }
            }
            for (int i = Integer.parseInt(name)-1;i>0;--i)
            {
                if (i%8==0)
                {
                    break;
                }
                else
                {
                    moveListW.add(String.valueOf(i));
                }
            }
            for (int i = Integer.parseInt(name)+9; i<=64;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                moveListSE.add(String.valueOf(i));
                i=i+9;
            }

            for (int i = Integer.parseInt(name)+7; i<=64;)
            {
                if (i%8==0)
                {
                    break;
                }

                moveListSW.add(String.valueOf(i));
                i=i+7;
            }

            for (int i = Integer.parseInt(name)-7; i>0;)
            {
                if ((i-1)%8==0)
                {
                    break;
                }

                moveListNE.add(String.valueOf(i));
                i=i-7;
            }

            for (int i = Integer.parseInt(name)-9; i>0;)
            {
                if (i%8==0)
                {
                    break;
                }

                moveListNW.add(String.valueOf(i));
                i=i-9;
            }
        }

        else if (icon==king)
        {
            Integer i=Integer.parseInt(name);

            if (i-8>0)
            {
                moveListN.add(String.valueOf(i-8));
            }
            if (i+8<=64)
            {
                moveListS.add(String.valueOf(i+8));
            }
            if (i%8==0)
            {
                moveListW.add(String.valueOf(i-1));
                if (i-9>0)
                {
                    moveListNW.add(String.valueOf(i-9));
                }
                if (i+7<=64)
                {
                    moveListSW.add(String.valueOf(i+7));
                }
            }
            else if ((i-1)%8==0)
            {
                moveListE.add(String.valueOf(i+1));
                if (i-7>0)
                {
                    moveListNE.add(String.valueOf(i-7));
                }
                if (i+9<=64)
                {
                    moveListSE.add(String.valueOf(i+9));
                }
            }
            else
            {
                moveListE.add(String.valueOf(i+1));
                moveListW.add(String.valueOf(i-1));

                if(i-9>0)
                {
                    moveListNW.add(String.valueOf(i-9));
                }

                if(i-7>0)
                {
                    moveListNE.add(String.valueOf(i-7));
                }

                if(i+7<=64)
                {
                    moveListSW.add(String.valueOf(i+7));
                }

                if(i+9<=64)
                {
                    moveListSE.add(String.valueOf(i+9));
                }
            }
        }//all algorithms consist of math that represent possible traversals for each piece on the board
        ArrayList [] validMoves = {moveListN, moveListNE, moveListE, moveListSE, moveListS, moveListSW, moveListW, moveListNW};
        return validMoves;
    }
}
