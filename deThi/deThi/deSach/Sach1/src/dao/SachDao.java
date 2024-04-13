package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        List<Sach> list = new ArrayList<>();
        try {
            String query = "select * from sach";
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");

                Sach s = new Sach(id, ten, soLuong, donGia);
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void them(Sach s) throws Exception {
        try {
            String query = "INSERT INTO sach(ten,so_luong,don_gia) VALUES (?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuong());
            ps.setFloat(3, s.getDonGia());
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
    public void sua(Sach s) throws Exception {
        try {
            String query = "UPDATE sach SET ten = ?,so_luong = ?,don_gia = ? WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuong());
            ps.setFloat(3, s.getDonGia());
            ps.setInt(4, s.getId());
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
    public void xoa(int index) throws Exception {
        try {
            String query = "DELETE FROM sach WHERE id = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, index);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
