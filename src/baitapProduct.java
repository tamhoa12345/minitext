import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
 public class baitapProduct {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         SanPham[] danhSach = new SanPham[5];
         danhSach[0] = new SanPham(1, "Laptop", 1500000, 10);
         danhSach[1] = new SanPham(2, "Chuột", 30000, 50);
         danhSach[2] = new SanPham(3, "Bàn phím", 8000, 30);
         danhSach[3] = new SanPham(4, "Tai nghe", 120000, 20);
         danhSach[4] = new SanPham(5, "Màn hình", 20000, 15);

         System.out.println("==== Danh sách sản phẩm ====");
         for (SanPham sp : danhSach) {
             sp.hienThi();
         }

         String tenCanTim = "Tai nghe";
         boolean timThay = false;
         for (SanPham sp : danhSach) {
             if (sp.layTenSanPham().equalsIgnoreCase(tenCanTim)) {
                 System.out.println("=== Sản phẩm tìm thấy ===");
                 sp.hienThi();
                 timThay = true;
                 break;
             }
         }
         if (!timThay) {
             System.out.println("Không tìm thấy sản phẩm: " + tenCanTim);
         }

         System.out.println("=== Sản phẩm có giá > 1.000.000 ===");
         for (SanPham sp : danhSach) {
             if (sp.layGia() > 1000000) {
                 sp.hienThi();
             }
         }

         SanPham spMax = danhSach[0];
         for (SanPham sp : danhSach) {
             if (sp.laySoLuong() > spMax.laySoLuong()) {
                 spMax = sp;
             }
         }
         System.out.println("=== Sản phẩm có số lượng tồn kho lớn nhất ===");
         spMax.hienThi();

         System.out.println("=== Thống kê ===");
         System.out.println("Tổng số sản phẩm: " + SanPham.layTongSanPham());
         System.out.println("Tổng giá trị tồn kho: " + SanPham.layTongGiaTriTonKho());
         System.out.println("Giá trung bình: " + SanPham.tinhGiaTrungBinh());

         SanPham.datTenKho("Kho miền Nam");
         System.out.println("Tên kho mới: " + SanPham.layTenKho());
     }
 }

 class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private double gia;
    private int soLuong;

    private static String tenKho = "Kho Tổng ABC";
    private static int tongSoSanPham = 0;
    private static double tongGiaTriTonKho = 0;

    public SanPham(int maSanPham, String tenSanPham, double gia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;

        tongSoSanPham++;
        tongGiaTriTonKho += tinhGiaTriTonKho();
    }

    public void hienThi() {
        System.out.println("Mã sản phẩm: " + maSanPham);
        System.out.println("Tên sản phẩm: " + tenSanPham);
        System.out.println("Giá: " + gia);
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Tên kho: " + tenKho);
        System.out.println("Giá trị tồn kho: " + tinhGiaTriTonKho());
        System.out.println("-------------------------");
    }

    public double tinhGiaTriTonKho() {
        return gia * soLuong;
    }

    public static double tinhGiaTrungBinh() {
        if (tongSoSanPham == 0) return 0;
        return tongGiaTriTonKho / tongSoSanPham;
    }

    public static String layTenKho() {
        return tenKho;
    }

    public static void datTenKho(String tenMoi) {
        tenKho = tenMoi;
    }

    public String layTenSanPham() {
        return tenSanPham;
    }

    public int laySoLuong() {
        return soLuong;
    }

    public double layGia() {
        return gia;
    }

    public static int layTongSanPham() {
        return tongSoSanPham;
    }

    public static double layTongGiaTriTonKho() {
        return tongGiaTriTonKho;
    }
}


