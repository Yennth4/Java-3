package reponsitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import service.NhanVienInterface;

public class NhanVienReponsitory implements NhanVienInterface<NhanVien> {

    private Connection conn;

    public NhanVienReponsitory() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            String query = "SELECT * FROM NHANVIEN";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                int trangThai = rs.getInt("trangThai");

                NhanVien n = new NhanVien(id, ma, ten, sdt, trangThai);
                listNV.add(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    @Override
    public void them(NhanVien nv) throws Exception {
        try {
            String query = "INSERT INTO NHANVIEN(Ma , Ten , Sdt ,TrangThai) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getSdt());
            ps.setInt(4, nv.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sua(NhanVien nv) throws Exception {
        try {
            String query = "UPDATE NHANVIEN SET Ma = ? , Ten = ? , Sdt = ? , TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getSdt());
            ps.setInt(4, nv.getTrangThai());
            ps.setString(5, nv.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void xoa(String index) throws Exception {
        try {
            String query = "DELETE FROM NHANVIEN WHERE Id = ? ";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, index);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
