package ch.efg.sample.repository;

import java.util.List;

public interface IUserRepository<T> {

    // Get
    List<T> getUserById(String id);
    List<T> getAllUsers();

    // Save
    T saveUser(T user);
    List<T> saveAll(Iterable<T> list);

    // Delete
    T deleteUser(String id);
}
