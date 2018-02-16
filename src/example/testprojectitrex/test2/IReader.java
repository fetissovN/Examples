package example.testprojectitrex.test2;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IReader {

    List<String> readOptions() throws IOException;

    Map<Integer,String[][]> readBlocks(List<String> options) throws IOException;
}
