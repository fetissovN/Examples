package example.itentics;


import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        LogicPalindrome logicPalindrome = new LogicPalindrome();
        Calendar calendarBefore = Calendar.getInstance();
        long timeInMillisBefore = calendarBefore.getTimeInMillis();

        long palindrome = logicPalindrome.getPalindrome();

        System.out.println("Biggest palindrome: " + palindrome);
        System.out.print("Multiplier 1: " + logicPalindrome.getPrimeOne());
        System.out.println("  Multiplier 2: " + logicPalindrome.getPrimeTwo());

        Calendar calendarAfter = Calendar.getInstance();
        long timeInMillisAfter = calendarAfter.getTimeInMillis();
        System.out.println("Iteration time: " + (timeInMillisAfter-timeInMillisBefore));
    }

}
