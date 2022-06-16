package game_project;

public class ColorText{
    public static String colorize(String text, String color){
        return color + text + ConsoleColors.RESET;
    }

    public static String red(String text){
        return colorize(text, ConsoleColors.RED);
    }
    
    public static String blue(String text){
        return colorize(text, ConsoleColors.BLUE);
    }

    public static String purple_bold(String text){
        return colorize(text, ConsoleColors.PURPLE_BOLD);
    }

    public static String blue_bold(String text){
        return colorize(text, ConsoleColors.BLUE_BOLD);
    }

    public static String green_bold(String text){
        return colorize(text, ConsoleColors.GREEN_BOLD);
    }
    public static String yellow(String text){
        return colorize(text, ConsoleColors.YELLOW);
    }

   
//for game
    public static String choice(String text){
        return colorize(text, ConsoleColors.YELLOW);
    }




}