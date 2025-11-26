package com.example;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testContainer() {
        Container<Integer> container = new Container<>();

        container.add(10);
        container.add(20);
        container.add(30);

        assertEquals(10, container.get(0));
        assertEquals(20, container.get(1));
        assertEquals(30, container.get(2));

        container.remove(1);

        assertEquals(2, container.size());
        assertEquals(30, container.get(1));
    }
}