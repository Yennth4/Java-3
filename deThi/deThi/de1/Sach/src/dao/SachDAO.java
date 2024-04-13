package dao;

import service.SachInterface;
import entity.Sach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SachDAO implements SachInterface<Sach>{

    private Connection conn;

    public SachDAO() {
        try {
            conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ArrayList<Sach> getAll() {
        ArrayList<Sach> listSach = new ArrayList<>();
        try {
            String query = "Select * from sach";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                int tacGiaId = rs.getInt("tac_gia_id");

                Sach s = new Sach(id, ten, soLuong, donGia, tacGiaId);
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
            String query = "INSERT INTO SACH(ten,so_luong,don_gia,tac_gia_id) VALUES (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuong());
            ps.setFloat(3, s.getDonGia());
            ps.setInt(4, s.getTacGiaId());
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
    public void sua(Sach s ,int index) throws Exception {
        try {
            String query = "UPDATE sach SET ten = ? , so_luong = ? , don_gia = ? , tac_gia_id = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, s.getTen());
            ps.setInt(2, s.getSoLuong());
            ps.setFloat(3, s.getDonGia());
            ps.setInt(4, s.getTacGiaId());
            ps.setInt(5, s.getId());
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
            PreparedStatement ps = conn.prepareStatement(query);
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
