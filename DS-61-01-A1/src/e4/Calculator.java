package e4;

import java.util.ArrayList;

import static e4.Calculator.Sign.*;

public class Calculator {

    public enum Sign {
        SUM {
            public float solveOP(float op1, float op2) { return (op1 + op2); }
            public String printOP() { return "+"; }
        },
        SUB {
            public float solveOP(float op1, float op2) { return (op1 - op2); }
            public String printOP() { return "-"; }
        },
        DIV {
            public float solveOP(float op1, float op2) { return (op1 / op2); }
            public String printOP() { return "/"; }
        },
        MUL {
            public float solveOP(float op1, float op2) { return (op1 * op2); }
            public String printOP() { return "*"; }
        };

        public abstract float solveOP(float op1, float op2);
        public abstract String printOP();
    }

    private static ArrayList<Operation> state;//declare the array

    public Calculator () { state = new ArrayList<>(); } //initialize the array

    public static void cleanOperations() { if (state.size() > 0) { state.subList(0, state.size()).clear(); } }

    public void addOperation ( String operation , float ... values ) {
        Sign sign = toSign(operation);
        if(state.size() == 0) { //the first operation
            state.add(new Operation(SUM, values[0]));
            state.add(new Operation(sign, values[1]));
        }
        else { state.add(new Operation(sign, values[0])); }
    }

    public float executeOperations () {
        float result = 0;
        for (Operation operation : state) {
            if (operation.value() == 0 && operation.operator() == DIV) { //divided by zero
                cleanOperations();
                throw new ArithmeticException();
            }
            result = operation.operator().solveOP(result, operation.value());
        }
        cleanOperations();
        return result;
    }

    public Sign toSign( String s) {
        Sign e;
        switch (s) {
            case "+" -> e = SUM;
            case "-" -> e = SUB;
            case "*" -> e = MUL;
            case "/" -> e = DIV;
            default -> {
                cleanOperations();
                throw new IllegalArgumentException(); //any other operation
            }
        }
        return e;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder("[STATE:"); //declare and initialize the string
        if (state.size() != 0) {
            s.append("[").append(state.get(1).operator().printOP()).append("]").append(state.get(0).value()).append("_").append(state.get(1).value());
            for (int i = 2; i < state.size(); i++) { s.append("[").append(state.get(i).operator().printOP()).append("]").append(state.get(i).value()); }
        }
        s.append("]"); //close the set
        return s.toString();
    }
}
