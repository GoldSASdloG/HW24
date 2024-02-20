package homeWorkLight;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MainLight {

    private static final String NAME_REGEX = "[А-я]+";
    private static final String NUM_REGEX = "\\d{11}|\\d{10}";

    private static Map<String, String> phoneBook = new TreeMap<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите имя или номер или (команды print, exit)");
            String input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("exit")){
                System.out.println("Good Bay!!!");
                return;
            } else if (input.equalsIgnoreCase("print")){
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

    public static void addForName(String name){
        if (phoneBook.containsKey(name)){
            System.out.println("Абонент " + name + " уже существует!");
            return;
        }
        System.out.println("Введите номер абонента " + name + ": ");
        String num = new Scanner(System.in).nextLine();
        num = num.replaceAll("\\D+", "");
        if (!num.matches(NUM_REGEX)) {
            System.out.println("Это не номер");
            return;
        }
        if (num.length() == 11){
            num = num.substring(1);
//        } else if (num.length() < 10){
//            System.out.println("");
        }
        if (phoneBook.containsValue(num)){
            System.out.println("Номер " + num + " уже существует!");
            return;
        }

        phoneBook.put(name, num);
        System.out.println("Абонент " + name + " с номером " + num + " добавлен!");

    }

    public static void print(){
        if (phoneBook.isEmpty()){
            System.out.println("Нет абонентов");
            return;
        }
        for (Map.Entry<String, String> contact : phoneBook.entrySet()){
            System.out.println("Абонент: " + contact.getKey() + " номер: " + contact.getValue());
        }
    }

    public static void addForNum(String num) {
        if (num.length() >= 11){
            num = num.substring(1);
        }
        if (phoneBook.containsValue(num)){
            System.out.println("Номер " + num + " уже есть у абонента");
            return;
        }
        System.out.println("Введите имя абонента для " + num);
        String name = new Scanner(System.in).nextLine();
        if (!name.matches(NAME_REGEX)){
            System.out.println("Это не имя");
            return;
        }
        if (phoneBook.containsKey(name)){
            System.out.println(name + " Абонент уже есть!");
            return;
        }
        phoneBook.put(name, num);
        System.out.println("Абонент " + name + " с номером " + num + " добавлен!");
    }
}
