package com.tutorial;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

// In JUnit 5, the test lifecycle is driven by four primary annotations
// i.e. @BeforeAll, @BeforeEach, @AfterEach and @AfterAll. Along with it,
// each test method must be marked with @Test annotation from package org.junit.jupiter.api.

// Default test instance = PER_METHOD
// The other is LifeCycle.PER_CLASS. The latter enables us to ask JUnit to
// create only one instance of the test class and reuse it between tests.
// @TestInstance(TestInstance.Lifecycle.PER_METHOD)
class SampleTest {

    // In JUnit, by default, for each test method – a new instance of test is created.
    Calculator calculator;

    // Gives meta information of test. (Dependency Injection)
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        calculator = new Calculator();

        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running: " + testInfo.getDisplayName());
    }

    @BeforeAll
    // if you use TestInstance.Lifecycle.PER_CLASS you have to remove static
    // only in PER_METHOD lifecycle it calls initAll method, before creating a new instance of SampleTest.
    static void initAll() {
        System.out.println("initAll");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_AddNumbers() {
        // Given
        int numberOne = 1;
        int numberTwo = 2;
        // When
        int actual = calculator.add(numberOne, numberTwo);
        // Then
        int expected = 3;

        // assertEquals(actual, expected);

        // user Assertj instead of assertEquals (Junit 5)
        org.assertj.core.api.Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    void should_ThrowException_When_DivideByZero() {
        // Given
        int numberOne = 10;
        int numberTwo = 0;
        // When
        Executable divideMethod = () -> calculator.divide(numberOne, numberTwo);
        // Then
        assertThrows(ArithmeticException.class, divideMethod);
    }

    @Test
    @Disabled
    @DisplayName("TDD.docx Method should not run")
    void shouldIgnore() {
        fail("This test method should be disabled.");
    }

    // Conditional Test Execution
    /*
    @EnabledOnOs(OS.LINUX)
    @EnabledOnJre(JRE.JAVA_11)
    @EnabledIf("")
    @EnabledIfSystemProperty()
    @EnabledIfEnvironmentVariable()
    */
    @Test
    void conditionalExample() {
        System.out.println("Conditional test execution");
    }

    @Test
    void assumptions() {
        boolean isServerUp = false;
        System.out.println("before Assumptions");
        Assumptions.assumeTrue(isServerUp);
        System.out.println("after Assumptions");
    }

    @Test
    void should_MultiplyNumbers() {
        assertAll(
                () -> assertEquals(4, calculator.multiply(2, 2)),
                () -> assertEquals(0, calculator.multiply(2, 0)),
                () -> assertEquals(-3, calculator.multiply(3, -1))
        );
    }

    // Very often, developer teams define a test class by class to test. That is a shared good practice
    // but it also may make your test class very big and to count several hundred of lines. You can indeed
    // have classes to test with multiple methods to test, multiple scenarios for each one and also some
    // initialization steps required in the unit test methods to test the scenarios.
    // All of these will naturally increase the test class size.
    // Above a threshold (maybe 500 lines or about), it becomes legitimate to ask yourself whether a refactoring
    // is needed.
    @Nested
    class NestedSampleTest {

        @BeforeEach
        void setUp() {
            System.out.println("Nested before each");
        }

        @Test
        void sample1() {
            System.out.println("Nested Sample 1 test");
            int actual = calculator.add(1, 2);
            int expected = 3;
            assertEquals(actual, expected);
        }

        @Test
        void sample2() {
            System.out.println("Nested Sample 2 test");
        }
    }

    // Using supplier for assert message
    @Test
    void should_AddTwoNumber_AssertMessageSupplier() {
        // Given
        int numberOne = 1;
        int numberTwo = 2;
        // When
        int actual = calculator.add(1, 3);
        // Then
        int expected = 3;
        // Here supplier method runs if test fails
        // When you pass String instead of supplier you concat string every time but by using supplier
        // it will concat every time is needed.
        assertEquals(expected, actual, () -> "should return " + expected + " but returned " + actual);
    }

    @RepeatedTest(3)
    void repetitionTest(RepetitionInfo repetitionInfo) {
        if(repetitionInfo.getCurrentRepetition() == 1) {
            // do something
        } else if(repetitionInfo.getCurrentRepetition() == 2) {
            // do something elese
        }
    }

    @Test
    @Tag("UnitTest")
    void tagTest() {
        // It's very common to execute all our JUnit tests automatically as a part of the CI build using Maven. This, however, is often time-consuming.
        // Therefore, we often want to filter our tests and execute either unit tests or integration tests or both at various stages of the build process.

        // 1- JUnit 5 allows us to implement test suites through which we can execute tagged test cases
        // @RunWith(JUnitPlatform.class)
        // @SelectPackages("com.baeldung.tags")
        // @IncludeTags("UnitTest")
        // public class EmployeeDAOUnitTestSuite {
        // }

        // 2- For filtering JUnit tests within the various phases of the Maven build, we can use the Maven Surefire plugin.
        // The Surefire plugin allows us to include or exclude the tags in the plugin configuration:
        // <plugin>
        //    <artifactId>maven-surefire-plugin</artifactId>
        //    <version>2.22.2</version>
        //    <configuration>
        //        <groups>UnitTest</groups>
        //    </configuration>
        // </plugin>

        // 3- Filtering Tags with an IDE
    }

    class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        int divide(int a, int b) {
            return a / b;
        }

        int multiply(int a, int b) {
            return a * b;
        }
    }
}


/**
 * Test-driven development is a software-development methodology which essentially
 * states that for each unit of software, a software developer must:
 *
 * define a test set for the unit first;
 * make the tests fail;
 * then implement the unit;
 * finally verify that the implementation of the unit makes the tests succeed.
 *
 */