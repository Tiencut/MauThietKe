package com.NguyenHuynhMinhTien.testbuilder;

public class Bánh {
    // Thuộc tính bắt buộc
    private double đường;
    private double bột;

    // Thuộc tính tuỳ chọn
    private double vani;
    private double nướcDừa;
    private double cacao;
    private double ớt;
    private double tiêu;

    // Inner class Builder
    public static class BánhBuilder {
        // Thuộc tính bắt buộc
        private double đường;
        private double bột;

        // Thuộc tính tuỳ chọn
        private double vani;
        private double nướcDừa;
        private double cacao;
        private double ớt;
        private double tiêu;

        // Constructor với thuộc tính bắt buộc
        public BánhBuilder(double đường, double bột) {
            this.đường = đường;
            this.bột = bột;
        }

        // Các hàm thiết lập thuộc tính tuỳ chọn
        public BánhBuilder vani(double value) {
            this.vani = value;
            return this;
        }
        public BánhBuilder nướcDừa(double value) {
            this.nướcDừa = value;
            return this;
        }
        public BánhBuilder cacao(double value) {
            this.cacao = value;
            return this;
        }
        public BánhBuilder ớt(double value) {
            this.ớt = value;
            return this;
        }
        public BánhBuilder tiêu(double value) {
            this.tiêu = value;
            return this;
        }

        // Hàm build
        public Bánh build() {
            return new Bánh(this);
        }
    }

    // Constructor private nhận builder
    private Bánh(BánhBuilder b) {
        this.đường = b.đường;
        this.bột = b.bột;
        this.vani = b.vani;
        this.nướcDừa = b.nướcDừa;
        this.cacao = b.cacao;
        this.ớt = b.ớt;
        this.tiêu = b.tiêu;
    }

    @Override
    public String toString() {
        return String.format("Bánh [đường=%.2f, bột=%.2f, vani=%.2f, nướcDừa=%.2f, cacao=%.2f, ớt=%.2f, tiêu=%.2f]",
                đường, bột, vani, nướcDừa, cacao, ớt, tiêu);
    }
}
