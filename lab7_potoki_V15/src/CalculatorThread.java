public class CalculatorThread implements Runnable {
    private int number;
    private long result = 1;

    public CalculatorThread(int number) {
        this.number = number;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start;");
        for (int i = number % 2 == 0 ? 2 : 1; i <= number; i += 2) {
            result *= i;
        }
        System.out.println(Thread.currentThread().getName() + " end;");
    }
}
