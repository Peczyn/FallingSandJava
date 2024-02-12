import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{ public JPanel all = new JPanel();
    GUI(Grid grid){
        super("Okno");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700,700);

        CustomJPanel matrix = new CustomJPanel(grid);
        matrix.setPreferredSize(new Dimension(600,600));

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout());

        all.setLayout(new BorderLayout());

        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Boolean> temp = new ArrayList<>();
                for(int i =0; i<grid.getGridSize(); i++)
                {
                    temp.add(true);
                }
                grid.grid.set(1,temp);
                grid.isGridRunning = true;
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.isGridRunning = false;
            }
        });

        north.add(start);
        north.add(stop);
        all.add(north, BorderLayout.NORTH);
        all.add(matrix, BorderLayout.CENTER);
        System.out.println("1");

        setContentPane(all);
        pack();
        setResizable(true);
        setVisible(true);
    }
}
