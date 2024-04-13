/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author admin
 */
public interface SachInterface<T> {

    public List<T> getAll();

    public void them(T entity) throws Exception;

    public void sua(T entity) throws Exception;

    public void xoa(int index) throws Exception;

}
