package casestudy_Modul2.Managers;

import casestudy_Modul2.IO.ReadAndWrite;
import casestudy_Modul2.Models.AccountAdmin;
import casestudy_Modul2.Models.AccountUser;
import casestudy_Modul2.Models.Product;
import casestudy_Modul2.Validate.ValidateUser;
import casestudy_Modul2.views.MenuUser;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ManagerUser {
    File file = new File("D:\\intellij\\demo\\demo\\src\\casestudy_Modul2\\File_text\\user.txt");
    File file1 = new File("D:\\intellij\\demo\\demo\\src\\casestudy_Modul2\\File_text\\giohang.txt");
    ReadAndWrite<AccountUser>readAndWrite = new ReadAndWrite<>();
    ReadAndWrite<Product>readAndWrite2 = new ReadAndWrite<>();
    ArrayList<AccountUser>accountUsers = readAndWrite.read(file);
    ArrayList<Product>giohang =readAndWrite2.read(file1);

    Scanner sc = new Scanner(System.in);
    ManagerProduct managerProduct = new ManagerProduct();

    MenuUser menuUser;
    ValidateUser validateUser;
    public void login() {
        try {
            System.out.println("Nhập username");
            String username = sc.nextLine();
            System.out.println("Nhập password");
            String password = sc.nextLine();
            for (int i = 0; i < accountUsers.size(); i++) {
                if (accountUsers.get(i).getUsername().equals(username) && accountUsers.get(i).getPassword().equals(password)) {
                    menuUser.menuUser();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void register(){
        System.out.println("Nhập tên user");
        String name = ValidateUser.name();
        System.out.println("Nhập tuổi");
        String age = ValidateUser.age();
        System.out.println("Nhập số điện thoại");
        String telephone = ValidateUser.telephone();
        System.out.println("Nhập email");
        String email = ValidateUser.email();
        String username;
        while (true){
            System.out.println("Nhập username");
            username = ValidateUser.username();
            if (checkUserName(username)) {
                break;
            }
            System.out.println("Trùng username rồi");
        }
        System.out.println("Nhập password");
        String password = ValidateUser.password();
        System.out.println("Nhập role");
        String role = sc.nextLine();
        accountUsers.add(new AccountUser(name,age,telephone,email,username,password,role,giohang));
        readAndWrite.write(file,accountUsers);
    }

    public boolean checkUserName(String username) {
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public void buyProduct(){
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng");
        String nameCaterory= sc.nextLine();
        for (int i = 0; i < managerProduct.products.size(); i++) {
            if(managerProduct.products.get(i).getNameCaterory().equals(nameCaterory)){
                giohang.add(managerProduct.products.get(i));
            }

        }
        readAndWrite.write(file , accountUsers);
        readAndWrite2.write(file1,giohang);
    }
    public void removeProduct(){
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng");
        String nameCaterory= sc.nextLine();
        for (int i = 0; i < managerProduct.products.size(); i++) {
            if(managerProduct.products.get(i).getNameCaterory().equals(nameCaterory)){
                giohang.remove(managerProduct.products.get(i));

            }

        }
        readAndWrite.write(file,accountUsers);
        readAndWrite2.write(file1,giohang);
    }

    public void showProduct(){
        for (int i = 0; i <managerProduct.products.size() ; i++) {
            System.out.println(managerProduct.products.get(i).toString());
        }



    }
    public void showGioHang(){
        for (int i = 0; i < giohang.size(); i++) {
            System.out.println(giohang.get(i));
        }
        System.out.println("Tổng tiền giỏ hàng: " + tongTien());
    }


    public double tongTien(){
        double tongTien = 0.0;

        for (int i = 0; i < giohang.size(); i++) {
            tongTien += giohang.get(i).getPrice();
        }
        return tongTien;
    }

}
