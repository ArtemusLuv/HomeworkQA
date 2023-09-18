public class MyArrayDataException extends Exception {
    public MyArrayDataException (int i, int j) {
        super(String.format("In array element [%d][%d] was written incorrectly!", i + 1, j + 1));
    }
}
