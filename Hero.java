//convert colortext.yellow to keyword
//game name : isolation
package game_project;

import java.util.Random;
import java.lang.String;
import java.util.ArrayList;

public class Hero {
    static Random random = new Random();
    public static String name;
    public static int strength;
    public static int agility;
    public static int intelligence;
    public static String role;
    public static int health = 0;
    public static int currency = 10;
    public static int round = 2;
    public static int text;
    public static String ans;
    public static Boolean alive;

    // hero item
    public static ArrayList<Item> collected_item = new ArrayList<Item>();
    //// here go to quest class to build quest
    public static ArrayList<Quest> collected_quest = new ArrayList<Quest>();
    public static ArrayList<Quest> completed_quest = new ArrayList<Quest>();
    public static ArrayList<String> friend_list = new ArrayList<String>();


    public static String keyword(String word) {
        return ColorText.yellow(word);
    }

    public static String place(String word) {
        return ColorText.green_bold(word);
    }

    public static String currency(String word) {
        return ColorText.blue(word);
    }

    public static String attack(String word) {
        return ColorText.red(word);
    }

    public static void invalidAnswer() {
        System.out.println(Hero.attack("Enter a valid choice"));
    }

    public static boolean hasQuest(int num) {
        for (Quest i : Hero.collected_quest) {
            if (i.id == num) {
                return true;
            }
        }
        return false;

    }

    public static boolean hasItem(int num) {
        for (Item i : Hero.collected_item) {
            if (i.id == num) {
                return true;
            }
        }
        return false;
    }

    public static void addItem(Item item) {
        Hero.collected_item.add(item);
        System.out.format("\n%s \n", keyword("Item received:" + item.name));
    }

    public static void addQuest(Quest quest) {
        Hero.collected_quest.add(quest);
        System.out.format(Hero.keyword("\nQuest %d received\n\n"), quest.id);
    }

    /// here 9dec
    public static void add_completedQuest(Quest quest) {
        Hero.completed_quest.add(quest);
        System.out.format(Hero.keyword("Quest %d completed"), quest.id);
    }
    /// Here return which value

    public static void checkItem() {
        System.out.println("\nItems acquired: ");
        for (Item i : Hero.collected_item) {
            System.out.format("%s,", i.name);
        }
    }

    public static int moneyLeft(int spent) {
        Hero.currency = Hero.currency - spent;
        System.out.format("\nYou have %s golds left", ColorText.yellow(String.valueOf(Hero.currency)));
        return Hero.currency;

    }

    public static String heroLeave() {
        String ans = Input.getString("You want to leave(Y/N)");
        if (ans.equalsIgnoreCase("y")) {
            return Locations.VALLEY;
        } else {
            System.out.println("good decision");
            return null;
        }
    }

    public static int takedamage(int damage) {
        System.out.format(Hero.attack("\nHealth - %s"), Integer.toString(damage));
        if (Hero.health < 6) {
            System.out.format("\n%s ", Hero.attack("You need healing"));
        } else {
            System.out.format("\nYour health: ");
        }
        return Hero.health - damage;

    }

    public static int healing(int heal) {
        Hero.health += heal;
        System.out.format(Hero.keyword("Healing is complete: Health + %d"), heal);
        return Hero.health;
    }

    public static Boolean isDead() {
        if (Hero.health <= 0) {
            return true;
        }
        return false;
    }

    public static void generate() {
        do {
            greet();
            while (text < 2 || text > 10) {
                String alert = ColorText.red("Your name should contain 2-10 letters!!");
                System.out.println(alert);
                greet();
            }
            strength = Game.randomStat(15, 25);
            agility = Game.randomStat(15, 25);
            intelligence = Game.randomStat(15, 25);

            assign_role();
            display();
            reassign_role();

            if (ans.equalsIgnoreCase("no")) {
                System.out.println("WELCOME TO ISOLATION");
                break;
            } else if (ans.equalsIgnoreCase("yes")) {
                --round;
                System.out.format("%d chance to change\n", round);
            }

            while ((!ans.equalsIgnoreCase("yes")) && (!ans.equalsIgnoreCase("no"))) {
                Hero.invalidAnswer();
                reassign_role();
            }

        } while (round > 0);
    }

    public static int greet() {
        System.out.print("\nWhat's your name: ");
        name = Main.scan.nextLine();
        text = name.length();
        return text;

    }

    public static void display() {

        System.out.println("\nYou are assigned as a....\n");
        if (role.equals("1")) {
            System.out.println(Art.text1());
        } else if (role.equals("2")) {
            System.out.println(Art.text2());
        } else if (role.equals("3")) {
            System.out.println(Art.text3());
        }

        String result = Hero.keyword("-------------------------------\nRESULT\n-------------------------------");
        String result2 = String.format(
                "\n %s --> Skill acquired \nright now you have\n %d agility\n %d strength \n %d intelligence\n %d gold\n %d  health\n",
                name, agility, strength, intelligence, currency, health);
        result2 = Hero.keyword(result2);
        System.out.println(result + result2);

    }

    public static String assign_role() {
        System.out.println("Pick one role 1)warrior 2)wizard 3)hunter: ");
        role = Input.getString();

        while (!role.equals("1") && !role.equals("2") && !role.equals("3")) {
            String alert2 = ColorText.red("Input number 1 or 2 or 3 only");
            System.out.println(alert2);
            System.out.println("Pick one role 1)warrior 2)wizard 3)hunter: ");
            role = Input.getString();
        }
        if (role.equals("1")) {
            agility = +5;
            currency = +1500;
            health = +45;
        } else if (role.equals("2")) {
            intelligence = +5;
            currency = +3000;
            health = +20;
        } else if (role.equals("3")) {
            strength = +5;
            currency = +2000;
            health = +30;
        } else {
            Hero.invalidAnswer();
        }
        return role;
    }

    public static String reassign_role() {
        System.out.println("Pick a new role?(yes/no)");
        ans = Main.scan.nextLine();
        return ans;
    }

    public static String openMap() {
        System.out.println(
                Hero.place("\nJungle ---> Field -----> Path to the abandoned farm(pfarm)-----> Abandoned farm(farm)"));
        String nextplace = Input.getString("where to go next?");
        do {
            if (nextplace.equalsIgnoreCase("field")) {
                return Locations.FIELD;
            } else if (nextplace.equalsIgnoreCase("pfarm")) {
                return Locations.PATH_TO_ABANDON_FARM;
            } else if (nextplace.equalsIgnoreCase("farm")) {
                return Locations.ABANDON_FARM;
            } else {
                Hero.invalidAnswer();
            }

        } while (true);

    }

}
