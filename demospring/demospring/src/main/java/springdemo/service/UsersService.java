package springdemo.service;

import org.springframework.stereotype.Service;
import springdemo.entity.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findById(int theId);

    Users save(Users theUsers);

    void deleteById(int theId);
}
