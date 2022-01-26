import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public final class Calculator {

    private final Map<String, BinaryOperator<Integer>> operators = new HashMap<>();

    /*
     * @Param symbol operands
     * @Param BinaryOperator operators
     */

    public void registerOperation(String symbol, BinaryOperator<Integer> operator) {
        //operators.put(symbol.strip(), operator); // strip() being supported since JDK 11+
        operators.put(symbol.trim(), operator);
    }


    /*
     * @Param a : left operand
     * @Param operator : operator
     * @Param b : right operand
     */
    public Integer calculate (Integer a, String operator, Integer b) {
        return operators.get(operator).apply(a, b);
    }

}
