package Service;

import Model.Clasez;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student> {
    private final Connection connection = ConnectionToMySql.getConnection();

    @Override
    public boolean add(Student student) {
        String sql = "INSERT INTO student (name, email, dateOfBirth, address, phoneNumber, classRoomId) VALUES (?,?,?,?,?,?);";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateOfBirth());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setInt(6, student.getClasez().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean edit(Student student, int id) {
        String sql = "update student set name =?,email=?,dateOfBirth=?,address=?,phoneNumber=?,classRoomId=? where id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getEmail());
            statement.setString(3, student.getDateOfBirth());
            statement.setString(4, student.getAddress());
            statement.setString(5, student.getPhoneNumber());
            statement.setInt(6, student.getClasez().getId());
            statement.setInt(7, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        String sql = "select s.*,cR.className from student s join classRoom cR on cR.id = s.classRoomId;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phoneNumber");
                int classId = resultSet.getInt("classRoomId");
                String classname = resultSet.getString("className");
                Clasez clasez = new Clasez(classId, classname);
                Student student = new Student(id, name, email, date, address, phone, clasez);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public List<Student> findProductByName(String nameFind) {
        List<Student> studentList = new ArrayList<>();
        String sql = "select s.*,cR.className from student s join classRoom cR on cR.id = s.classRoomId and s.name like ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nameFind + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phoneNumber");
                int classId = resultSet.getInt("classRoomId");
                String classname = resultSet.getString("className");
                Clasez clasez = new Clasez(classId, classname);
                Student student = new Student(id, name, email, date, address, phone, clasez);
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    @Override
    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String date = resultSet.getString("dateOfBirth");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phoneNumber");
                int classId = resultSet.getInt("classRoomId");
                Clasez clasez = new Clasez(classId);
                Student student = new Student(id, name, email, date, address, phone, clasez);
                return student;
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
