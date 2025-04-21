import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;

public class java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        while(true){
            System.out.println("=====MENU====== ");
            System.out.println("1. Them phan tu vao stack");
            System.out.println("2. undo thao tac gan nhat");
            System.out.println("3. xem tat ca thao tac");
            System.out.println("0. Thoat");
            System.out.print("Vui long chon chuc nang: ");
            int chon = Integer.parseInt(scanner.nextLine());
            if(chon == 0) break;
            switch(chon){
                case 1:
                    System.out.println("Nhap thao tac can them: ");
                    String thaoTac = scanner.nextLine();
                    stack.push(thaoTac);
                    System.out.println("Da them thao tac " + thaoTac + " vao stack");
                    break;
                case 2:
                    if(!stack.isEmpty()){
                        String undo = stack.pop();
                        System.out.println("Da undo thao tac " + undo);
                    }
                    else{
                        System.out.println("khong co thao tac nao de Undo: ");
                    }
                    break;
                case 3:
                    System.out.println("===Tat ca thao tac trong stack===");
                    for(String thaoTac1 : stack){
                        System.out.println(thaoTac1);
                    }
                    break;
                case 0:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("thao tac khong hop le");
            }
        }
    }
}
