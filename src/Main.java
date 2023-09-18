public class Main {

    public static void main(String[] args) {

        // Correct
        String [][] stringArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println("1) Sum of array elements = " + sumArray(stringArray));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Incorrect length
        String [][] stringArray2 = {
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println("2) Sum of array elements = " + sumArray(stringArray2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Incorrect type
        String [][] stringArray3 = {
                {"1", "2", "3", "im not number"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            System.out.println("3) Sum of array elements = " + sumArray(stringArray3));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int sumArray (String[][] strArray) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray.length != 4 || strArray[i].length != 4) {
                throw new MyArraySizeException("Wrong format in array! Must be [4][4].");
            }
            for (int j = 0; j < strArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(strArray[i][j]);
                } catch (NumberFormatException e) {
                    throw  new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }

}