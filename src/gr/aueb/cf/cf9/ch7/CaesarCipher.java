package gr.aueb.cf.cf9.ch7;

public class CaesarCipher {
    public static void main(String[] args) {
        String original = "HelloWorld";
        int key  = 3;
        String encrypted = encrypt(original, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Original: " + original);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + key));
        }

        return encrypted.toString();
    }

    public static String decrypt(String input, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            decrypted.append((char) (c - key));
        }

        return decrypted.toString();
    }

    // Encrypt: shift characters to the RIGHT by 'key' positions
    public static String encrypt2(String input, int key) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') { // Uppercase letters
                char newChar = (char) ('A' + (c - 'A' + key) % 26);
                encrypted.append(newChar);
            } else if (c >= 'a' && c <= 'z') { // Lowercase letters
                char newChar = (char) ('a' + (c - 'a' + key) % 26);
                encrypted.append(newChar);
            } else { // Non-letters (spaces, punctuation, numbers) stay the same
                encrypted.append(c);
            }
        } return encrypted.toString();
    }
    // Decrypt: shift characters to the LEFT by 'key' positions
    public static String decrypt2(String input, int key) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                char newChar = (char) ('A' + (c - 'A' - key + 26) % 26);
                decrypted.append(newChar);
            } else if (c >= 'a' && c <= 'z') {
                char newChar = (char) ('a' + (c - 'a' - key + 26) % 26);
                decrypted.append(newChar);
            } else {
                decrypted.append(c);
            }
        } return decrypted.toString();
    }
}
