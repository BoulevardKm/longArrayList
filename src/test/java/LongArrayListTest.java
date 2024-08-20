import org.example.list.LongArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongArrayListTest {
    LongArrayList longArrayList = new LongArrayList();

    @Test
    public void testArrayRealization() {

        longArrayList.add(0, 10);
        longArrayList.add(1, 20);
        longArrayList.add(2, 30);
        longArrayList.add(3, 40);
        longArrayList.add(4, 50);
        longArrayList.add(60);

        assertEquals(10, longArrayList.get(0));
        assertEquals(20, longArrayList.get(1));
        assertEquals(30, longArrayList.get(2));
        assertEquals(40, longArrayList.get(3));
        assertEquals(50, longArrayList.get(4));
        assertEquals(60, longArrayList.get(5));

        assertEquals(6, longArrayList.size());

        longArrayList.set(4, 51);
        assertEquals(51, longArrayList.get(4));

        assertFalse(longArrayList.isEmpty());

        longArrayList.remove(3);
        assertEquals(5, longArrayList.size());

        assertTrue(longArrayList.contains(51));
        assertFalse(longArrayList.contains(100));

    }


}
