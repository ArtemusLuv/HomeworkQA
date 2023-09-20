import java.util.HashMap;
import java.util.Map;

// Task 2
public class PhoneBook {

    private HashMap<String,String> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    //   8 900 000 00 00
    // + 7 900 000 00 00
    public void add(String phoneNumbers, String name) throws WrongNumber {
        if (phoneNumbers.contains("+")) {
            if (phoneNumbers.length() != 12) throw new WrongNumber("Your length is " + phoneNumbers.length() + ", but must be 12!");
        } else {
            throw new WrongNumber("Your length is " + phoneNumbers.length() + ", but must be 12 or 11!");
        }
        phoneBook.put(phoneNumbers, name);
    }

    public void get(String name) {
        if (phoneBook.containsValue(name)) {
            System.out.print(name + ": ");
            for (Map.Entry<String,String> set : phoneBook.entrySet()) {
                if (set.getValue() == name) {
                    System.out.print(set.getKey() + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println(name + " is not in the book");
        }
    }

}
