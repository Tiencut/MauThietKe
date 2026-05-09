package vn.edu.husc.dp4.NguyenHuynhMinhTien;

import java.util.Random;

import vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy.BubbleSortStrategy;
import vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy.InsertionSortStrategy;
import vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy.QuickSortStrategy;
import vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy.SortingContext;
import vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy.SortingStrategy;

public class SortingBenchmark {

    public static void main(String[] args) {

        int[] sizes = {1000, 5000, 10000, 20000, 100000};

        int runs = 5;

        System.out.printf("%-20s %-15s %-20s%n",
                "Thuật toán",
                "Kích thước",
                "Thời gian TB (ms)");

        for (int size : sizes) {

            System.out.println("\n--- Kích thước mảng: " + size + " ---");

            int[] array = genRandomArray(size);

            SortingContext context = new SortingContext();

            thuNghiem(context, new BubbleSortStrategy(), array, runs);
            thuNghiem(context, new QuickSortStrategy(), array, runs);
            thuNghiem(context, new InsertionSortStrategy(), array, runs);
        }
    }

    private static void thuNghiem(
            SortingContext context,
            SortingStrategy strategy,
            int[] array,
            int runs) {

        long totalTime = 0;

        context.setStrategy(strategy);

        for (int i = 0; i < runs; i++) {

            int[] copy = array.clone();

            long start = System.nanoTime();

            context.sort(copy);

            long end = System.nanoTime();

            totalTime += (end - start);
        }

        double averageTimeMs = (totalTime / runs) / 1_000_000.0;

        System.out.printf("%-20s %-15d %-20.2f ms%n",
                strategy.getName(),
                array.length,
                averageTimeMs);
    }

    private static int[] genRandomArray(int size) {

        Random random = new Random(new java.util.Date().getTime());

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }
}
