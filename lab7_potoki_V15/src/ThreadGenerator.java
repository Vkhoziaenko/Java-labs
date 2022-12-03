import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadGenerator {
    private static int thrNum;
    private static char action;
    private static int number;

    public static void main(String[] args) {
        System.out.println("Enter count of threads");
        try (Scanner sc = new Scanner(System.in)) {
            thrNum = Integer.parseInt(sc.nextLine());
            System.out.println("Action: ");
            action = sc.nextLine().charAt(0);
            System.out.println("Enter number ");
            number = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        getResult(execute());
    }

    private static List<CalculatorThread> execute() {
        List<CalculatorThread> calculatorThreads = new ArrayList<>();
        for (int i = 0; i < thrNum; i++) {
            calculatorThreads.add(new CalculatorThread(number));
            Thread thr = new Thread(calculatorThreads.get(i));
            thr.start();
            try{
                thr.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        for(var s : calculatorThreads){
            System.out.println(s.getResult());
        }
        return calculatorThreads;
    }

    private static void getResult(List<CalculatorThread> calculatorThreads) {
        long tmp = 0;
        switch (action){
            case '+'->{
                for(var s : calculatorThreads){
                    tmp += s.getResult();
                }
            }
            case '-'->{
                for(var s : calculatorThreads){
                    tmp -= s.getResult();
                }
            }
            case '*'->{
                tmp = 1;
                for(var s : calculatorThreads){
                    tmp *= s.getResult();
                }
            }
            default -> {
                System.out.println("Exception: action not detected;");
                return;
            }
        }
        System.out.println("Result: " + tmp);
    }
}
