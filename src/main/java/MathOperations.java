import java.util.ArrayList;
import java.util.Map;

import static java.lang.StrictMath.sqrt;

public class MathOperations {
    public static ArrayList<Integer> primeFactorization(int value) {
        ArrayList<Integer> primeNumbersArr = new ArrayList<>();
        int potentialPrimeNumber;
        for (potentialPrimeNumber = 2; potentialPrimeNumber <= value; potentialPrimeNumber++) {
            boolean isPrime = true;
            for (int i = 2; i <= sqrt(potentialPrimeNumber); i++) {
                int mod = potentialPrimeNumber % i;
                if (mod == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbersArr.add(potentialPrimeNumber);
            }
        }
        ArrayList<Integer> newArray = new ArrayList<>();
        int inputNumber = value;
        for (int i = 0; i < primeNumbersArr.size(); i++) {
            int mod = inputNumber % primeNumbersArr.get(i);
            if (mod == 0) {
                newArray.add(primeNumbersArr.get(i));
                inputNumber = inputNumber / primeNumbersArr.get(i);
                i--;
            }
        }
        return newArray;
    }

    static int calculateFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }


    public static int findNOD(int valueA, int valueB) {
        Map<Integer, Integer> primeNumbersMapA = Converter.convertToMap(MathOperations.primeFactorization(valueA));
        Map<Integer, Integer> primeNumbersMapB = Converter.convertToMap(MathOperations.primeFactorization(valueB));
        Map<Integer, Integer> repetitiveNumbers = Operations.findRepetitiveNumbers(primeNumbersMapA, primeNumbersMapB);
        int NOD = 1;
        for (int primeNumber : repetitiveNumbers.keySet())
            NOD *= Math.pow(primeNumber, repetitiveNumbers.get(primeNumber));
        return NOD;
    }
}