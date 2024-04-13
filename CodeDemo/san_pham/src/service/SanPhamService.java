package service;

import dao.SanPhamDAO;
import java.util.List;
import model.SanPham;

public class SanPhamService {

    private SanPhamDAO dao;

    public SanPhamService() {
    dao = new SanPhamDAO();
    }
    
    public List<SanPham> findAll() {
        return dao.findAll();
    }

    public void them(SanPham sanPham) throws Exception {
        dao.them(sanPham);
    }

    public void sua(SanPham sanPham) throws Exception {
        dao.sua(sanPham);
    }

    public void xoa(int index) throws Exception {
        dao.xoa(index);
    }

}
