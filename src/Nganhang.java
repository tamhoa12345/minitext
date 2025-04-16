import java.util.*;


public class Nganhang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       ArrayList<TaiKhoanThuong> danhSach = new ArrayList<>();

       while (true) {
              System.out.println("1.Them tai khoan moi ");
              System.out.println("2.Xem danh sach tai khoan");
              System.out.println("3.Tim kiem tai khoan theo ten");
              System.out.println("4.nap tien");
              System.out.println("5.rut tien");
              System.out.println("6.Chuyen tien giua 2 tai khoan ");
              System.out.println("7.xoa tai khoan theo ten");
              System.out.println("8.Sap xep tai khoan theo so du giam dan");
              System.out.println("9.xap xep theo ten tu A-Z");
              System.out.println("10.in tong so tai khoan vs tong so du");
              System.out.println("11.tinh lai suat");
              System.out.println("0.thoat");
              System.out.println("nhap lua chon nhan 0 the thoat: ");
              int luaChon = Integer.parseInt(scanner.nextLine());
              if (luaChon == 0) break;
              switch(luaChon){
                  case 1:
                       System.out.println("nhap ten khach hang: ");
                       String ten = scanner.nextLine();

                       System.out.println("nhap so tai khoan: ");
                       int soTaiKhoan = Integer.parseInt(scanner.nextLine());
                       for (TaiKhoanThuong t : danhSach) {
                           if(t.getSoTaiKhoan() == soTaiKhoan){
                               while (t.getSoTaiKhoan() == soTaiKhoan){
                                      System.out.println("So tai khoan da ton tai, vui long nhap lai: ");
                                      soTaiKhoan = Integer.parseInt(scanner.nextLine());
                               }
                           }
                       }

                       System.out.println("nhap so du: ");
                       double soDu = Double.parseDouble(scanner.nextLine());
                       TaiKhoanThuong tk = new TaiKhoanThuong(ten, soTaiKhoan, soDu);
                       if (tk.getSoDu() >= 50000) {
                           danhSach.add(tk);
                       }
                      break;
                  case 2:
                      System.out.println("==== Danh sach tai khoan ====");
                        for (TaiKhoanThuong tkt : danhSach) {
                            tkt.inThongTin();
                        }
                      break;
                  case 3:
                        System.out.println("nhap ten khach hang can tim: ");
                        String tenCanTim = scanner.nextLine();

                        boolean timThay = false;
                        for (TaiKhoanThuong tkt : danhSach) {
                            if (tkt.getTen().equalsIgnoreCase(tenCanTim)) {
                                System.out.println("Da tim thay tai khoan: ");
                                tkt.inThongTin();
                                timThay = true;
                                break;
                            }
                        }
                        if (!timThay) {
                            System.out.println("Khong tim thay tai khoan: " + tenCanTim);
                        }
                      break;
                  case 4:
                        System.out.println("nhap ten khach hang can nap tien: ");
                        String tenCanNap = scanner.nextLine();
                        boolean timThay2 = false;
                        for (TaiKhoanThuong tkt : danhSach) {
                            if (tkt.getTen().equalsIgnoreCase(tenCanNap)) {
                                System.out.println("nhap so tien can nap: ");
                                double soTienNap = Double.parseDouble(scanner.nextLine());
                                tkt.napTien(soTienNap);
                                tkt.inThongTin();
                                timThay2 = true;
                                break;
                            }
                        }
                        if (!timThay2) {
                            System.out.println("Khong tim thay tai khoan: " + tenCanNap);
                        }
                      break;
                  case 5:
                        System.out.println("nhap ten khach hang can rut tien: ");
                        String tenCanRut = scanner.nextLine();
                        boolean timThay3 = false;
                        for (TaiKhoanThuong tkt : danhSach) {
                            if (tkt.getTen().equalsIgnoreCase(tenCanRut)) {
                                System.out.println("nhap so tien can rut: ");
                                double soTienRut = Double.parseDouble(scanner.nextLine());
                                tkt.rutTien(soTienRut);
                                tkt.inThongTin();
                                timThay3 = true;
                                break;
                            }
                        }
                        if (!timThay3) {
                            System.out.println("Khong tim thay tai khoan: " + tenCanRut);
                        }
                      break;
                  case 6:
                      System.out.println("nhap ten nguoi chuyen: ");
                      String tenTaiKhoanChuyen = scanner.nextLine();
                      System.out.println("nhap ten nguoi nhan : ");
                      String tenTaiKhoanNhan = scanner.nextLine();
                      boolean nguoiChuyen = false;
                      boolean nguoiNhan = false;

                      for (TaiKhoanThuong tkt : danhSach) {
                          if (tkt.getTen().equalsIgnoreCase(tenTaiKhoanChuyen)) {
                              nguoiChuyen = true;
                          }
                          if (tkt.getTen().equalsIgnoreCase(tenTaiKhoanNhan)) {
                              nguoiNhan = true;
                          }

                      }
                      if (!nguoiChuyen) {
                          System.out.println("Khong tim thay tai khoan nguoi chuyen: " + tenTaiKhoanChuyen);
                          break;
                      }
                      if (!nguoiNhan) {
                            System.out.println("Khong tim thay tai khoan nguoi nhan: " + tenTaiKhoanNhan);
                            break;
                      }
                      if(nguoiChuyen && nguoiNhan) {
                          System.out.println("nhap so tien can chuyen:");
                          double soTienChuyen = Double.parseDouble(scanner.nextLine());
                          for (TaiKhoanThuong tkt : danhSach) {
                              if (tkt.getTen().equalsIgnoreCase(tenTaiKhoanChuyen)) {
                                  if (soTienChuyen > 0 && soTienChuyen <= (tkt.getSoDu() - 50000)) {
                                      tkt.chuyenTien(soTienChuyen);
                                      for(TaiKhoanThuong tkt2 : danhSach) {
                                          if (tkt2.getTen().equalsIgnoreCase(tenTaiKhoanNhan)) {
                                                tkt2.nhanTienChuyen(soTienChuyen);
                                                tkt2.inThongTin();
                                                break;
                                          }
                                      }
                                  } else {
                                      System.out.println("so tien chuyen khong hop le hoac vuot qua so du mac dinh la 50.000");
                                  }
                              }

                          }
                      }
                      break;
                  case 7:
                        System.out.println("nhap ten khach hang can xoa: ");
                        String tenCanXoa = scanner.nextLine();
                        boolean timThay4 = false;
                        for (TaiKhoanThuong tkt : danhSach) {
                            if(tkt.getTen().equalsIgnoreCase(tenCanXoa)) {
                                System.out.println("ban co chac chan muon xoa tai khoan: " + tenCanXoa + " khong? (y/n)");
                                String xacNhan = scanner.nextLine();
                                if(xacNhan.equalsIgnoreCase("y")) {
                                    danhSach.remove(tkt);
                                    System.out.println("Da xoa tai khoan: " + tenCanXoa);
                                    timThay4 = true;
                                    break;
                                }
                                else{
                                    System.out.println("Khong xoa tai khoan: " + tenCanXoa);
                                    timThay4 = true;
                                    break;
                                }
                            }
                        }
                        if (!timThay4) {
                            System.out.println("Khong tim thay tai khoan: " + tenCanXoa);
                        }
                      break;
                  case 8:
                      Collections.sort(danhSach, new SoDuGiamDanComparator());
                      System.out.println("Sap xep tai khoan theo so du giam dan: ");
                        for (TaiKhoanThuong tkt : danhSach) {
                            tkt.inThongTin();
                        }
                      break;
                  case 9:
                      Collections.sort(danhSach, new Comparator<TaiKhoanThuong>() {
                          @Override
                          public int compare(TaiKhoanThuong a1, TaiKhoanThuong a2){
                              return a1.getTen().compareToIgnoreCase(a2.getTen());
                          }
                      });
                        System.out.println("Sap xep tai khoan theo ten A-Z: ");
                        for (TaiKhoanThuong tkt : danhSach) {
                            tkt.inThongTin();
                        }
                      break;
                  case 10:
                      System.out.println("tong so tai khoan la: " + TaiKhoanThuong.TongSoTaiKhoan());
                      System.out.println("tong so du la: " + TaiKhoanThuong.TongSoDu());
                      break;
                  case 11:
                     System.out.println("nhap ten khach hang can gui tiet kiem: ");
                     String tenGuiTietKiem = scanner.nextLine();
                     boolean timThay5 = false;
                     for(int i = 0; i < danhSach.size(); i++) {
                         TaiKhoanThuong tkt = danhSach.get(i);
                         if(tkt.getTen().equalsIgnoreCase(tenGuiTietKiem)) {
                             System.out.println("nhap so tien gui tiet kiem: ");
                             double tienTietKiem = Double.parseDouble(scanner.nextLine());
                             System.out.println("nhap thang gui: ");
                             int thang = Integer.parseInt(scanner.nextLine());
                                GuiTietKiem GTK = new GuiTietKiem(
                                        tkt.getTen(),
                                        tkt.getSoTaiKhoan(),
                                        tkt.getSoDu(),
                                        tienTietKiem,
                                        thang

                                );
                             danhSach.set(i, GTK);
                             GTK.inThongTin();
                             timThay5 = true;
                             break;


                         }
                     }
                     if(!timThay5) {
                            System.out.println("Khong tim thay tai khoan: " + tenGuiTietKiem);
                     }

                      break;

                  case 0:
                      System.out.println("Thoat");
                      return;
                  default:
                      System.out.println("Lua chon khong hop le");



              }
       }


    }
}

class TaiKhoanThuong{
    private String ten;
    private int soTaiKhoan;
    private double soDu;



    private static int TongSoTaiKhoan = 0;
    private static double TongSoDu = 0;

    TaiKhoanThuong(String ten, int soTaiKhoan, double soDu) {
        this.ten = ten;
        this.soTaiKhoan = soTaiKhoan;
        setSoDu(soDu);

        TongSoTaiKhoan++;
        TongSoDu += soDu;
    }
    public String getTen() {
        return ten;
    }
    public int getSoTaiKhoan() {
        return soTaiKhoan;
    }
    public double getSoDu() {
        return soDu;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public void setSoTaiKhoan(int soTaiKhoan) {
        this.soTaiKhoan = soTaiKhoan;
    }
    public void setSoDu(double soDu) {
        if (soDu >= 50000) {
            this.soDu = soDu;
        } else {
            System.out.println("Số dư tối thiểu là 50.000");
        }
    }
    public static int TongSoTaiKhoan() {
        return TongSoTaiKhoan;
    }
    public static double TongSoDu() {
        return TongSoDu;
    }
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
        }
        else{
            System.out.println("So tien nap phai > 0");
        }
    }
    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= (soDu - 50000) ) {
            soDu -= soTien;
        }
        else {
            System.out.println("So du khong hop le hoac vuot qua so du mac dinh la 50.000");
        }
    }
    public void chuyenTien(double tienChuyen){
            System.out.println("tai khoan " + getSoTaiKhoan() +" Chuyen tien thanh cong");
            soDu -= tienChuyen;
            TongSoDu -= tienChuyen;
            System.out.println("so du con lai la: " + soDu);

    }
    public void nhanTienChuyen(double tienNhan){
        soDu += tienNhan;
        TongSoDu += tienNhan;
        System.out.println("tai khoan " + getSoTaiKhoan() + " da nhan duoc so tien chuyen la: " + tienNhan + " tong so du la: " + soDu);
    }
    public void inThongTin(){
        if (soDu < 50000) {
            System.out.println("Tai Khoan "+ getTen() + " So du khong du hoac vuot qua so du mac dinh la 50.000");
        } else {
            System.out.println("========in thong tin tai khoan========");
            System.out.println("Ten: " + ten);
            System.out.println("So tai khoan: " + soTaiKhoan);
            System.out.println("So du: " + soDu);
        }

    }

}
class GuiTietKiem extends TaiKhoanThuong{
    private double tienTietKiem;
    private int thang;

    GuiTietKiem(String ten, int soTaiKhoan, double soDu , double tienTietKiem, int thang) {
        super(ten, soTaiKhoan, soDu);
        this.tienTietKiem = tienTietKiem;
        this.thang = thang;
    }
    public double getTienTietKiem() {
        return tienTietKiem;
    }
    public void setTienTietKiem(double tienTietKiem) {
            this.tienTietKiem = tienTietKiem;

    }
    public double tinhLaiSuat(double tienTietKiem, int thang){
        if(thang > 6){
            return (tienTietKiem * 0.06) / 12 * thang;
        }
        else if(thang > 1){
            return (tienTietKiem * 0.05) / 12 * thang;
        }
        else {
            return 0;
        }
    }
    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println("So tien gui tiet kiem: " + getTienTietKiem());
        System.out.println("lai Suat: " + tinhLaiSuat(getTienTietKiem(), thang));

    }

}
  class SoDuGiamDanComparator implements Comparator<TaiKhoanThuong>{
    @Override
      public int compare(TaiKhoanThuong a, TaiKhoanThuong b){
        if (a.getSoDu() < b.getSoDu()){
            return 1;
        }
        else if (a.getSoDu() > b.getSoDu()){
            return -1;
        }
        else {
            return 0;
        }


    }
  }
