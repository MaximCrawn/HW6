package HW_6;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

class PhoneBook {
    private static HashMap<String, ArrayList<Long>> phoneBook = new HashMap<>();

    public void add(String name, Long phoneNum) {

        // Введите свое решение ниже
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNum);
        }else{
            ArrayList<Long> phoneBookList = new ArrayList<>();
            phoneBookList.add(phoneNum);
            phoneBook.put(name, phoneBookList);
        }
}



    public void find(String name) {
        // Введите свое решение ниже
        if(phoneBook.containsKey(name)){
            System.out.println(phoneBook.get(name));
        }else{
            System.out.println("Запись не найдена!!!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

}

    public static List<Entry<String, ArrayList<Long>>> getPhoneBook() {
        List<Entry<String, ArrayList<Long>>> sortedEntries = phoneBook.entrySet()
            .stream()
            .sorted(Comparator.comparingInt(entry -> -entry.getValue().size()))
            .collect(Collectors.toList());
        return sortedEntries;
    }
}

public class HW_6 {
     public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        while (work) {
            System.out.println("1.Добавить новую запись ");
            System.out.println("2.Поиск по имени ");
            System.out.println("3.Вывести телефонный справочник ");
            System.out.println("4.Выход ");
            String line = scanner.nextLine();
            System.out.print("\033[H\033[J");
            switch (line) {
                case "1":
                    System.out.println("Введите Имя латиницей");
                    String name = scanner.nextLine();
                    System.out.print("\033[H\033[J");
                    System.out.println("Введите номер телефона в формате +12345678910  ");
                    String phone = scanner.nextLine().replaceAll("\\+", "");
                    long num = Long.parseLong(phone);
                    myPhoneBook.add(name, num);
                    System.out.print("\033[H\033[J");
                    System.out.println("Запись добавлена успешно!!!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("\033[H\033[J");

                    break;
                case "2":
                    System.out.println("Введите Имя латиницей ");
                    String name1 = scanner.nextLine();
                    System.out.print("\033[H\033[J");
                    myPhoneBook.find(name1);
                    break;
                case "3":
                    System.out.println(PhoneBook.getPhoneBook());
                    break;
                case "4":
                    System.out.println("Телефонный справочник закрыт!!!");
                    work = false;
                    break;     
                default:
                    System.out.println("Введен не корректный символ");
            }
        }
    }
}
