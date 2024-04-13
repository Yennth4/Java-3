package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;

public class DanhMucDAO {

    private Connection conn;

    public DanhMucDAO() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DanhMuc> findAll() {
        ArrayList<DanhMuc> listDanhMuc = new ArrayList<>();
        try {
            String query = "SELECT * FROM danh_muc where trang_thai = 1";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");

                DanhMuc danhMuc = new DanhMuc(id, ten, moTa, trangThai);
                listDanhMuc.add(danhMuc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDanhMuc;
    }

    public List<DanhMuc> search(DanhMuc danhMuc) {
        List<DanhMuc> danhMucs = new ArrayList<>();
        try {
            String query = "SELECT * FROM danh_muc WHERE trang_thai = ? AND (ten like ? or ten like ? or ten like ?)";
            PreparedStatement ps = DBContext.getConnection().prepareStatement(query);
            ps.setObject(1, danhMuc.getTrangThai());
            ps.setString(2, '%' + danhMuc.getTen() + '%');
            ps.setString(3, '%' + danhMuc.getTen());
            ps.setString(4, danhMuc.getTen() + '%');

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                danhMucs.add(new DanhMuc(
                        rs.getInt("id"),
                        String.valueOf(rs.getString("ten")),
                        rs.getString("mo_ta"),
                        rs.getInt("trang_thai")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return danhMucs;
    }
}
