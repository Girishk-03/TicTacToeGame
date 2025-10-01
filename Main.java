import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        char[][] baord=new char[3][3];
        //first make board has empty
        for(int row=0;row< baord.length;row++)
        {
            for (int col=0;col< baord[0].length;col++)
            {
                baord[row][col]=' ';//empty
            }
        }


        char player='X';

        //for gameover and checking won or not
        boolean gameOver=false;//starting make it false

        while(!gameOver)
        {
            //after that print board
            printBoard(baord);

            //player has make move if game is not over
            //player has to place at certain row & col
            int row=sc.nextInt();
            int col= sc.nextInt();

            //if the player entered box is empty means insert
            if(baord[row][col]==' ')
            {
                baord[row][col]=player;
                //make sure to check game is over
                gameOver=HasWon(baord,player);//prints true or false here..

                //if gameOver is true means print player has won
                if(gameOver)
                {
                    System.out.println("Player " +player+  "has Won The Game!..");
                }
                else//give chance for another player to move
                {
//                    if(player=='X')
//                    {
//                        player='0';
//                    }
//                    else
//                    {
//                        player='X';
//                    }
                    player=(player=='X')?'0':'X';
                }


            }
            //if board is not empty and game is not over means it is not valid game and no one as not won
            else
            {
                System.out.println("Invalid Move.. make Valid move ");
            }

            if(!(baord[row][col] ==' '))
            {
                System.out.println("Game over");
            }

        }
        //At final print board has final
        printBoard(baord);

        if(HasWon(baord,player))
        {
            System.out.println("Player "+player+" Has Won The Game");
        }


    }

    private static boolean HasWon(char[][] baord, char player)
    {
        //by checking conditions
        //if any one conditions becomes true means player has won
        //for row check
        for(int row=0;row< baord.length;row++)
        {
            if(baord[row][0]==player && baord[row][1]==player && baord[row][2]==player)
            {
                return true;
            }

        }

        //for col check
        for(int col=0;col< baord[0].length;col++)
        {
            if(baord[0][col]==player && baord[1][col]==player && baord[2][col]==player)
            {
                return true;
            }

        }

        //for diagonal check
        if(baord[0][0]==player && baord[1][1]==player && baord[2][2]==player)
        {
            return true;
        }

        if(baord[0][2]==player && baord[1][1]==player && baord[2][0]==player)
        {
            return true;
        }


        //otherwise player has not won
        return false;
    }


    private static void printBoard(char[][] baord)
    {
        for(int row=0;row< baord.length;row++)
        {
            for (int col=0;col< baord[0].length;col++)
            {
                System.out.print(baord[row][col]+" | ");
            }
            System.out.println();
        }

    }
}