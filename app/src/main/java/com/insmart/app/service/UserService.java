package com.insmart.app.service;

import com.insmart.app.model.User;
import com.insmart.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User update(User user,Long id) {
        User user1 = userRepository.findById(id).get();
        user1.setDescription(user.getDescription());
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        return userRepository.save(user);
    }
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByUsernameAndPassword(String username,String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}
