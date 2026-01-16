package com.Attendance.AttendanceManagement.security.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.Attendance.AttendanceManagement.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

        private final UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username)
                        throws UsernameNotFoundException {

                var user = userRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException("Invalid username"));

                return org.springframework.security.core.userdetails.User
                                .withUsername(user.getUsername())
                                .password(user.getPassword())
                                .roles(user.getRole())
                                .disabled(!user.isEnabled())
                                .build();

        }
}
