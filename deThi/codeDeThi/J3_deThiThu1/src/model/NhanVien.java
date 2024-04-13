package model;

public class NhanVien {

    private String id;
    private String ma;
    private String ten;
    private String sdt;
    private int trangThai;

    public NhanVien() {
    }

    public NhanVien(String id, String ma, String ten, String sdt, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

//    public String trangThai() {
//        if (trangThai == 1) {
//            return "Dang Hoat Dong";
//        }
//        return "Khong Hoat Dong";
//    }
}
