package com.vilca.sugarapp.Repository;

import com.orm.SugarRecord;
import com.vilca.sugarapp.Model.User;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User read(Long id){
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void create(String fullname, String email, String password){
        User user = new User(fullname, email, password);
        SugarRecord.save(user);
    }

    public static void delete(Long id){
        User user=SugarRecord.findById(User.class,id);
        SugarRecord.delete(user);
    }
}
