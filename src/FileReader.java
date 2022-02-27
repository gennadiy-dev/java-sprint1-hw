import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {
    String[] dataList;

    String path;
    String year;
    int monthCount;

    FileReader (String path, String year, int monthCount) {
        this.path = path;
        this.year = year;
        this.monthCount = monthCount;
    }

    public String[] readMonthFiles() {
        dataList = new String[monthCount];

        for (int i = 0; i < dataList.length; i++) {
            String month;
            if (i < 10) {
                month = "0" + (i + 1);
            } else {
                month = Integer.toString(i + 1);
            }
            dataList[i] = readFile(path + "/" + "m."+ year + month + ".csv");
        }
        return dataList;
    }

    public String readYearFile() {
        return readFile(path + "/" + "y." + year + ".csv");
    }

    private String readFile(String path){
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
