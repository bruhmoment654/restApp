package ru.cs.vsu.storage.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.cs.vsu.storage.entity.UserEntity;
import ru.cs.vsu.storage.exceptions.UserAlreadyExistException;
import ru.cs.vsu.storage.exceptions.UserNotFoundException;
import ru.cs.vsu.storage.model.User;
import ru.cs.vsu.storage.repo.UserRepo;

@Service
@AllArgsConstructor
public class UserService {
    UserRepo userRepo;

    public UserEntity register(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("user with this name exists");
        }
        userRepo.save(user);
        return user;
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("user doesn't exist");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
