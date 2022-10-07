package casestudy_Modul2;



import casestudy_Modul2.views.MenuAdmin;
import casestudy_Modul2.views.MenuUser;


import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuAdmin menuAdmin = new MenuAdmin();
        MenuUser menuUser = new MenuUser();
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("╔===================================================╗");
            System.out.println("║   ▂ ▃ ▅ ▆ █  Đăng nhập với vai trò là █ ▆ ▅ ▃ ▂   ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. ADMIN                                        ║");
            System.out.println("║>[2]. KHÁCH HÀNG                                   ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    menuAdmin.menuAdmin();
                    break;
                case 2:
                    menuUser.menuUser();
                    break;
            }
        }
    }
}


