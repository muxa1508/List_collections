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
            System.out.println("Выберите операцию:");
            System.out.println("1- добавить");
            System.out.println("2- показать");
            System.out.println("3- удалить");
            System.out.println("0- завершить программу");
            int operationNumber = Integer.parseInt(scanner.nextLine());
            switch (operationNumber) {

                case 0:
                    System.out.println("Программа завершена");
                    break;
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String addItem = scanner.nextLine();
                    shopList.add(addItem);
                    System.out.println("итого в списке покупок: " + shopList.size());
                    continue;
                case 2:
                    showShopList();
                    continue;
                case 3:
                    showShopList();
                    System.out.println("Какую хотите удалить ? Введите номер или название:");
                    String inputDeleteItem = scanner.nextLine();

                    try {
                        int inputDeleteNumberItem = Integer.parseInt(inputDeleteItem);
                        String deletedItem = shopList.get(inputDeleteNumberItem -1);
                        shopList.remove(inputDeleteNumberItem - 1);
                        showShopList();
                        System.out.println(deletedItem);
                    } catch (NumberFormatException errorA) {
                        shopList.remove(inputDeleteItem);
                        showShopList();
                        System.out.println(inputDeleteItem);
                    }
                    continue;
                default:
                    System.out.println("Введите корректное значение операции");
                    continue;
            }

            break;
        }


    }


}