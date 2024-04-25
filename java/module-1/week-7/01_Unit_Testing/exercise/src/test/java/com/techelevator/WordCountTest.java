package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {
    private WordCount wordCount;

    @Before
    public void setUp() {
        wordCount = new WordCount();
    }

    @Test
    public void return_correct_count_from_array_of_strings() {
        String[] array1 = {"ba", "ba", "black", "sheep"};
        Map<String, Integer> result1 = wordCount.getCount(array1);
        assertEquals(2, (int) result1.get("ba"));
        assertEquals(1, (int) result1.get("black"));
        assertEquals(1, (int) result1.get("sheep"));

        String[] array2 = {"a", "b", "a", "c", "b"};
        Map<String, Integer> result2 = wordCount.getCount(array2);
        assertEquals(2, (int) result2.get("a"));
        assertEquals(2, (int) result2.get("b"));
        assertEquals(1, (int) result2.get("c"));

        String[] array3 = {"c", "b", "a"};
        Map<String, Integer> result3 = wordCount.getCount(array3);
        assertEquals(1, (int) result3.get("a"));
        assertEquals(1, (int) result3.get("b"));
        assertEquals(1, (int) result3.get("c"));
    }

    @Test
    public void correct_return_of_empty_array() {
        String[] array = {};
        Map<String, Integer> result = wordCount.getCount(array);
        assertTrue(result.isEmpty());
    }
}
