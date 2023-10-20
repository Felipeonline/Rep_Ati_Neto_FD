package test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import main.App;
public class AppTest {
    @Test
    public void testEncontre() {
        assertEquals(1, App.encontre(new int[]{1, 2, 3, 4, 5}, 3));
        assertEquals(1, App.encontre(new int[]{1, 2, 3}, 3));
        assertEquals(0, App.encontre(new int[]{1, 2, 3}, 7));
        assertEquals(1, App.encontre(new int[]{1, 2,7, 3}, 7));
        assertEquals(0, App.encontre(new int[]{}, 7));
    }

    @Test
    public void testMaior() {
        assertEquals(5, App.maior(new int[]{1, 2, 3, 4, 5}));
        assertEquals(5, App.maior(new int[]{5, 2, 3, 4, 5}));
        assertEquals(5, App.maior(new int[]{5, 2, 3, 4, 1}));
        assertEquals(-1, App.maior(new int[]{-5, -2, -3, -4, -1}));
        assertEquals(-5, App.maior(new int[]{-5}));
    }

    @Test
    public void testParMaisProximo() {
        assertEquals(1.414, App.parMaisProximo(new Integer[][]{new Integer[]{2, 4}, new Integer[]{5, 9}, new Integer[]{1, 3}, new Integer[]{8, 2}, new Integer[]{6, 7}}));
        assertNull(App.parMaisProximo(new Integer[][]{}));
        assertEquals(0, App.parMaisProximo(new Integer[][]{new Integer[]{2, 4}, new Integer[]{5, 9}, new Integer[]{1, 3}, new Integer[]{8, 2}, new Integer[]{2, 4}}));
    }
}
