package ru.cs.vsu.storage.repo;

import org.springframework.data.repository.CrudRepository;
import ru.cs.vsu.storage.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

}
