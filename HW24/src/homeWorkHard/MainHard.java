package homeWorkHard;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainHard {

    private static final String NAME_REGEX = "[А-я]+";
    private static final String NUM_REGEX = "\\d{11}|\\d{10}";

    private static Map<String, Set<String>> phoneBook = new TreeMap<>();


    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите имя или номер или (команды print, exit)");
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Good Bay!!!");
                return;

            } else if (input.equalsIgnoreCase("print")){
                System.out.println("\t--------Список всех абонентов---------");
                print();
            } else if (input.matches(NAME_REGEX)){
                addForName (input);
            } else if (input.replaceAll("\\D+", "").matches(NUM_REGEX)){
                addForNum (input.replaceAll("\\D+", ""));
            } else {
                System.out.println("Неверная команда: " + input + " . Попробуйте снова!");
            }
        }
    }

    private static void addToBook(String name, String num) {
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).add(num);
            System.out.println("Абоненту " + name + " добавлен номер " + num);
        } else {
            Set<String> nums = new TreeSet<>();
            nums.add(num);
            phoneBook.put(name, nums);
            System.out.println("Абонент " + name + " с номером " + num + " добавлен!");
        }
    }

    private static String normalNum (String num) {
        if (num.length() == 11){
            num = num.substring(1);
        }
        return num;
    }

    public static void print() {
        if (phoneBook.isEmpty()) {
            System.out.println("Нет абонентов список пуст!");
            return;
        }
        for (Map.Entry<String, Set<String>> contact : phoneBook.entrySet()) {
            System.out.println("Абонент: " + contact.getKey());
            for (String num : contact.getValue()) {
                System.out.println("\t" + num);
            }
        }
    }
    public static void addForName(String name) {
        if (phoneBook.containsKey(name)) {
            System.out.println("Абонент " + name + " уже существует!");
            System.out.println("Номера: " + phoneBook.get(name));
        }
        System.out.println("Введите номер абонента " + name + ": ");
        String num = new Scanner(System.in).nextLine();
        num = num.replaceAll("\\D+", "");
        if (!num.matches(NUM_REGEX)) {
            System.out.println("Это не номер");
            return;
        }
        num = checkNum(num);
        addToBook(name, num);
    }

    public static void addForNum(String num) {
        num = checkNum(num);
        if (num == null) return;
        System.out.println("Введите имя абонента для " + num);
        String name = new Scanner(System.in).nextLine();
        if (!name.matches(NAME_REGEX)){
            System.out.println("Это не имя");
            return;
        }
        addToBook(name, num);
    }

    private static String checkNum(String num) {
        num = normalNum(num);
        for (Map.Entry<String, Set<String>> contact : phoneBook.entrySet()) {
            if (contact.getValue().contains(num)) {
                System.out.println("Номер " + num + " уже есть у другого абонента " + searchByNum(num));
                return null;
            }
        }
        return num;
    }

    public static String searchByNum(String num) {
        String name = null;
        for (Map.Entry<String, Set<String>> contact : phoneBook.entrySet()) {
            if (contact.getValue().contains(num)) {
                name = contact.getKey();
            }
        }
        return name;
    }
}
