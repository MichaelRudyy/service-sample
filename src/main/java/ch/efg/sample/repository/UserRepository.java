package ch.efg.sample.repository;

import ch.efg.sample.api.IUser;
import ch.efg.sample.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository<IUser> {

    static List<IUser> userList = new ArrayList<>();

    @PostConstruct
    static void generateUserList(){
        userList.add(new User("0","Mark","0"));
        userList.add(new User("1","Jeff","1"));
        userList.add(new User("2","Mike","0"));
        userList.add(new User("3","Kristen","2"));
        userList.add(new User("2","Dark side of Mike","3"));
    }


    @Override
    public List<IUser> getUserById(String id) {
        return userList.
                stream().
                filter(
                        user -> user.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<IUser> getAllUsers() {
        return userList;
    }

    @Override
    public IUser saveUser(IUser user) {
        userList.add(user);
        return user;
    }

    @Override
    public List<IUser> saveAll(Iterable<IUser> userIterable) {
        List<IUser> list = new ArrayList<>();
        userIterable.forEach(u->list.add(u));
        userList.addAll(list);
        return list;
    }

    @Override
    public IUser deleteUser(String id) {
        Optional<IUser> user = userList.stream().filter(u->u.getId().equals(id)).findFirst();
        user.ifPresent(iUser -> userList.remove(iUser));
        return user.orElse(null);
    }
}
