package model;

/**
 *
 * @author admin
 */
public class SanPham {
    private int id;
    private String ten;
    private int soLuong;
    private String mauSac;
    private int donGia;
    private int danhMucId;

    public SanPham() {
    }

    public SanPham(int id, String ten, int soLuong, String mauSac, int donGia, int danhMucId) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.mauSac = mauSac;
        this.donGia = donGia;
        this.danhMucId = danhMucId;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }
    
    
}
