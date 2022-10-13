package ThiThucHanhModul2;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String studentCode;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double mediumScore;

    public SinhVien() {
    }

    public SinhVien(String studentCode, String name, int age, String gender, String address, double mediumScore) {
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumScore = mediumScore;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(double mediumScore) {
        this.mediumScore = mediumScore;
    }

    @Override
    public String toString() {
        return
                "mã học viên=" + studentCode +
                ", họ tên='" + name + '\'' +
                ", tuổi=" + age +
                ", giới tính='" + gender + '\'' +
                ", địa chỉ='" + address + '\'' +
                ", điểm trung bình=" + mediumScore ;
    }
}
