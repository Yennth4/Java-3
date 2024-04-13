package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangRepository {

    private Connection conn;

    public KhachHangRepository() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<KhachHang> findAll() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        try {
            String query = "SELECT * FROM khach_hang";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.executeQuery();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                String diaChi = rs.getString("dia_chi");
                String email = rs.getString("email");
                int tuoi = rs.getInt("tuoi");
                int gioi_tinh = rs.getInt("gioi_tinh");

                KhachHang khachHang = new KhachHang(id, ten, diaChi, email, tuoi, gioi_tinh);
                listKhachHang.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public void them(KhachHang khachHang) throws Exception {
        try {
            String query = "INSERT INTO khach_hang(ten , dia_chi , email , tuoi , gioi_tinh) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, khachHang.getTen());
            ps.setString(2, khachHang.getDiaChi());
            ps.setString(3, khachHang.getEmail());
            ps.setInt(4, khachHang.getTuoi());
            ps.setInt(5, khachHang.getGioiTinh());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void sua(KhachHang khachHang, int index) throws Exception {
        try {
            String query = "UPDATE khach_hang SET ten = ? , dia_chi = ? , email = ? , tuoi = ? , gioi_tinh = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, khachHang.getTen());
            ps.setString(2, khachHang.getDiaChi());
            ps.setString(3, khachHang.getEmail());
            ps.setInt(4, khachHang.getTuoi());
            ps.setInt(5, khachHang.getGioiTinh());
            ps.setInt(6, khachHang.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void xoa(int index) throws Exception {
        try {
            String query = "DELETE FROM khach_hang WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, index);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
