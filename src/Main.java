import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Check Task 1
        System.out.println("\nCheck Task 1\n");
        String[] wordsArray = {"Bob", "Jack", "Ryan", "Shepard", "Bob", "Arnold", "Simon", "Trevor", "Simon", "Ken", "Bob"};
        String[] wordsArray2 = getWordsArrayWithoutCopy(wordsArray);
        getCountOfWordsInArray(wordsArray);


        // Check Task 2
        System.out.println("\nCheck Task 2\n");
        PhoneBook phoneBook = new PhoneBook();
        try {
            phoneBook.add("+79000916023","Alesha");
            phoneBook.add("+79000916075","Alesha");
            phoneBook.add("+79009005050","Ivan");
            phoneBook.add("+795509","Mark");
        } catch (Exception e) {
            e.printStackTrace();
        }

        phoneBook.get("Alesha");
        phoneBook.get("Ivan");
        phoneBook.get("Petr");

    }


    // Task 1
    public static String[] getWordsArrayWithoutCopy (String[] array) {

        Set<String> wordsSet = new HashSet<>();
        for (String word : array) {
            wordsSet.add(word);
        }

        return wordsSet.toArray(new String[]{});
    }

    public static void getCountOfWordsInArray (String[] array) {

        Set<String> wordsSet = new HashSet<>();
        for (String word : array) {
            wordsSet.add(word);
        }

        for (String wordInSet : wordsSet) {
            int count = 0;
            for (String wordInArray : array) {
                if (wordInSet == wordInArray) {
                    count++;
                }
            }
            System.out.println(wordInSet + count);
        }

    }

}