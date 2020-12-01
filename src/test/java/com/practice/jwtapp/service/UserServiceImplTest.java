package com.practice.jwtapp.service;

import com.practice.jwtapp.model.User;
import com.practice.jwtapp.model.UserDataTransferObject;
import com.practice.jwtapp.repository.UserRepository;
import com.practice.jwtapp.testUtil.TestUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    BCryptPasswordEncoder passwordEncoder;
    private TestUtil testUtil;


    @BeforeEach
    public void setup() {
        testUtil = new TestUtil();
        userService = new UserServiceImpl();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByUsername() {
        Mockito.when(userRepository.findByUsername("defaultUser")).thenReturn(Optional.of(testUtil.createTestUser()));
        User user = userService.findByUsername("defaultUser");
        assertEquals(user.getUsername(), "defaultUser");
        Mockito.verify(userRepository, times(1)).findByUsername("defaultUser");
    }

    @Test
    public void usernameNotFound() {
        assertThrows(UsernameNotFoundException.class, () -> {
            userService.findByUsername("defaultUser");
        });
    }

    @Test
    public void saveUser() {
        User mockUser = testUtil.createTestUser();
        UserDataTransferObject userDto = testUtil.createUserDto();
        Mockito.when(userRepository.save(mockUser)).thenReturn(mockUser);
        Mockito.when(passwordEncoder.encode(anyString())).thenReturn(anyString());

        User resultUser =  userService.saveUser(userDto);

        assertEquals("defaultUser", resultUser.getUsername());
    }
}