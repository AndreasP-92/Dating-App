//package com.example.datingApp.DatingApp.services;
//
//import com.example.datingApp.DatingApp.UserRepository;
//import com.example.datingApp.DatingApp.models.MyUserDetails;
//import com.example.datingApp.DatingApp.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service("userDetailsService")
//public class MyUserDetailsService02 implements UserDetailsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        Optional<User> user = userRepository.findByUserName(userName);
//
//        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
//
//        return user.map(MyUserDetails::new).get();
//
//    }
//}
