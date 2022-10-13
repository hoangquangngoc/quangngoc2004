package casestudy_Modul2.Managers;

import casestudy_Modul2.IO.ReadAndWrite;
import casestudy_Modul2.Models.AccountAdmin;
import casestudy_Modul2.Models.AccountUser;
import casestudy_Modul2.Models.Product;
import casestudy_Modul2.Validate.ValidateUser;
import casestudy_Modul2.views.MenuUser;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
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


    MenuUser menuUser = new MenuUser();
    ValidateUser validateUser;
    public boolean login() {
        try {
            System.out.println("Nhập username");
            String username = sc.nextLine();
            System.out.println("Nhập password");
            String password = sc.nextLine();
            for (int i = 0; i < accountUsers.size(); i++) {
                if (accountUsers.get(i).getUsername().equals(username) && accountUsers.get(i).getPassword().equals(password)) {
                   return true;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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

        accountUsers.add(new AccountUser(name,age,telephone,email,username,password,giohang));
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
    public  void forgotpassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------------");
        System.out.println("Nhập email");
        String email = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getEmail().equals(email)) {
                System.out.println("");
                System.out.println("   Tài khoản bạn cần tìm là : ");
                System.out.println("----------------------------------");
                System.out.println("Account  : "+ readAndWrite.read(file).get(i).getUsername());
                System.out.println("Password : "+ readAndWrite.read(file).get(i).getPassword());
                System.out.println("----------------------------------");
                check=false;
            }

        }
        if (check==true) {
            System.out.println("-----------------------------------------");
            System.out.println("     Không tìm thấy tài khoản bạn cần tìm ");
        }
      login();
    }
    public void buyProduct(){
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng");
        String nameCaterory= sc.nextLine();
        for (int i = 0; i < managerProduct.products.size(); i++) {
            if(managerProduct.products.get(i).getNameCaterory().equals(nameCaterory)){
                giohang.add(managerProduct.products.get(i));
                System.out.println("Thêm sản phẩm thành công");
            }

        }
        readAndWrite.write(file , accountUsers);
        readAndWrite2.write(file1,giohang);
    }
    public void removeProduct(){
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi giỏ hàng");
        String nameCaterory= sc.nextLine();

        for (int i = 0; i <giohang.size(); i++) {
            if(giohang.get(i).getNameCaterory().equals(nameCaterory)){
                giohang.remove(giohang.get(i));
                System.out.println("Xóa sản phẩm thành công");

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
    public void sort(){
        giohang.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        for (int i = 0;i< giohang.size();i++){
            System.out.println(giohang.get(i));
        }
    }
    public void showUserClient(){
        for (int i = 0; i < accountUsers.size(); i++) {
            System.out.println(accountUsers.get(i));

        }
    }
    public void removeClient() {
        System.out.println("Nhập tài khoản khách hàng muốn xóa");
        String username = sc.nextLine();
        for (int i = 0; i < accountUsers.size(); i++) {
            if (accountUsers.get(i).getUsername().equals(username)) {
                System.out.println("Bạn có muốn xóa sản phẩm này không ?(Nhấn y để xóa)");
                String check = sc.nextLine();
                if (check.equals("y") || check.equals("Y")) {
                    accountUsers.remove(accountUsers.get(i));
                    System.out.println("Xóa thành công");
                } else {
                    System.out.println("Tài khoản khách hàng không tồn tại");
                }
            }
        }

    }

}
