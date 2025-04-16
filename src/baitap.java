import java.util.Scanner;

public class baitap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NhanVien[] nhanViens = new NhanVien[5];
        nhanViens[0] = new NhanVienFulltime("t1234","hoatam",20,325646,"tamhoa12345",400000,25000,222222);
        nhanViens[1] = new NhanVienFulltime("t1235","ererd",22,97332737,"tamhoa123456",150000,33333,444444);
        nhanViens[2] = new NhanVienParttime("t1236","dsfcc",32,972237,"tamhoa32432",10);
        nhanViens[3] = new NhanVienParttime("t1237","ffgf",45,9734431,"tamhoa3444r5",20);
        nhanViens[4] = new NhanVienParttime("t1238","jjjj",69,6473734,"tamh4343345",30);

        double avg = 0;
        while (true){
            System.out.println("1.tính trung bình lương của nhân viên cả công ty : ");
            System.out.println("2.danh sách NhanVienFulltime co luong thap hon luong trung binh : ");
            System.out.println("3.tinh tong so luong phai tra cho tat ca nhan vien NhanVienParttime : ");
            System.out.println("4.sắp xếp nhân viên NhanVienFulltime theo số lương tăng dần : ");
            System.out.println("5.in ra danh sach nhan vien : ");
            System.out.println("0.thoát : ");
            System.out.print("vui long chon: ");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            switch (choice) {
                case 1:
                   for (NhanVien nhanVien : nhanViens) {
                          avg += nhanVien.tinhLuong();
                       }
                   avg = avg / nhanViens.length;
                     System.out.println("trung binh luong ca cong ty la: "+ avg);
                    break;
                case 2:
                    boolean timthay = false;
                    for (NhanVien nhanVien : nhanViens) {
                        if(nhanVien instanceof NhanVienFulltime){
                            NhanVienFulltime nhanVienFulltime = (NhanVienFulltime) nhanVien;
                            if (nhanVienFulltime.tinhLuong() < avg){
                                timthay = true;
                                System.out.println("nhan vien co luong thap hon luong trung binh la: " + nhanVienFulltime.getHoTen());
                            }
                            else{
                            }
                        }
                    }
                    if (!timthay){
                        System.out.println("khong co nhan vien nao co luong thap hon luong trung binh");
                    }
                    break;
                case 3:
                    double tongluong = 0;
                    for(NhanVien nhanVien : nhanViens){
                        if(nhanVien instanceof NhanVienParttime){
                            NhanVienParttime nhanVienParttime = (NhanVienParttime) nhanVien;
                            tongluong += nhanVienParttime.tinhLuong();
                        }
                    }
                    System.out.println("tong luong phai tra cho tat ca nhan vien NhanVienParttime la: " + tongluong);
                    break;
                case 4:
                    System.out.println("========xap xep nhan vien Fulltime theo luong tang dan=========");
                    for(int i = 0; i < nhanViens.length; i++){
                        for(int j = 0; j < nhanViens.length; j++){
                            if (nhanViens[i] instanceof NhanVienFulltime && nhanViens[j] instanceof NhanVienFulltime){
                                if (nhanViens[i].tinhLuong() < nhanViens[j].tinhLuong()){
                                    NhanVien temp = nhanViens[i];
                                    nhanViens[i] = nhanViens[j];
                                    nhanViens[j] = temp;
                                }
                            }
                        }
                    }
                    for (NhanVien nhanVien : nhanViens) {
                        if (nhanVien instanceof NhanVienFulltime) {
                            System.out.println("nhan vien Fulltime co luong tang dan la: " + nhanVien.getHoTen() + " co luong la: " + nhanVien.tinhLuong());
                        }
                    }
                    break;
                case 5:
                    System.out.println("=======danh sach nhan vien=========");
                    for (NhanVien nhanVien : nhanViens) {
                        System.out.println(nhanVien);
                    }
                    break;
                case 0:
                    System.out.println("thoat chuong trinh");
                    break;
                default:
                     System.exit(0);
            }
        }


    }
}
abstract class NhanVien{
    private String maNhanVien;
    private String hoTen;
    private int tuoi;
    private int soDienThoai;
    private String email;
    NhanVien(String maNhanVien, String hoTen, int tuoi,int soDienThoai, String email) {
            this.maNhanVien = maNhanVien;
            this.hoTen = hoTen;
            this.tuoi = tuoi;
            this.soDienThoai = soDienThoai;
            this.email = email;

    }
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public int getSoDienThoai() {
        return soDienThoai;
    }
    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public abstract double tinhLuong();
    public String toString() {
        return "ma nhan vien: " + maNhanVien +
                ", ho ten: " + hoTen +
                ", tuoi: " + tuoi +
                ", so dien thoai: " + soDienThoai +
                ", email: " + email;
    }



}
class NhanVienFulltime extends NhanVien{
    private double tienThuong;
    private double tienPhat;
    private double luongCoBan;
    NhanVienFulltime(String maNhanVien, String hoTen, int tuoi,int soDienThoai, String email, double tienThuong,double tienPhat,double luongCoBan) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email);
        this.tienThuong = tienThuong;
        this.tienPhat = tienPhat;
        this.luongCoBan = luongCoBan;
    }
    public double getTienThuong() {
        return tienThuong;
    }
    public void setTienThuong(double tienThuong) {
        this.tienThuong = tienThuong;
    }
    public double getTienPhat() {
        return tienPhat;
    }
    public void setTienPhat(double tienPhat) {
        this.tienPhat = tienPhat;
    }
    public double getLuongCoBan() {
        return luongCoBan;
    }
    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
    @Override
    public double  tinhLuong() {
        return luongCoBan + (tienThuong - tienPhat);
    }
    @Override
    public String toString() {
        return super.toString() +
                ", tien thuong: " + tienThuong +
                ", tien phat: " + tienPhat +
                ", luong co ban: " + luongCoBan;
    }

}

class NhanVienParttime extends NhanVien{
    private double gioLamViec;
    NhanVienParttime(String maNhanVien, String hoTen, int tuoi,int soDienThoai, String email, double gioLamViec) {
        super(maNhanVien, hoTen, tuoi, soDienThoai, email);
        this.gioLamViec = gioLamViec;
    }
    public double getGioLamViec() {
        return gioLamViec;
    }
    public void setGioLamViec(double gioLamViec) {
        this.gioLamViec = gioLamViec;
    }
    @Override
    public double tinhLuong() {
        return gioLamViec * 100000;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", gio lam viec: " + gioLamViec;
    }

}

