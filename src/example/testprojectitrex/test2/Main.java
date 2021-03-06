package example.testprojectitrex.test2;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            Reader reader = new Reader();
            List<String> options = reader.readOptions();
            Map<Integer, String[][]> map = reader.readBlocks(options);
            reader.close();

            Logic logic = new Logic(map,options);
            int steps = logic.play();
            System.out.println(steps*5+" seconds");


        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Check your labyrinth!");
        } catch (IndexOutOfBoundsException e){
            System.out.println("Wrong options");
        } catch (IOException e) {
            System.out.println("Check your file name and location");
        }
    }
}
