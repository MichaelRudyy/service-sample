package ch.efg.sample.rest;

import ch.efg.sample.api.IUser;
import ch.efg.sample.model.User;
import ch.efg.sample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String greeting(){
        return "User Rest Controller";
    }

    @GetMapping("/{id}")
    public List<IUser> getUserById(@PathVariable("id") String id){
        return userService.findById(id);
    }

    @PostMapping("/")
    public IUser addUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/addList")
    public List<IUser> addUsers(@RequestBody ArrayList<User> list){
        return userService.saveAll(list);
    }

    @DeleteMapping("/{id}")
    public IUser deleteUserById(@PathVariable("id") String id){
        return userService.delete(id);
    }

    @GetMapping("/groupById")
    public Map<String,List<IUser>> getGroupByGroupId(){
        return userService.findAllGroupByGroupId();
    }

    @GetMapping("/all")
    public List<IUser> getAllUsers(){
        return userService.findAll();
    }

}
