package game_project;

public class Input {

    // gets the integer from the user
    public static int getInt() {
        int i = Main.scan.nextInt();
        Main.scan.nextLine();

        return i;
    }

    // prints a message and then gets the integer from the user
    public static int getInt(String msg) {
        System.out.print(msg);
        int i = Main.scan.nextInt();
        Main.scan.nextLine();

        return i;
    }

    public static String getString(String question) {
        System.out.println(question);
        String a = Main.scan.nextLine();
        return a;
    }

    public static String getString() {
        String a = Main.scan.nextLine();
        return a;
    }

    public static double getDouble() {

        double i = Main.scan.nextDouble();
        Main.scan.nextLine();
        return i;

    }

    public static double calculate(double a, double b, double c) {
        double aver = (a + b + c) / 3;
        return aver;
    }

    public static void pressEnterToContinue() {
        System.out.println("PRESS ENTER TO CONTINUE");
        Main.scan.nextLine();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void quiet() {
        for (int i = 7; i > 0; i--) {
            Game.sleep(1);
            System.out.print(".");
        }
    }

}
