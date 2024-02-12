import javax.swing.*;


public class Main extends JFrame{
    public static void main(String[] args) throws InterruptedException {
        Grid griD = new Grid(100);
        new GUI(griD);


    }


}