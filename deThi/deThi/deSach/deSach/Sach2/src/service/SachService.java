package service;

import dao.SachDao;
import java.util.List;
import model.Sach;

/**
 *
 * @author admin
 */
public class SachService {

    private SachDao dao;

    public SachService() {
    dao = new SachDao();
    }
    
    public List<Sach> getAll() {
        return dao.getAll();
    }

    public void them(Sach s) throws Exception {
        dao.them(s);
    }

    public void sua(Sach s) throws Exception {
        dao.sua(s);
    }

    public void xoa(String index) throws Exception {
        dao.xoa(index);
    }

}
