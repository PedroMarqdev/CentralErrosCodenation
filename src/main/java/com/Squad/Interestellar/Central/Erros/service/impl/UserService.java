package com.Squad.Interestellar.Central.Erros.service.impl;

import com.Squad.Interestellar.Central.Erros.entity.User;
import com.Squad.Interestellar.Central.Erros.repository.UserRepository;
import com.Squad.Interestellar.Central.Erros.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface {

 @Autowired
 private UserRepository userRepository;

 @Override
 public Optional<User> findByLogin(final String login) {
	return userRepository.findByLogin(login);
 }

 @Override
 public List<User> findAll() {
	return userRepository.findAll();
 }

 @Override
 public User save(final User user) {
	user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	return userRepository.save(user);
 }
}
