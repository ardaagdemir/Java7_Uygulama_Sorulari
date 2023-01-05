package com.bilgeadam.hibernateexample1.manager;

import com.bilgeadam.hibernateexample1.entity.User;
import com.bilgeadam.hibernateexample1.repository.ICrud;
import com.bilgeadam.hibernateexample1.repository.UserRepository;

import java.util.List;

public class UserManager  {
    static UserRepository userRepository = new UserRepository();
    public static void main(String[] args) {

        userRepository.setup();
        //save();
        //update();
        deleteById(1);
        getAll();
        userRepository.exit();
    }


    /*public static void save(){
        User user1 = new User( "c", "c", "c", "b");
        userRepository.save(user1);
    }*/
    public static void getAll(){
        List<User> userList = null;
        try{
            userList = userRepository.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        for (User user : userList){
            System.out.println(user);
        }
    }
    /*public static void update(){
        User user = new User(1, "A", "B", "C", "D");
        try{
            userRepository.update(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Güncelleme başarısız");
        }
    }*/

    public static void deleteById(int id){
        try{
            userRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
