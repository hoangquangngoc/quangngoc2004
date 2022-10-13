package ThiThucHanhModul2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerSinhVien managerSinhVien = new ManagerSinhVien();
        while (true) {
            System.out.println("---Chương trình quản lí sinh viên---");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật");
            System.out.println("4. xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc file");
            System.out.println("7. ghi file");
            System.out.println("0. thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    managerSinhVien.showStudentList();
                    break;
                case 2:
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
                    managerSinhVien.moreStudents(sinhVien);
                    break;
                case 3:
                    managerSinhVien.update();
                    break;
                case 4:
                    managerSinhVien.delete();
                    break;
                case 5:
                    managerSinhVien.sort();
                    break;
                case 6:
                    managerSinhVien.readFile();
                    break;
                case 7:
                    managerSinhVien.writeFile();
                case 0:
                  return;
            }

        }
    }
}
