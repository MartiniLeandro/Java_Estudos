class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        if(operation == null) throw new IllegalArgumentException("Operation cannot be null");
        if(operation.isBlank()) throw new IllegalArgumentException("Operation cannot be empty");

        switch (operation) {
            case "+" -> {
                int sum = operand1 + operand2;
                return operand1 + " + " + operand2 + " = " + sum;
            }
            case "*" -> {
                int multi = operand1 * operand2;
                return operand1 + " * " + operand2 + " = " + multi;
            }
            case "/" -> {
                try{
                    int div = operand1 / operand2;
                    return operand1 + " / " + operand2 + " = " + div;
                }catch(ArithmeticException ex){
                    throw  new IllegalOperationException("Division by zero is not allowed", ex);
                }
            }
        }

        throw new IllegalOperationException("Operation '" + operation + "' does not exist");

    }
}
