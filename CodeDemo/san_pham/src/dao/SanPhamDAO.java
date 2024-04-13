package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import model.SanPham;
import service.SanPhamInterface;

public class SanPhamDAO implements SanPhamInterface<SanPham>{

    private Connection conn;

    public SanPhamDAO() {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SanPham> findAll() {
        String query = "SELECT * FROM san_pham";
        List<SanPham> ds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                ds.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public void them(SanPham sanPham) throws Exception {
        try {
            String query = "INSERT INTO san_pham(ten, so_luong ,mau_sac , don_gia , danh_muc_id) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sanPham.getTen());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setString(3, sanPham.getMauSac());
            ps.setInt(4, sanPham.getDonGia());
            ps.setInt(5, sanPham.getDanhMucId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sua(SanPham sanPham) throws Exception {
        try {
            String query = "UPDATE san_pham SET ten = ? , so_luong = ? , mau_sac = ? , don_gia = ? , danh_muc_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sanPham.getTen());
            ps.setInt(2, sanPham.getSoLuong());
            ps.setString(3, sanPham.getMauSac());
            ps.setInt(4, sanPham.getDonGia());
            ps.setInt(5, sanPham.getDanhMucId());
            ps.setInt(6, sanPham.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void xoa(int index) throws Exception {
        try {
            String query = "DELETE FROM san_pham WHERE id = ?";
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
