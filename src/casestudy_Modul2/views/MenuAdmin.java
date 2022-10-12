package casestudy_Modul2.views;

import casestudy_Modul2.Managers.ManagerAdmin;
import casestudy_Modul2.Managers.ManagerProduct;
import casestudy_Modul2.Models.Product;

import java.util.Scanner;

public class MenuAdmin {

    Scanner sc = new Scanner(System.in);
    ManagerAdmin managerAccount = new ManagerAdmin();
    ManagerProduct managerProduct = new ManagerProduct();
    public void menuAdmin(){
        while (true) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("╔===================================================╗");
            System.out.println("║         ▂ ▃ ▅ ▆ █ XIN CHÀO ADMIN █ ▆ ▅ ▃ ▂        ║");
            System.out.println("╠===================================================╣");
            System.out.println("║>[1]. Đăng nhập                                    ║");
//            System.out.println("║>[2]. Đăng ký                                      ║");
            System.out.println("║>[0]. Thoát                                        ║");
            System.out.println("╚===================================================╝");
            System.out.println("Nhập lựa chọn:");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println();
                    System.err.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                }
                switch (choice) {
                    case 1:
                        if (managerAccount.login()) {
                            System.out.println("Đăng Nhập thành công");
                        }
                        else {
                            System.out.println("Không có taì khoản!");
                            return;
                        }
                        while (true) {
                            System.out.println("╔===================================================╗");
                            System.out.println("║         ▂ ▃ ▅ ▆ █ QUẢN LÝ SẢN PHẨM █ ▆ ▅ ▃ ▂      ║");
                            System.out.println("╠===================================================╣");
                            System.out.println("║>[1]. Hiển thị danh sách sản phẩm                  ║");
                            System.out.println("║>[2]. Thêm Sản Phẩm                                ║");
                            System.out.println("║>[3]. Sửa Sản Phẩm                                 ║");
                            System.out.println("║>[4]. Tìm kiếm Sản Phẩm                            ║");
                            System.out.println("║>[5]. Xóa sản phẩm                                 ║");
                            System.out.println("║>[6]. Thoát                                        ║");
                            System.out.println("╚===================================================╝");
                            System.out.println("Nhập lựa chọn:");
                            try {
                                int choice1 = Integer.parseInt(sc.nextLine());
                                if (choice1 < 0 || choice1 > 6) {
                                    System.out.println();
                                    System.out.println("⛔ Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                                }

                                switch (choice1) {
                                    case 1:
                                        managerProduct.show();
                                        break;
                                    case 2:
                                        Product product = managerProduct.create();
                                        managerProduct.add(product);
                                        break;
                                    case 3:
                                        managerProduct.edit();
                                        break;
                                    case 4:
                                        managerProduct.search();
                                        break;
                                    case 5:
                                        managerProduct.deleteProduct();
                                        break;
                                    case 6:
                                        return;
                                }
                            } catch (Exception e) {
                                System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");

                            }

                        }

//                    case 2:
//                        managerAccount.register();
//                        break;
                    case 0:
                        return;
                }

            } catch (Exception e) {
                System.err.println("⛔ Bạn nhập sai dữ liệu, mời nhập lại !!!");
                menuAdmin();
            }

        }
    }
}
