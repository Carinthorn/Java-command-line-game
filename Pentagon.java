package game_project;

import java.util.Scanner;

public class Pentagon {

        public static Scanner scan = new Scanner(System.in);

        public static void test(){
            System.out.println("Enter the side lenght and the apothem:");
            double side = Input.getDouble();
            double apothem = Input.getDouble();
            System.out.format("Area is %f cm^2\n", areaOfPentagon(side, apothem));

            System.out.println("Enter the height of the pentagon prism:");
            double height = Input.getDouble();
            System.out.format("Volume is %f cm^3\n", volumeOfPentagonPrism(side, apothem, height));

            System.out.println("Enter rise and run: ");
            double rise = Input.getDouble();
            double run = Input.getDouble();
            scan.nextLine();
            System.out.format("The slope is %f",slope(rise, run));


        }

        public static double areaOfPentagon(double side, double apothem){
            return 0.5 * 5 * side * apothem;
        }
        public static double volumeOfPentagonPrism(double side, double apothem, double height){
            return areaOfPentagon(side, apothem) * height;

        }

        public static double slope(double rise, double run){
            return rise/run;

        }

}