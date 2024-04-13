package service;

import java.util.List;

public interface NhanVienInterface<T> {

    public List<T> getAll();

    public void them(T entity) throws Exception;

    public void sua(T entity) throws Exception;

    public void xoa(String index) throws Exception;

}
