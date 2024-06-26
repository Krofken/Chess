package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{
    public Bishop(Board board, int column, int row, boolean isWhite){
        super(board);
        this.col = column;
        this.row= row;
        this.xPos = column* board.tileSize;
        this.yPos = row* board.tileSize;
        this.isWhite= isWhite;
        this.name="Bishop";

        this.sprite=sheet.getSubimage(2* sheetScale, isWhite? 0:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row){
        return Math.abs(this.col - col)==Math.abs(this.row-row);
    }
    //up left
    public boolean moveCollidesWithPieces(int col, int row) {
        // Up left
        if (this.col > col && this.row > row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getPiece(this.col - i, this.row - i) != null) {
                    return true;
                }
            }
        }
        // Up right
        if (this.col < col && this.row > row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getPiece(this.col + i, this.row - i) != null) {
                    return true;
                }
            }
        }
        // Down left
        if (this.col > col && this.row < row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getPiece(this.col - i, this.row + i) != null) {
                    return true;
                }
            }
        }
        // Down right
        if (this.col < col && this.row < row) {
            for (int i = 1; i < Math.abs(this.col - col); i++) {
                if (board.getPiece(this.col + i, this.row + i) != null) {
                    return true;
                }
            }
        }
        return false;
    }



}
