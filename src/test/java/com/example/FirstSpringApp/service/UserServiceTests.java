package com.example.FirstSpringApp.service;

import com.example.FirstSpringApp.entity.User;
import com.example.FirstSpringApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSources;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import com.*;
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @ParameterizedTest
//    @CsvSource({
//            "Mukesh",
//            "harsh",
//            "Lakshay"
//    })
//    @ValueSource(strings = {
//            "Mukesh",
//            "harsh",
//            "Lakshay"
//    })
    @ArgumentsSources(UserArgumentsProvider.class)
    public void testFindByUserName(User user)
    {
        assertTrue(userService.saveNewUser(user));
    }
    public void testFindByUserName(String name)
    {
          assertNotNull(userRepository.findByUserName(name),"Failed for the name of :"+name);
//        User user = userRepository.findByUserName(name);
//        assertTrue(user.getJournalEntries().isEmpty());
    }
//    @Test
@Disabled
@ParameterizedTest
@CsvSource({
       "3,1,2",
        "22,10,12",
        "3,3,0"
})
    public void test(int expected,int a,int b)
    {
        assertEquals(expected,a+b);
    }
//        assertTrue(5 > 3);
//        assertNotNull(userRepository.findByUserName("Mukesh"));
//        assertEquals(4,2+2);
//    public void testAdd()
//    {
//        assertEquals(4,2+2);
//    }
}
