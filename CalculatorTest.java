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
        // do nothing
    }

    @Test
    public void testAddition() {
        assert calculator.calculate(1, "+", 1) == 2;    // 1+1=2 test passed
        System.out.println("test passed");
    }

    @Test
    public void testSubtraction() {
        assert calculator.calculate(45, "-", 43) == 1;  // 45-43=2 test failed
        System.out.println("test passed");
    }

}
