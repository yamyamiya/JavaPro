package org.example;

import org.example.Task1.CustomArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomArrayListTest {

    CustomArrayList instance = new CustomArrayList();

    @Test
    public void shouldAddElement() {
        instance.add("first element");

        assertEquals("first element", instance.get(0));
    }

    @Test
    public void shouldAddTwoElements() {
        instance.add("first element");
        instance.add("second element");
        assertEquals("first element", instance.get(0));
        assertEquals("second element", instance.get(1));
    }

    @Test
    public void shouldAddManyElements() {
        for (int i = 0; i < 20; i++) {
            instance.add("element" + i);
            assertEquals("element" + i, instance.get(i));
        }

        for (int i = 0; i < 20; i++) {
            assertEquals("element" + i, instance.get(i));
        }
    }

    @Test
    public void shouldRemoveElementByIndex() {
        for (int i = 0; i < 20; i++) {
            instance.add("element " + i);
        }

        assertTrue(instance.remove("element 11"));

        assertEquals(-1, instance.indexOf("element 11"));
    }
}
