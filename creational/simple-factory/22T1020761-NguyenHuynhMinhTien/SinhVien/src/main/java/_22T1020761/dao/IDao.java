package _22T1020761.dao;

import java.util.List;

import _22T1020761.entity.SinhVien;

/**
 * Interface cho Data Access Object của SinhVien.
 */
public interface IDao {
    List<SinhVien> getAll();
    void insert(SinhVien sv);
    void delete(String maSV);
}