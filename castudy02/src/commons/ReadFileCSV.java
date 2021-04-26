package commons;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {
    private String path;
    private BufferedWriter reader;

    public static List<String> readCSV(String pathFile) {
        List<String> stringList = new ArrayList<>();
        File file = new File(pathFile);

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader buffRead = new BufferedReader(fileReader);

            String line;
            while ((line = buffRead.readLine()) != null) {
                stringList.add(line);
            }
            buffRead.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
