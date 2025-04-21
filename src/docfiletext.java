//import java.io.*;
//import java.util.*;
//
// class DocFileText {
//    public static void main(String[] args) {
//        ArrayList<SinhVien> danhSach = docFile("SinhVien.txt");
//
//        System.out.println("📂 Danh sách sinh viên doc từ file:");
//        for (SinhVien sv : danhSach) {
//            System.out.println(sv);
//        }
//    }
//
//    public static ArrayList<SinhVien> docFile(String fileName) {
//        ArrayList<SinhVien> danhSach = new ArrayList<>();
//
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(fileName));
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                if (line.trim().isEmpty()) continue;
//
//                String[] index = line.split(", ");
//                if (index.length < 3) {
//                    System.out.println("⚠️ Dòng lỗi: " + line);
//                    continue;
//                }
//
//                String ten = index[0];
//                int maSo = Integer.parseInt(index[1]);
//
//
//                // Xử lý chuỗi điểm
//                int viTriDau;
//                int viTriCuoi;
//                for (int i = 0; i < index.length; i++) {
//                    viTriDau = index[i].indexOf("[");
//                    viTriCuoi = index[i].indexOf("]");
//                }
//
////                if (viTriDau == -1 || viTriCuoi == -1) continue;
//                String diemChuoi = index[2].substring(viTriDau + 1, viTriCuoi);
//
////              String diemChuoi = index[2].replace("[", "").replace("]", "");
//                String[] diemStr = diemChuoi.split(", ");
//                int[] diem = new int[diemStr.length];
//
//                for (int i = 0; i < diemStr.length; i++) {
//                    diem[i] = Integer.parseInt(diemStr[i].trim());
//                }
//
//                SinhVien sv = new SinhVien(ten, maSo, diem);
//                danhSach.add(sv);
//            }
//
//            reader.close();
//        } catch (IOException e) {
//            System.out.println(" Lỗi khi đọc file: " + e.getMessage());
//        }
//
//        return danhSach;
//    }
//}
