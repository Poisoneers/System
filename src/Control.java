import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Buttons: start, stop, pause, resume
//Eventlisteners: to handle the control operations
//TIMER and


public class Control {
    private JFrame frame;
    private Timer timer;
    private int elapsedSeconds = 0;
    private JLabel timerLabel;
    private boolean isRunning = false;
    private boolean isPaused = false;


    public Control() {
        frame = new JFrame("Controller");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        //Timer label
        timerLabel = new JLabel("Time: 00:00");
        timerLabel.setBounds(100,10,100,30);
        frame.add(timerLabel);



        // the control buttons
        JButton startButton = new JButton("Start");
        startButton.setBounds(50, 50, 80, 30);
        startButton.setForeground(Color.GREEN);
        frame.add(startButton);

        JButton pauseButton = new JButton("Pause");
        pauseButton.setBounds(150, 50, 80, 30);
        frame.add(pauseButton);

        JButton resumeButton = new JButton("Resume");
        resumeButton.setBounds(150,100,80, 30);
        frame.add(resumeButton);

        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(50, 100, 80, 30);
        stopButton.setForeground(Color.RED);
        frame.add(stopButton);


        //The timers setup
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                int minutes = elapsedSeconds/ 60;
                int seconds = elapsedSeconds% 60;
                timerLabel.setText(String.format("Time: %02d:%02d",minutes,seconds));
            }
        });





        // Event listeners
        startButton.addActionListener (e -> {
            if( !isRunning){
                elapsedSeconds = 0;
                timer.start();
                isRunning = true;
                isPaused = false;
                System.out.println("Program started.");
            }
        });


        pauseButton.addActionListener(e ->{
            if (isRunning && !isPaused){
                timer.stop();
                isPaused = true;
                System.out.println("Program paused.");
            }
        });



        resumeButton.addActionListener(e -> {
            if (isRunning && isPaused){
                timer.start();
                isPaused = false;
                System.out.println("Program resumed");
            }
        });


        stopButton.addActionListener(e ->  {
            if(isRunning){
                timer.stop();
                isRunning = false;
                isPaused = false;
                JOptionPane.showMessageDialog(frame,String.format("Simulation stopped.\n Total elapsed time: %02d:%02d",
                                elapsedSeconds/60,elapsedSeconds%60),
                "Summary",
                JOptionPane.INFORMATION_MESSAGE);
                elapsedSeconds = 0;
                timerLabel.setText("Time: 00:00");
                System.out.println("Program stopped.");
            }
        });
    }


    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Control gui = new Control();
        gui.show();
    }
}
