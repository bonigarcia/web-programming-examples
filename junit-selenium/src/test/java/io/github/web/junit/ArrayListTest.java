package io.github.web.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArrayListTest {

    List<String> list;
    final String[] data = { "data1", "data2", "data3" };

    @BeforeEach
    void setup() {
        list = new ArrayList<String>();
        for (String s : data) {
            list.add(s);
        }
    }

    @Test
    void testContent() {
        for (int i = 0; i < data.length; i++) {
            // Exercise
            String expectedContent = data[i];
            String realContent = list.get(i);

            // Verify
            assertEquals(expectedContent, realContent);
        }
    }

    @Test
    void testSize() {
        // Exercise
        int expectedSize = data.length;
        int realSize = list.size();

        // Verify
        assertTrue(realSize == expectedSize);
    }

    @AfterEach
    void teardown() {
        list.clear();
    }
}
