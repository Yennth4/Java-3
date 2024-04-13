package service;

import dao.SachDAO;
import entity.Sach;
import java.util.ArrayList;

public class SachService {

    private SachDAO dao;

    public SachService() {
        dao = new SachDAO();
    }

    public ArrayList<Sach> getAll() {
        return dao.getAll();
    }

    public void them(Sach s) throws Exception {
        dao.them(s);
    }

    public void sua(Sach s, int index) throws Exception {
        dao.sua(s, index);
    }

    public void xoa(int index) throws Exception {
        dao.xoa(index);
    }
}
