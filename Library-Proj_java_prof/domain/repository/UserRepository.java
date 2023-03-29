package domain.repository;

import java.util.List;
import domain.model.User;

public interface UserRepository {
    // CRUD
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> findAll();

    User findById(int id);

    User findByName(String name);

    // ...
}