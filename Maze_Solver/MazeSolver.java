import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;


public class MazeSolver extends JFrame {
    private int[][] Maze =
            {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                    {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},
                    {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                    {1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                    {1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1},
                    {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1},
                    {1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1},
                    {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                    {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 9, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
//timer for maze Solver
    private JLabel timerLabel;
    private List<Integer> path = new ArrayList<>();
    private Timer timer;
    private int seconds;

    public MazeSolver() {
        setTitle("Maze Solver");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 380);
        setLocation(500, 20);


        //        Timer
        timerLabel = new JLabel("Time: 0");
        add(timerLabel, BorderLayout.NORTH);
//        Taken 1000 MiliSec
        timer = new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timerLabel.setText("Time: " + seconds);
            }
        });

        timer.start();

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                // Start the timer
                seconds = 0;
                timer.start();

                // Stop the timer
                timer.stop();

                if (e.getSource() == solveButton) {
                        DFSTraversal.PathTraversal(Maze, 1, 1, path);
                        System.out.println(path);
                        repaint(); // Call repaint() to update the UI
                    }
                }
        });
        add(solveButton, BorderLayout.SOUTH);


    }

    @Override
    public void paint(Graphics G) {
        G.translate(50, 50);
        for (int i = 0; i < Maze.length; i++) {
            for (int j = 0; j < Maze[0].length; j++) {
                Color color;
                switch (Maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.red;
                        break;
                    default:
                        color = Color.white;
                        break;
                }
                G.setColor(color);
                G.fillRect(30 * j, 30 * i, 30, 30);
                G.setColor(Color.red);
                G.drawRect(30 * j, 30 * i, 30, 30);
            }
        }
        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);

            G.setColor(Color.orange);
            G.fillRect(30 * pathx, 30 * pathy, 30, 30);
            G.setColor(Color.WHITE);
            G.drawRect(30 * pathx, 30 * pathy, 30, 30);
        }
    }

    public static void main(String[] args) {
        MazeSolver view = new MazeSolver();
        view.setVisible(true);
    }
}
