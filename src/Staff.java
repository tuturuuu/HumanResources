abstract class Staff {
    private int id, tuoi,soNgayNghiPhep;
    private String ten, boPhanLamViec,ngayVaoLam;
    private double heSoLuong;

    abstract void displayInformation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public int getSoNgayNghiPhep() {
        return soNgayNghiPhep;
    }

    public void setSoNgayNghiPhep(int soNgayNghiPhep) {
        this.soNgayNghiPhep = soNgayNghiPhep;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public Staff(int id, int tuoi, String ngayVaoLam, int soNgayNghiPhep, String ten, String boPhanLamViec, double heSoLuong) {
        this.id = id;
        this.tuoi = tuoi;
        this.ngayVaoLam = ngayVaoLam;
        this.soNgayNghiPhep = soNgayNghiPhep;
        this.ten = ten;
        this.boPhanLamViec = boPhanLamViec;
        this.heSoLuong = heSoLuong;
    }
}
