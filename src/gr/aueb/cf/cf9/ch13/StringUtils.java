package gr.aueb.cf.cf9.ch13;

public class StringUtils {

    public static String reverse(String string) {
        if (string == null) {
            return null;
        }

        //sb is mutable and we can use reverse, strings are immutable
        return new StringBuilder(string).reverse().toString();
    }

    public static String toUppercase(String string) {
        if (string == null) {
            return null;
        }

        //to upper case return a new string, does not mess t=with the string's immutability
        return string.toUpperCase();
    }

    public static boolean isPalindrome(String string) {
        if (string == null) {
            return false;
        }

        int left = 0;
        int right = string.length() - 1;
        string = string.toLowerCase();

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
