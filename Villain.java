package game_project;

import java.lang.String;

public class Villain {
    
    public static String name;
    public static String ans;
    public static Boolean alive;
    public static int strength = Hero.random.nextInt(30 + 15);


    public Villain(String name){
        name = Villain.name;
    }


    public static int monstAttack(int attack){
        Villain.strength -= attack;
        System.out.println(Hero.attack("\nYou are attacked"));
        System.out.format("\nHealth %s", Hero.attack(Integer.toString(-attack)));
        return strength;
    }
    
    public static int takedamage(int damage) {
        System.out.format(Hero.attack("\nVillain's strength - %d"), damage);
        System.out.format("\nstrength left: %d", strength);
        if (strength < 6) {
            System.out.format("\n%s ", Hero.attack("Monster is nearly defeated"));
        } else {
            System.out.println("\nIt is not yet dead");
        }
        return strength - damage;

    }

    public static Boolean isDead() {
        if (strength <= 0) {
            return true;
        }
        return false;
    }
}
