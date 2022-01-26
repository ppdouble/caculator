public final class CalculatorTest implements UnitTest{
    private  final Calculator calculator = new Calculator();

    @Override
    public void beforeEachTest() {
        calculator.registerOperation("+", (a, b) -> a + b);
        calculator.registerOperation("-", (a, b) -> a - b);
        calculator.registerOperation("/", (a, b) -> a / b);
        calculator.registerOperation("*", (a, b) -> a * b);
    }

    @Override
    public void afterEachTest() {

    }

    @Test
    public void testAddition() {
        assert calculator.calculate(1, "+", 1) == 2;
        System.out.println("test passed");
    }

    @Test
    public void testSubtraction() {
        assert calculator.calculate(45, "-", 43) == 1;
        System.out.println("test passed");
    }

}
