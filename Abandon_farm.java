package game_project;

public class Abandon_farm {
    public static String doAbandon_farm() {
        Input.clearScreen();
        Quest quest2 = new Quest(Quest.Quest2);
        do {
            if (Hero.hasItem(Item.POTION)) {

                System.out.println(Art.abandon_farm());
                System.out.println(
                        "\n\nthe sky is overcast, you start seeing animal carcasses, so you realized that you have entered \n");

                System.out.println("\nSuddenly, the monster approached and attacked you");
                Villain.monstAttack(8);
                String ans = Input.getString("\nHide or retaliate(H/R)");
                // check if user input string

                while (!ans.equalsIgnoreCase("h") || !ans.equalsIgnoreCase("r")) {
                    if (ans.equalsIgnoreCase("h")) {
                        Hero.takedamage(7);
                        break;

                    } else if (ans.equalsIgnoreCase("r")) {
                        Hero.takedamage(10);
                        break;
                    } else {
                        Hero.invalidAnswer();
                    }
                }
                if (Hero.isDead() == true) {
                    return Locations.GAMEOVER;
                } else {
                    System.out.format("%s", Hero.attack(
                            "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"));
                    System.out.format("%s", Hero.attack(
                            "\nyour health is at risk; find item in your inventory to strengther your health"));
                    System.out.format("%s", Hero.attack(
                            "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"));
                    String check = Input.getString("\nCheck your inventory?(Y/N)");
                    if (check.equalsIgnoreCase("y")) {
                        Hero.checkItem();
                        if (Hero.hasItem(Item.BLOOD_BAG) == true) {
                            String blood_bag = Input.getString("\nUse a blood bag(Y/N)");
                            if (blood_bag.equalsIgnoreCase("y")) {
                                Hero.healing(15);
                                Hero.collected_item.remove(Shop.blood_bag);
                                // Hero.remove item
                            } else if (blood_bag.equalsIgnoreCase("n")) {
                                System.out.println("\nAre You sure?");
                            } else {
                                Hero.invalidAnswer();
                            }

                        } else {
                            System.out.println(Hero.attack("\nYou has no blood bag"));

                        }
                        if (Hero.hasItem(Item.BODY_ARMOR) == true) {
                            String body_armor = Input.getString("\nUse body armor(Y/N)");
                            if (body_armor.equalsIgnoreCase("y")) {
                                System.out.println(Hero.keyword("Strength + 15"));
                                Hero.strength += 15;
                                Hero.collected_item.remove(Shop.body_armor);
                            } else {
                                System.out.println("\nYou sure?");
                            }

                        } else {
                            System.out.println(Hero.attack("\nYou has no body armor"));

                        }

                    } else if (check.equalsIgnoreCase("no ")) {
                        Input.pressEnterToContinue();
                    }
                    System.out.println("\nHow can i defeat it? \nWell, let me see what i still have");
                    Hero.checkItem();
                    System.out.println("\nWill this potion work? that " + Hero.keyword("crazy old apothecary ")
                            + "looks suspicious?");
                    String use = Input.getString("\nUse the potion?(Y/N)");
                    if (use.equalsIgnoreCase("y")) {
                        System.out.println(ColorText.purple_bold("\nI will throw this to its body"));
                        System.out.println(ColorText.purple_bold("\nThe potion is very acidic that eats up the skin"));
                        Villain.takedamage(30);
                        Hero.collected_item.remove(Game.potion);

                        System.out.println(
                                "\nThe monster was tortured by the side effect of the potion\nIts outer skin slowly melts into gluelish liquid\nfound a body of a dead person");
                        System.out.println("it's Jim???!!\n");
                        Hero.add_completedQuest(quest2);
                        Game.winning();
                        Game.sleep(2);
                        return Locations.GAMEOVER;// create start page to display the title && winning page

                    } else if (use.equalsIgnoreCase("n")) {
                        System.out.format("%s", Hero.attack("\nIt saw you first"));
                        Villain.monstAttack(30);
                        if (Hero.isDead() == true) {
                            System.out.println(" You are defeated");
                            Game.sleep(2);
                            return Locations.GAMEOVER;
                        } else {
                            Villain.monstAttack(30);
                            System.out.println("\nYou are dead");
                            Game.sleep(2);
                            return Locations.GAMEOVER;

                        }

                    } else {
                        Hero.invalidAnswer();
                    }

                }

            } else {
                System.out.format("\n%s :you are not allowed to enter this field", Hero.attack("No potion"));
                return Locations.PATH_TO_ABANDON_FARM;
            }

        } while (true);
    }
}

// clear screen
// remove map
// less space spy kill and q2 receive
