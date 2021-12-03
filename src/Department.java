public class Department {
    private int idBoPhan, soLuongNhanVien;
    private String tenBoPhan;

    public Department(int idBoPhan, int soLuongNhanVien, String tenBoPhan) {
        this.idBoPhan = idBoPhan;
        this.soLuongNhanVien = soLuongNhanVien;
        this.tenBoPhan = tenBoPhan;
    }

    public String toString(){
        return "Ma bo phan: "+idBoPhan +"\n"+"Ten bo phan: "+tenBoPhan+"\n"+"So luong nhan vien hien tai: "+soLuongNhanVien;
    }

    public int getIdBoPhan() {
        return idBoPhan;
    }

    public void setIdBoPhan(int idBoPhan) {
        this.idBoPhan = idBoPhan;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }
}
