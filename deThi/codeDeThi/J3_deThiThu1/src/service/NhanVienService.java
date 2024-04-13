package service;

import java.util.List;
import model.NhanVien;
import reponsitory.NhanVienReponsitory;

public class NhanVienService {

    private NhanVienReponsitory dao;
    
    public NhanVienService() {
        dao = new NhanVienReponsitory();
    }
    
    public List<NhanVien> getAll() {
        return dao.getAll();
    }
    
    public void them(NhanVien nv) throws Exception {
        dao.them(nv);
    }
    
    public void sua(NhanVien nv) throws Exception {
        dao.sua(nv);
    }
    
    public void xoa(String index) throws Exception {
        dao.xoa(index);
    }
    
}
