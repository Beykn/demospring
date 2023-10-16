package springdemo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springdemo.dao.UserRepository;
import springdemo.entity.Users;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(UserRepository theUserRepository){
        userRepository = theUserRepository;
    }
    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Users findById(int theId) {
        Optional<Users> result = userRepository.findById(theId);
        Users theUser = null;

        if(result.isPresent()){
            theUser = result.get();
        }else{
            //we did not find the user
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return null;
    }

    @Override
    public Users save(Users theUser) {
        return userRepository.save(theUser);
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);

    }
}
