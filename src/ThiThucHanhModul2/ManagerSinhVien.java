package ThiThucHanhModul2;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerSinhVien {
    ArrayList<SinhVien> sinhViens = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ManagerSinhVien() {
        this.sinhViens = new ArrayList<SinhVien>();
    }

    public ManagerSinhVien(ArrayList<SinhVien> sinhViens) {
        this.sinhViens = sinhViens;
    }

    public void showStudentList() {
        for (int i = 0; i < sinhViens.size(); i++) {
            System.out.println(sinhViens.get(i).toString());

        }
    }

    public void moreStudents(SinhVien sv) {
        this.sinhViens.add(sv);
        IOStudent.write(sinhViens);
    }

    public void update() {
        System.out.println("Nhập mã sinh viên cần sửa");
        String studentCode = sc.nextLine();
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getStudentCode().equals(studentCode)) {
                SinhVien sinhVien = creatStudent();
                sinhViens.set(i, sinhVien);
            }

        }
        IOStudent.write(sinhViens);
    }

    public SinhVien creatStudent() {
        System.out.println("Nhập mã sinh viên");
        String studentCode = sc.nextLine();
        System.out.println("Nhập họ tên sinh viên");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi của sinh viên");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập giới tính");
        String gender = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc.nextLine();
        System.out.println("Nhập điểm trung bình");
        double mediumScore = Double.parseDouble(sc.nextLine());

        SinhVien sinhVien = new SinhVien(studentCode, name, age, gender, address, mediumScore);
        return sinhVien;
    }

    public void delete() {
        System.out.println("Nhập mã sinh vien bạn muốn xóa");
        String studentCode = sc.nextLine();

        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getStudentCode().equals(studentCode)) {
                System.out.println("Bạn có muốn xóa sinh viên này không ?(Nhấn y để xóa)");
                String check = sc.nextLine();
                if (check.equals("y") || check.equals("Y")) {
                    sinhViens.remove(i);
                }
            }
        }

        IOStudent.write(sinhViens);
    }

    public void sort() {
        while (true){

        System.out.println("---Sắp xếp sinh viên theo điểm trung bình---");
        System.out.println("Chọn chức năng theo số(để tiếp tục)");
        System.out.println("1. Sắp xếp điểm trung bình tăng dần");
        System.out.println("2. Sắp xếp điểm trung bình giảm dần");
        System.out.println("3. Thoát");
        System.out.println("Chọn chức năng");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                sinhViens.sort(new Comparator<SinhVien>() {
                    @Override
                    public int compare(SinhVien o1, SinhVien o2) {
                        return o1.getStudentCode().compareTo(o2.getStudentCode());
                    }

                });
                for (int i = 0; i < sinhViens.size(); i++) {
                    System.out.println(sinhViens.get(i));
                }
                break;
            case 2:
                sinhViens.sort(new Comparator<SinhVien>() {
                    @Override
                    public int compare(SinhVien o1, SinhVien o2) {
                        return o2.getStudentCode().compareTo(o1.getStudentCode());
                    }
                });
                for (int i = 0; i < sinhViens.size(); i++) {
                    System.out.println(sinhViens.get(i));
                }
                break;
            case 3:
                return;

        }
    }
}
   public void readFile(){
        sinhViens = IOStudent.read();
       System.out.println("Đọc file thành công");
   }
   public void  writeFile(){
        IOStudent.write(sinhViens);
       System.out.println("Ghi file thành công");
   }
}
