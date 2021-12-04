import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanResources {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<String> boPhan = new ArrayList<>();
    public static void main(String[] args){
        try {
            int luaChon;
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
                System.out.println("8.Thoat khoi ung dung");
                System.out.println("\nHay chon chuc nang ban muon bang cach nhan so tu 1-8");
                luaChon = sc.nextInt();
                if (luaChon == 1) {
                    System.out.println("Hien thi danh sach nhan vien hien co trong cong ty");
                    hienThiTatCaNhanVien();
                } else if (luaChon == 2) {
                    System.out.println("Hien thi cac bo phan trong cong ty");
                    hienThiCacBoPhan();
                } else if (luaChon == 3) {
                    System.out.println("Hien thi cac nhan vien cong ty theo tung bo phan");
                } else if (luaChon == 4) {
                    System.out.println("Them nhan vien moi vao cong ty");
                    themNhanVien();
                } else if (luaChon == 5) {
                    System.out.println("Tim kiem thong tin nhan vien theo ten hoac ma nhan vien ");
                } else if (luaChon == 6) {
                    System.out.println("Hien thi bang luong cua nhan vien toan cong ty");
                    hienThiBangLuong();
                } else if (luaChon == 7) {
                    System.out.println("Hien thi bang luong the thu tu tang dan");
                    hienThiBangLuongTangDan();
                } else if (luaChon == 8) {
                    break;
                } else {
                    System.out.println("Khong tim duoc chuc nang trong ung dung");
                }
            } while (true);
            }catch(InputMismatchException e){
            System.out.println("Ban da nhap sai kieu du lieu");
            System.out.println("Hay nhap lai");
            themNhanVien();
            }
    }

    //1
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

    //2
    public static void hienThiCacBoPhan(){
        for (String s : boPhan) {
            System.out.println(s);
        }
    }

    //4
    public static void themNhanVien(){
        Scanner sc = new Scanner(System.in);
        String ten,chucVu,ngayVaoLam,boPhanLamViec,chucDanh;
        int tuoi,id,soNgayNghiPhep,gioLamThem;
        double heSoLuong;
        try{
        System.out.println("Ban muon them nhan vien hay quan ly(nhan vien/quan ly)?");
        chucVu = sc.nextLine();
        while(true) {
            if (chucVu.equalsIgnoreCase("nhan vien")) {
                System.out.println("Hay nhap ten? ");
                ten = sc.nextLine();
                System.out.println("Hay nhap tuoi? ");
                tuoi = sc.nextInt();
                System.out.println("Hay nhap ma so nhan vien? ");
                id = sc.nextInt();
                System.out.println("Hay nhap bo phan lam viec?");
                sc.nextLine();
                boPhanLamViec = sc.nextLine();
                if (checkBoPhan(boPhanLamViec)) {
                    boPhan.add(boPhanLamViec);
                }
                System.out.println("Hay nhap ngay vao lam? ");
                ngayVaoLam = sc.nextLine();
                System.out.println("Hay nhap so ngay nghi phep? ");
                soNgayNghiPhep = sc.nextInt();
                System.out.println("Hay nhap he so luong? ");
                heSoLuong = sc.nextDouble();
                System.out.println("Hay nhap gio lam them? ");
                gioLamThem = sc.nextInt();
                employees.add(new Employee(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong, gioLamThem));
                break;
            } else if (chucVu.equalsIgnoreCase("quan ly")) {
                System.out.println("Hay nhap ten? ");
                ten = sc.nextLine();
                System.out.println("Hay nhap tuoi? ");
                tuoi = sc.nextInt();
                System.out.println("Hay nhap ma so nhan vien? ");
                id = sc.nextInt();
                System.out.println("Hay nhap bo phan lam viec?");
                sc.nextLine();
                boPhanLamViec = sc.nextLine();
                if (checkBoPhan(boPhanLamViec)) {
                    boPhan.add(boPhanLamViec);
                }
                System.out.println("Hay nhap ngay vao lam? ");
                ngayVaoLam = sc.nextLine();
                System.out.println("Hay nhap so ngay nghi phep? ");
                soNgayNghiPhep = sc.nextInt();
                System.out.println("Hay nhap he so luong? ");
                heSoLuong = sc.nextDouble();
                System.out.println("Hay nhap chuc danh? ");
                sc.nextLine();
                chucDanh = sc.nextLine();
                while (true) {
                    if (chucDanh.equalsIgnoreCase("Business Leader")) {
                        break;
                    } else if (chucDanh.equalsIgnoreCase("Project Leader")) {
                        break;
                    } else if (chucDanh.equalsIgnoreCase("Technical Leader")) {
                        break;
                    } else {
                        System.out.println("Chuc danh khong co trong he thong");
                        System.out.println("Hay nhap lai chuc danh");
                        chucDanh = sc.nextLine();
                    }
                }
                managers.add(new Manager(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong, chucDanh));
                break;
            }
            else{
                System.out.println("Ban da nhap sai chuc vu, hay nhap lai(nhan vien/quan ly)");
                chucVu = sc.nextLine();
            }
        }
        }catch(InputMismatchException e){
            System.out.println("Ban da nhap sai kieu du lieu");
            System.out.println("Hay nhap lai tu dau");
            themNhanVien();
        }
    }

    //6
    public static void hienThiBangLuong(){
        if(!employees.isEmpty()){
            System.out.println("Thong tin cua nhan vien");
            for(int i = 0; i  < employees.size();i++){
                System.out.println("nhan vien "+(i+1));
                System.out.printf("%d",employees.get(i).calculateSalary());
                System.out.println();
            }
        }
        if(!managers.isEmpty()){
            System.out.println("Thong tin cua quan ly");
            for (int i = 0; i < managers.size(); i++) {
                System.out.println("quan ly " + (i + 1));
                System.out.printf("%d", managers.get(i).calculateSalary());
                System.out.println();
            }
        }
    }

    //7
    public static void hienThiBangLuongTangDan(){
        int temp;
        ArrayList<Integer> luong = new ArrayList<>();
        for (Employee employee : employees) {
            luong.add(employee.calculateSalary());
        }
        for (Manager manager : managers) {
            luong.add(manager.calculateSalary());
        }
        for(int i = 0; i < luong.size(); i++){
            for(int j = i+1; j< luong.size();j++){
                if(luong.get(i)> luong.get(j)){
                    temp = luong.get(i);
                    luong.set(i, luong.get(j));
                    luong.set(j, temp);
                }
            }
        }
        for (Integer integer : luong) {
            System.out.printf("|%d|\n", integer);
        }
    }
    public static boolean checkBoPhan(String boPhanLamViec){
        boolean result =  true;
        for (String s : boPhan) {
            if (boPhanLamViec.equals(s)) {
                result = false;
                break;
            }
        }
        return result;
    }
}

