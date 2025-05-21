package com.shiva.repository;

import com.shiva.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository <User, Long>{

 //   List<User> id(String Long);
}
