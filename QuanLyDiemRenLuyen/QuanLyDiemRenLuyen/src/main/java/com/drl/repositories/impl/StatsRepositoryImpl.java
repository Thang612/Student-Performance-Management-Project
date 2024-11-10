/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.drl.repositories.impl;

import com.drl.pojo.Dieu;
import com.drl.pojo.HoatDong;
import com.drl.pojo.HocKi;
import com.drl.pojo.HocKiNamHoc;
import com.drl.pojo.Khoa;
import com.drl.pojo.Lop;
import com.drl.pojo.NamHoc;
import com.drl.pojo.NguoiDung;
import com.drl.pojo.SinhVien;
import com.drl.pojo.SinhVienHoatDong;
import com.drl.repositories.StatsRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Transactional
@Repository
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsDiemRenLuyenTheoKhoa() {
        Session s = this.factory.getObject().getCurrentSession();

        String subqueryHQL = "SELECT nd.id, nd.ho, nd.ten, k.ten AS khoa, d.dieu,l.ten, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN sv.lopId l "
                + "JOIN l.khoaId k "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hn.hocKiId hk "
                + "JOIN hn.namHocId nh "
                + "JOIN sv.nguoiDung nd "
                + "WHERE hk.hocKi LIKE '1' AND nh.namHoc = 2024 AND svhd.trangThai = 1 "
                + "GROUP BY nd.id, nd.ho, nd.ten, k.ten, d.dieu, l.ten, d.diemToiDa";

        Map<Integer, Integer> resultMap = new HashMap<>();

        List<Object[]> subqueryResult = s.createQuery(subqueryHQL).getResultList(); //Câu truy vấn tính điểm theo từng điều

        for (Object[] row : subqueryResult) { //Tiến hành TÍNH ĐIỂM group by ID
            int id = (int) (row[0]);
            int diemTong = (int) row[6];
            if (resultMap.containsKey(id)) {
                resultMap.put(id, resultMap.get(id) + diemTong);
            } else {
                resultMap.put(id, diemTong);
            }
        }

        List<Object[]> finalResults = new ArrayList<>();//Tiến hành Subquery cho các trường ho,ten,khoa cho kết quả tính tổng nảy
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int id = entry.getKey();
            int sumDiemTong = entry.getValue();

            // Tìm kiếm phần tử trong subqueryResult có id tương ứng
            for (Object[] row : subqueryResult) {
                int currentId = (int) row[0];
                if (currentId == id) {
                    String ho = (String) row[1];
                    String ten = (String) row[2];
                    String khoa = (String) row[3];
                    int dieu = (int) row[4];
                    String lop = (String) row[5];

                    finalResults.add(new Object[]{id, ho, ten, lop, khoa, sumDiemTong});
                    break; // Dừng vòng lặp khi tìm thấy id tương ứng
                }
            }
        }

        return finalResults;
    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoKhoa(int min, int max, int hocKi, int namHoc) {
        Session s = this.factory.getObject().getCurrentSession();

        String subqueryHQL = "SELECT nd.id, nd.ho, nd.ten, k.ten AS khoa, d.dieu,l.ten, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN sv.lopId l "
                + "JOIN l.khoaId k "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hn.hocKiId hk "
                + "JOIN hn.namHocId nh "
                + "JOIN sv.nguoiDung nd "
                + "WHERE hk.hocKi = :hocKi AND nh.namHoc = :namHoc AND svhd.trangThai = 1 "
                + "GROUP BY nd.id, nd.ho, nd.ten, k.ten, d.dieu, l.ten, d.diemToiDa";

        Map<Integer, Integer> resultMap = new HashMap<>();

        Query query = s.createQuery(subqueryHQL);
        query.setParameter("hocKi", String.valueOf(hocKi)); // Bind giá trị cho tham số hocKiId
        query.setParameter("namHoc", namHoc);
        List<Object[]> subqueryResult = query.getResultList();

        for (Object[] row : subqueryResult) {
            int id = (int) (row[0]);
            int diemTong = (int) row[6];
            if (resultMap.containsKey(id)) {
                resultMap.put(id, resultMap.get(id) + diemTong);
            } else {
                resultMap.put(id, diemTong);
            }
        }

        List<Object[]> temptResult = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int id = entry.getKey();
            int sumDiemTong = entry.getValue();

            // Tìm kiếm phần tử trong subqueryResult có id tương ứng
            for (Object[] row : subqueryResult) {
                int currentId = (int) row[0];
                if (currentId == id) {
                    String ho = (String) row[1];
                    String ten = (String) row[2];
                    String khoa = (String) row[3];
                    int dieu = (int) row[4];
                    String lop = (String) row[5];

                    temptResult.add(new Object[]{id, ho, ten, lop, khoa, sumDiemTong});
                    break; // Dừng vòng lặp khi tìm thấy id tương ứng
                }
            }
        }
        Map<String, Integer> countByKhoa = new HashMap<>();
        List<Object[]> finalResult = new ArrayList<>();

        for (Object[] row : temptResult) {
            String khoa = (String) row[4]; // Lấy giá trị của trường khoa từ temptResult
            int sumDiemTong = (int) row[5]; // Lấy giá trị sumDiemTong từ temptResult

            // Kiểm tra nếu sumDiemTong lớn hơn hoặc bằng 90
            if (sumDiemTong >= min && sumDiemTong <= max) {
                // Kiểm tra nếu khoa đã tồn tại trong Map
                if (countByKhoa.containsKey(khoa)) {
                    // Nếu đã tồn tại, tăng giá trị đếm lên 1
                    countByKhoa.put(khoa, countByKhoa.get(khoa) + 1);
                } else {
                    // Nếu chưa tồn tại, thêm khoa vào Map với giá trị 1
                    countByKhoa.put(khoa, 1);
                }
                // Không cần thêm mới Object[] vào danh sách finalResult ở đây,
                // vì chúng ta đã thêm nó vào temptResult từ trước rồi
            }
        }

        // Tạo các đối tượng kết quả và thêm vào danh sách finalResult
        for (Map.Entry<String, Integer> entry : countByKhoa.entrySet()) {
            String khoa = entry.getKey();
            int count = entry.getValue();
            finalResult.add(new Object[]{khoa, count});
            System.out.println(finalResult);
        }

        return finalResult;

    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTichVaTheoLop(int min, int max, int hocKi, int namHoc, int khoaId) {
        Session s = this.factory.getObject().getCurrentSession();

        String subqueryHQL = "SELECT nd.id, nd.ho, nd.ten, k.ten AS khoa, d.dieu,l.ten, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN sv.lopId l "
                + "JOIN l.khoaId k "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hn.hocKiId hk "
                + "JOIN hn.namHocId nh "
                + "JOIN sv.nguoiDung nd "
                + "WHERE hk.hocKi = :hocKi AND nh.namHoc = :namHoc AND k.id = :khoaId AND svhd.trangThai = 1 "
                + "GROUP BY nd.id, nd.ho, nd.ten, k.ten, d.dieu, l.ten, d.diemToiDa";

        Map<Integer, Integer> resultMap = new HashMap<>();

        Query query = s.createQuery(subqueryHQL);
        query.setParameter("hocKi", String.valueOf(hocKi)); // Bind giá trị cho tham số hocKiId
        query.setParameter("namHoc", namHoc);
        query.setParameter("khoaId", khoaId);
        List<Object[]> subqueryResult = query.getResultList();

        for (Object[] row : subqueryResult) {
            int id = (int) (row[0]);
            int diemTong = (int) row[6];
            if (resultMap.containsKey(id)) {
                resultMap.put(id, resultMap.get(id) + diemTong);
            } else {
                resultMap.put(id, diemTong);
            }
        }

        List<Object[]> temptResult = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int id = entry.getKey();
            int sumDiemTong = entry.getValue();

            // Tìm kiếm phần tử trong subqueryResult có id tương ứng
            for (Object[] row : subqueryResult) {
                int currentId = (int) row[0];
                if (currentId == id) {
                    String ho = (String) row[1];
                    String ten = (String) row[2];
                    String khoa = (String) row[3];
                    int dieu = (int) row[4];
                    String lop = (String) row[5];

                    temptResult.add(new Object[]{id, ho, ten, lop, khoa, sumDiemTong});
                    break; // Dừng vòng lặp khi tìm thấy id tương ứng
                }
            }
        }
        Map<String, Integer> countByLop = new HashMap<>();
        List<Object[]> finalResult = new ArrayList<>();

        for (Object[] row : temptResult) {
            String lop = (String) row[3]; // Lấy giá trị của trường khoa từ temptResult
            int sumDiemTong = (int) row[5]; // Lấy giá trị sumDiemTong từ temptResult

            // Kiểm tra nếu sumDiemTong lớn hơn hoặc bằng 90
            if (sumDiemTong >= min && sumDiemTong <= max) {
                // Kiểm tra nếu khoa đã tồn tại trong Map
                if (countByLop.containsKey(lop)) {
                    // Nếu đã tồn tại, tăng giá trị đếm lên 1
                    countByLop.put(lop, countByLop.get(lop) + 1);
                } else {
                    // Nếu chưa tồn tại, thêm khoa vào Map với giá trị 1
                    countByLop.put(lop, 1);
                }
                // Không cần thêm mới Object[] vào danh sách finalResult ở đây,
                // vì chúng ta đã thêm nó vào temptResult từ trước rồi
            }
        }

        // Tạo các đối tượng kết quả và thêm vào danh sách finalResult
        for (Map.Entry<String, Integer> entry : countByLop.entrySet()) {
            String lop = entry.getKey();
            int count = entry.getValue();
            finalResult.add(new Object[]{lop, count});
        }

        return finalResult;

    }

    @Override
    public List<Object[]> statsDiemRenLuyenTheoThanhTich(int min, int max, int hocKi, int namHoc, int lopId) {
        Session s = this.factory.getObject().getCurrentSession();

        String subqueryHQL = "SELECT nd.id, nd.ho, nd.ten, k.ten AS khoa, d.dieu,l.ten, "
                + "CASE WHEN SUM(hd.diem) > d.diemToiDa THEN d.diemToiDa ELSE SUM(hd.diem) END AS diem_tong "
                + "FROM SinhVienHoatDong svhd "
                + "JOIN svhd.sinhVienId sv "
                + "JOIN svhd.hoatDongId hd "
                + "JOIN hd.dieuId d "
                + "JOIN sv.lopId l "
                + "JOIN l.khoaId k "
                + "JOIN hd.hocKiNamHocId hn "
                + "JOIN hn.hocKiId hk "
                + "JOIN hn.namHocId nh "
                + "JOIN sv.nguoiDung nd "
                + "WHERE hk.hocKi = :hocKi AND nh.namHoc = :namHoc AND l.id = :lopId AND svhd.trangThai = 1 "
                + "GROUP BY nd.id, nd.ho, nd.ten, k.ten, d.dieu, l.ten, d.diemToiDa";

        Map<Integer, Integer> resultMap = new HashMap<>();

        Query query = s.createQuery(subqueryHQL);
        query.setParameter("hocKi", String.valueOf(hocKi)); // Bind giá trị cho tham số hocKiId
        query.setParameter("namHoc", namHoc);
        query.setParameter("lopId", lopId);
        List<Object[]> subqueryResult = query.getResultList();

        for (Object[] row : subqueryResult) {
            int id = (int) (row[0]);
            int diemTong = (int) row[6];
            if (resultMap.containsKey(id)) {
                resultMap.put(id, resultMap.get(id) + diemTong);
            } else {
                resultMap.put(id, diemTong);
            }
        }
        Map<String, Integer> countByThanhTich = new HashMap<>();
        List<Object[]> finalResult = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            int id = entry.getKey();
            int sumDiemTong = entry.getValue();

            String thanhTich = "";
            if (sumDiemTong >= min && sumDiemTong <= max) {//Tính COUNT GROUP BY THÀNH TÍCH
                if (sumDiemTong >= 90) {
                    thanhTich = "Xuất sắc";
                } else if (sumDiemTong >= 80) {
                    thanhTich = "Giỏi";
                } else if (sumDiemTong >= 70) {
                    thanhTich = "Khá";
                }
                // Kiểm tra nếu Thành Tích đã tồn tại trong Map
                if (countByThanhTich.containsKey(thanhTich)) {
                    // Nếu đã tồn tại, tăng giá trị đếm lên 1
                    countByThanhTich.put(thanhTich, countByThanhTich.get(thanhTich) + 1);
                } else {
                    // Nếu chưa tồn tại, thêm Thành Tích vào Map với giá trị 1
                    countByThanhTich.put(thanhTich, 1);
                }

            }

        }

        for (Map.Entry<String, Integer> entry : countByThanhTich.entrySet()) {
            String thanhTich = entry.getKey();
            int count = entry.getValue();
            finalResult.add(new Object[]{thanhTich, count});
        }
        return finalResult;
    }
}
