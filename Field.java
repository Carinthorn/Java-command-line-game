package game_project;

public class Field {
    // how to access item map withour creating in dif class
    public static String doField() {


        boolean foundSpy = false;
        int chance = 2;
        Quest quest2 = new Quest(Quest.Quest2);

        Art.field();
        do{
            if (Hero.hasItem(Item.MAP)) {
                System.out.format("\n\nYou and your teammates walk through the %s", Hero.place("field"));
                System.out.print("\nTo see the route to the abandoned farm\nOpen map\n");
                Hero.collected_item.remove(Jungle.map);
                if (Hero.hasItem(Item.MAP) == false) {
                    System.out.println(Hero.attack("oh ooh map is lost"));
                } else {
                    System.out.println("Map is still here");
                }
                Hero.checkItem();
                Input.quiet();
    
                do {
    
                    System.out.format("\nWhere is the %s? Did someone %s it?\n", Hero.keyword("map"),
                            Hero.keyword("steal"));
    
                    Input.clearScreen();
                    System.out.println(Hero.attack("\nSuspicious people: "));
                    
                    Hero.friend_list.add("Victoria");
                    Hero.friend_list.add("Jeremy");
                    Hero.friend_list.add("Jim");
                    Hero.friend_list.add("Jake");
    
                    for (String i : Hero.friend_list) {
                        System.out.println(i);
                    }
    
                    String ans = Input.getString("Guess who?");
                    if (ans.toString().equalsIgnoreCase("Jim")) {
                        foundSpy = true;
                        System.out.println(Hero.keyword("\nCongrats you are right, the spy is killed"));
                        Hero.addQuest(quest2);
                        return Locations.PATH_TO_ABANDON_FARM;
    
                    } else {
                        System.out.format("\n%s", Hero.attack("Nope!!"));
                        chance -= 1;
                        System.out.format("\n%d chance left to guess", chance);
    
                        if (chance < 1) {
                            System.out.format("\n%s", Hero.attack("You are killed"));
                            return Locations.GAMEOVER;
                        }
    
                    }
                } while (foundSpy == false);
    
            } else {
                System.out.format("\n%s", Hero.attack("Map is required, GO to the mountain to get the map"));
                return Locations.VALLEY;
            }
            
        }while(true);
    }
}
