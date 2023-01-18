package jdbc_example1;

import utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Student student = new Student("Mehmet", 25, "Ankara");
        //main.create(student);
        //main.read();
        //main.delete(3);
        //main.update(student);
        //main.readById(5);
        main.sameCityCount("Ankara");
    }

    DB db = new DB();
    List<Student> studentList = new ArrayList<>();

    public void create(Student student){
        String sql = "insert into student(name,age,city) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getCity());
            preparedStatement.executeUpdate();
            System.out.println(student.getName() + " veri tabanına eklendi.");
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void read(){
        try {
            String sql = "select * from student";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");

                Student student = new Student(id, name, age, city);
                studentList.add(student);
            }
            if (studentList.isEmpty()){
                System.out.println("List is empty");
            }else {
                studentList.forEach(System.out::println);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //crud --> create, read, update, delete
    public void delete(int id){
        try{
            String sql = "delete from student where id=?";
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            read();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void update(Student student){
        String sql = "update student set name = ?, age = ?, city = ? where id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setString(3, student.getCity());
            preparedStatement.setInt(4, student.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();

            read();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void readById(int studentId){
        String sql = "select id, name, age, city from student where id = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String city = rs.getString("city");
                Student student = new Student(id, name, age, city);
                System.out.println(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //aynı şehirde yaşayanların sayısını bulalım
    public void sameCityCount(String word){
        String sql = "select count(*) from student where city = ?";
        try {
            PreparedStatement preparedStatement = db.connection.prepareStatement(sql);
            preparedStatement.setString(1, word);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            System.out.println(word + " counted: " + rs.getInt("count(*)"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
