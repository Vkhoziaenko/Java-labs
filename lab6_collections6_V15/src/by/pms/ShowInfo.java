package by.pms;

import java.util.List;

public class ShowInfo {
    public static void showInfo(List<Airline> airlines){
        for(var s : airlines){
            System.out.println(s.toString());
        }
        System.out.println("\n");
    }
}
