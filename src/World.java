import java.util.Random;
import java.util.Scanner;

public class World {

    boolean gameStatus = true;

    public World() {
        Hero hero = new Hero();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите имя для персонажа");
        String name = scanner.nextLine();
        hero.setName(name);
        System.out.println("""
                Куда вы хотите пойти?
                1. К торговцу
                2. В тёмный лес
                3. На выход""");

        while (gameStatus) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    Shop.shopping(hero);
                    break;
                case "2":
                    Random random = new Random();
                    int c = random.nextInt(0, 2);
                    Monster monster = c == 0 ? new Goblin() : new Skeleton(); // создаём скелета или гоблина с вероятностью 1/2
                    monster.level = hero.level;
                    monster.createStats(monster.level);
                    System.out.println(hero);
                    System.out.println("                                    VS");
                    System.out.println(monster);
                    Fight fight = new Fight(hero, monster);
                    fight.start();
                    try {
                        fight.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (hero.isAlive) {
                        System.out.println("""
                                1. К торговцу
                                2. Продолжить бой
                                3. На выход""");
                    } else {
                        gameStatus = false;
                    }
                    break;
                case "3":
                    System.out.println("Счастливого пути!");
                    gameStatus = false;
                    break;
            }
        }
    }
}
