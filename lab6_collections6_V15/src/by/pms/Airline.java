package by.pms;

import java.sql.Time;
import java.util.Comparator;
import java.util.List;

public class Airline implements Comparable<Airline> {
    private String destination;
    private int flightNumber;
    private String type;
    private String departureTime;
    private String dayOfWeek;

    public Airline(String[] str){
        this.destination = str[0];
        this.flightNumber = Integer.parseInt(str[1]);
        this.type = str[2];
        this.departureTime = str[3];
        this.dayOfWeek = str[4];
    }

    public Airline(){}

    public static void flightByDestination(List<Airline> airlines, String destination){
        boolean ok = false;
        for(var s : airlines){
            if(s.destination.equals(destination)){
                System.out.println(s.toString());
                ok = true;
            }
        }
        if(!ok) System.out.println("No result for this destination");
    }

    public static void flightByDayOfWeek(List<Airline> airlines, String dayOfWeek){
        boolean ok = false;
        for(var s : airlines){
            if(s.dayOfWeek.equals(dayOfWeek)){
                System.out.println(s.toString());
                ok = true;
            }
        }
        if(!ok) System.out.println("No result for this week");
    }

    public static void flightByDepartureTime(List<Airline> airlines, String departureTime){
        boolean ok = false;
        for(var s : airlines){
            if(s.departureTime.equals(departureTime)){
                System.out.println(s.toString());
                ok = true;
            }
        }
        if(!ok) System.out.println("No result for this time");
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination + '\'' +
                ", flightNumber=" + flightNumber +
                ", type='" + type + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", dayOfWeek='" + dayOfWeek + '\'' +
                '}';
    }

    @Override
    public int compareTo(Airline o) {
        if(this.destination.length() < o.destination.length()) return 1;
        if(this.destination.length() > o.destination.length()) return -1;
        return this.destination.toUpperCase().compareTo(o.destination.toUpperCase());
    }
}
