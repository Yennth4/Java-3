package model;

import java.io.Serializable;

public class DanhMuc {
    private int id;
    private String ten;
    private String moTa;
    private int trangThai;

    public DanhMuc() {
    }

    public DanhMuc(int id, String ten, String moTa, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public String trangThai1(){
        
        if (trangThai == 1){
            return "Dang Hoat Dong";
        }
        return "Khong Hoat Dong";
    }
}

