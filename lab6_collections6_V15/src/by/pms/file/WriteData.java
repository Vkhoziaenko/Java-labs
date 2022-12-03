package by.pms.file;

import by.pms.Airline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteData {
    public static void writeData(List<Airline> airlines) {

        try (FileWriter wr = new FileWriter("src\\by\\pms\\file\\Out.txt")) {
            for (var single : airlines) {
                wr.write(String.valueOf(single) + "\n");
            }

            wr.flush();
        } catch (IOException e) {
            System.out.println("Writing error");
            System.out.println(e.toString());
        }
    }
}
