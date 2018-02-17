package example.itentics;

import java.util.ArrayList;
import java.util.List;


public class LogicPalindrome {

    private List<Integer> primes = new ArrayList<>();

    private long palindrome;
    private long primeOne = 0;
    private long primeTwo = 0;

    private final int max = 99999;
    private final int min = 10001;

    public LogicPalindrome() {
        createListOfSimpleNumbers();
    }


    /**
     *  Looping primes list with borders to avoid useless iterations
     * @return long palindrome value
     */
    public long getPalindrome() {
        int size = primes.size()-1;

        for (int i = size; i > 0; i--) {
            long primeOne = primes.get(i);
            //bottom border - no sense to go further
            if (primeOne < this.primeTwo){
                break;
            }
            for (int j = size; j > 0; j--) {
                long primeTwo = primes.get(j);
                //bottom border of second loop
                if (primeTwo < this.primeTwo){
                    break;
                }
                //Top border of second loop
                if (this.primeTwo != 0 && primeTwo > this.primeOne){
                    continue;
                }

                long result = primeOne * primeTwo;
                String strResult = String.valueOf(result);
                if (strResult.equals(new StringBuilder(strResult).reverse().toString())) {
                    if (result > palindrome){
                        palindrome = result ;
                        this.primeOne = primeOne;
                        this.primeTwo = primeTwo;
                    }
                    break;
                }
            }
        }
        return palindrome;
    }


    private void createListOfSimpleNumbers() {

        for (int i = min; i < max; i += 2){
            if (i%5 == 0){
                continue;
            }else {
                if (isPrime(i)){
                    primes.add(i);
                }
            }
        }
    }

    private boolean isPrime(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public long getPrimeOne() {
        return primeOne;
    }


    public long getPrimeTwo() {
        return primeTwo;
    }

}
