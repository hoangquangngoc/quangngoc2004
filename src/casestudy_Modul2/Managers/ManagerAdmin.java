package casestudy_Modul2.Managers;

import casestudy_Modul2.IO.ReadAndWrite;
import casestudy_Modul2.Models.AccountAdmin;
import casestudy_Modul2.Models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAdmin {
    File file = new File("D:\\intellij\\demo\\demo\\src\\casestudy_Modul2\\File_text\\account.txt");
    ReadAndWrite<AccountAdmin> readAndWrite = new ReadAndWrite<>();
    ArrayList<AccountAdmin> accounts = readAndWrite.read(file);
    Scanner sc = new Scanner(System.in);

    ManagerProduct managerProduct;


    public void login() {
        System.out.println("Nhập user name");
        String userName = sc.nextLine();
        System.out.println("Nhập password");
        String password = sc.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(userName) && accounts.get(i).getPassword().equals(password)) {


            }
        }
}

public void register(){
        String userName;
        while (true){
            System.out.println("Nhập username");
            userName = sc.nextLine();
            if (checkUserName(userName)) {
                break;
            }
            System.out.println("Trùng username rồi");
        }

        System.out.println("Nhập password");
        String password = sc.nextLine();
        System.out.println("Nhập role");
        String role = sc.nextLine();
        accounts.add(new AccountAdmin(userName,password,role));
        readAndWrite.write(file,accounts);
    }

    public boolean checkUserName(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUserName().equals(username)) {
                return false;
            }
        }
        return true;
    }

}



