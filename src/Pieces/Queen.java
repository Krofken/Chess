package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Queen extends Piece{
    public Queen(Board board, int column, int row, boolean isWhite){
        super(board);
        this.column= column;
        this.row= row;
        this.xPos = column* board.tileSize;
        this.yPos = row* board.tileSize;
        this.isWhite= isWhite;
        this.name="Queen";

        this.sprite=sheet.getSubimage(1* sheetScale, isWhite? 0:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row){
        return this.column == col || this.row == row || Math.abs(this.column - col)==Math.abs(this.row-row);
    }
    public boolean moveCollidesWithPieces(int col, int row){
        if (this.column == col || this.row == row) {
            //left
            if (this.column > col) {
                for (int c = this.column - 1; c > col; c--) {
                    if (board.getPiece(c, this.row) != null) {
                        return true;
                    }
                }
            }
            //right
            if (this.column < col) {
                for (int c = this.column + 1; c < col; c++) {
                    if (board.getPiece(c, this.row) != null) {
                        return true;
                    }
                }
            }
            //left
            if (this.row > row) {
                for (int r = this.row - 1; r > row; r--) {
                    if (board.getPiece(this.column, r) != null) {
                        return true;
                    }
                }
            }
            //right
            if (this.row < row) {
                for (int r = this.row + 1; r < row; r++) {
                    if (board.getPiece(this.column, r) != null) {
                        return true;
                    }
                }
            }
        }else {
            // Up left
            if (this.column > col && this.row > row) {
                for (int i = 1; i < Math.abs(this.column - col); i++) {
                    if (board.getPiece(this.column - i, this.row - i) != null) {
                        return true;
                    }
                }
            }
            // Up right
            if (this.column < col && this.row > row) {
                for (int i = 1; i < Math.abs(this.column - col); i++) {
                    if (board.getPiece(this.column + i, this.row - i) != null) {
                        return true;
                    }
                }
            }
            // Down left
            if (this.column > col && this.row < row) {
                for (int i = 1; i < Math.abs(this.column - col); i++) {
                    if (board.getPiece(this.column - i, this.row + i) != null) {
                        return true;
                    }
                }
            }
            // Down right
            if (this.column < col && this.row < row) {
                for (int i = 1; i < Math.abs(this.column - col); i++) {
                    if (board.getPiece(this.column + i, this.row + i) != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
