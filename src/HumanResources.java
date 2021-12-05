import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanResources {
    //Khai bao cac mang cuc bo
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Manager> managers = new ArrayList<>();
    public static ArrayList<String> boPhan = new ArrayList<>();
    public static ArrayList<Integer> idNhanVien = new ArrayList<>();
    public static void main(String[] args){
        try {
            int luaChon;
            Scanner sc = new Scanner(System.in);
            do {
                //Dua ra nhung lua chon cho chuong trinh
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

                //Chay 1 trong nhung lua chon day bang cach kiem tra bien luaChon
                if (luaChon == 1) {
                    System.out.println("Hien thi danh sach nhan vien hien co trong cong ty");
                    hienThiTatCaNhanVien();
                } else if (luaChon == 2) {
                    System.out.println("Hien thi cac bo phan trong cong ty");
                    hienThiCacBoPhan();
                } else if (luaChon == 3) {
                    System.out.println("Hien thi cac nhan vien cong ty theo tung bo phan");
                    nhanVienTheoBoPhan();
                } else if (luaChon == 4) {
                    System.out.println("Them nhan vien moi vao cong ty");
                    themNhanVien();
                } else if (luaChon == 5) {
                    System.out.println("Tim kiem thong tin nhan vien theo ten hoac ma nhan vien ");
                    timkiemNhanVien();
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
                //Vong lap se khong dung lai den khi luaChon ==8
            } while (true);
            }
            //Neu nguoi dung nhap sai kieu du lieu -> chuong trinh se yeu cau nhap lai
            catch(InputMismatchException e){
            System.out.println("Ban da nhap sai kieu du lieu");
            System.out.println("Hay nhap lai");
            main(args);
            }
    }

    //1 Hien thi thong tin cua tat ca nhan vien
    public static void hienThiTatCaNhanVien(){
        //Vong lap di qua 2 mang employees va managers va hien thi tung nhan vien cua mang
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

    //2 Hien thi cac bo phan
    public static void hienThiCacBoPhan(){
        //Di qua tung phan mang boPhan va hien thi tung phan tu
        for (String s : boPhan) {
            System.out.println(s);
        }
    }

    //3 Hien thi tung nhan vien theo tung bo phan
    public static void nhanVienTheoBoPhan(){
        //Vong lap di qua tung phan tu cua boPhan
        for (String s : boPhan) {
            System.out.println("Nhung nhan vien co trong bo phan " + s );
            //Vong lap di qua tung phan tu cua nhanVien
            for (Employee employee : employees) {
                //Neu phan tu co bo phan giong voi phan tu trong mang -> hien thi phan tu
                if (s.equals(employee.getBoPhanLamViec()))
                    employee.displayInformation();
                System.out.println();
            }
            //Tuong tu doi voi quan ly
            System.out.println("Nhung quan ly co trong bo phan " + s );
            for (Manager manager : managers) {
                if (s.equals(manager.getBoPhanLamViec()))
                    manager.displayInformation();
                System.out.println();
            }
        }

    }
    //4 Them nhan vien moi vao cong ty
    public static void themNhanVien(){
        Scanner sc = new Scanner(System.in);
        String ten,chucVu,ngayVaoLam,boPhanLamViec,chucDanh;
        int tuoi,id,soNgayNghiPhep,gioLamThem;
        double heSoLuong;
        try{
        System.out.println("Ban muon them nhan vien hay quan ly(nhan vien/quan ly)?");
        chucVu = sc.nextLine();
        //Neu chucVu khac nhan vien/quan ly -> vong lap se yeu cau nguoi dung nhap lai
        while(true) {
            //Neu chucVu la nhan vien thi se co bien gio lam them, neu chucVu la quan ly thi se co bien chucDanh
            if (chucVu.equalsIgnoreCase("nhan vien")) {
                System.out.println("Hay nhap ten? ");
                ten = sc.nextLine();
                System.out.println("Hay nhap tuoi? ");
                tuoi = sc.nextInt();
                System.out.println("Hay nhap ma so nhan vien? ");
                id = sc.nextInt();
                //Vong lap se dung khi nguoi dung nhap id chua co trong bo nho
                while(!checkId(id)){
                    //Neu id da co trong bo nho -> nhap lai
                        System.out.println("Ma nhan vien da co trong bo nho");
                        System.out.println("Hay nhap lai");
                        id = sc.nextInt();
                }
                //Them id vao mang idNhanVien
                idNhanVien.add(id);
                System.out.println("Hay nhap bo phan lam viec?");
                sc.nextLine();
                boPhanLamViec = sc.nextLine();
                //Neu bo phan chua co trong mang boPhanLamViec -> luu vao mang
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
                //Add 1 phan tu moi vao mang bang construcor
                employees.add(new Employee(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong, gioLamThem));
                break;
            } else if (chucVu.equalsIgnoreCase("quan ly")) {
                System.out.println("Hay nhap ten? ");
                ten = sc.nextLine();
                System.out.println("Hay nhap tuoi? ");
                tuoi = sc.nextInt();
                System.out.println("Hay nhap ma so nhan vien? ");
                id = sc.nextInt();
                //Vong lap se dung khi nguoi dung nhap id chua co trong bo nho
                while(!checkId(id)){
                    //Neu id da co trong bo nho -> nhap lai
                    System.out.println("Ma nhan vien da co trong bo nho");
                    System.out.println("Hay nhap lai");
                    id = sc.nextInt();
                }
                //Them id vao mang idNhanVien
                idNhanVien.add(id);
                System.out.println("Hay nhap bo phan lam viec?");
                sc.nextLine();
                boPhanLamViec = sc.nextLine();
                //Neu bo phan chua co trong mang boPhanLamViec -> luu vao mang
                if (checkBoPhan(boPhanLamViec)) {
                    boPhan.add(boPhanLamViec);
                }
                System.out.println("Hay nhap ngay vao lam? ");
                ngayVaoLam = sc.nextLine();
                System.out.println("Hay nhap so ngay nghi phep? ");
                soNgayNghiPhep = sc.nextInt();
                System.out.println("Hay nhap he so luong? ");
                heSoLuong = sc.nextDouble();
                System.out.println("Hay nhap chuc danh?(Business Leader/Project Leader/Technical Leader)");
                sc.nextLine();
                chucDanh = sc.nextLine();
                //Neu chuc danh khong co trong cong ty ->yeu cau nguoi dung nhap lai
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
                //Add 1 phan tu moi vao mang bang constructor
                managers.add(new Manager(id, tuoi, ngayVaoLam, soNgayNghiPhep, ten, boPhanLamViec, heSoLuong, chucDanh));
                break;
            }
            else{
                //Yeu cau nguoi dung nhap lai bien chucVu
                System.out.println("Ban da nhap sai chuc vu, hay nhap lai(nhan vien/quan ly)");
                chucVu = sc.nextLine();
            }
        }
        }
        //Neu nguoi dung nhap sai kieu du lieu -> yeu cau nguoi dung nhap lai thong tin nhan vien
        catch(InputMismatchException e){
            System.out.println("Ban da nhap sai kieu du lieu");
            System.out.println("Hay nhap lai tu dau");
            themNhanVien();
        }
    }

    //5 Tim kiem nhan vien theo ten hoac id
    public static void timkiemNhanVien(){
        Scanner sc = new Scanner(System.in);
        int id;
        String ten;
        System.out.println("Ban muon tim thong tin nhan vien theo ten hay ma nhan vien(ten/ma nhan vien)");
        String luaChon = sc.nextLine();
        //Neu luaChon khong bang ten/ma nhan vien -> vong lap se yeu cau nguoi dung nhap lai
        while(true) {
            if (luaChon.equalsIgnoreCase("ten")) {
                System.out.println("Hay nhap ten nhan vien: ");
                ten = sc.nextLine();
                System.out.println("Nhung nhan vien co ten " + ten);
                //Dung vong lap di qua tung phan tu-> neu nhan vien nao co ten = voi bien ten -> hien thi phan tu
                for (Employee employee : employees) {
                    if (ten.equalsIgnoreCase(employee.getTen()))
                        employee.displayInformation();
                }
                //Dung vong lap di qua tung phan tu-> neu nhan vien nao co ten = voi bien ten -> hien thi phan tu
                for (Manager manager : managers) {
                    if (ten.equalsIgnoreCase(manager.getTen()))
                        manager.displayInformation();
                }
                break;
            } else if (luaChon.equalsIgnoreCase("ma nhan vien")) {
                System.out.println("Hay nhap ma nhan vien: ");
                id = sc.nextInt();
                //Dung vong lap di qua tung phan tu-> neu nhan vien nao co id = voi bien id -> hien thi phan tu
                for (Employee employee : employees) {
                    if (id == employee.getId())
                        employee.displayInformation();
                }
                //Dung vong lap di qua tung phan tu-> neu nhan vien nao co id = voi bien id -> hien thi phan tu
                for (Manager manager : managers) {
                    if (id == manager.getId())
                        manager.displayInformation();
                }
                break;
            }else {
                //Neu nguoi dung nhap sai bien luaChon -> yeu cau nguoi dung nhap lai
                System.out.println("Ban da nhap sai");
                System.out.println("Hay nha lai(ten/ma nhan vien)");
                luaChon = sc.nextLine();
            }
        }
    }
    //6 Hien thi bang luong cua nhan vien toan cong ty
    public static void hienThiBangLuong(){
        //Neu mang employees khac rong
        if(!employees.isEmpty()){
            System.out.println("Thong tin cua nhan vien");
            //Di qua tung phan tu va hien thi luong cua tung nhan vien
            for (Employee employee : employees) {
                System.out.println("Id nhan vien: " + employee.getId());
                System.out.printf("%d", employee.calculateSalary());
                System.out.println();
            }
        }
        //Neu mang employees khac rong
        if(!managers.isEmpty()){
            System.out.println("Thong tin cua quan ly");
            //Di qua tung phan tu va hien thi luong cua tung nhan vien
            for (Manager manager : managers) {
                System.out.println("Id nhan vien: " + manager.getId());
                System.out.printf("%d", manager.calculateSalary());
                System.out.println();
            }
        }
    }

    //7 Hien thi bang luong theo thu tu tang dan
    public static void hienThiBangLuongTangDan(){
        int temp;
        ArrayList<Integer> luong = new ArrayList<>();
        //Luu luong cua tat ca nhan vien vao 1 mang ArrayList luong
        for (Employee employee : employees) {
            luong.add(employee.calculateSalary());
        }
        for (Manager manager : managers) {
            luong.add(manager.calculateSalary());
        }
        //Sap xep mang luong theo thu tu tang dan
        for(int i = 0; i < luong.size(); i++){
            for(int j = i+1; j< luong.size();j++){
                if(luong.get(i)> luong.get(j)){
                    temp = luong.get(i);
                    luong.set(i, luong.get(j));
                    luong.set(j, temp);
                }
            }
        }
        //Dung vong lap de di qua tung phan tu cua mang
        for (Integer integer : luong) {
            System.out.printf("|%d|\n", integer);
        }
    }
    //Kiem tra xem bo phan co trong bo nho hay chua
    public static boolean checkBoPhan(String boPhanLamViec){
        boolean result =  true;
        //Di qua tung phan tu cua mang boPhan -> neu bo phan co trong mang ->result = false
        for (String s : boPhan) {
            if (boPhanLamViec.equals(s)) {
                result = false;
                break;
            }
        }
        return result;
    }
    //Kiem tra xem id co trong bo nho hay chua
    public static boolean checkId(int maNhanVien){
        boolean result = true;
        //Di qua tung phan tu cua mang idNhanVien -> neu id co trong mang ->result = false
        for (Integer integer : idNhanVien) {
            if (maNhanVien == integer) {
                result = false;
                break;
            }
        }
        return result;
    }
}

