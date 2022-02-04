package com.digidwarf.loginregistrauthservice.security;

import com.digidwarf.loginregistrauthservice.model.User;
import com.digidwarf.loginregistrauthservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository ;

    @Override
    public CurrentUser loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(s);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("user with" + s + "does not exist");
        }
        return new CurrentUser(user.get());
    }


}

