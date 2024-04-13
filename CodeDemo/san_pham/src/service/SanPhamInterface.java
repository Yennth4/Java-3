package service;

import java.util.List;

public interface SanPhamInterface<T> {

    public List<T> findAll();

    public void them(T entity) throws Exception;

    public void sua(T entity) throws Exception;

    public void xoa(int index) throws Exception;

}
