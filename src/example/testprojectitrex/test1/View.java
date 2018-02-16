package example.testprojectitrex.test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    public void start(){
        BufferedReader br = null;

        try{

            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.print("Enter something : ");
                String input = br.readLine();



                if ("q".equals(input)) {
                    System.out.println("Exit!");
                    System.exit(0);
                }else {
                    Logic logic = new Logic(input);
                    String s = logic.doJob();

                    System.out.println("-----------\n");
                    System.out.println(s);
                    System.out.println("-----------\n");
                    System.exit(0);
                }
            }

        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
