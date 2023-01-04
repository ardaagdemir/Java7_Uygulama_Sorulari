package com.bilgeadam.hibernateexample1.manager;

import com.bilgeadam.hibernateexample1.entity.User;
import com.bilgeadam.hibernateexample1.repository.ICrud;
import com.bilgeadam.hibernateexample1.repository.UserRepository;

public class UserManager  {
    public static void main(String[] args) {

        User user1 = new User( "c", "c", "c", "b");

        UserRepository userRepository = new UserRepository();
        userRepository.setup();
        userRepository.save(user1);
        userRepository.exit();
    }


}
