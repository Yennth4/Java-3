package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Sach;
import service.SachInterface;

public class SachDao implements SachInterface<Sach> {

    private Connection c;

    public SachDao() {
        try {
            c = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Sach> getAll() {
        List<Sach> listSach = new ArrayList<>();
        try {
            String query = "SELECT * FROM Sach";
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                int donGia = rs.getInt("donGia");
                int trangThai = rs.getInt("trangThai");

                Sach s = new Sach(id, ma, ten, donGia, trangThai);
                listSach.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }

    @Override
    public void them(Sach s) throws Exception {
        try {
            String query = "INSERT INTO Sach(Ma , Ten , DonGia ,TrangThai) VALUES (?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.setInt(3, s.getDonGia());
            ps.setInt(4, s.getTrangThai());
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sua(Sach s) throws Exception {
        try {
            String query = "UPDATE Sach SET Ma = ? , Ten = ? , DonGia = ? , TrangThai = ? WHERE Id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, s.getMa());
            ps.setString(2, s.getTen());
            ps.setInt(3, s.getDonGia());
            ps.setInt(4, s.getTrangThai());
            ps.setString(5, s.getId());
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void xoa(String index) throws Exception {
        try {
            String query = "DELETE FROM Sach WHERE Id = ? ";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, index);
            ps.execute();
        } catch (SQLServerException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
