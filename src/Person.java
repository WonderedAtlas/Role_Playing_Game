import java.util.Random;
// сделать переменные private, реализовать геттеры и сеттеры?

abstract class Person {
    int hp = 150;
    int str = 10;
    int agility = 20;
    int gold = 0;
    int exp = 0;
    int level = 1;
    String name = "";
    boolean isAlive = true;

    public Person() {
    }

    public void getGold(int gold) {
        this.gold += gold;
    }

    public void setName(String name) {
        this.name = name;
    }

    void attack(Person person) {
        Random random = new Random();
        if (this.agility * 3 > random.nextInt(101)) { //если ловкость, умноженная на 3, больше, чем случайное значение (от 0 до 100),
            if (random.nextInt((101 - this.agility * 3)) == 1 || random.nextInt((101 - this.agility * 3)) == 2) { //
                System.out.println(this.name + " dealt " + this.str * 2 + " damage to " + person.name + " Critical Strike!");
                person.damage(str * 2); // атакуем с удвоенной силой
            } else {
                System.out.println(this.name + " dealt " + this.str + " damage to " + person.name);
                person.damage(str); // атакуем в размере силы
            }
        } else
            System.out.println(this.name + " missed!");
    }

    private void damage(int dhp) {
        hp -= dhp;
        if (hp <= 0) {
            isAlive = false;
        }
    }
}
