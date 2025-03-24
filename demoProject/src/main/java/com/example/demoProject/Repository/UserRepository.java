package com.example.demoProject.Repository;

import com.example.demoProject.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    private JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getUsers(){
        String sqlQueryForGetAllUsers = "SELECT * FROM USERS";
        List<User>  usersList = new ArrayList<>();
        jdbcTemplate.query(sqlQueryForGetAllUsers, rs -> { //resultSet
                int id = rs.getInt("ID");
                String name = rs.getString("NAME");
                String surname = rs.getString("SURNAME");
                int age = rs.getInt("AGE");

                usersList.add(new User(id, name, surname, age));

        });
       return usersList;
    }
 /*   public int getLastID(){
        String sqlQuery = "SELECT MAX(\"ID\") FROM USERS";
        return jdbcTemplate.queryForObject(sqlQuery, Integer.class);
    }*/

    public User getUserById(int id){
        String sqlQueryForGetUserById = "SELECT * FROM USERS WHERE \"id\"  = ?";
        return jdbcTemplate.queryForObject(sqlQueryForGetUserById, (rs, rowNum) -> {
            int userId = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            int age = rs.getInt("age");

            return new User(userId, name, surname,age);
        }, id);
    }

    public void addUser(User user){
       // int newId = getLastID() + 1 ;
        String sqlQueryAddUser = "INSERT INTO USERS (\"name\", \"surname\", \"age\") VALUES (?,  ?, ?)";
        jdbcTemplate.update(sqlQueryAddUser,  user.getName(), user.getSurname(), user.getAge());

    }

    public void updateUser(int id, User user){
        String sqlQueryUpdatedUser = "UPDATE USERS SET \"name\" = ?, \"surname\" = ?, \"age\" = ? WHERE \"id\" = ?";
        jdbcTemplate.update(sqlQueryUpdatedUser, user.getName(), user.getSurname(), user.getAge(), id);

    }

    public void deleteUser(int id){
        String sqlQueryDeleteUser = "DELETE FROM USERS WHERE \"id\"  = ?";
        jdbcTemplate.update(sqlQueryDeleteUser, id);

    }




}
