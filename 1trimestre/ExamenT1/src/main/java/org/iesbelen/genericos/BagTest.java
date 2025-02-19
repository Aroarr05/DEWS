package org.iesbelen.genericos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {

    private static Bag<Integer> bag;

    @BeforeAll
    public static void setUp() {
        bag = new Bag<>();
    }

    @Test
    public void add() {
        bag.add(1);
        bag.add(2);
        bag.add(3);

        assertEquals(3, bag.size());

        bag.remove(1);
        assertEquals(2, bag.size());


    }

    @Test
    public void remove() {
        bag.add(1);
        bag.add(2);
        bag.add(3);

        assertEquals(3, bag.size());

        bag.remove(1);
        assertEquals(2, bag.size());

    }

    public void getCount() {
        bag.add(1);
        bag.add(1);

        assertEquals(2, bag.getCount());

        bag.remove(1);
        assertEquals(2, bag.size());

    }


}
