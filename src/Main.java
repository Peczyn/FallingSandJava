import javax.swing.*;


public class Main extends JFrame{
    public static void main(String[] args) throws InterruptedException {
        Grid griD = new Grid(50);
        new GUI(griD);


    }


}