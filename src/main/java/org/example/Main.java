package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //THIS IS THE BOARD 3X3
        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '},
        };
        //print the starting board
        printBoard(board);

        //this is turning move by player and the computer
        while(true){
            playerMove(board);
            printBoard(board);
            if(isTheGameFinished(board)){
                break;
            }
            computerMove(board);
            printBoard(board);
            if(isTheGameFinished(board)){
                break;
            }

        }


    }

    // winning pattern method
    private static boolean winPattern(char[][] board, char symbols){
        //ROW
        if(((board[0][0] == symbols && board[0][1] == symbols && board[0][2] == symbols) ||
                (board[1][0] == symbols && board[1][1] == symbols && board[1][2] == symbols) ||
                (board[2][0] == symbols && board[2][1] == symbols && board[2][2] == symbols)) ||
                //COLLUMN
                ((board[0][0] == symbols && board[1][0] == symbols && board[2][0] == symbols) ||
                        (board[0][1] == symbols && board[1][1] == symbols && board[2][1] == symbols) ||
                        (board[0][2] == symbols && board[1][2] == symbols && board[2][2] == symbols)) ||
                //SLANT
                (board[0][0] == symbols && board[1][1] == symbols && board[2][2] == symbols) ||
                (board[0][2] == symbols && board[1][1] == symbols && board[2][0] == symbols) ){
            return true;
        }

        return false;
    }

    //check if the game end and it's a tie
    private static boolean tieGame(char [][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //check if the game is finished and who win the game
    private static boolean isTheGameFinished(char[][] board){
        //player pattern
        if(winPattern(board,'X')){
            System.out.println("You win!!");
            printBoard(board);
            return true;
        }
        if(winPattern(board,'O')){
            System.out.println("Computerwin win!!");
            printBoard(board);
            return true;
        }
        if(tieGame(board)){
            System.out.println("its a tie");
            printBoard(board);
            return true;
        }

        return false;
    }

    //check if the move is already taken or it is a valid move
    private static boolean isValidMove(char[][] board, int position){
        switch (position){
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');

            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    //method to place the move in the board
    private static void placeMove(char [][] board, int position, char symbol){
        switch (position){
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    //random move of the computer
    private static void computerMove(char[][] board){
        Random random = new Random();
        int computerMove;
        while(true){
            computerMove = random.nextInt(9)+1;
            if(isValidMove(board,computerMove)){
                break;
            }
        }
        placeMove(board,computerMove,'O');
        System.out.println("Computer move to " + computerMove);

    }

    //player move method
    private static void playerMove(char[][] board){
        int playerMove;
        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("In 1-9 where would you want to put your move ");
            System.out.println("Put your moves"); playerMove = scan.nextInt();
            if(isValidMove(board,playerMove)){
                break;
            }
        }
        placeMove(board,playerMove,'X');

    }


    // the looks of the board
    private static void printBoard(char[][] board){
        System.out.println("|" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + board[2][0] + "|" + board[2][1] + "|" + board[2][2] + "|");
        System.out.println("+-+-+-+");
    }
}