package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{
    public Pawn(Board board, int column, int row, boolean isWhite){
        super(board);
        this.col = column;
        this.row= row;
        this.xPos = column* board.tileSize;
        this.yPos = row* board.tileSize;
        this.isWhite= isWhite;
        this.name="Pawn";
        this.isFirstMove=true;

        this.sprite=sheet.getSubimage(5* sheetScale, isWhite? 0:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row) {
        int colorIndex= isWhite ? 1:-1;

        //push pawn 1
        if (this.col == col && row==this.row-colorIndex && board.getPiece(col,row)==null){
            return true;
        }
        if (isFirstMove &&
                this.col == col &&
                row == (this.row - (colorIndex * 2)) &&
                board.getPiece(col, row) == null &&
                board.getPiece(col, row + colorIndex) == null) {

            return true;
        }
        //capture left
        if (col==this.col - 1 && row == this.row -colorIndex && board.getPiece(col,row)!=null){
            return true;
        }
        if (col==this.col + 1 && row == this.row -colorIndex && board.getPiece(col,row)!=null){
            return true;
        }

        return false;
    }
}
