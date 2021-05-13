package com.Squad.Interestellar.Central.Erros.controller;

import com.Squad.Interestellar.Central.Erros.entity.User;
import com.Squad.Interestellar.Central.Erros.service.impl.UserService;
import io.swagger.annotations.ApiOperation;
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

    @PostMapping
    @ApiOperation(value = "Cadastra um usuário")
    public ResponseEntity<String> create(@Valid @RequestBody User user) {
        this.userService.save(user);
        return new ResponseEntity<String>("Usuário cadastrado com sucesso", HttpStatus.CREATED);

 }

}
