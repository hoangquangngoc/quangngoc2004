package casestudy_Modul2.Validate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
 public static final String regexname = "[A-Za-z]+";
 public static final String regexage = "[0-9]{1,2}";
 public static final String regextelephone = "[+84][0-9]{11}";
 public static final String regexemail = "^[a-zA-Z]+[0-9_a-zA-z.]*@([a-z]+\\.[a-z]+)+";
 public static final String regexusername = "[a-z0-9]{1,9}";
 public static final String regexpassword = "[A-Za-z0-9]+";

 static Scanner sc = new Scanner(System.in);

 public static String name(){
  while (true){
   String Name = sc.nextLine();
   Pattern pattern = Pattern.compile(regexname);
   Matcher matcher = pattern.matcher(Name);
   if (matcher.matches()){
    return Name;
   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi(bắt đầu bằng chữ hoa)");
  }
 }
 public static String age(){
  while (true){
   String Age = sc.nextLine();
   Pattern pattern = Pattern.compile(regexage);
   Matcher matcher= pattern.matcher(Age);
   if (matcher.matches()){
    return Age;
   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi(phải nhập bằng chữ số)");
  }
 }
 public static String telephone(){
  while (true){
   String Telephone = sc.nextLine();
   Pattern pattern = Pattern.compile(regextelephone);
   Matcher matcher = pattern.matcher(Telephone);
   if (matcher.matches()){
    return Telephone;

   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi(bắt đầu với +84)");
  }
 }
 public static String email(){
  while (true){
   String Email = sc.nextLine();
   Pattern pattern = Pattern.compile(regexemail);
   Matcher matcher = pattern.matcher(Email);
   if (matcher.matches()){
    return Email;
   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi (abc123@gmail.com)");
  }
 }
 public static String username(){
  while (true){
   String Username = sc.nextLine();
   Pattern pattern = Pattern.compile(regexusername);
   Matcher matcher = pattern.matcher(Username);
   if(matcher.matches()){
    return Username;
   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi(tên tài khoản phải có đầy đủ cả chữ và số)");
  }
 }

 public static String password(){
  while (true){
   String Password = sc.nextLine();
   Pattern pattern = Pattern.compile(regexpassword);
   Matcher matcher= pattern.matcher(Password);
   if(matcher.matches()){
    return Password;
   }
   System.out.println("Nhập sai định dạng rồi ,nhập lại đi");
  }
 }
}
