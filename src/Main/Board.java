package Main;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    public int tileSize = 85;

    int rolls = 8;
    int columns = 8;

    public Board(){

        this.setPreferredSize(new Dimension(columns*tileSize,rolls*tileSize));
        this.setBackground(Color.green);
    }
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        for (int r = 0;r < rolls;r++){
            for (int c = 0;c < columns;c++){
                g2d.setColor((c+r) % 2 == 0 ? new Color(85, 39, 196, 255) : new Color(3, 7, 10));
                g2d.fillRect(c*tileSize,r*tileSize,tileSize,tileSize);
            }
        }
    }

}
