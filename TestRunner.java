import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestRunner {
    //private static final List<Class<?>> TESTS = List.of(CalculatorTest.class);  // List.of being supported since JDK9+
    private static final List<Class<?>> TESTS = Arrays.asList(CalculatorTest.class);

    public static void main(String[] args) throws Exception {

        List<String> passed = new ArrayList<>();
        List<String> failed = new ArrayList<>();
        //Object UnitTest;
        for (Class<?> klass : TESTS) {
            if (!UnitTest.class.isAssignableFrom(klass)) {
                throw new IllegalArgumentException("Class " + klass.toString() + " must implement UnitTest");
            }

            for (Method method : klass.getDeclaredMethods()) {
                if (method.getAnnotation(Test.class) != null) {
                    try {
                        UnitTest test = (UnitTest) klass.getConstructor().newInstance();
                        test.beforeEachTest();
                        method.invoke(test);
                        test.afterEachTest();
                        passed.add(getTestName(klass, method));
                    } catch (Throwable throwable) {
                        failed.add(getTestName(klass, method));
                    }
                }
            }
        }

        System.out.println("Passed tests: " + passed);
        System.out.println("Failed tests: " + failed);
    }

    private static String getTestName(Class<?> klass, Method method) {
        return klass.getName() + "#" + method.getName();
    }
}
