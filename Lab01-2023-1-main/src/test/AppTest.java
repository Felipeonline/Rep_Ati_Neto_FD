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
import java.util.Arrays;

public class App {

    public static int encontre_lista(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    }

    public static int maior(int[] arr) {
        if (arr.length == 0) {
            return -1; // Return -1 for an empty array
        }

        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static Double par_mais_proximo(Integer[][] points) {
        if (points.length < 2) {
            return null; // Return null for an insufficient number of points
        }

        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distanceBetweenPoints(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    private static double distanceBetweenPoints(Integer[] point1, Integer[] point2) {
        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];

        int dx = x2 - x1;
        int dy = y2 - y1;

        return Math.sqrt(dx * dx + dy * dy);
    }
}


