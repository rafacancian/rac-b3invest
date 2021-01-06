package com.b3investoauth.external;


import com.b3investoauth.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface TicketGateway {

    User findByEmail(final String email);
    
    UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException;

}
