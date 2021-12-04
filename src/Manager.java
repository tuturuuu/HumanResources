import java.util.Scanner;

public class Manager extends Staff implements ICalculator{
    private String chucDanh;
    Scanner sc = new Scanner(System.in);
    public void displayInformation() {
        System.out.println("Ma nhan vien: " + super.getId());
        System.out.println("Ten nhan vien: " + super.getTen());
        System.out.println("Tuoi nhan vien: " + super.getTuoi());
        System.out.println("He so luong: " + super.getHeSoLuong());
        System.out.println("Ngay vao lam: " + super.getNgayVaoLam());
        System.out.println("Bo phan lam viec: " + super.getBoPhanLamViec());
        System.out.println("So ngay nghi phep: " + super.getSoNgayNghiPhep());
        System.out.println("Chuc danh: " + this.chucDanh);
    }

    public Manager(int id, int tuoi, String ngayVaoLam, int soNgayNghiPhep, String ten, String boPhanLamViec, double heSoLuong, String chucDanh) {
        super(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong);
        this.chucDanh = chucDanh;
        checkChucDanh();
    }

    public int calculateSalary(){
        while(true) {
            if (chucDanh.equalsIgnoreCase("Business Leader")) {
                return (int) (super.getHeSoLuong() * 5000000 + 8000000);
            } else if (chucDanh.equalsIgnoreCase("Project Leader")) {
                return (int) (super.getHeSoLuong() * 5000000 + 5000000);
            } else if (chucDanh.equalsIgnoreCase("Technical Leader")) {
                return (int) (super.getHeSoLuong() * 5000000 + 6000000);
            }
        }
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
        checkChucDanh();
    }

    private void checkChucDanh(){
        while(true) {
            if(chucDanh.equalsIgnoreCase("Business Leader")) {
                break;
            } else if (chucDanh.equalsIgnoreCase("Project Leader")) {
                break;
            } else if (chucDanh.equalsIgnoreCase("Technical Leader")) {
                break;
            } else {
                System.out.println("Chuc danh khong co trong he thong");
                System.out.println("Hay nhap lai chuc danh");
                setChucDanh(sc.nextLine());
            }
        }
    }
}
