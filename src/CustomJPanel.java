import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class CustomJPanel extends JPanel {
    static int i = 0;
    private Grid grid1;
    public ArrayList<Block> blockArray;

    CustomJPanel(Grid grid){
        setSize(800,800);
        grid1 = grid;
        (new AnimationThread()).start();
        blockArray = new ArrayList<>();


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point coords = getMousePosition();
                if(coords == null) return;

                int row = coords.y/(getWidth()/grid1.getGridSize());
                int col = coords.x/(getWidth()/grid1.getGridSize());



                ArrayList<Boolean> temp = grid1.grid.get(row);
                if(!temp.get(col))
                {
                    blockArray.add(new Block(row, col));
                    temp.set(col, true);
                    grid1.grid.set(row,temp);
                }


            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;


        int gridSize = grid1.getGridSize();
        float size = (float) getWidth() /gridSize;
        //WYRYSOWAC MATRIX PIASKU
//        for(int i=0; i<gridSize; i++)
//        {
//            for(int j=0; j<gridSize; j++)
//            {
//                g2d.draw(new Rectangle2D.Float(size*j, size*i, size, size));
//                ArrayList<Boolean> gridRow = grid1.grid.get(i);
//                if(gridRow.get(j))
//                {
//                    g2d.fill(new Rectangle2D.Float(size*j, size*i, size, size));
//                }
//            }
//        }

        //RYSUJ ARRAYBLOCK
        for (Block block : blockArray) {
            g2d.fill(new Rectangle2D.Float(size*block.col, size*block.row, size, size));
        }

    }

    class AnimationThread extends Thread{
        @Override
        public void run(){
            while(true)
            {
//                System.out.println("JPANEL: " + grid1.grid.get(0));
                repaint();
            }
        }
    }









}
