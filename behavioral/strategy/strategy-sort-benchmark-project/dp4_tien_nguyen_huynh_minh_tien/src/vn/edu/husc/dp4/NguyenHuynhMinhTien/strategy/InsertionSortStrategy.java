package vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy;

public class InsertionSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    @Override
    public String getName() {
        return "Sắp xếp chèn";
    }
}
