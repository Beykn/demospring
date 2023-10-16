package springdemo.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springdemo.entity.Users;
import springdemo.service.UsersService;

import java.util.List;

@RestController
public class UserRestController {
    private UsersService usersService;


    //This dependency injection makes it easier to create and manage the object.
    @Autowired
    public UserRestController(UsersService theUsersService){
        usersService = theUsersService;
    }

    // expose "/users" and return a list of employees
    @GetMapping("/users")
    public List<Users> findAll(){
        return usersService.findAll();
    }

    //add mapping for GET /users({userId}
    //The purpose of this code block is to find the user with the id given as a parameter using the HTTP GET request.
   //If we find the user return user information but we cannot throw an exception
    @GetMapping("/users({userId}")
    public Users getUsers(@PathVariable int id){
        Users theUser = usersService.findById(id);
        if(theUser == null){
            throw  new RuntimeException("Users id not found - " + id);
        }
        return theUser;
    }

    //add mapping for POST /users -add new user
    //The purpose of this block of code is to register the new user whose information is given in JSON format using an HTTP POST request and return this new information.
    @PostMapping("/users")
    public Users addUser(@RequestBody Users theUser){
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        //We use this line when we add a user to make it harder to add them without using an existing id
        theUser.setId(0);
        //this part registers the user
        Users dbUser = usersService.save(theUser);
        //in the end we return the registered user
        return dbUser;
    }

    //add mapping for PUT /users -update existing user
    //The purpose of this block of code is te update the existing user using an HTTP PUT request.In this part information also given JSON format
    @PutMapping("/users")
    public Users updateUser(@RequestBody Users theUser){
        Users dbUser =usersService.save(theUser);
        return dbUser;
    }

    //add mapping for DELETE /users/{id} - delete user

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id){
        Users theUser = usersService.findById(id);

        //if we cannot find the user throw an exception

        if(theUser == null){
            throw new RuntimeException("User id not found- " + id);
        }

        return "Deleted user id - " + id;
    }

}
