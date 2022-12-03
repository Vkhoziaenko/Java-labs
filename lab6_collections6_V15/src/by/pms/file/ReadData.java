package by.pms.file;

import by.pms.Airline;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadData {
    public static List<Airline> readDataCSV(){
        List<String> lines = new ArrayList<>();
        String FILE_NAME = "src\\by\\pms\\file\\DATA.csv";
        try(Scanner cs = new Scanner(new FileReader(FILE_NAME))){
            while(cs.hasNextLine()){
                lines.add(cs.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cant find file.");
        }
        return pars(lines);
    }
    private static List<Airline> pars(List<String> list){
        List<Airline> airlines = new ArrayList<>();
        for(var s : list){
            String[] str = s.split(",");
            airlines.add(new Airline(str));
        }
        return airlines;
    }
}
