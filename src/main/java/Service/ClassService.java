package Service;

import Model.Clasez;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassService implements IClasezService<Clasez> {
    private Connection connection = ConnectionToMySql.getConnection();

    @Override
    public boolean add(Clasez clasez) {
        return false;
    }

    @Override
    public boolean edit(Clasez clasez, int id) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Clasez> findAll() {
        List<Clasez> clasezList = new ArrayList<>();
        String sql = "select *from classRoom;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("classname");
                Clasez clasez = new Clasez(id, name);
                clasezList.add(clasez);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clasezList;
    }

    @Override
    public List<Clasez> findProductByName(String nameFind) {
        return null;
    }
}
