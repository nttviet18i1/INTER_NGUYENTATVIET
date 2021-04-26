package commons;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileCSV {
    public void write(String path, String data, Boolean append) {
        try {
            BufferedWriter writer;

            if (append) {
                writer = new BufferedWriter(new FileWriter(path, true));
            }else {
                writer =new BufferedWriter(new FileWriter(path,false));

            }
            writer.write(data);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
