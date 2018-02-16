package example.testprojectitrex.test2;


import java.util.List;
import java.util.Map;

public class Logic {

    private Map<Integer, String[][]> map;

    private List<String> options;

    private int levels;

    private int rows;

    private int cols;

    private int blockIsCurrentlyAnalysing = 1;

    private int counterTime = 0;

    private int[] princeLocationWhileFalling = new int[2];

    private boolean finished = false;

    public Logic(Map<Integer, String[][]> map, List<String> options) {
        this.map = map;
        this.options = options;
        String levelsStr = options.get(0);
        String rowStr = options.get(1);
        String colStr = options.get(2);
        levels = new Integer(levelsStr);
        rows = new Integer(rowStr);
        cols = new Integer(colStr);
    }

    public int play(){
        boolean trigger = true;
        while (trigger){
            String[][] block = map.get(blockIsCurrentlyAnalysing);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++){
                    if (block[i][j].equals("1")){
                        boolean movedH = moveHorizontally(i, j, block);
                        boolean movedV = moveVertically(i,j, block);
                        if (finished == true){
                            return counterTime;
                        }
                        if (!movedH && !movedV){
                            blockIsCurrentlyAnalysing++;
                            putPrinceOnLowerLevel(i,j);
                        }

                    }
                }

            }
        }
        return counterTime;
    }

    private void putPrinceOnLowerLevel(int i, int j) {
        String[][] block = map.get(blockIsCurrentlyAnalysing);
        if (block[i][j].equals("2")){
            finished = true;
        }else {
            block[i][j] = "1";
            map.put(blockIsCurrentlyAnalysing,block);
        }
    }

    private boolean moveVertically(int i, int j, String[][] block) {
        boolean movedUp = false;
        boolean movedDown = false;


        if (i>0){
            String upperBlock = block[i-1][j];
            if (upperBlock.equals("O")){
                movedUp = false;
            }
            if (upperBlock.equals("2")){
                finished = true;
            }
            if (upperBlock.equals(".")){
                block[i-1][j] = "1";
                block[i][j] = "O";
                movedUp = true;
                switchBlock(block);
            }
        }
        if (i<rows-1){
            String lowerBlock = block[i+1][j];
            if (lowerBlock.equals("0")){
                movedDown = false;
            }
            if (lowerBlock.equals("2")){
                finished = true;
                counterTime++;
            }
            if (lowerBlock.equals(".")){
                block[i+1][j] = "1";
                block[i][j] = "O";
                movedDown = true;
                switchBlock(block);
            }
        }
        return movedUp || movedDown;
    }

    private boolean moveHorizontally(int i, int j, String[][] block) {
        boolean movedLeft = false;
        boolean movedRight = false;


        if (j>0){
            String leftBlock = block[i][j-1];
            if (leftBlock.equals("O")){
                movedLeft = false;
            }
            if (leftBlock.equals("2")){
                finished = true;
                counterTime++;
            }
            if (leftBlock.equals(".")){
                block[i][j-1] = "1";
                block[i][j] = "O";
                movedLeft = true;
                switchBlock(block);
            }
        }
        if (j<cols-1){
            String rightBlock = block[i][j+1];
            if (rightBlock.equals("0")){
                movedRight = false;
            }
            if (rightBlock.equals("2")){
                finished = true;
                counterTime++;
            }
            if (rightBlock.equals(".")){
                block[i][j+1] = "1";
                block[i][j] = "O";
                movedRight = true;
                switchBlock(block);
            }
        }
        return movedLeft || movedRight;
    }

    private void switchBlock(String[][] block) {
        map.put(blockIsCurrentlyAnalysing,block);
        counterTime++;
    }


}
