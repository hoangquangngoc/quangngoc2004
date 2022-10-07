package casestudy_Modul2.views;

import casestudy_Modul2.Managers.ManagerUser;
import casestudy_Modul2.Models.Product;

import java.util.Scanner;

public class MenuUser {
    public void menuUser() {
        Scanner sc = new Scanner(System.in);
        ManagerUser managerUser = new ManagerUser();
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("╔===================================================╗");
            System.out.println("║      ▂ ▃ ▅ ▆ █ XIN CHÀO KHÁCH HÀNG █ ▆ ▅ ▃ ▂      ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Đăng nhập                                    ║");
            System.out.println("║>[2]. Đăng ký                                      ║");
            System.out.println("║>[0]. Thoát                                        ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println();
                    System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                }
                switch (choice) {
                    case 1:
                        managerUser.login();
                        System.out.println("Đăng Nhập thành công");
                        boolean isbreak = true;
                        while (isbreak) {
                            System.out.println("╔===================================================╗");
                            System.out.println("║    ▂ ▃ ▅ ▆ █ SẢN PHẨM CỦA KHÁCH HÀNG█ ▆ ▅ ▃ ▂     ║");
                            System.out.println("╠===================================================╣");
                            System.out.println("║>[1]. Hiển thị danh sách sản phẩm                  ║");
                            System.out.println("║>[2]. Thêm Sản Phẩm                                ║");
                            System.out.println("║>[3]. Xóa Sản Phẩm                                 ║");
                            System.out.println("║>[4]. Hiển thị sản phẩm và tổng tiền               ║");
                            System.out.println("║>[5]. Thoát                                        ║");
                            System.out.println("║                                                   ║");
                            System.out.println("╚===================================================╝");
                            System.out.println("Nhập lựa chọn:");
                            try {
                                int choice1 = Integer.parseInt(sc.nextLine());
                                if (choice1 < 0 || choice1 > 5) {
                                    System.out.println();
                                    System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                                }

                                switch (choice1) {
                                    case 1:
                                        managerUser.showProduct();
                                        break;
                                    case 2:
                                       managerUser.buyProduct();
                                        break;
                                    case 3:
                                       managerUser.removeProduct();
                                        break;
                                    case 4:
                                        managerUser.showGioHang();
                                    case 5:
                                        isbreak = false;
                                }
                            } catch (Exception e) {
                                System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");

                            }

                        }

                    case 2:
                        managerUser.register();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                }

            } catch (Exception e) {
                System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                menuUser();
            }

        }
    }
}
