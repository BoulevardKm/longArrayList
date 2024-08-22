import org.example.list.LongArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongArrayListTest {
    LongArrayList longArrayList = new LongArrayList();

    @Test
    public void testArrayRealization() {

        //добавление элементов
        longArrayList.add(0, 10);
        longArrayList.add(1, 20);
        longArrayList.add(2, 30);
        longArrayList.add(3, 40);
        longArrayList.add(4, 50);
        longArrayList.add(60);

        //получение добавленных элементов
        assertEquals(10, longArrayList.get(0));
        assertEquals(20, longArrayList.get(1));
        assertEquals(30, longArrayList.get(2));
        assertEquals(40, longArrayList.get(3));
        assertEquals(50, longArrayList.get(4));
        assertEquals(60, longArrayList.get(5));

        //получение размера массива, проверка размера
        assertEquals(6, longArrayList.size());

        //замена элемента, проверка замены
        longArrayList.set(4, 51);
        assertEquals(51, longArrayList.get(4));

        //проверка того что массив не пустой
        assertFalse(longArrayList.isEmpty());

        //удаление элемента, проверка что размер массива уменьшен
        longArrayList.remove(3);
        assertEquals(5, longArrayList.size());

        //проверка что в массиве содержится элемент 51 и не содержится элемент 100
        assertTrue(longArrayList.contains(51));
        assertFalse(longArrayList.contains(100));

        //проверка негативных кейсов
        try {
            longArrayList.get(-1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            longArrayList.set(-1, 100);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            longArrayList.remove(-1);
        } catch (IndexOutOfBoundsException e) {
        }

        try {
            longArrayList.add(7, 100);
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
