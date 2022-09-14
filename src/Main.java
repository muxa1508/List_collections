import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> shopList = new ArrayList<String>();
    static Scanner scanner = new Scanner(System.in);

    protected static void showShopList() {
        System.out.println("Список покупок:");
        for (int i = 0; i < shopList.size(); i++) {
            System.out.println((i + 1) + ". " + shopList.get(i));
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Выберите операцию:");
            System.out.println("1- добавить");
            System.out.println("2- показать");
            System.out.println("3- удалить");
            System.out.println("4- найти");
            System.out.println("0- завершить программу");
            int operationNumber = Integer.parseInt(scanner.nextLine());
            switch (operationNumber) {
                case 0:
                    System.out.println();
                    System.out.println("Программа завершена");
                    break;
                case 1:
                    System.out.println();
                    System.out.println("Какую покупку хотите добавить?");
                    String addItem = scanner.nextLine();
                    shopList.add(addItem);
                    System.out.println("итого в списке покупок: " + shopList.size());
                    continue;
                case 2:
                    System.out.println();
                    showShopList();
                    continue;
                case 3:
                    System.out.println();
                    showShopList();
                    System.out.println("Какую хотите удалить ? Введите номер или название:");
                    String inputDeleteItem = scanner.nextLine();
                    try {
                        int inputDeleteNumberItem = Integer.parseInt(inputDeleteItem);
                        String deletedItem = shopList.get(inputDeleteNumberItem - 1);
                        shopList.remove(inputDeleteNumberItem - 1);
                        System.out.println("Покупка " + deletedItem + " удалена");
                        showShopList();
                    } catch (NumberFormatException errorA) {
                        shopList.remove(inputDeleteItem);
                        System.out.println("Покупка " + inputDeleteItem + " удалена");
                        showShopList();
                    }
                    continue;
                case 4:
                    System.out.println();
                    System.out.println("Введите текст поиска");
                    String searchItem = scanner.nextLine();
                    System.out.println("Найдено:");
                    String queryLower = searchItem.toLowerCase();
                    for (int i = 0; i < shopList.size(); i++) {
                        String item = shopList.get(i);
                        String itemLower = item.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + shopList.get(i));
                        }
                    }
                    continue;
                default:
                    System.out.println();
                    System.out.println("Введите корректное значение операции");
                    continue;
            }
            break;
        }
    }
}