package gr.aueb.cf.cf9.ch4;

public class Sum1To50 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 50; i++) {
            sum += i;
        }
        System.out.printf("The sum of the 50 first integers is %d%n", sum);
    }
}
