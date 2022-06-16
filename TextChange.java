package game_project;

public class TextChange {
    public static void test() {
        int i = 2;
        while (i > 1){
            System.out.println("Choose the text:\n 1. A\n 2. B\n 3. C\n 4.Quit \n");
            int ans1 = Main.scan.nextInt();
            String word = "";

            if (ans1 == 1) {
                word = Art.getAText();
            
            } else if (ans1 == 2) {
                word = Art.getBText();
            
            } else if (ans1 == 3) {
                word = Art.getCText();
    
            } else {
                System.out.println("Good bye!");
                break;
    
            }

            System.out.println("Choose the color\n 1. Red\n 2. Blue\n 3. Purple Bold");
            int ans2 = Main.scan.nextInt();
            Main.scan.nextLine();
            String textPrint;
            if (ans2 == 1) {
                textPrint = ColorText.colorize(word, ConsoleColors.RED);
                System.out.println(textPrint);

                if (ans1 == 1) {
                System.out.println(Art.getA());
                } else if (ans1 == 2) {
                System.out.println(Art.getB());
                } else {
                System.out.println(Art.getC());
                }
            
            } else if (ans2 == 2) {
                textPrint = ColorText.colorize(word, ConsoleColors.BLUE);
                System.out.println(textPrint);
                if (ans1 == 1) {
                  System.out.println(Art.getA());
                } else if (ans1 == 2) {
                  System.out.println(Art.getB());
                } else {
                   System.out.println(Art.getC());
            }
            
            } else {
                textPrint = ColorText.colorize(word, ConsoleColors.PURPLE_BOLD);
                System.out.println(textPrint);
                if (ans1 == 1) {
                  System.out.println(Art.getA());
                } else if (ans1 == 2) {
                  System.out.println(Art.getB());
                } else {
                  System.out.println(Art.getC());
                }
            }
            /*Art.pressEnterToContinue();
            Art.clearScreen();*/
        }

    }

}


