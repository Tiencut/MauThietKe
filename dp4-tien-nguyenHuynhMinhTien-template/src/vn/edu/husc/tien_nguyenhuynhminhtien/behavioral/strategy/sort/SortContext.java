package vn.edu.husc.tien_nguyenhuynhminhtien.strategy.sort;

public class SortContext {
    private SortingStrategy strategy;

    pubic void setStrategy(SortingStrategy strategy) {
        this.strategy = stratrgy;
    }

    public void sort(int arr[]) {
        if (strategy == null) {
            throw new IllegalStateException("Chưa chọn thuật toán sắp xếp");
        }
        strategy.sort(arr);
    }

    public String getStrategyName() {
        if (strategy == null) {
            return "Chưa chọn thuật toán sắp xếp";
        }
        return strategy.getName();
    }
}
