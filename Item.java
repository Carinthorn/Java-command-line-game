package game_project;
public class Item {
    //Hero item
    public static final int MAP = 1;
    public static final int POTION = 2;
    
    //Shop item
    public static final int BLOOD_BAG = 3;
    public static final int BODY_ARMOR = 4;
    public static final int SHORT_KNIFE = 5;
    public static final int LEAVE_SHOP = 6;
    
    int id;
    int price;
    String name;
    String detail;

    public Item( String item_name, int item_price, int item_id, String item_detail){
        name = item_name;
        price = item_price;
        id = item_id;
        detail = item_detail;

    }
    public String toString(){
        return String.format("%s", name);
    }


    
   

    

}
