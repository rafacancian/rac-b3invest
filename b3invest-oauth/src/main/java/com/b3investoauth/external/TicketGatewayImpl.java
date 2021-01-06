package com.b3investoauth.external;

import com.b3investoauth.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TicketGatewayImpl implements TicketGateway {

    private final UserFeignClient userFeignClient;

    //Used just to test
    public User findByEmail(final String email) {
        log.info("UserService findByEmail: {}", email);

        final User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("Email found: " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        log.info("UserService loadUserByUsername: {}", username);
        final User user = userFeignClient.findByEmail(username).getBody();
        if (user == null) {
            log.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }
        log.info("Email found: " + username);
        return user;
    }

}
