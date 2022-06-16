package game_project;

import java.util.*;

public class Shop {
    public static ArrayList<Item> shopItem = new ArrayList<Item>();
    public static boolean first_time = true;

    // problem with adding name and public static thing
    // 25 Dec
    public static Item blood_bag = new Item("blood bag", 150, Item.BLOOD_BAG, "Health + 15");
    public static Item body_armor = new Item("body armor", 250, Item.BODY_ARMOR, "Strength + 15");
    public static Item short_knife = new Item("short knife", 200, Item.SHORT_KNIFE, "for self protection");

    public static void shopStock() {

        if (first_time == true) {
            first_time = false;
            shopItem.add(blood_bag);
            shopItem.add(body_armor);
            shopItem.add(short_knife);

        } else {
            if (shop_has_item(Item.BLOOD_BAG) == false) {
                shopItem.add(blood_bag);

            }
            if (shop_has_item(Item.BODY_ARMOR) == false) {
                shopItem.add(body_armor);

            }
            if (shop_has_item(Item.SHORT_KNIFE) == false) {
                shopItem.add(short_knife);

            }
        }

    }

    public static boolean shop_has_item(int itemID) {
        for (Item i : shopItem) {
            if (i.id == itemID) {
                return true;
            }
        }
        return false;
    }

    public static String doShop() {
        Art.shop();
        boolean shoppingComplete = false;

        do {
            Shop.shopStock();
            System.out.format("\nThis is a shop. Select %s you want to purchase\n", Hero.keyword("item"));
            int i = 1;
            for (Item item : Shop.shopItem) {
                System.out.format("\n%d) %s price %s gold : %s", i, Hero.keyword(item.name),
                        Hero.currency(Integer.toString(item.price)), item.detail);
                i++;
            }
            System.out.format("\nYou have %s gold", Hero.currency(Integer.toString(Hero.currency)));
            System.out.format("\nSelect number(%s or %s or %s) or %s\n", Hero.keyword("1"), Hero.keyword("2"),
                    Hero.keyword("3"), Hero.keyword("leave"));
            String ans = Input.getString();

            if (ans.equalsIgnoreCase("leave")) {
                return Locations.VALLEY;
                // ans should be an int?
            } else if (ans.equalsIgnoreCase("1") || ans.equalsIgnoreCase("2") || ans.equalsIgnoreCase("3")) {
                int ans_int = Integer.parseInt(ans);
                Item item = shopItem.get(ans_int - 1);

                if (Hero.currency >= item.price && ans_int <= shopItem.size()) {
                    if (item.id == Item.BLOOD_BAG) {
                        Hero.moneyLeft(blood_bag.price);
                        Hero.addItem(shopItem.remove(0));

                    } else if (item.id == Item.BODY_ARMOR) {
                        Hero.moneyLeft(body_armor.price);
                        Hero.addItem(shopItem.remove(1));
                    } else if (item.id == Item.SHORT_KNIFE) {
                        Hero.moneyLeft(short_knife.price);
                        Hero.addItem(shopItem.remove(2));
                    }
                } else {
                    System.out.println("\nsorry you dont have enough money");
                    return Locations.VALLEY;
                }

            } else {
                Hero.invalidAnswer();
                Game.sleep(1);
            }

        } while (shoppingComplete == false);
        return Locations.VALLEY;

    }

}
