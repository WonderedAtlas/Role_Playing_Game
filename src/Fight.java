public class Fight extends Thread {

    Hero hero;
    Monster monster;

    public Fight(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    @Override
    public void run() {
        while (true) { // логика сражения с монстром
            hero.attack(monster);
            if (!monster.isAlive) {
                hero.getGold(monster.gold);
                System.out.println("Monster " + monster.name + " was killed");
                hero.lvlUp(monster.exp);
                break;
            } else {
                monster.attack(hero);
                if (!hero.isAlive) {
                    System.out.println("Hero " + hero.name + " was killed");
                    break;
                }
            }
        }
    }
}
