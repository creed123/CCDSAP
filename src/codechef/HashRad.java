package codechef;

import java.util.Scanner;

public class HashRad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder allAlphas = new StringBuilder();
        for (int i = 'a'; i <=  'a' + 25; i++) {
            allAlphas.append((char) i);
        }
        Integer T = scanner.nextInt();
        while (T > 0) {
            String S = scanner.next();
            System.out.println(calcLexString(S, "", allAlphas.toString(), 0));
            T--;
        }
    }

    private static Integer calSum(String s) {
        Integer sum = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer ch = (int) s.charAt(i);
            sum+=ch;
        }
        return sum;
    }

    public static String calcLexString(String actual, String currString, String allAlphas, Integer currIdx) {
        if (currIdx > 25) {
            if (currString.length() == actual.length() && calSum(actual).equals(calSum(currString))) {
                return currString;
            } else {
                return "";
            }
        }
        if (currString.length() == actual.length() && !calSum(actual).equals(calSum(currString))) {
            return "";
        } else if (currString.length() == actual.length() && calSum(actual).equals(calSum(currString)) && !actual.equals(currString)) {
            return currString;
        }
        String str = calcLexString(actual, currString + allAlphas.charAt(currIdx), allAlphas, currIdx + 1);
        if (str.equals("")) {
            str = calcLexString(actual, currString , allAlphas, currIdx + 1);
        }
        return !str.equals(actual) ? str: "";
    }
}