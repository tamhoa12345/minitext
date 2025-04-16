//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Student[] students = new Student[5];
//    for (int i = 0; i < students.length; i++) {
//        System.out.println("nhap ID:");
//        String id = scanner.nextLine();
//
//        System.out.println("nhap Nama:");
//        String nama = scanner.nextLine();
//
//        System.out.println("nhap Gmail:");
//        String gmail = scanner.nextLine();
//
//        System.out.println("nhap Age:");
//        int age = Integer.parseInt(scanner.nextLine());
//
//        System.out.println("nhap Diem:");
//        Double diem = Double.parseDouble(scanner.nextLine());
//
//       students[i] = new Student(id, nama, gmail, age, diem);
//    }
//
//}
//
//class Student{
//    private String iD;
//    private String name;
//    private String gmail;
//    private int aGe;
//    private double diem;
//    Student(String iD, String name, String gmail, int age, double diem) {
//        this.iD = iD;
//        this.name = name;
//        this.gmail = gmail;
//        this.aGe = age;
//        this.diem = diem;
//    }
//    public String getID() {
//        return iD;
//    }
//    public String getName() {
//        return name;
//    }
//    public String getGmail() {
//        return gmail;
//    }
//    public int getAge() {
//        return aGe;
//    }
//    public double getDiem() {
//        return diem;
//    }
//    public void setDiem(int diem) {
//        this.diem = diem;
//    }
//    public void inThongTin(){
//        System.out.println("ID: " + iD);
//        System.out.println("Name: " + name);
//        System.out.println("Gmail: " + gmail);
//        System.out.println("Age: " + aGe);
//        System.out.println("Diem: " + diem);
//    }
//
//}