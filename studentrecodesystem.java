import java.util.Scanner;
import java.sql.*;
class studentinfo {
    int rollno;
    String sname;
    String phone;
    int age;
    int classs;
    int marks;
    Connection con;
    Statement st;
    Scanner sc = new Scanner(System.in);
    private studentinfo()throws Exception{
        String url="jdbc:mysql://localhost:3306/studentdetails";
        String user="root";
        String pass="223335"; // replace with youw own password.
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection(url,user,pass);
        st=con.createStatement();
    }
    public void insertrecord()throws Exception{
        System.out.print("enter your unique rollno:");
        rollno=sc.nextInt();
        sc.nextLine();
        System.out.print("enter your name:");
        sname=sc.nextLine();
        System.out.print("enter your phone:");
        phone=sc.nextLine();
        System.out.print("enter your age:");
        age=sc.nextInt();
        System.out.print("enter your class");
        classs=sc.nextInt();
        System.out.print("enter your marks:");
        marks=sc.nextInt();
        boolean checkrecordexist=checkexsit(rollno);
        if(!checkrecordexist){
            String str = "insert into studentinfo values(" + rollno + ", '" + sname + "', '" + phone + "', " + age + ", " + classs + ", " + marks + ")";
            st.executeUpdate(str);
            System.out.println("record successfully upload!!");
        }else{
            System.out.println("--> already a person is avalable with rollno "+rollno);
            System.out.println("--> rollno should be unique");
            System.out.println();
        }
    }
    public boolean checkexsit(int rolno)throws Exception{
        String str = "select exists(select 1 from studentinfo where rollno="+rolno+")";
        ResultSet rs=st.executeQuery(str);
        rs.next();
        return rs.getInt(1) == 1;
    }
    public void displayrecord(int rol)throws Exception{
        ResultSet rs=st.executeQuery("select rollno,sname,sphone,sage,sclass,marks from studentinfo where rollno="+rol);
        if (rs.next()) {
            System.out.println("------------Student details------------");
            System.out.println("student rollno:" + rs.getInt(1) + "\n" + "student name:" + rs.getString(2) + "\n" +
                    "student phone no:" + rs.getString(3) + "\n" + "student age:" + rs.getInt(4) + "\n" +
                    "student class:" + rs.getInt(5) + "\n" + "student marks:" + rs.getInt(6));
            System.out.println("---------------------------------------");
        }else{
            System.out.println("--------------------------");
            System.out.println("rollno is not exsisted!!!");
            System.out.println("--------------------------");
        }
    }
    public int togetrollno()throws Exception{
        System.out.print("enter the rollno:");
        int rol = sc.nextInt();
        displayrecord(rol);
        return rol;
    }
    public void updaterecord()throws Exception{
        System.out.print("enter your roll no to update the record:");
        int rol=sc.nextInt();
        sc.nextLine();
        System.out.print("which attribute you want to updata(name,phone,age,class,marks):");
        String str=sc.nextLine();
        String hold="",sql="";
        int holdt=0;
        if(str.equals("name")){
            System.out.print("enter the new name:");
            hold=sc.nextLine();
            sql="update studentinfo set sname='"+hold+"' where rollno="+rol;
            st.executeUpdate(sql);
            displayrecord(rol);
        }else if(str.equals("phone")){
            System.out.print("enter the new phone no:");
            hold=sc.nextLine();
            sql="update studentinfo set sphone='"+hold+"' where rollno="+rol;
            st.executeUpdate(sql);
            displayrecord(rol);
        }else if(str.equals("age")){
            System.out.print("enter the new age:");
            holdt=sc.nextInt();
            sql="update studentinfo set sage='"+holdt+"' where rollno="+rol;
            st.executeUpdate(sql);
            displayrecord(rol);
        }else if(str.equals("class")){
            System.out.print("enter the new class:");
            holdt=sc.nextInt();
            sql="update studentinfo set sclass='"+holdt+"' where rollno="+rol;
            st.executeUpdate(sql);
            displayrecord(rol);
        }else if(str.equals("marks")){
            System.out.print("enter the new marks:");
            holdt=sc.nextInt();
            sql="update studentinfo set marks='"+holdt+"' where rollno="+rol;
            st.executeUpdate(sql);
            displayrecord(rol);
        }else{
            System.out.println("you can only update above mentioned attributes.");
        }
    }
    public void deleterecord()throws Exception{
         int hold=togetrollno();
         String sql="delete from studentinfo where rollno="+hold;
         st.executeUpdate(sql);
         System.out.println("record deleted form database!");
    }
    public void displayallrecord()throws Exception{
        String sql="select *from studentinfo";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            System.out.println("------------"+rs.getString(2)+" student details------------");
            System.out.println("student rollno:" + rs.getInt(1) + "\n" + "student name:" + rs.getString(2) + "\n" +
                    "student phone no:" + rs.getString(3) + "\n" + "student age:" + rs.getInt(4) + "\n" +
                    "student class:" + rs.getInt(5) + "\n" + "student marks:" + rs.getInt(6));
            System.out.println("----------------------------------------------------------");
        }
    }
    public static studentinfo createobeject()throws Exception{
        return new studentinfo();
    }
}
public class studentrecodesystem {
    public static void main(String[] args)throws Exception{
        String tri;
        Scanner sc = new Scanner(System.in);
        studentinfo obj = studentinfo.createobeject();
        do{
            System.out.println("1.insert record");
            System.out.println("2.display record");
            System.out.println("3.update record");
            System.out.println("4.delete record");
            System.out.println("5.display all records");
            System.out.println("t.for exit");
            System.out.print("enter your option:");
            tri=sc.next();
            switch (tri) {
                case "1" -> obj.insertrecord();
                case "2" -> obj.togetrollno();
                case "3" -> obj.updaterecord();
                case "4" -> obj.deleterecord();
                case "5" -> obj.displayallrecord();
                default -> {
                    if(!tri.equals("t")) System.out.println("choose options above mentioned!!");
                }
            }
        }while (!tri.equals("t"));
    }
}
