package gr.aueb.cf.cf9.ch12;

public class Main {

    public static void main(String[] args) {
        PointXYZ point = new PointXYZ(2.3, 2.2, 1.1);

        System.out.println("Σημείο: " + point);
        System.out.println("Σημείο: " + point.pointToString());
        System.out.println("Απόσταση XY: " + point.getXYDistance());
        System.out.println("Απόσταση YZ: " + point.getYZDistance());
        System.out.println("Απόσταση XZ: " + point.getXZDistance());
        System.out.println("Απόσταση XYZ: " + point.getXYZDistance());
    }
}
