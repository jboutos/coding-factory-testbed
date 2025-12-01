package gr.aueb.cf.cf9.ch4;

public class FourStarsPyramid {
    public static void main(String[] args) {
        for (int i = 1; i <= 4; i++) {
            switch(i) {
                case 1 -> System.out.println("   *   ");
                case 2 -> System.out.println("  ***  ");
                case 3 -> System.out.println(" ***** ");
                case 4 -> System.out.println("*******");
            }
        }
    }
}
