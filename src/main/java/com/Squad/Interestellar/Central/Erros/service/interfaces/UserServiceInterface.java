package com.Squad.Interestellar.Central.Erros.service.interfaces;

import com.Squad.Interestellar.Central.Erros.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {


 Optional<User> findByLogin(String login);

    User save(User user);
}
