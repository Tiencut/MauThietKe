package vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy;

public class BubbleSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Sắp xếp nổi bọt";
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
