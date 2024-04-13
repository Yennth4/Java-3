package service;

import repository.KhachHangRepository;
import java.util.ArrayList;
import model.KhachHang;

public class KhachHangService {

    private KhachHangRepository khachHangRepository;

    public KhachHangService() {
        khachHangRepository = new KhachHangRepository();
    }

    public ArrayList<KhachHang> findAll() throws Exception {
        return khachHangRepository.findAll();
    }

    public KhachHang them(KhachHang khachHang) throws Exception{
        khachHangRepository.them(khachHang);
        return khachHang;
    }

    public KhachHang sua(KhachHang khachHang, int index) throws Exception{
        khachHangRepository.sua(khachHang, index);
        return khachHang;
    }

    public void xoa(int index) throws Exception{
        khachHangRepository.xoa(index);
    }

}
