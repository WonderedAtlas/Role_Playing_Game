import java.util.Scanner;

public class Shop {

    static boolean shopStatus = true;

    public static void shopping(Hero hero) {
        shopStatus = true;
        while (shopStatus) {
            System.out.println("Текущее золото: " + hero.gold);
            System.out.println("""
                    Выберите, что вы хотите купить
                    1. Малое зелье лечения (+50) - 50 золота
                    2. Среднее зелье лечения (+100) - 100 золота
                    3. Большое зелье лечения (+150) - 150 золота
                    4. Выйти из магазина""");

            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    if (hero.gold >= 50) {
                        hero.hp += 50;
                        hero.gold -= 50;
                    } else System.out.println("Недостаточно золота");
                    break;
                case "2":
                    if (hero.gold >= 100) {
                        hero.hp += 100;
                        hero.gold -= 100;
                    } else System.out.println("Недостаточно золота");
                    break;
                case "3":
                    if (hero.gold >= 150) {
                        hero.hp += 150;
                        hero.gold -= 150;
                    } else System.out.println("Недостаточно золота");
                    break;
                case "4":
                    shopStatus = false;
                    System.out.println("""
                            Куда вы хотите пойти?
                            1. К торговцу
                            2. В тёмный лес
                            3. На выход""");
                    break;
            }
        }
    }
}
