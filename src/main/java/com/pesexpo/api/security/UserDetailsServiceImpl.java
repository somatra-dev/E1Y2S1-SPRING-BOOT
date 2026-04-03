package com.pesexpo.api.security;

import com.pesexpo.api.spring_structure.domain.Role;
import com.pesexpo.api.spring_structure.domain.UserEntity;
import com.pesexpo.api.spring_structure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        log.info("User found: {}", user.getUsername());
        log.info("User roles: {}", user.getRoles().stream().map(Role::getName).toList());

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getEncryptedPassword())
                .roles(
                        user.getRoles().stream()
                                .map(Role::getName)
                                .toArray(String[]::new)
                )
                .build();
    }

}
