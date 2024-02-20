import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> nameAge = new TreeMap<>();

        nameAge.put("Masha", 33);
        nameAge.put("Viktor", 21);
        nameAge.put("Karina", 19);

        System.out.println(nameAge.get("Viktor"));
        System.out.println(nameAge.get("Karina"));
        System.out.println(nameAge.get("Marina") + "\n");

        for (Map.Entry<String, Integer> entry : nameAge.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Integer age : nameAge.values()){
            System.out.println(age);
        }

        System.out.println(nameAge.containsKey("Marina"));
        System.out.println(nameAge.containsValue(21));


        Set<String> todoVasia = new TreeSet<>();
        todoVasia.add("купить молока");
        todoVasia.add("купить колбаски");
        todoVasia.add("купить хлеба");
        todoVasia.add("вылить молока");
        todoVasia.add("сварить молока");


        Set<String> todoVika = new TreeSet<>();
        todoVika.add("помыть ванной");
        todoVika.add("помыть посуду");
        todoVika.add("сварить борщ");
        todoVika.add("накрасить губы");
        todoVika.add("одеть одежду");

        Map<String, Set<String>> spisokSpiskov = new HashMap<>();
        spisokSpiskov.put("Vasia", todoVasia);
        spisokSpiskov.put("Vika", todoVika);

        System.out.println(spisokSpiskov.get("Vika"));

        for (String todo : spisokSpiskov.get("Vika")){
            System.out.println(todo);
        }
        for (Map.Entry<String, Set<String>> entry : spisokSpiskov.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for (Map.Entry<String, Set<String>> entry : spisokSpiskov.entrySet()){
            String name = entry.getKey();
            System.out.println(name);
            for (String todo : entry.getValue()){
                System.out.println("\t" + todo);
            }
        }

        System.out.println(spisokSpiskov.containsKey("Vika"));

        boolean isConteyns = false;
        for (Map.Entry<String, Set<String>> entry22 : spisokSpiskov.entrySet()){
            for (String val : entry22.getValue()){
                if (val.equals("накрасить губы")) {
                    System.out.println(val + "  - содержится в делах - " + entry22.getKey());
                    isConteyns = true;
                }
//                } else {
//                    System.out.println("Нет такого дела!!!");
//                }
            }
        }
        if (!isConteyns){
            System.out.println("Нет такого значения!");
        }
    }
}