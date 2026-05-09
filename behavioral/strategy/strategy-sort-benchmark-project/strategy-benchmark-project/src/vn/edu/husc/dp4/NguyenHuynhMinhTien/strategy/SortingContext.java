package vn.edu.husc.dp4.NguyenHuynhMinhTien.strategy;

public class SortingContext {

    private SortingStrategy strategy;

    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] a) {
        if (strategy == null) {
            throw new IllegalStateException("Chưa chọn thuật toán sắp xếp");
        }

        strategy.sort(a);
    }

    public String getStrategyName() {
        return strategy != null ? strategy.getName() : "No strategy";
    }
}
