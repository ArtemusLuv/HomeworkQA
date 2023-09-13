import java.io.Serializable;

public class AppData implements Serializable {
    private String [] header;
    private int [][] data;

    public AppData(String [] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public String getHeader() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < header.length; i++) {
            str.append(header[i] + ";");
        }
       return str.toString();
    }

    public String getData() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                str.append(data[i][j] + ";");
                if (j + 1 == data[0].length) {
                    str.append("\n");
                }
            }
        }
        return str.toString();
    }

}
