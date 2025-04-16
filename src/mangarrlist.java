import java.util.*;
import java.io.*;

//public class mangarrlist {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        ArrayList<SinhVien> danhSach = new ArrayList<>();
//        ArrayList<SinhVien> ds = DocFileText.docFile("SinhVien.txt");
//        System.out.println("📂 Đang đọc file từ: " + new File("SinhVien.txt").getAbsolutePath());
//
//        while (true) {
//            System.out.println("nhap ten: ");
//            String ten = scanner.nextLine();
//            System.out.println("nhap ma so: ");
//            int maSo = Integer.parseInt(scanner.nextLine());
//            for (int i = 0; i < danhSach.size(); i++) {
//                SinhVien sv = danhSach.get(i);
//                if(sv.getMaSo()== maSo){
//                   while(sv.getMaSo() == maSo){
//                          System.out.println("ma so da ton tai, vui long nhap lai");
//                          maSo = Integer.parseInt(scanner.nextLine());
//                   }
//                }
//            }
//
//            int soMon = 0;
//            try {
//                System.out.println("nhap so mon: ");
//                soMon = Integer.parseInt(scanner.nextLine());
//            }
//            catch (NumberFormatException e) {
//                System.out.println("Loi! Ban phai Nhap so nguyen");
//                continue;
//            }
//
//            int[] diem = new int[soMon];
//            for (int i = 0; i < soMon; i++) {
//                try {
//                    System.out.println("nhap diem: ");
//                    diem[i] = Integer.parseInt(scanner.nextLine());
//                    if (diem[i] < 0 || diem[i] > 10) {
//                        System.out.println("Loi! Diem phai tu 0 den 10");
//                        i--;
//                    }
//                }
//                catch (NumberFormatException e) {
//                    System.out.println("Loi! Ban phai Nhap so nguyen, vui long nhap lai");
//                    i--;
//                }
//            }
//            SinhVien sv = new SinhVien(ten, maSo, diem);
//            danhSach.add(sv);
//            System.out.println("ban co muon tiep tuc khong? (y/n)");
//            String chon = scanner.nextLine();
//            if (chon.equalsIgnoreCase("n")) break;
//
//
//
//
//        }
//
//        double maxagv = 0;
//        for (SinhVien sv : danhSach){
//            if (sv.tinhDiemTrungBinh() > maxagv) maxagv = sv.tinhDiemTrungBinh();
//        }
//
//        System.out.println("===Sinh vien co diem trung binh cao nhat ===");
//        int count = 0;
//        for(int i = 0; i < danhSach.size(); i++){
//            SinhVien sv = danhSach.get(i);
//            if(sv.tinhDiemTrungBinh() == maxagv){
//                count++;
//            }
//        }
//        if(count > 1){
//            System.out.println("co " + count + " sinh vien co diem trung binh cao nhat la");
//        }
//        else {
//            System.out.println("sinh vien co diem trung binh cao nhat la: ");
//        }
//        for (SinhVien sv : danhSach){
//            if (sv.tinhDiemTrungBinh() == maxagv){
//                System.out.println(sv);
//            }
//        }
////        try{
////            BufferedWriter ghiGioiNhat = new BufferedWriter(new FileWriter("SinhVien.txt", true));
////            ghiGioiNhat.write("===Sinh vien co diem trung binh cao nhat ===");
////            ghiGioiNhat.newLine();
////            for (SinhVien sv : danhSach){
////                if(sv.tinhDiemTrungBinh() == maxagv){
////                    ghiGioiNhat.write(sv.toString());
////                    ghiGioiNhat.newLine();
////                }
////            }
////            ghiGioiNhat.close();
////            System.out.println("Da ghi danh sach vao file SinhVien.txt");
////        }
////        catch (IOException e) {
////            System.out.println("Loi! Khong the ghi vao file" + e.getMessage());
////        }
//
//
//        System.out.println("===in danh sach sinh vien ===");
//        for (SinhVien sv : danhSach){
//            System.out.println(sv);
//        }
//
//
//
//
//    }
//}
class SinhVien{
    private String ten;
    private int maSo;
    private int [] diem;
    public SinhVien(String ten, int maSo,int[] diem) {
        this.ten = ten;
        this.maSo = maSo;
        this.diem = diem;
    }
    public double tinhDiemTrungBinh(){
        double tong = 0;
        for (int i = 0; i < diem.length; i++){
            tong += diem[i];
        }
        return tong / diem.length;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public int getMaSo() {
        return maSo;
    }
    public void setMaSo(int maSo) {
        this.maSo = maSo;
    }
    public int[] getdiem() {
        return diem;
    }
    @Override
    public String toString(){
        return "Ten: " + ten +
                ", ma so: " + maSo +
                ", diem: " + Arrays.toString(diem) +
                ", diem trung binh: " + tinhDiemTrungBinh();
    }


}

//class DocFileText{
//    public static void main(String[] args) {
//        ArrayList<SinhVien> danhSach = docFile("SinhVien.txt");
//        System.out.println("📦 Số sinh viên đọc được: " + danhSach.size());
//        System.out.println("doc file danh sach sinh vien");
//        for (SinhVien sv : danhSach){
//            System.out.println(sv);
//        }
//    }
//    public static ArrayList<SinhVien> docFile(String fileName) {
//        ArrayList<SinhVien> danhSach = new ArrayList<>();
//        try{
//            BufferedReader bf = new BufferedReader(new FileReader(fileName));
//            String line;
//
//            while ((line = bf.readLine()) != null){
//                String[] index = line.split(", ");
//
//                if (index.length < 3){
//                    System.out.println("Loi! Khong du thong tin sinh vien");
//                    continue;
//                }
//                String ten = index[0];
//                int maSo = Integer.parseInt(index[1]);
//
//                String diemChuoi = index[2].replace("[","").replace("]","");
//                String [] diemStr = diemChuoi.split(",");
//                int [] diem = new int[diemStr.length];
//                for (int i = 0; i < diemStr.length; i++){
//                    diem[i] = Integer.parseInt(diemStr[i].trim());
//                }
//                SinhVien sv = new SinhVien(ten, maSo, diem);
//                danhSach.add(sv);
//
//
//
//
//            }
//            bf.close();
//        }
//        catch (IOException e){
//            System.out.println("Loi! Khong the doc file" + e.getMessage());
//        }
//        return danhSach;
//
//
//
//    }
//
//
//
//
//}



