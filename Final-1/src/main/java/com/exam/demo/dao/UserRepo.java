package com.exam.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.User;

public interface UserRepo extends CrudRepository<User,Integer>{

}
