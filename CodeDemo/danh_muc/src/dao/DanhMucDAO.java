package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DanhMuc;

public class DanhMucDAO {

    private Connection conn;

    public DanhMucDAO() {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DanhMuc> findAll() {
        String query = "SELECT * FROM danh_muc";

        ArrayList<DanhMuc> ds = new ArrayList<>(); // tao list de luu duLieu vao 
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");

                DanhMuc danhMuc = new DanhMuc(id, ten, moTa, trangThai);
                ds.add(danhMuc); // add danh muc vua duyet kia vao list
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }

    public void them(DanhMuc danhMuc) {
        try {
            String query = "INSERT INTO danh_muc (ten, mo_ta , trang_thai) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, danhMuc.getTen());
            ps.setString(2, danhMuc.getMoTa());
            ps.setInt(3, danhMuc.getTrangThai());
            ps.execute();
            System.out.println("Them thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Them that bai");
        }
    }

    public void sua(DanhMuc danhMuc, int index) {

        try {
            String query = "UPDATE danh_muc SET ten = ?, mo_ta = ?, trang_thai = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, danhMuc.getTen());
            ps.setString(2, danhMuc.getMoTa());
            ps.setInt(3, danhMuc.getTrangThai());
            ps.setInt(4, danhMuc.getID());
            ps.executeUpdate();
            System.out.println("Update thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update that bai");
        }
    }

    public void xoa(int index) {
        try {
            String query = "DELETE FROM danh_muc WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, index);
            ps.executeUpdate();
            System.out.println("Xoa thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Delete that bai");

        }
    }
}
