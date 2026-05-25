package com.LLD.Low_Level_design.Application.TicTacToe.Model;

import com.LLD.Low_Level_design.Application.TicTacToe.Enum.PieceType;

public class PlayingPiece {
    PieceType pieceType;

    public PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }

    public PieceType getPieceType(){
        return pieceType;
    }

    public void setPieceType(PieceType pieceType){
        this.pieceType = pieceType;
    }
}
