public class Hero extends Person {

    public Hero() {
    }

    void lvlUp(int exp) {
        this.exp += exp;
        if (this.level != 10 && this.exp >= this.level * 100) { // для поднятия уровня нужно (this.level * 100) опыта
            this.str += 5; // прирост силы
            this.agility += 1; // прирост ловкости
            this.exp = this.exp - this.level * 100;
            this.level += 1;
            System.out.println("Lvl up to " + this.level);
            if (this.level == 10) System.out.println("Reached MAX Level!");
        }
    }

    @Override
    public String toString() {
        return "Hero " + name +  " (" + "hp = " + hp +
                ", str = " + str +
                ", agility = " + agility +
                ", gold = " + gold +
                ", exp =  " + exp +
                ", level = " + level +
                ')';
    }
}
