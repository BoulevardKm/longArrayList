import org.example.list.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<String> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
    }

    @Test
    void testAddAndSize() {
        myArrayList.add("Hello");
        assertEquals(1, myArrayList.size());
        myArrayList.add("World");
        assertEquals(2, myArrayList.size());
    }

    @Test
    void testGet() {
        myArrayList.add("Hello");
        myArrayList.add("World");
        assertEquals("Hello", myArrayList.get(0));
        assertEquals("World", myArrayList.get(1));
    }

    @Test
    void testGetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.get(0));
    }

    @Test
    void testSet() {
        myArrayList.add("Hello");
        myArrayList.set(0, "World");
        assertEquals("World", myArrayList.get(0));
    }

    @Test
    void testSetOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.set(0, "Hello"));
    }

    @Test
    void testRemove() {
        myArrayList.add("Hello");
        myArrayList.add("World");
        String removed = myArrayList.remove(0);
        assertEquals("Hello", removed);
        assertEquals(1, myArrayList.size());
        assertEquals("World", myArrayList.get(0));
    }

    @Test
    void testRemoveOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(0));
    }

    @Test
    void testContains() {
        myArrayList.add("Hello");
        myArrayList.add("World");
        assertTrue(myArrayList.contains("Hello"));
        assertFalse(myArrayList.contains("Test"));
    }

    @Test
    void testContainsNull() {
        myArrayList.add(null);
        assertTrue(myArrayList.contains(null));
    }

    @Test
    void testIsEmpty() {
        assertTrue(myArrayList.isEmpty());
        myArrayList.add("Hello");
        assertFalse(myArrayList.isEmpty());
    }
}
