package springdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springdemo.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
