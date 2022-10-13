package ThiThucHanhModul2;

import java.io.*;
import java.util.ArrayList;

public class IOStudent {
    static File file = new File("D:\\intellij\\demo\\Case\\src\\ThiThucHanhModul2\\file\\student.scv");

    public static void write(ArrayList<SinhVien> sinhViens){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sinhViens);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<SinhVien>read(){
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<SinhVien>sinhViens= (ArrayList<SinhVien>) objectInputStream.readObject();
            return sinhViens;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
