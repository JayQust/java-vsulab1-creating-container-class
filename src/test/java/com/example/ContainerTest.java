package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container<String> stringContainer;
    private Container<Integer> intContainer;

    @BeforeEach
    void setUp() {
        stringContainer = new Container<>();
        intContainer = new Container<>(5);
    }

    // тесты метода ADD и ENSURE_CAPACITY
    @Test
    void testAddAndGet() {
        stringContainer.add("good");
        stringContainer.add("Work");

        assertEquals(2, stringContainer.size(), "размер после добавления двух элементов - 2");
        assertEquals("good", stringContainer.get(0), "элемент по индексу 0 - 'good'");
        assertEquals("Work", stringContainer.get(1), "элемент по индексу 1 - 'Work'");
    }

    @Test
    void testCapacityExpansion() {
        for (int i = 0; i<11; i++){
            intContainer.add(i);
        }
        assertEquals(11, intContainer.size());
        assertEquals(10, intContainer.get(10));
        // Проверка на работу контейнера после расширения
        assertThrows(IndexOutOfBoundsException.class, () -> intContainer.get(11));
    }
    
    // тесты метода GET и проверки индекса
    @Test
    void testGetOutOfBoundsThrowExeption() {
        stringContainer.add("french");
        assertThrows(IndexOutOfBoundsException.class, () -> stringContainer.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> stringContainer.get(1));
    }

    // тесты метода REMOVE
    @Test
    void testRemoveMiddleElement() {
        stringContainer.add("A");
        stringContainer.add("B");
        stringContainer.add("C");
        stringContainer.remove(1);
        
        assertEquals(2, stringContainer.size());
        assertEquals("A", stringContainer.get(0));
        assertEquals("C", stringContainer.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> stringContainer.get(2));
    }

    @Test
    void testRemoveFirstElement() {
        stringContainer.add("First");
        stringContainer.add("Second");
        stringContainer.remove(0);

        assertEquals(1, stringContainer.size());
        assertEquals("Second", stringContainer.get(0));
    }

    @Test
    void testRemoveSecondElement() {
        stringContainer.add("First");
        stringContainer.add("Second");
        stringContainer.remove(1);

        assertEquals(1, stringContainer.size());
        assertEquals("First", stringContainer.get(0));
    }

    @Test
    void testRemoveFromEmptyContainerThrowsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> stringContainer.remove(0));
    }

    //тесты методов SIZE и CLEAR
    @Test
    void testSize() {
        assertEquals(0, stringContainer.size());
        stringContainer.add("one");
        assertEquals(1, stringContainer.size());
        stringContainer.remove(0);
        assertEquals(0, stringContainer.size());
    }

    @Test
    void testClear() {
        stringContainer.add("1");
        stringContainer.add("2");
        stringContainer.clear();
        
        assertEquals(0, stringContainer.size());
        assertThrows(IndexOutOfBoundsException.class, () -> stringContainer.get(0)); 
    }
}