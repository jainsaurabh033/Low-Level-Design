package com.LLD.Low_Level_design.Application.TicTacToe;

import com.LLD.Low_Level_design.Application.TicTacToe.Enum.PieceType;
import com.LLD.Low_Level_design.Application.TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame(){
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO nought = new PlayingPieceO();
        Player player2 = new Player("Player2", nought);

        players.add(player1);
        players.add(player2);

        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean isWinner = true;

        while(isWinner){
            Player playerturn = players.removeFirst();

            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                isWinner = false;
                continue;
            }

            System.out.print("Player:" + playerturn.name + " Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerturn.playingPiece);
            if(!pieceAddedSuccessfully){
                System.out.println("Incorrect position chosen try again");
                players.addFirst(playerturn);
                continue;
            }
            players.addLast(playerturn);

            boolean winner = isWinner(inputRow, inputColumn, playerturn.getPlayingPiece().getPieceType());
            if(winner){
                return playerturn.name;
            }
        }

        return "tie";
    }

    public boolean isWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0;i<gameBoard.size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].getPieceType() != pieceType){
                rowMatch = false;
            }
        }

        for(int i = 0;i<gameBoard.size;i++){
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].getPieceType() != pieceType){
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].getPieceType() != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
