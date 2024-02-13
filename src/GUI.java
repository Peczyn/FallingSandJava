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
        JButton reset = new JButton("Reset");
        JRadioButton showGrid = new JRadioButton("Show Grid");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.isGridRunning = true;
            }
        });

        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.isGridRunning = false;
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.isGridRunning = false;
                for(ArrayList<Boolean> arr : grid.grid)
                {
                    for(int i =0; i<grid.getGridSize(); i++)
                    {
                        arr.set(i,false);
                    }
                }
            }
        });

        showGrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.isGridShown = !grid.isGridShown;
            }
        });

        showGrid.setSelected(true);

        north.add(start);
        north.add(stop);
        north.add(reset);
        north.add(showGrid);
        all.add(north, BorderLayout.NORTH);
        all.add(matrix, BorderLayout.CENTER);
        System.out.println("1");

        setContentPane(all);
        pack();
        setResizable(true);
        setVisible(true);
    }
}
