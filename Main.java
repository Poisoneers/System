import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Evacuation Simulator");
        window.setSize(600, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoomPanel room = new RoomPanel();
        window.add(room);
        window.setVisible(true);
    }
}


