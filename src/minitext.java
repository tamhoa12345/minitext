import java.util.ArrayList;
import java.util.Scanner;

public class minitext {
    public static void main(String[] args) {
        ArrayList<Book> danhSach = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap ma Sach: ");
        int maSach = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

        System.out.print("nhap ten Sach: ");
        String ten = scanner.nextLine();

        System.out.print("nhap gia sach: ");
        double giaSach = Double.parseDouble(new java.util.Scanner(System.in).nextLine());

        System.out.print("nhap tac gia: ");
        String tacGia = scanner.nextLine();
        Book book = new Book(maSach, ten, giaSach, tacGia);
        danhSach.add(book);
        while(true){
            System.out.println("1.Tạo 3 cuốn sách lập trình (ProgrammingBook)");
            System.out.println("2.Tạo 3 cuốn sách viễn tưởng (FictionBook)");
            System.out.println("3.Tính tổng tiền của cả 6 cuốn (gọi getPrice() để lấy giá sau giảm)");
            System.out.println("4.Đếm số sách ProgrammingBook có language là Java");
            System.out.println("5.Đếm số sách FictionBook có category là Viễn tưởng 1");
            System.out.println("6.Đếm số sách FictionBook có giá < 100");
            System.out.println("7.In danh sách sách");
            System.out.println("0.Thoat Ham");
            System.out.print("Nhap lua chon: ");
            int chon = Integer.parseInt(new java.util.Scanner(System.in).nextLine());
            if(chon == 0) break;
            switch(chon){
                case 1:
                    int count1 = 0;
                    System.out.println("nhap ten lay 3 cuon sach ProgrammingBook tu thu vien hoac tao moi : ");
                    while(count1 < 3) {

                        boolean timThay = false;
                        System.out.print("Nhap ten tim kiem: ");
                        String tensach1 = scanner.nextLine();
                        Book sachTonTai = null;

                        for(Book b : danhSach) {
                            if (b.getTen().equalsIgnoreCase(tensach1)) {
                                sachTonTai = b;
                                break;
                            }
                        }

                        if(sachTonTai != null){
                            if (sachTonTai instanceof ProgrammingBook) {
                                System.out.println("Sach da ton tai trong ProgrammingBook khong duoc tao lai");
                                System.out.println("===vui long tao moi danh sach==== ");
                            }
                            else{
                                System.out.println("Sach da ton tai ban co muon lay tu thu vien khong ? yes/no");
                                String chon1 = scanner.nextLine();
                                if (chon1.equalsIgnoreCase("yes")) {

                                    System.out.print("Ngon Ngu: ");
                                    String ngonNgu = scanner.nextLine();

                                    System.out.print("Khung lam Viec: ");
                                    String khungLamViec = scanner.nextLine();

                                    for (int i = 0; i < danhSach.size(); i++) {
                                        Book book1 = danhSach.get(i);
                                        if (book1.getTen().equalsIgnoreCase(tensach1)) {
                                            ProgrammingBook programmingBook = new ProgrammingBook(book1.getMaSach(),
                                                    book1.getTen(),
                                                    book1.getGiaSach(),
                                                    book1.getTacGia(),
                                                    ngonNgu,
                                                    khungLamViec);
                                            System.out.println("=====da them vao danh sach====");
                                            System.out.println("Sách lập trình được giảm 5% gia sau giam la: " + programmingBook.tinhGiaSauGiam());
                                            System.out.println(programmingBook);
                                            danhSach.set(i, programmingBook);
                                            count1++;

                                            timThay = true;
                                            break;
                                        }


                                    }
                                }
                            }
                        }

                        if(!timThay) {
                            System.out.print("nhap ma Sach: ");
                            int maSach1 = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

                            boolean timSach;
                            String ten1;
                            do{
                                timSach = false;
                                System.out.print("nhap ten Sach: ");
                                ten1 = scanner.nextLine();
                                for (Book b : danhSach) {
                                    if (b.getTen().equalsIgnoreCase(ten1)) {
                                        System.out.println("ten sach da ton tai, vui long nhap lai");
                                        timSach = true;
                                        break;
                                    }
                                }
                            }while (timSach);

                            System.out.print("nhap gia sach: ");
                            double giaSach1 = Double.parseDouble(new java.util.Scanner(System.in).nextLine());

                            System.out.print("nhap tac gia: ");
                            String tacGia1 = scanner.nextLine();

                            System.out.print("Ngon Ngu: ");
                            String ngonNgu = scanner.nextLine();

                            System.out.print("Khung lam Viec: ");
                            String khungLamViec = scanner.nextLine();


                            ProgrammingBook programmingBook = new ProgrammingBook(maSach1, ten1, giaSach1, tacGia1, ngonNgu, khungLamViec);
                            danhSach.add(programmingBook);
                            System.out.println("Sách lập trình được giảm 5% gia sau giam la: " + programmingBook.tinhGiaSauGiam());
                            System.out.println(programmingBook);
                            count1++;
                            System.out.println("=====da them vao danh sach====");


                        }
                    }


                    break;
                case 2:
                    int count = 0;
                    System.out.println("nhap ten lay 3 cuon sach FictionBook tu thu vien hoac tao moi : ");
                    while(count < 3) {

                        boolean timThay = false;
                        System.out.print("Nhap ten tim kiem: ");
                        String tensach1 = scanner.nextLine();
                        Book sachTonTai = null;

                        for(Book b : danhSach) {
                            if (b.getTen().equalsIgnoreCase(tensach1)) {
                                sachTonTai = b;
                                break;
                            }
                        }

                        if(sachTonTai != null){
                            if (sachTonTai instanceof FictionBook) {
                                System.out.println("Sach da ton tai trong ProgrammingBook khong duoc tao lai");
                                System.out.println("===vui long tao moi danh sach==== ");
                            }
                            else{
                                System.out.println("Sach da ton tai ban co muon lay tu thu vien khong ? yes/no");
                                String chon1 = scanner.nextLine();
                                if (chon1.equalsIgnoreCase("yes")) {

                                    System.out.print("the loai sach: ");
                                    String loaiSach = scanner.nextLine();

                                    for (int i = 0; i < danhSach.size(); i++) {
                                        Book book1 = danhSach.get(i);
                                        if (book1.getTen().equalsIgnoreCase(tensach1)) {
                                            FictionBook fictionBook = new FictionBook(book1.getMaSach(),
                                                    book1.getTen(),
                                                    book1.getGiaSach(),
                                                    book1.getTacGia(),
                                                    loaiSach);
                                            System.out.println("=====da them vao danh sach====");
                                            System.out.println("Sách viễn tưởng được giảm 7% gia sau giam la: " + fictionBook.tinhGiaSauGiam());
                                            System.out.println(fictionBook);
                                            danhSach.set(i, fictionBook);
                                            count++;

                                            timThay = true;
                                            break;
                                        }


                                    }
                                }
                            }
                        }


                        if(!timThay) {
                            System.out.print("nhap ma Sach: ");
                            int maSach1 = Integer.parseInt(new java.util.Scanner(System.in).nextLine());

                            boolean timSach;
                            String ten1;
                           do{
                               timSach = false;
                               System.out.print("nhap ten Sach: ");
                                ten1 = scanner.nextLine();
                                 for (Book b : danhSach) {
                                      if (b.getTen().equalsIgnoreCase(ten1)) {
                                        System.out.println("ten sach da ton tai, vui long nhap lai");
                                        timSach = true;
                                        break;
                                      }
                                 }
                           }while (timSach);



                            System.out.print("nhap gia sach: ");
                            double giaSach1 = Double.parseDouble(new java.util.Scanner(System.in).nextLine());

                            System.out.print("nhap tac gia: ");
                            String tacGia1 = scanner.nextLine();

                            System.out.print("the loai sach: ");
                            String loaiSach = scanner.nextLine();


                            FictionBook fictionBook = new FictionBook(maSach1, ten1, giaSach1, tacGia1, loaiSach);
                            danhSach.add(fictionBook);
                            System.out.println("Sách viễn tưởng được giảm 7% gia sau giam la: " + fictionBook.tinhGiaSauGiam());
                            System.out.println(fictionBook);
                            count++;
                            System.out.println("=====da them vao danh sach====");


                        }
                    }


                    break;
                case 3:
                    double tongTienProgrammingBook = 0;
                    double tongTienFictionBook = 0;
                    int count5 = 0;
                    int count6 = 0;

                    for (Book b : danhSach) {
                        if (b instanceof ProgrammingBook) {
                            ProgrammingBook bb = (ProgrammingBook) b;
                            tongTienProgrammingBook += bb.tinhGiaSauGiam();
                            count5++;

                        }
                        if (b instanceof FictionBook) {
                            FictionBook fb = (FictionBook) b;
                            tongTienFictionBook += fb.tinhGiaSauGiam();
                            count6++;
                        }
                    }
                    System.out.println("tong tien cua "+ count5 +" cuon sach ProgrammingBook la: " + tongTienProgrammingBook);
                    System.out.println("tong tien cua "+ count6 +"  cuon sach FictionBook la: " + tongTienFictionBook);
                    double tongTien = tongTienProgrammingBook + tongTienFictionBook;
                    System.out.println("tong tien 6 cuon sach la: " + tongTien);
                    break;
                case 4:
                    int count2 = 0;
                    for (Book b : danhSach) {
                        if(b.getClass() == ProgrammingBook.class){
                            ProgrammingBook bb = (ProgrammingBook) b;
                            if(bb.getNgonNgu().equalsIgnoreCase("java")){
                                count2++;
                            }

                        }
                    }
                    System.out.println("So Sach Co Ngon Ngu java la: " + count2);
                    break;
                case 5:
                    int count3 = 0;
                    for (Book b : danhSach) {
                        if(b.getClass() == FictionBook.class){
                            FictionBook bb = (FictionBook) b;
                            if(bb.getTheLoai().equalsIgnoreCase("Vien Tuong 1")){
                                count3++;
                            }

                        }
                    }
                    System.out.println("So Sach Co The Loai Vien Tuong 1 la: " + count3);
                    break;
                case 6:
                    int count4 = 0;
                    for (Book b : danhSach) {
                        if(b.getClass() == FictionBook.class){
                            FictionBook bb = (FictionBook) b;
                            if(bb.getGiaSach() < 100){
                                count4++;
                            }

                        }
                    }
                    System.out.println("So Sach Co Gia < 100 la: " + count4);
                    break;
                case 7:
                    System.out.println("===in danh sach ===");
                    for (Book b : danhSach){
                        System.out.println(b);
                    }
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}



class Book{
    private int maSach;
    private String ten;
    private double giaSach;
    private String tacGia;
    Book(int maSach, String ten, double giaSach, String tacGia) {
        this.maSach = maSach;
        this.ten = ten;
        this.giaSach = giaSach;
        this.tacGia = tacGia;



    }
    public int getMaSach() {
        return maSach;
    }
    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public double getGiaSach() {
        return giaSach;
    }
    public void setGiaSach(double giaSach) {
        this.giaSach = giaSach;
    }
    public String getTacGia() {
        return tacGia;
    }
    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }
    public String toString() {
        return "Mã sách: " + maSach +
                ", Tên sách: " + ten +
                ", Giá sách: " + giaSach +
                ", Tác giả: " + tacGia;
    }


}
class ProgrammingBook extends Book{
    private String ngonNgu;
    private String khungLamViec;
    ProgrammingBook(int maSach, String ten, double giaSach, String tacGia, String ngonNgu, String khungLamViec) {
        super(maSach, ten, giaSach, tacGia);
        this.ngonNgu = ngonNgu;
        this.khungLamViec = khungLamViec;
    }
    public String getNgonNgu() {
        return ngonNgu;
    }
    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }
    public String getKhungLamViec() {
        return khungLamViec;
    }
    public void setKhungLamViec(String khungLamViec) {
        this.khungLamViec = khungLamViec;
    }
    public double tinhGiaSauGiam(){
        if (getGiaSach() > 0) {
            return getGiaSach() * 0.95;
        }
        return 0;

    }
    @Override
    public String toString() {
        return super.toString()+
                ", Ngôn ngữ: " + ngonNgu +
                ", Khung làm việc: " + khungLamViec;
    }

}
class FictionBook extends Book{
    private String theLoai;
    FictionBook(int maSach, String ten, double giaSach, String tacGia, String theLoai) {
        super(maSach, ten, giaSach, tacGia);
        this.theLoai = theLoai;
    }
    public String getTheLoai() {
        return theLoai;
    }
    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }
    public double tinhGiaSauGiam(){
        if (getGiaSach() > 0) {
                return getGiaSach() * 0.93;
        }
        return 0;
    }
    @Override
    public String toString() {
        return super.toString()+
                ", Thể loại: " + theLoai;
    }
}
