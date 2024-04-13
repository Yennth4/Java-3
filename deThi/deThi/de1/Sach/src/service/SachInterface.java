package service;

import java.util.ArrayList;

public interface SachInterface<T> {

    public ArrayList<T> getAll();

    public void them(T entity) throws Exception;

    public void sua(T entity , int index) throws Exception;

    public void xoa(int index) throws Exception;

}
