import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RoomPanel extends JPanel {
    private ArrayList<Obstacle> obstacles;

public RoomPanel() {
    obstacles = new ArrayList<>();
    
    int tableWidth = 30;
    int tableHeight = 20;
    int rows = 13;
    int cols = 4;

    int spacingX = 50;
    int spacingY = 50;

   
    int startX1 = 64;
    int startY1 = 60;

    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            int x = startX1 + col * spacingX;
            int y = startY1 + row * spacingY;
            obstacles.add(new Obstacle(x, y, tableWidth, tableHeight));
        }
    }

    
    int startX2 = 340; 
    int startY2 = 60;

    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            int x = startX2 + col * spacingX;
            int y = startY2 + row * spacingY;
            obstacles.add(new Obstacle(x, y, tableWidth, tableHeight));
        }
    }
}



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Room background
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Outer walls
        g.setColor(Color.DARK_GRAY);
        int wallThickness = 30;
        g.fillRect(0, 0, getWidth(), wallThickness); // Top
        g.fillRect(0, 0, wallThickness, getHeight()); // Left
        g.fillRect(0, getHeight() - wallThickness, getWidth(), wallThickness); // Bottom
        g.fillRect(getWidth() - wallThickness, 0, wallThickness, getHeight()); // Right

        // Exits
        g.setColor(Color.GREEN);
        g.fillRect(getWidth() / 2 - 25, 0, 50, wallThickness); // Top exit
        g.fillRect(getWidth() / 2 - 25, getHeight() - wallThickness, 50, wallThickness); // Bottom exit

        
        for (Obstacle obs : obstacles) {
            obs.draw(g);
        }
    }
}
