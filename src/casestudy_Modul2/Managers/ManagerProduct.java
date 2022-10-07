package casestudy_Modul2.Managers;

import casestudy_Modul2.IO.ReadAndWrite;
import casestudy_Modul2.Models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("D:\\intellij\\demo\\demo\\src\\casestudy_Modul2\\File_text\\product.txt");
    ReadAndWrite<Product>readAndWrite = new ReadAndWrite<>();
    ArrayList<Product>products = readAndWrite.read(file);
    Scanner sc = new Scanner(System.in);


    public void show(){
        for (Product product:products) {
            System.out.println(product);
        }
    }
    public void add(Product product){
        products.add(product);
        readAndWrite.write(file,products);
    }
    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getIdProduct() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product create() {
        int  idProduct;
        int index;
        while (true) {
            System.out.println("Nhập id :");
            idProduct = Integer.parseInt(sc.nextLine());
            index = findIndexById( idProduct);
            if (index == -1) {
                break;
            }
            System.out.println("Nhập trùng id rồi.");
        }
        System.out.println("Nhập name");
        String  nameCaterory = sc.nextLine();

        System.out.println("Nhập price");
        double price = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số lượng");
        int amount = Integer.parseInt(sc.nextLine());
        System.out.println("nhập mô tả");
        String  describe = sc.nextLine();

        return new Product(idProduct,nameCaterory,price,amount,describe);
    }

    public void edit() {
        System.out.println("Nhập id :");
        int idProduct= Integer.parseInt(sc.nextLine());
        int index = findIndexById(idProduct);
//        if (index != -1) {
//            products.set(index, create());
        
//        
        for (int i = 0; i <products.size() ; i++) {
            if(i == index){
                products.set(i, create());
            }
            
        }
    }
    public void deleteProduct(){
        System.out.println("Nhập id sản phẩm muốn xóa");
        int idProduct = Integer.parseInt(sc.nextLine());
        for (int i = 0; i <products.size() ; i++) {
            if (products.get(i).getIdProduct() == idProduct){
                products.remove(i);
            }

        }
    }
}
