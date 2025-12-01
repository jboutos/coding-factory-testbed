package gr.aueb.cf.cf9.ch7;

public class CipherApp {
    public static void main(String[] args) {
        String original = "HelloWorld";
        String encrypted = encrypt(original);
        String decrypted = decrypt(encrypted);

        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 1)); // επόμενο χαρακτήρα
        }
        return encrypted.toString();
    }

    public static String decrypt(String input) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append((char) (c - 1)); // προηγούμενο χαρακτήρα
        }
        return decrypted.toString();
    }
}
