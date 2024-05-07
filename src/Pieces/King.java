package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class King extends Piece{
    public King(Board board, int column, int row, boolean isWhite){
        super(board);
        this.col = column;
        this.row= row;
        this.xPos = column* board.tileSize;
        this.yPos = row* board.tileSize;
        this.isWhite= isWhite;
        this.name="King";

        this.sprite=sheet.getSubimage(0* sheetScale, isWhite? 0:sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize,board.tileSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row) {
        int colDiff = Math.abs(col - this.col);
        int rowDiff = Math.abs(row - this.row);

        return colDiff == 1 && rowDiff == 0 // Horizontal movement
                || colDiff == 0 && rowDiff == 1 // Vertical movement
                || colDiff == 1 && rowDiff == 1; // Diagonal movement
    }
}
