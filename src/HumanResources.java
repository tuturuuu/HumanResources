import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HumanResources {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static void main(String[] args){
        int luaChon;
        String end;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Cac chuc nang co ban cua ung dung");
            System.out.println("1.Hien thi danh sach nhan vien hien co trong cong ty");
            System.out.println("2.Hien thi cac bo phan trong cong ty");
            System.out.println("3.Hien thi cac nhan vien cong ty theo tung bo phan");
            System.out.println("4.Them nhan vien moi vao cong ty");
            System.out.println("5.Tim kiem thong tin nhan vien theo ten hoac ma nhan vien ");
            System.out.println("6.Hien thi bang luong cua nhan vien toan cong ty");
            System.out.println("7.Hien thi bang luong the thu tu tang dan");
            System.out.println("\nHay chon chuc nang ban muon bang cach nhan so tu 1-8");
            luaChon = sc.nextInt();
            if(luaChon==1){
                System.out.println("Hien thi danh sach nhan vien hien co trong cong ty");
                hienThiTatCaNhanVien();
            }
            else if(luaChon==2){
                System.out.println("Hien thi cac bo phan trong cong ty");
            }
            else if(luaChon==3){
                System.out.println("Hien thi cac nhan vien cong ty theo tung bo phan");
            }
            else if(luaChon==4){
                System.out.println("Them nhan vien moi vao cong ty");
                themNhanVien();
            }
            else if(luaChon==5){
                System.out.println("Tim kiem thong tin nhan vien theo ten hoac ma nhan vien ");
            }
            else if(luaChon==6){
                System.out.println("Hien thi bang luong cua nhan vien toan cong ty");
                hienThiBangLuong();
            }
            else if(luaChon==7){
                System.out.println("Hien thi bang luong the thu tu tang dan");
            }
            else {
                System.out.println("Khong tim duoc chuc nang trong ung dung");
            }
            sc.nextLine();
            while(true) {
                System.out.println("Ban co muon tiep tuc chuong trinh?(co/khong)");
                end = sc.nextLine();
                if(end.equalsIgnoreCase("co")) {
                    System.out.println("Chuong trinh duoc tiep tuc");
                    break;
                }
                else if(end.equalsIgnoreCase("khong")){
                    System.out.println("Thoat chuong trinh");
                    break;
                }
                else{
                    System.out.println("Ban da nhap sai, hay nhap lai co/khong");
                }
            }
        }while(end.equalsIgnoreCase("co"));
    }

    public static void themNhanVien(){
        Scanner sc = new Scanner(System.in);
        String chucVu;
        System.out.println("Ban muon them nhan vien hay quan ly(nhan vien/quan ly)?");
        chucVu = sc.nextLine();
        if(chucVu.equalsIgnoreCase("nhan vien")){
            System.out.println("Hay nhap ten? ");
            String ten = sc.nextLine();
            System.out.println("Hay nhap tuoi? ");
            int tuoi = sc.nextInt();
            System.out.println("Hay nhap ma so nhan vien? ");
            int id = sc.nextInt();
            System.out.println("Hay nhap bo phan lam viec?");
            sc.nextLine();
            String boPhanLamViec = sc.nextLine();
            System.out.println("Hay nhap ngay vao lam? ");
            String ngayVaoLam = sc.nextLine();
            System.out.println("Hay nhap so ngay nghi phep? ");
            int soNgayNghiPhep = sc.nextInt();
            System.out.println("Hay nhap he so luong? ");
            int heSoLuong = sc.nextInt();
            System.out.println("Hay nhap gio lam them? ");
            int gioLamThem = sc.nextInt();
            employees.add(new Employee(id,tuoi,ngayVaoLam,soNgayNghiPhep,ten,boPhanLamViec, heSoLuong, gioLamThem));
        }
        else if(chucVu.equalsIgnoreCase("quan ly")){
            System.out.println("Hay nhap ten? ");
            String ten = sc.nextLine();
            System.out.println("Hay nhap tuoi? ");
            int tuoi = sc.nextInt();
            System.out.println("Hay nhap ma so nhan vien? ");
            int id = sc.nextInt();
            System.out.println("Hay nhap bo phan lam viec?");
            sc.nextLine();
            String boPhanLamViec = sc.nextLine();
            System.out.println("Hay nhap ngay vao lam? ");
            String ngayVaoLam = sc.nextLine();
            System.out.println("Hay nhap so ngay nghi phep? ");
            int soNgayNghiPhep = sc.nextInt();
            System.out.println("Hay nhap he so luong? ");
            int heSoLuong = sc.nextInt();
            System.out.println("Hay nhap chuc danh? ");
            sc.nextLine();
            String chucDanh = sc.nextLine();
            managers.add(new Manager(id,tuoi,ngayVaoLam,soNgayNghiPhep,ten,boPhanLamViec, heSoLuong, chucDanh));
        }
    }
    public static void hienThiTatCaNhanVien(){
        System.out.println("Thong tin cua nhan vien");
        for(int i = 0; i < employees.size();i++){
            System.out.println("Nhan vien "+(i+1));
            employees.get(i).displayInformation();
            System.out.println();
        }
        System.out.println("Thong tin cua quan ly");
        for (int i = 0; i< managers.size();i++){
            System.out.println("Quan ly "+(i+1));
            managers.get(i).displayInformation();
            System.out.println();
        }
    }
    public static void hienThiBangLuong(){
        for(int i = 0; i < employees.size();i++){
            System.out.println("nhan vien "+(i+1));
            System.out.printf("%d",employees.get(i).calculateSalary());
            System.out.println();
        }
        System.out.println("Thong tin cua quan ly");
        for (int i = 0; i< managers.size();i++){
            System.out.println("quan ly "+(i+1));
            System.out.printf("%d",managers.get(i).calculateSalary());
            System.out.println();
        }
    }
    public static void hienThiBangLuongTangDan(){
        ArrayList<Integer> luong = new ArrayList<Integer>();
        for(int i = 0;i<employees.size();i++){
            luong.add((int)employees.get(i).calculateSalary());
        }
        for(int i = employees.size();i< employees.size()+ managers.size();i++){
            luong.add((int)managers.get(i).calculateSalary());
        }


    }
}

