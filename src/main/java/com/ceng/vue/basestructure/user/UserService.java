package com.ceng.vue.basestructure.user;

import com.ceng.vue.basestructure.ExceptionFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User save(User user) {
        if (StringUtils.isEmpty(user.getEmailAddress())){
            ExceptionFactory.throwException("Email address not null", HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isEmpty(user.getUsername())){
            ExceptionFactory.throwException("Username not null", HttpStatus.BAD_REQUEST);
        }

        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
