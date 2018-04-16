package io.github.web.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    @BeforeAll
    static void setupClass() {
        // Initialization per test case
    }

    @BeforeEach
    public void setupTest() {
        // Initialization per test
    }

    @Test
    public void test1() {
        // Exercise and verify
    }

    @Test
    public void test2() {
        // Exercise and verify

        boolean booleanCondition = true;
        Object object1 = null;
        Object object2 = new Object();
        Object[] array1 = {};
        Object[] array2 = {};

        assertTrue(booleanCondition, "The condition is not met");
        assertFalse(booleanCondition, "The condition is met");

        assertArrayEquals(array1, array2, "The array is not equal");

        assertNull(object1, "The object is null");
        assertNotNull(object2, "The object is not null");

        fail("Test failure");
    }

    @AfterEach
    void teardownTest() {
        // Finish per test
    }

    @AfterAll
    static void teardownClass() {
        // Finish per test
    }

}
