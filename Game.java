package game_project;

public class Game {
    public static Item potion = new Item("potion", 1000, Item.POTION, "unknown booster");

    public static int randomStat(int min, int max) {
        int num = (int) Math.floor(Math.random() * (max - min) + min);
        return num;
    }

    public static void sleep(int seconds) {
        long start = System.currentTimeMillis();
        while (start >= System.currentTimeMillis() - seconds * 1000)
            ;

    }

    public static void start() {
        System.out.println(Art.title());
        Hero.generate();
        String nextLocation = Locations.VALLEY;
        do {
            if (nextLocation.equalsIgnoreCase(Locations.VALLEY)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Game.doValley();
            } else if (nextLocation.equalsIgnoreCase(Locations.SHOP)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Shop.doShop();
            } else if (nextLocation.equalsIgnoreCase(Locations.MOUNTAIN)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Game.doMountain();
            } else if (nextLocation.equalsIgnoreCase(Locations.JUNGLE)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Jungle.doJungle();
            } else if (nextLocation.equalsIgnoreCase(Locations.FIELD)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Field.doField();
            } else if (nextLocation.equalsIgnoreCase(Locations.PATH_TO_ABANDON_FARM)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Game.doPath_to_abandon_farm();
            } else if (nextLocation.equalsIgnoreCase(Locations.ABANDON_FARM)) {
                Game.sleep(2);
                Input.clearScreen();
                nextLocation = Abandon_farm.doAbandon_farm();
            } else if (nextLocation.equalsIgnoreCase(Locations.GAMEOVER)) {
                Game.sleep(2);
                Input.clearScreen();
                Game.gameOver();
                break;

            } else {
                Hero.invalidAnswer();
            }

        } while (true);
    }

    public static String doValley() {

        do {
            System.out.format("\nYou are in the middle of the %s\n  are %s, %s, %s, %s", Hero.place("Valley"),
                    Hero.place("Shop"), Hero.place("Mountain"), Hero.place("Field"),
                    Hero.place("Jungle"));

            if (Hero.hasItem(Item.MAP)) {
                System.out.format("\nTo find your next quest, please proceed to the %s", Hero.place("field"));
            } else if (Hero.hasItem(Item.MAP) == false) {
                System.out.format("\nTo find the first quest, please proceed to the %s", Hero.place("mountain"));
            }
            ;

            System.out.format("%s",
                    Hero.keyword("\n\n---------------------------------------------------------------"));
            System.out.format(Hero.keyword("\nSuggestion:") + "you should buy a short knife at the %s",
                    Hero.place("shop"));
            System.out.format("%s", Hero.keyword("\n---------------------------------------------------------------"));

            String ans = Input.getString("\n\nChoose one of the following place: ");

            if (ans.toString().equalsIgnoreCase(Locations.SHOP)) {
                return Locations.SHOP;
            } else if (ans.toString().equalsIgnoreCase(Locations.MOUNTAIN)) {
                return Locations.MOUNTAIN;
            } else if (ans.toString().equalsIgnoreCase(Locations.JUNGLE)) {
                return Locations.JUNGLE;
            } else if (ans.toString().equalsIgnoreCase(Locations.FIELD)) {
                return Locations.FIELD;
            } else {
                Hero.invalidAnswer();
            }

        } while (true);

    }

    public static String doMountain() {

        Quest quest1 = new Quest(Quest.Quest1);

        if (Hero.hasQuest(Quest.Quest1) == true) {
            System.out.println(Hero.attack("\nYou has alreay passed this barrier"));
            return Locations.VALLEY;
        } else {
            Art.mountain();
            System.out.format("\n\n%s: You and your team took a rest on the %s %s", Hero.keyword("Circumstance"),
                    Hero.place("mountain"),
                    Hero.keyword("\n----------------------\nThe next morning\n----------------------"));
            System.out.println("\nYou: 1 2 3 4.....Hey Any of you see Jake?");
            System.out.println("Jill: No. His stuff is still here though");
            System.out.println("Jeremy: Let me see");
            System.out.format(
                    "Jeremy: ?! I think He was carried away by the human eaters to the %s",
                    Hero.place("deadly jungle"));
            System.out.println("\nJim: Luke(you), will you go then?(Y/N)");
            String ans;

            do {
                ans = Input.getString();
                if (ans.toString().equalsIgnoreCase("y")) {
                    System.out.println("You: I'll go save him. Jim, Jeremy come with me, Vicky, you stay here ");
                    Hero.addQuest(quest1);
                    return Locations.JUNGLE;

                } else if (ans.toString().equalsIgnoreCase("n")) {
                    System.out.println("Proceed to the jungle");
                    return Locations.VALLEY;

                } else {
                    Hero.invalidAnswer();
                    ;
                    return Locations.MOUNTAIN;

                }

            } while (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));

        }

    }

    public static String doPath_to_abandon_farm() {
        Input.clearScreen();
        Art.pathToAbandonFarm();

        if (Hero.hasQuest(Quest.Quest2)) {
            do {
                System.out.println("\n\nTo fight the monster, you need to walk pass the amusement park");
                // show pic
                System.out.format("Losing the map, nothing to rely on, You see %s and ask him",
                        Hero.keyword("a wizened apothecary"));
                System.out.println("\nTo go to the abandoned farm, you need a special " + Hero.keyword("potion")
                        + "\n\nHe said he'll trade for " + Hero.currency("1000 golds"));
                String ans = Input.getString("\nTrade? (Y/N)");
                if (ans.equalsIgnoreCase("y")) {
                    Hero.moneyLeft(1000);
                    Hero.addItem(potion);
                    Hero.checkItem();

                    return Locations.ABANDON_FARM;
                } else if (ans.equalsIgnoreCase("n")) {
                    return Locations.ABANDON_FARM;
                } else {
                    Hero.invalidAnswer();
                }

            } while (true);
            // not sure what to return
        } else {
            System.out.println("\nYou do not have quest2, proceed to the field to acquire quest2");
            return Locations.FIELD;
        }

    }

    public static void winning() {
        Art.winning();

    }

    public static void gameOver() {
        Art.gameOver();
        String ans = Input.getString("Want to restart the game?(Y/N)");
        boolean gameEnd = false;

        do {
            if (Main.scan.hasNextLine()) {
                if (ans.equalsIgnoreCase("y")) {
                    Game.start();
                    gameEnd = true;
                } else if (ans.equalsIgnoreCase("n")) {
                    System.out.println(Art.title());
                    gameEnd = true;
                } else {
                    Hero.invalidAnswer();
                }
            } else {
                Hero.invalidAnswer();
            }

        } while (gameEnd);

    }
};