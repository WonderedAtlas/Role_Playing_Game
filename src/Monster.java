import java.util.Random;

public class Monster extends Person {

    public Monster() {
        this.hp = 50;
        this.str = 5;
        this.agility = 19;
    }

    @Override
    public String toString() {
        return name + " (" + "hp = " + hp +
                ", str = " + str +
                ", agility = " + agility +
                ", gold = " + gold +
                ", exp =  " + exp +
                ", level = " + level +
                ')';
    }

    public void createStats(int monsterLvl) {
        Random random = new Random();
        this.hp += monsterLvl*50;
        this.str += 5 * (monsterLvl);
        this.agility += monsterLvl;
        this.gold = random.nextInt(this.level * 50, this.level * 100);
        this.exp = random.nextInt(this.level * 100, this.level * 150);
    }

}
