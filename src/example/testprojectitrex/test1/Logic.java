    package example.testprojectitrex.test1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Logic {

    private static String text;
    private static final String C = "c";

    private static final String A = "a";
    private static final String AN = "an";
    private static final  String THE = "the";

    public Logic(String input) {
        this.text = input;
    }

    public String doJob() {
        String[] splitedText = text.split(" ");
        StringBuilder withoutC= checkC(splitedText);

        String[] withoutCArray  = withoutC.toString().split(" ");
        StringBuilder doubleRemovedText = checkDouble(withoutCArray);

        String[] doubleRemovedTextArray = doubleRemovedText.toString().split(" ");
        StringBuilder textWithNoE = removerLastLetter(doubleRemovedTextArray);

        StringBuilder finalText = removeArticles(text, textWithNoE);
        return finalText.toString();
    }

    private StringBuilder checkC(String[] splitedText){

        StringBuilder totalString = new StringBuilder();
        for (int i = 0; i < splitedText.length; i++) {
            StringBuilder sBuilder = new StringBuilder(splitedText[i]);

            while (true) {
                int c = sBuilder.indexOf(C);
                if (c != -1) {
                    if (c == sBuilder.length()-1){
                        sBuilder.replace(c, c + 1, "k");
                        totalString.append(sBuilder + " ");
                        break;
                    }
                    if (!String.valueOf(sBuilder.charAt(c + 1)).equals("i")
                            && !String.valueOf(sBuilder.charAt(c + 1)).equals("e")) {
                        sBuilder.replace(c, c + 1, "k");
                    } else if (String.valueOf(sBuilder.charAt(c + 1)).equals("i")) {
                        sBuilder.replace(c, c + 2, "si");
                    } else if (String.valueOf(sBuilder.charAt(c + 1)).equals("e")) {
                        sBuilder.replace(c, c + 2, "se");
                    }
                } else {
                    totalString.append(sBuilder + " ");
                    break;
                }

            }
        }
        return totalString;
    }

    private StringBuilder checkDouble(String[] withoutC){
        boolean wordIsChecking;
        StringBuilder totalString = new StringBuilder();
        for (int i = 0; i < withoutC.length; i++) {
            wordIsChecking = true;
            StringBuilder sBuilder = new StringBuilder(withoutC[i]);
            while (wordIsChecking){
                String checkWord = sBuilder.toString();
                for (int j = 0; j < sBuilder.length(); j++) {
                    if (j == sBuilder.length()-1){
                        totalString.append(sBuilder+" ");
                        wordIsChecking = false;
                        break;
                    }
                    if (String.valueOf(sBuilder.charAt(j))
                            .equals(String.valueOf(sBuilder.charAt(j+1)))){
                        if (String.valueOf(sBuilder.charAt(j)).equals("e")){
                            sBuilder.replace(j,j+2,"i");
                        }else if (String.valueOf(sBuilder.charAt(j)).equals("o")){
                            sBuilder.replace(j,j+2,"u");
                        }else {
                            sBuilder.replace(j,j+2,String.valueOf(sBuilder.charAt(j)));
                        }
                    }
                }
                if (checkWord.equals(sBuilder.toString())){
                    break;
                }
            }
        }
        return totalString;
    }

    private StringBuilder removerLastLetter(String[] doubleRemovedText) {
        StringBuilder totalString = new StringBuilder();
        for (int i = 0; i < doubleRemovedText.length; i++) {
            StringBuilder sBuilder = new StringBuilder(doubleRemovedText[i]);
            String lastChar = String.valueOf(sBuilder.charAt(sBuilder.length()-1));

            if (sBuilder.length() > 1
                    && lastChar.equals("e")){
                sBuilder.deleteCharAt(sBuilder.length()-1);
            }
            totalString.append(sBuilder+" ");
        }
        return totalString;
    }


    private StringBuilder removeArticles(String text, StringBuilder textWithNoE) {
        String[] inputTextArray = text.split(" ");
        List<Integer> integers = new ArrayList<>(inputTextArray.length);
        for (int i = 0; i < inputTextArray.length; i++) {
            if (inputTextArray[i].equals(A)
                    || inputTextArray[i].equals(AN)
                    || inputTextArray[i].equals(THE)){
                integers.add(i);
            }
        }
        String[] finalArray = textWithNoE.toString().split(" ");
        List<String> stringList = new LinkedList<>(Arrays.asList(finalArray));
        for (Integer i: integers) {
            stringList.remove((int)i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s: stringList) {
            stringBuilder.append(s+" ");
        }
        return stringBuilder;
    }

}
