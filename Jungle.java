package game_project;

//if already have map them cant come in 
public class Jungle {
    public static Item map = new Item("map", 0, Item.MAP, "this will lead you to the field");
    public static Quest complete_1 = new Quest(Quest.Quest1);

    public static String doJungle() {
        Input.clearScreen();
        Art.jungle();

        if (Hero.hasQuest(Quest.Quest1) == false) {
            System.out.format("\n%s",
                    Hero.attack("\nQuest1 is needed to enter this barrier. GO to the mountain "));
                    //Game.sleep(3);
            return Locations.VALLEY;
        } else if (Hero.hasItem(Item.MAP) == true) {
            System.out.format("\n%s", Hero.attack("\nNothing to do here"));
            return Locations.VALLEY;
        } else {
            System.out.println("\nYou see a group of wild people carrying Jake to the " + Hero.place("jungle"));
            // print pic of mountain
            System.out.println(
                    "\nsomeone tied your friend with a really strong rope in the middle of the square , unfortunately, there is no way to approach him");
            System.out.println("\nThe darkness took over the village, no one is here....");

            do {
                String ans = Input.getString("\nYou quickly run to save your friend(Y/N)");

                if (ans.toString().equalsIgnoreCase("y")) {
                    if (Hero.hasItem(Item.SHORT_KNIFE)) {
                        System.out.format("\nYou used your %s to cut rope and save him", Hero.keyword("short knife"));
                        Hero.friend_list.add("Jake");
                        Hero.addItem(map);
                        Hero.add_completedQuest(complete_1);
                        Hero.checkItem();
                        Hero.openMap();
                        // Hero.friend_list.add("Jake");

                        return Locations.FIELD;
                        // here change color and invalid ans to Hero.invalidAns()
                    } else {
                        Input.clearScreen();
                        System.out.println("\nYou untied the rope with bare hands");
                        Input.quiet();
                        System.out.format("%s", Hero.attack(
                                "\nIt's to late. One human eater saw you!! Luckily, you can survive and save Jake\n"));
                        Hero.takedamage(5);
                        Hero.friend_list.add("Jake");
                        Hero.addItem(map);
                        Hero.add_completedQuest(complete_1);
                        Hero.checkItem();

                        String ans2 = Input.getString("\nGo to the shop for some blood bag?(Y/N)\n");
                        do {
                            if (ans2.toString().equalsIgnoreCase("y")) {
                                return Locations.SHOP;
                            } else if (ans2.toString().equalsIgnoreCase("n")) {
                                Hero.openMap();
                                return Locations.FIELD;
                            } else {
                                Hero.invalidAnswer();
                            }

                        } while (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n"));

                    }

                } else if (ans.toString().equalsIgnoreCase("n")) {
                    Input.clearScreen();
                    System.out.println("\nYou began to starve");
                    System.out.println("\nHuman eaters see you in the dark, they put you and your friends in soup");
                    //Game.sleep(2);
                    return Locations.GAMEOVER;
                } else {
                    Hero.invalidAnswer();
                }

            } while (true);

        }

    }
}
