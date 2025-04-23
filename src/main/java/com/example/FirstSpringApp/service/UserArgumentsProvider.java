//package com.example.FirstSpringApp.service;
//
//import org.junit.jupiter.api.extension.*;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.stream.Stream;
//
//public class UserArgumentProvider implements ArgumentsProvider {
//
//    @Override
//    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
//        return Stream.of(
//                Arguments.of(User.withUsername("shyam").password("shyam").roles("USER").build()),
//                Arguments.of(User.withUsername("suraj").password("suraj").roles("USER").build())
//        );
//    }
//}
