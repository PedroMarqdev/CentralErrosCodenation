package com.Squad.Interestellar.Central.Erros.controller;

import com.Squad.Interestellar.Central.Erros.entity.User;
import com.Squad.Interestellar.Central.Erros.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

 @Autowired
 private UserService userService;

 @GetMapping
 public Iterable<User> listAll() {
	return this.userService.findAll();
 }

 @PostMapping
 public ResponseEntity<User> create(@Valid @RequestBody final User user) {

	return new ResponseEntity<User>(this.userService.save(user), HttpStatus.CREATED);

 }

}
