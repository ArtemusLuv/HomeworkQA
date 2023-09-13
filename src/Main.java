import java.io.*;

public class Main {

    public static void main(String[] args) {

        AppData data1 = new AppData(new String[]{"Value 1", "Value 2", "Value 3"},
                                    new int[][]{{100, 300, 200}, {500, 500, 300}});
        AppData data2 = new AppData(new String[]{"Value 1", "Value 2", "Value 3"},
                                    new int[][]{{100, 300, 200}, {500, 500, 300}, {1000, 0, 300}});

        save(data1, "src/DataPackage/data1.csv");
        save(data2,"src/DataPackage/data1.csv");
        get("src/DataPackage/data1.csv");

    }

    // Task 1
    public static void save(AppData appData, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            writer.write(appData.getHeader());
            writer.append('\n');
            writer.write(appData.getData());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Task 2
    public static void get(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}