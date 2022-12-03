import by.pms.Airline;
import by.pms.ShowInfo;
import by.pms.file.ReadData;
import by.pms.file.WriteData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        List<Airline> airlines = ReadData.readDataCSV();
        Collections.sort(airlines);
        WriteData.writeData(airlines);
        ShowInfo.showInfo(airlines);
        exercise(airlines);
    }
    private static void exercise(List<Airline> airlines){
        System.out.println("Enter destination");
        Scanner sc = new Scanner(System.in);
        Airline.flightByDestination(airlines, sc.nextLine());
        System.out.println("Enter week (word)");
        Airline.flightByDayOfWeek(airlines, sc.nextLine());
        System.out.println("Enter fly time (00.00)");
        Airline.flightByDepartureTime(airlines, sc.nextLine());
    }
}
