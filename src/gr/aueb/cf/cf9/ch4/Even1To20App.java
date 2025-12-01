package gr.aueb.cf.cf9.ch4;

public class Even1To20App {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.printf("%d is an even number%n", i);
            }
        }
    }
}
