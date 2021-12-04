public class Employee extends Staff implements ICalculator{
    private int gioLamThem;

    public int getGioLamThem() {
        return gioLamThem;
    }

    public Employee(int id, int tuoi, String ngayVaoLam, int soNgayNghiPhep, String ten, String boPhanLamViec, double heSoLuong, int gioLamThem) {
        super(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong);
        this.gioLamThem = gioLamThem;
    }

    public int calculateSalary(){
        return (int) (super.getHeSoLuong()*3000000+this.gioLamThem*200000);
    }

    public void displayInformation(){
        System.out.println("Ma nhan vien: "+super.getId());
        System.out.println("Ten nhan vien: "+super.getTen());
        System.out.println("Tuoi nhan vien: "+super.getTuoi());
        System.out.println("He so luong: "+super.getHeSoLuong());
        System.out.println("Ngay vao lam: "+ super.getNgayVaoLam());
        System.out.println("Bo phan lam viec: "+super.getBoPhanLamViec());
        System.out.println("So ngay nghi phep: "+super.getSoNgayNghiPhep());
        System.out.println("So gio lam them: "+this.gioLamThem);
    }
}
