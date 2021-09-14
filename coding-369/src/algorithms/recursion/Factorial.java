package algorithms.recursion;

public class Factorial {
    public int factorialFunc(int num) {
        if (num <= 1) {
            return num;
        }
        return num * this.factorialFunc(num - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorialFunc(5));
    }
}
