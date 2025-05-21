package com.shiva.service;

import com.shiva.model.User;
import com.shiva.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
   // private List<User> userList = new ArrayList<>();
    private  final UserRepository userRepository;
    //private  Long idCounter = 1L;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public void createUser(User user) {
//        user.setId(String.valueOf(idCounter++));
//        userList.add(user);
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
     //  return  userList.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
        return userRepository.findById(id);
    }

    public Optional<User> updateInfoById(Long id, User user) {
//        userList.forEach(val -> {
//            if(val.getId().equals(id)){
//                val.setEmail(user.getEmail());
//                val.setFirstName(user.getFirstName());
//            }
//        });
//        return userList.stream().filter(val -> val.getId().equals(id)).findFirst();

//        return userList.stream()
//                .filter(val -> val.getId().equals(id))
//                .peek(val -> {
//                    val.setEmail(user.getEmail());
//                    val.setFirstName(user.getFirstName());
//                })
//                .findFirst();
        //using JPA
         return  userRepository.findById(id).map(val -> {
                    val.setEmail(user.getEmail());
                    val.setFirstName(user.getFirstName());
                    return userRepository.save(val);
                });
    }
}
