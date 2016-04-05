package io.github.web.junit;

import java.util.ArrayList;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    private List<String> list;
    private final String[] data = { "data1", "data2", "data3" };

    @Before
    public void setupTest() {
        list = new ArrayList<String>();
        for (String s : data) {
            list.add(s);
        }
    }

    @Test
    public void testContet() {
        for (int i = 0; i < data.length; i++) {
            // Exercise
            String expectedContent = data[i];
            String realContent = list.get(i);

            // Verify
            Assert.assertEquals(
                    "Element at position " + i + " should be " + expectedContent
                            + " and is " + realContent,
                    expectedContent, realContent);
        }
    }

    @Test
    public void testSize() {
        // Exercise
        int expectedSize = data.length;
        int realSize = list.size();

        // Verify
        Assert.assertTrue(
                "List size should be " + expectedSize + " and is " + realSize,
                realSize == expectedSize);
    }

    @After
    public void teardownTest() {
        list.clear();
    }
}
