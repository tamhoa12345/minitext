import java.util.Arrays;
import java.util.Scanner;

public class baitap_abstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[6];
        vehicles[0] = new Car("1234", "Toyota", 200000,4);
        vehicles[1] = new Car("5678", "Honda", 300000,5);
        vehicles[2] = new MotoBike("9101", "Yamaha", 150000,true);
        vehicles[3] = new MotoBike("1121", "Suzuki", 100000,true);
        vehicles[4] = new Car("3141", "Ford", 180000,9);
        vehicles[5] = new MotoBike("9102", "Yamaha", 150000,false);
//        double totalThue = 0;
//        int count = 0;
//        int count1 = 0;
//        for (Vehicle vehicle : vehicles) {
//            System.out.println(vehicle);
//            totalThue += vehicle.tinhThue();
//
//
//            if (vehicle instanceof Car) {
//                Car car = (Car) vehicle;
//                if (car.getSoCho()>= 7) {
//                    count1++;
//                }
//            }
//
//            if (vehicle instanceof MotoBike) {
//                MotoBike motoBike = (MotoBike) vehicle;
//                if (motoBike.isPhanhABS()){
//                    count++;
//                }
//            }
//        }
       for (int i = 0; i < vehicles.length; i++) {
           for(int j = 0; j < vehicles.length; j++){
                if (vehicles[i].tinhThue() < vehicles[j].tinhThue()){
                     Vehicle temp = vehicles[i];
                     vehicles[i] = vehicles[j];
                     vehicles[j] = temp;
                }

           }

       }
       System.out.println("========xap xep danh sach thue sau giam la===========: ");
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }

        System.out.println("=======Tìm phương tiện có thuế cao nhất==============");
        double maxthue = 0;
        for(Vehicle vehicle : vehicles){
            if(vehicle.tinhThue() > maxthue){
                maxthue = vehicle.tinhThue();
            }
        }
        for(Vehicle vehicle : vehicles){
            if(vehicle.tinhThue() == maxthue){
                System.out.println("xe co thue cao nhat la: " + vehicle);
            }
        }

        System.out.println("========phuong tien co gia duoi 200000 va thue tren 5% la: =======");
        for(Vehicle vehicle : vehicles){
            if(vehicle.getGia() < 200000 && vehicle.tinhThue() > (vehicle.getGia() * 0.05)){
                System.out.println(vehicle);
            }
        }


        double totalThuemotobike = 0;
        double totalThuecar = 0;
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof MotoBike){
                MotoBike motobike = (MotoBike) vehicle;
                totalThuemotobike += motobike.tinhThue();
            }
            if(vehicle instanceof Car){
                Car car = (Car) vehicle;
                totalThuecar += car.tinhThue();
            }
        }
        System.out.println("Thua cua Car la: " + totalThuecar);
        System.out.println("Thue cua MotoBike la: " + totalThuemotobike);




//        System.out.println("tong thue cua 6 xe la: " + totalThue);
//        System.out.println("Motorbike có phanh ABS la : " + count);
//        System.out.println("Car co so cho >= 7 la: " + count1);






         }
    }



abstract class Vehicle{
    private String bienSo;
    private String hangSanXuat;
    private double gia;

    public Vehicle(String bienSo, String hangSanXuat, double gia) {
        this.bienSo = bienSo;
        this.hangSanXuat = hangSanXuat;
        this.gia = gia;
    }
    public String getBienSo() {
        return bienSo;
    }
    public String getHangSanXuat() {
        return hangSanXuat;
    }
    public double getGia() {
        return gia;
    }
    public abstract double tinhThue();

    public void setGia(double gia) {
        this.gia = gia;
    }
    public void setHangSanXuat(String hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }
    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }
    @Override
    public String toString() {
         return "bien so: " + bienSo +
                ", hang san xuat: " + hangSanXuat +
                ", gia: " + gia;
    }
}
class Car extends Vehicle{
    private int soCho;

    Car(String bienSo, String hangSanXuat, double gia, int soCho) {
        super(bienSo, hangSanXuat, gia);
        this.soCho = soCho;
    }
    @Override
    public double tinhThue() {
        if(soCho > 5) {
            return getGia() * 0.1;
        }else {
            return getGia() * 0.07;
        }
    }
    public int getSoCho() {
        return soCho;
    }
    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }
    @Override
    public String toString() {
        return "Car: " + super.toString() +
                ", so cho: " + soCho +
                ", thue: " + tinhThue();
    }

}
class MotoBike extends Vehicle{
    private boolean phanhABS;
    MotoBike(String bienSo, String hangSanXuat, double gia, boolean phanhABS) {
        super(bienSo, hangSanXuat, gia);
        this.phanhABS = phanhABS;
    }
    @Override
    public double tinhThue() {
        if(phanhABS) {
            return getGia() * 0.05;
        }else {
            return getGia() * 0.02;
        }
    }
    public boolean isPhanhABS() {
        return phanhABS;
    }
    @Override
    public String toString() {
        return "MotoBike: " + super.toString()+
                ", phanh ABS: " + phanhABS +
                ", thue: " + tinhThue();
    }


}