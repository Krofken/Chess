package Main;

import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Board extends JPanel {

    public int tileSize = 85;

    int row = 8;
    int column = 8;
    public Piece selectedPiece;
    ArrayList<Piece> pieceList = new ArrayList<>();

    Input input = new Input(this);
    public Board(){

        this.setPreferredSize(new Dimension(column *tileSize, row *tileSize));
        this.setBackground(Color.green);
        addPieces();

        this.addMouseListener(input);
        this.addMouseMotionListener(input);
    }

    public Piece getPiece(int columns, int rolls){
        for (Piece piece : pieceList){
            if(piece.column==columns&&piece.row==rolls){
                return piece;
            }
        }
        return null;
    }

    public void makeMove(Move move){
        move.piece.column = move.newCol;
        move.piece.row= move.newRow;
        move.piece.xPos = move.newCol * tileSize;
        move.piece.yPos = move.newRow * tileSize;
        capture(move);
    }

    public void capture(Move move){
        pieceList.remove(move.capture);
    }
    public boolean isValidMove(Move move){
        if (sameTeam(move.piece, move.capture)){
            return false;
        }
        if (!move.piece.isValidMovement(move.newCol,move.newRow)){
            return false;
        }
        if (move.piece.moveCollidesWithPieces(move.newCol,move.newRow)){
            return false;
        }

    return true;
    }

    public boolean sameTeam(Piece p1, Piece p2){
        if (p1 == null || p2 ==null){
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }
    public void addPieces(){
        pieceList.add(new Rook(this,0,0,false));
        pieceList.add(new Knight(this,1,0,false));
        pieceList.add(new Bishop(this,2,0,false));
        pieceList.add(new King(this,3,0,false));
        pieceList.add(new Queen(this,4,0,false));
        pieceList.add(new Bishop(this,5,0,false));
        pieceList.add(new Knight(this,6,0,false));
        pieceList.add(new Rook(this,7,0,false));

        pieceList.add(new Pawn(this,0,1,false));
        pieceList.add(new Pawn(this,1,1,false));
        pieceList.add(new Pawn(this,2,1,false));
        pieceList.add(new Pawn(this,3,1,false));
        pieceList.add(new Pawn(this,4,1,false));
        pieceList.add(new Pawn(this,5,1,false));
        pieceList.add(new Pawn(this,6,1,false));
        pieceList.add(new Pawn(this,7,1,false));

        pieceList.add(new Rook(this,0,7,true));
        pieceList.add(new Knight(this,1,7,true));
        pieceList.add(new Bishop(this,2,7,true));
        pieceList.add(new King(this,4,7,true));
        pieceList.add(new Queen(this,3,7,true));
        pieceList.add(new Bishop(this,5,7,true));
        pieceList.add(new Knight(this,6,7,true));
        pieceList.add(new Rook(this,7,7,true));

        pieceList.add(new Pawn(this,0,6,true));
        pieceList.add(new Pawn(this,1,6,true));
        pieceList.add(new Pawn(this,2,6,true));
        pieceList.add(new Pawn(this,3,6,true));
        pieceList.add(new Pawn(this,4,6,true));
        pieceList.add(new Pawn(this,5,6,true));
        pieceList.add(new Pawn(this,6,6,true));
        pieceList.add(new Pawn(this,7,6,true));
    }
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        //Paint the board
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                g2d.setColor((c + r) % 2 == 0 ? new Color(133, 49, 49, 255) : new Color(175, 81, 81));
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }
        //Paint the pieces
        for (Piece piece: pieceList){
            piece.paint(g2d);
        }


        //Paint the highlights
        if (selectedPiece!=null) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        g2d.setColor(new Color(2, 255, 0, 107));
                        g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
                    }
                }
            }
        }

    }

}
