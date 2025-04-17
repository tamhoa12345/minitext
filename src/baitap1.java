import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class baitap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Material[] danhSach = new Material[10];
        danhSach[0] = new CrispyFlour("VL001", "Bột mì", LocalDate.of(2023, 1, 1), 20000, 5);
        danhSach[1] = new CrispyFlour("VL002", "Bột gạo", LocalDate.of(2023, 2, 1), 15000, 10);
        danhSach[2] = new Meat("VL003", "Thịt heo", LocalDate.of(2023, 3, 1), 80000, 2.5);
        danhSach[3] = new Meat("VL004", "Thịt bò", LocalDate.of(2023, 4, 1), 120000, 3.0);
        danhSach[4] = new CrispyFlour("VL005", "Bột năng", LocalDate.of(2023, 5, 1), 25000, 8);
        danhSach[5] = new Meat("VL006", "Thịt gà", LocalDate.of(2023, 6, 1), 60000, 1.5);
        danhSach[6] = new CrispyFlour("VL007", "Bột bắp", LocalDate.of(2023, 7, 1), 18000, 12);
        danhSach[7] = new Meat("VL008", "Thịt vịt", LocalDate.of(2023, 8, 1), 70000, 2.0);
        danhSach[8] = new CrispyFlour("VL009", "Bột mì đa dụng", LocalDate.of(2023, 9, 1), 22000, 6);
        danhSach[9] = new Meat("VL010", "Thịt cừu", LocalDate.of(2023, 10, 1), 90000, 4.0);


        while (true){
            System.out.println("1.Thêm vật liệu");
            System.out.println("2.Sua vat lieu");
            System.out.println("3.Xoa vat lieu");
            System.out.println("4.tinh triet khau");
            System.out.println("5.tinh so tien cheng lech");
            System.out.println("6.=======in thong tin===========");
            System.out.println("0.thoat");
            System.out.print("vui long chon: ");
            int choice = scanner.nextInt();
            if (choice == 0) break;

            switch (choice) {
                case 1:
                    System.out.println("vui long chon them vao danh sach (1 = bot) hay (2 = thit)");
                    int chon = scanner.nextInt();
                    if (chon == 1) {
                        String maVatLieu;
                        boolean timThay;
                        do {
                            System.out.println("nhap ma van lieu");
                            maVatLieu = scanner.next();
                            timThay = false;
                            for (Material material : danhSach) {
                                if (maVatLieu.equalsIgnoreCase(material.getMaVatLieu())) {
                                    timThay = true;
                                    System.out.println("ma vat lieu da ton tai, vui long nhap lai");
                                    break;
                                }
                            }
                        }while (timThay);
                        System.out.println("nhap ten vat lieu");
                        String tenVatLieu = scanner.next();
                        System.out.println("nhap ngay san xuat");
                        System.out.println("nhap nam");
                        int nam = scanner.nextInt();
                        System.out.println("nhap thang");
                        int thang = scanner.nextInt();
                        System.out.println("nhap ngay");
                        int ngay = scanner.nextInt();
                        LocalDate ngaySanXuat = LocalDate.of(nam, thang, ngay);
                        System.out.println("nhap don gia");
                        int donGia = scanner.nextInt();
                        System.out.println("nhap so luong");
                        int soLuong = scanner.nextInt();
                        CrispyFlour crispyFlour = new CrispyFlour(maVatLieu, tenVatLieu, ngaySanXuat, donGia, soLuong);
                        Material[] danhSach1 = new Material[(danhSach.length) + chon];
                        for (int i = 0; i < danhSach.length; i++) {
                            danhSach1[i] = danhSach[i];
                        }
                        danhSach1[danhSach.length] = crispyFlour;
                        danhSach = danhSach1;
                        for (Material material : danhSach) {
                            System.out.println(material);
                        }



                    }
                    else if (chon == 2) {
                        String maVatLieu;
                        boolean timThay;
                        do {
                            System.out.println("nhap ma van lieu");
                            maVatLieu = scanner.next();
                            timThay = false;
                            for (Material material : danhSach) {
                                if (maVatLieu.equalsIgnoreCase(material.getMaVatLieu())) {
                                    timThay = true;
                                    System.out.println("ma vat lieu da ton tai, vui long nhap lai");
                                    break;
                                }
                            }
                        }while (timThay);
                        System.out.println("nhap ten vat lieu");
                        String tenVatLieu = scanner.next();
                        System.out.println("nhap ngay san xuat");
                        System.out.println("nhap nam");
                        int nam = Integer.parseInt(scanner.next());
                        System.out.println("nhap thang");
                        int thang = Integer.parseInt(scanner.next());
                        System.out.println("nhap ngay");
                        int ngay = Integer.parseInt(scanner.next());
                        LocalDate ngaySanXuat = LocalDate.of(nam, thang, ngay);
                        System.out.println("nhap don gia");
                        int donGia = Integer.parseInt(scanner.next());
                        System.out.println("nhap so KG");
                        double soKG = Double.parseDouble(scanner.next());
                        Meat meat = new Meat(maVatLieu, tenVatLieu, ngaySanXuat, donGia, soKG);
                        Material danhSach1[] = new Material[(danhSach.length) + (chon-1)];
                        for (int i = 0; i < danhSach.length; i++) {
                            danhSach1[i] = danhSach[i];
                        }
                        danhSach1[danhSach.length] = meat;
                        danhSach = danhSach1;
                        for (Material material : danhSach) {
                            System.out.println(material);
                        }

                    }

                    break;
                case 2:
                    System.out.println("nhap ma vat lieu can sua");
                    String maVatLieu = scanner.next();
                    boolean timThay = false;
                    for (Material material : danhSach) {
                        if (maVatLieu.equalsIgnoreCase(material.getMaVatLieu())) {
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("khong tim thay vat lieu");
                        return;
                    }

                    for (Material material : danhSach) {
                        if (maVatLieu.equalsIgnoreCase(material.getMaVatLieu())) {
                               if(material instanceof CrispyFlour) {
                                      CrispyFlour crispyFlour = (CrispyFlour) material;
                                      System.out.println("nhap ten vat lieu");
                                      String tenVatLieu1 = scanner.next();
                                      System.out.println("nhap ngay san xuat");
                                      System.out.println("nhap nam");
                                      int nam = Integer.parseInt(scanner.next());
                                      System.out.println("nhap thang");
                                      int thang = Integer.parseInt(scanner.next());
                                      System.out.println("nhap ngay");
                                      int ngay = Integer.parseInt(scanner.next());
                                      LocalDate ngaySanXuat = LocalDate.of(nam, thang, ngay);
                                      System.out.println("nhap don gia");
                                      int donGia = Integer.parseInt(scanner.next());
                                      System.out.println("nhap so luong");
                                      int soLuong = Integer.parseInt(scanner.next());
                                      System.out.println("===Thay doi thanh cong danh sach vat lieu cu la===");
                                      crispyFlour.setTenVatLieu(tenVatLieu1);
                                      crispyFlour.setNgaySanXuat(ngaySanXuat);
                                      crispyFlour.setDonGia(donGia);
                                      crispyFlour.setSoLuong(soLuong);
                                   System.out.println("===Thay doi thanh cong danh sach vat lieu la===");
                                   for (int i = 0; i < danhSach.length; i++) {
                                       System.out.println(danhSach[i]);
                                   }
                                 }
                                 else if (material instanceof Meat){
                                        Meat meat = (Meat) material;
                                        System.out.println("nhap ten vat lieu");
                                        String tenVatLieu1 = scanner.next();
                                        System.out.println("nhap ngay san xuat");
                                        System.out.println("nhap nam");
                                        int nam = Integer.parseInt(scanner.next());
                                        System.out.println("nhap thang");
                                        int thang = Integer.parseInt(scanner.next());
                                        System.out.println("nhap ngay");
                                        int ngay = Integer.parseInt(scanner.next());
                                        LocalDate ngaySanXuat = LocalDate.of(nam, thang, ngay);
                                        System.out.println("nhap don gia");
                                        int donGia = Integer.parseInt(scanner.next());
                                        System.out.println("nhap so KG");
                                        double soKg = Double.parseDouble(scanner.next());
                                        meat.setTenVatLieu(tenVatLieu1);
                                        meat.setNgaySanXuat(ngaySanXuat);
                                        meat.setDonGia(donGia);
                                        meat.setSoKg(soKg);
                                   System.out.println("===Thay doi thanh cong danh sach vat lieu la===");
                                   for (int i = 0; i < danhSach.length; i++) {
                                       System.out.println(danhSach[i]);
                                   }
                               }

                        }
                    }
                    break;
                case 3:
                    System.out.println("nhap ma vat lieu muon xoa");
                    String maVatLieu1 = scanner.next();
                    boolean timThay1 = false;
                    for (Material material : danhSach) {
                        if (maVatLieu1.equalsIgnoreCase(material.getMaVatLieu())) {
                            timThay1 = true;
                            break;
                        }
                    }
                    if (!timThay1) {
                        System.out.println("khong tim thay vat lieu");
                        return;
                    }
                    System.out.println("Ban co that su muon xoa khong? (y/n)");
                    String xoa = scanner.next();
                    if (xoa.equalsIgnoreCase("y")) {
                        Material [] danhSach1 = new Material[danhSach.length-1];
                        for (int i = 0; i < danhSach.length-1; i++) {
                            if(danhSach[i].getMaVatLieu().equalsIgnoreCase(maVatLieu1)) {
                              Material temp = danhSach[i];
                                danhSach[i] = danhSach[i+1];
                                danhSach[i+1] = temp;
                            }
                            danhSach1[i] = danhSach[i];
                        }
                        System.out.println("===da xoa thanh cong vat lieu co ma: " + maVatLieu1 + "===");
                        for (int i = 0; i < danhSach1.length; i++) {
                            System.out.println(danhSach1[i]);
                        }
                        danhSach = danhSach1;


                    }

                    break;
                case 4:
                    String maVatLieu2;
                    boolean timThay2;
                    do {
                        System.out.println("nhap ma vat lieu muon tinh triet khau");
                        maVatLieu2 = scanner.next();
                        timThay2 = true;
                        for (Material material : danhSach) {
                            if (maVatLieu2.equalsIgnoreCase(material.getMaVatLieu())) {
                                timThay2 = false;
                                break;
                            }
                        }
                    }while (timThay2);

                    for (Material material : danhSach) {
                        if (maVatLieu2.equalsIgnoreCase(material.getMaVatLieu())) {
                            if (material instanceof CrispyFlour) {
                                CrispyFlour crispyFlour = (CrispyFlour) material;
                                crispyFlour.soTienSauKhiGiam(crispyFlour.tinhTongThanhTien());
                                System.out.println(material);
                                System.out.println("gia sau khi giam CrispyFlour  " + crispyFlour.soTienSauKhiGiam(crispyFlour.tinhTongThanhTien()));
                            } else if (material instanceof Meat) {
                                Meat meat = (Meat) material;
                                meat.soTienSauKhiGiam(meat.tinhTongThanhTien());
                                System.out.println(material);
                                System.out.println("gia sau khi giam Meat  " + meat.soTienSauKhiGiam(meat.tinhTongThanhTien()));
                            }
                        }
                    }

                    break;
                case 5:
                    System.out.println("tong tien sau khi giam cua (1,meat) (2,crispyFlour)");
                    int chon2 = scanner.nextInt();
                    if (chon2 == 1) {
                        for(Material material : danhSach) {
                            if (material instanceof Meat) {
                                Meat meat = (Meat) material;
                                System.out.println(meat);
                                System.out.println("tong tien truoc khi giam la: " + meat.tinhTongThanhTien());
                                System.out.println("tong tien sau khi giam Meat  " + meat.soTienSauKhiGiam(meat.tinhTongThanhTien()));


                            }
                        }
                    }
                    else if (chon2 == 2) {
                        for (Material material : danhSach) {
                            if (material instanceof CrispyFlour) {
                                CrispyFlour crispyFlour = (CrispyFlour) material;
                                System.out.println(crispyFlour);
                                System.out.println("tong tien truoc khi giam la: " + crispyFlour.tinhTongThanhTien());
                                System.out.println("tong tien sau khi giam CrispyFlour  " + crispyFlour.soTienSauKhiGiam(crispyFlour.tinhTongThanhTien()));
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("thoat");
                    break;
                    default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
                    break;
            }




        }




    }
}

abstract class Material{
    private String maVatLieu;
    private String tenVatLieu;
    private LocalDate ngaySanXuat;
    private int donGia;
    Material(String maVatLieu, String tenVatLieu,LocalDate ngaySanXuat, int donGia) {
        this.maVatLieu = maVatLieu;
        this.tenVatLieu = tenVatLieu;
        this.ngaySanXuat = ngaySanXuat;
        this.donGia = donGia;
    }
    public String getMaVatLieu() {
        return maVatLieu;
    }
    public void setMaVatLieu(String maVatLieu) {
        this.maVatLieu = maVatLieu;
    }
    public String getTenVatLieu() {
        return tenVatLieu;
    }
    public void setTenVatLieu(String tenVatLieu) {
        this.tenVatLieu = tenVatLieu;
    }
    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }
    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        this.ngaySanXuat = ngaySanXuat;
    }
    public int getDonGia() {
        return donGia;
    }
    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }
    public abstract double tinhTongThanhTien();
    public abstract LocalDate hanSuDung();

    public String toString(){
        return "ma vat lieu " + getMaVatLieu()
                + ", ten vat lieu " + getTenVatLieu()
                + ", ngay san xuat " + getNgaySanXuat()
                + ", don gia " + getDonGia()
                + ", tong thanh tien " + tinhTongThanhTien()
                + ", han su dung " + hanSuDung();

    }


}
class CrispyFlour extends Material implements trietKhau {
    private int soLuong;

    CrispyFlour(String maVatLieu, String tenVatLieu, LocalDate ngaySanXuat, int donGia, int soLuong) {
        super(maVatLieu, tenVatLieu, ngaySanXuat, donGia);
        this.soLuong = soLuong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    @Override
    public double tinhTongThanhTien() {
        return getDonGia() * soLuong;
    }

    @Override
    public LocalDate hanSuDung() {
        return getNgaySanXuat().plusYears(1);
    }
    @Override
    public double soTienSauKhiGiam(double sotien) {
        LocalDate today = LocalDate.now();
        LocalDate hanSuDung = hanSuDung();
        long mon = ChronoUnit.DAYS.between(today, hanSuDung);
        if (mon <= 2) {
            return tinhTongThanhTien() * 0.6;
        } else if (mon <= 4) {
           return tinhTongThanhTien() * 0.8;
        } else {
            return tinhTongThanhTien() * 0.95;
        }


    }

    @Override
    public String toString() {
        return super.toString() +
                ", so luong " + getSoLuong()+
                ", tong thanh tien " + tinhTongThanhTien();
    }
}

class Meat extends Material implements trietKhau{
    private double soKg;
    Meat(String maVatLieu, String tenVatLieu, LocalDate ngaySanXuat, int donGia, double soKg) {
        super(maVatLieu, tenVatLieu, ngaySanXuat, donGia);
        this.soKg = soKg;
    }
    public double getSoKg() {
        return soKg;
    }
    public void setSoKg(double soKg) {
        this.soKg = soKg;
    }
    @Override
    public double tinhTongThanhTien() {
        return getDonGia() * soKg;
    }
    @Override
    public LocalDate hanSuDung() {
        return getNgaySanXuat().plusDays(7);
    }

    @Override
    public double soTienSauKhiGiam(double soTien) {
        LocalDate today = LocalDate.now();
        LocalDate hanSuDung = hanSuDung();
        long days = ChronoUnit.DAYS.between(today, hanSuDung);

        if (days <= 5) {
            return soTien * 0.7;
        } else {
            return soTien * 0.9;
        }

    }
    @Override
    public String toString() {
        return super.toString() +
                ", so kg " + getSoKg() +
                ", tong thanh tien " + tinhTongThanhTien()+
                ",tien sau giam " + soTienSauKhiGiam(tinhTongThanhTien());
    }


}
  interface trietKhau {
    double soTienSauKhiGiam (double soTien);
        }
