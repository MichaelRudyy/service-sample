package ch.efg.sample.services;

import ch.efg.sample.api.IUser;
import ch.efg.sample.api.IUserService;
import ch.efg.sample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service that impl IUserService
 * @author michaelrudyy
 * @version 1.3
 */

@Service
public class UserService implements IUserService<IUser, String> {

    @Autowired
    UserRepository userRepository;
    /**
     * Return all users
     * @return list of users
     */
    public List<IUser> findAll() {
        return userRepository.getAllUsers();
    }

    /**
     * Return list of users with id == s
     * @param s
     * @return list of users
     */
    public List<IUser> findById(String s) {
        return userRepository.getUserById(s);
    }

    /**
     * Delete User
     * @param var1
     * @return User that was deleted
     */
    public IUser delete(String var1) {
        return userRepository.deleteUser(var1);
    }

    /**
     * Group All by Group ID
     * @return map of String & List of iUser
     */
    public Map<String, List<IUser>> findAllGroupByGroupId() {

        Map<String,List<IUser>> userMap = userRepository.getAllUsers()
                .stream()
                .collect(
                        Collectors.groupingBy(IUser::getId))
                ;

        return userMap;
    }

    /**
     * Save User
     * @param var1
     * @return Obj that was saved
     */
    public IUser save(IUser var1) {
        return userRepository.saveUser(var1);
    }
    /**
     * Save All Users
     * @param var1
     * @return
     */
    public List<IUser> saveAll(Iterable var1) {
        return userRepository.saveAll(var1);
    }


}
