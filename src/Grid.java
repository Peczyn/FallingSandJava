import java.util.ArrayList;

public class Grid {
    public boolean isGridRunning = false;
    public ArrayList<ArrayList<Boolean>> grid = new ArrayList<>();



    Grid(int n){
        for(int i=0; i<n; i++)
        {
            ArrayList<Boolean> temp = new ArrayList<>();
            for(int j=0; j<n; j++)
            {
                temp.add(false);
            }
            grid.add(temp);
        }
        (new GridThread()).start();
    }

    public ArrayList<ArrayList<Boolean>> getGrid()
    {
        return grid;
    }

    public int getGridSize()
    {
        return grid.size();
    }

    class GridThread extends Thread{
        @Override
        public void run(){
            while(true) {
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(isGridRunning){

                    for(int i = getGridSize()-2; i>=0; i--) {
                        ArrayList<Boolean> rowUpper = grid.get(i);
                        ArrayList<Boolean> rowLower = grid.get(i+1);

                        for(int j=0; j<getGridSize(); j++){
                            if(!rowUpper.get(j)) continue;
                            if(rowLower.get(j)) continue;

                            rowUpper.set(j,false);
                            rowLower.set(j,true);
                            
                        }
                        grid.set(i,rowUpper);
                        grid.set(i+1,rowLower);
                    }

                }
            }
        }
    }


}
