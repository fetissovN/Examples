package example.testprojectitrex.test2;


import java.io.*;
import java.util.*;

class Reader implements IReader{

    private final String file = "input.txt";
    private LineNumberReader br;


    Reader() throws IOException {
        br = new LineNumberReader(new FileReader(file));
    }

    @Override
    public List<String> readOptions() throws IOException {
        List<String> list = new ArrayList<>();
        String line = br.readLine();
            if (line != null) {
                String[] stringsArr = line.split(",");
                List<String> strings = Arrays.asList(stringsArr);
                list.addAll(strings);
            }
        return list;
    }

    @Override
    public Map<Integer,String[][]> readBlocks(List<String> options) throws IOException, IndexOutOfBoundsException {
        String levelsStr = options.get(0);
        String rowStr = options.get(1);
        String colStr = options.get(2);
        int levels = new Integer(levelsStr);
        int rows = new Integer(rowStr);
        int cols = new Integer(colStr);

        Map<Integer,String[][]> map = new HashMap<>();
        String[][] block = new String[rows][cols];
        int count = 0;
        int times = 1;
        for (String line = null; (line = br.readLine()) != null;) {
            if (br.getLineNumber() > 2) {
                String[] split = line.split("");
                if (line.equals("")){
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    block[count][j] = split[j];
                }
                count++;
                if (count == rows){
                    map.put(times,block);
                    block = new String[rows][cols];
                    count = 0;
                    times++;
                }
            }
        }
        return map;
    }

    public void close() throws IOException {
        br.close();
    }

}
