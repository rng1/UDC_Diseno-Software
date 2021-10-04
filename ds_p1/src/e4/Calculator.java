package e4;

import java.util.ArrayList;

import static e4.Calculator.Sign.*;

public class Calculator {

    public enum Sign { SUM, SUB, DIV, MUL;
        public float solveOP(float op1, float op2) {
            float result = 0;
            switch(this){
                case SUM-> result = op1 + op2;
                case SUB-> result = op1 - op2;
                case MUL-> result = op1 * op2;
                case DIV-> result = op1 / op2;
            }
            return result;
        }
    }

    private class Operation {
        Sign operator;
        String symbol;
        float value;

        public void set(float n){
            operator = SUM;
            symbol = "+";
            value = n;
        }

        public void set(String o, float n){
            if(o.length() > 1) { cleanOperations(); throw new IllegalArgumentException(); }
            //for(int i = 0; i < 4; i++) { if(CMP.charAt(i) != o.charAt(0)) { throw new IllegalArgumentException(); } }
            switch (o) {
                case "+" -> operator = SUM;
                case "-" -> operator = SUB;
                case "*" -> operator = MUL;
                case "/" -> operator = DIV;
                default -> {
                    cleanOperations();
                    throw new IllegalArgumentException();
                }
            }
            value = n;
            symbol = o;
        }

        public Sign getOperator() { return operator; }

        public String getSymbol() { return symbol; }

        public float getValue() { return value; }
    }
    private final ArrayList<Operation> state;

    public Calculator () { state= new ArrayList<>(); }

    public void cleanOperations() { if (state.size() > 0) { state.subList(0, state.size()).clear(); } }

    public void addOperation ( String operation , float ... values ) {
        Operation newop = new Operation();
        Operation newop2 = new Operation();
        if(state.size() == 0) {
            newop.set(values[0]);
            state.add(newop);
            newop2.set(operation, values[1]);
            state.add(newop2);
        }
        else {
            newop.set(operation, values[0]);
            state.add(newop);
        }
    }

    public float executeOperations () {
        float result = 0;
        for (Operation operation : state) { /*switch (operation.getOperator()) {
                case SUM -> result += operation.getValue();
                case SUB -> result -= operation.getValue();
                case MUL -> result *= operation.getValue();
                case DIV -> {
                    if (operation.getValue() == 0) {
                        cleanOperations();
                        throw new ArithmeticException();
                    }
                    result /= operation.getValue();
                }
            }*/
            if (operation.value == 0 && operation.operator == DIV) { cleanOperations(); throw new ArithmeticException();}
            result = operation.operator.solveOP(result, operation.value); }
        cleanOperations();
        return result;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder("[STATE:");
        if (state.size() != 0) {
            s.append("[").append(state.get(1).getSymbol()).append("]").append(state.get(0).getValue()).append("_").append(state.get(1).getValue());
            for (int i = 2; i < state.size(); i++) {
                s.append("[").append(state.get(i).getSymbol()).append("]").append(state.get(i).getValue());
            }
        }
        s.append("]");
        return s.toString();
    }


}
