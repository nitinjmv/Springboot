package dev.jmv;

public class MathOperations {
    public int handler(int a, int b, String op){

        switch (op){
            case "+": return a + b;
            case "-": return a > b ? a - b : b - a ;
            case "*": return a * b;
            default: return 0;
        }
    }
}
