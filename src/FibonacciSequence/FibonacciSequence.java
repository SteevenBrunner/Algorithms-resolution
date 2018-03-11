package FibonacciSequence;

public class FibonacciSequence {

    // iterative Fibonacci sequence
    private static long iterFibonacci(int n) {
        int x = 0;
        int y = 1;
        int z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    // recursive Fibonacci sequence
    private static long recursFibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return recursFibonacci(n - 1) + recursFibonacci(n - 2);
    }

    public static void main(String[] args) {
        // the best way to test if a Fibonacci sequence function works is :
        // fibonacci(i) = fibonacci(i-1) + fibonacci(i-2)
        // for example fibonacci(5) = fibonacci(4) + fibonacci(3)
        // the 93rd fibonacci number will overflow a long
        // it takes a lot of times after 20-30 numbers

        int n = 45;

        long tStart = System.currentTimeMillis();
        long result = iterFibonacci(n);

        //stop and parse the time
        long tEnd = System.currentTimeMillis();
        long tDelta = tEnd - tStart;
        double elapsedSeconds = tDelta / 1000.0;

        if (result != iterFibonacci(n - 1) + iterFibonacci(n - 2))
            System.out.println("Something went wrong in iterFibonacci(int n) function");
        else
            System.out.println("iterFibonacci(int n) is working well");

        System.out.println("Time for iterFibonacci(" + n + ") :" + elapsedSeconds + " seconds.\n");


        tStart = System.currentTimeMillis();
        result = recursFibonacci(n);

        //stop and parse the time
        tEnd = System.currentTimeMillis();
        tDelta = tEnd - tStart;
        elapsedSeconds = tDelta / 1000.0;

        if (result != recursFibonacci(n - 1) + recursFibonacci(n - 2))
            System.out.println("Something went wrong in recursFibonacci(int n)");
        else
            System.out.println("recursFibonacci(int n) is working well");

        System.out.println("Time for recursFibonacci(" + n + ") :" + elapsedSeconds + " seconds.");
    }

}
