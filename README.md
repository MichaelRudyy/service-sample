# Rest Service 
This RESTful service provide implementation of `IUser` and `IUserService`

### How it works

`UserRepository` store `User`'s (it's hard coded). Functionality of `UserRepository` uses in `UserService` to get, modify and delete `User`'s.
User can communicate with service throught `UserController`, RESTful contorller that dublicate functionality of `UserService`.

### How test it

There is some requests that you can test:

**Get users with ID = 1** 

_GET_ `localhost:8080/user/1`

**Get all users** 

_GET_ `localhost:8080/user/all` 

**Get group by ID users** 

_GET_ `localhost:8080/user/groupById`

**Add user**

_POST_ `localhost:8080/user/`

_Body_ : `{
        	"id": "100",
        	"name": "Terminator",
        	"groupId": "10"
        }`
        
**Add 2 user's (and more)**

_POST_ `localhost:8080/user/addList`

_Body_ : `[
          	{
          		"id": "200",
          		"name": "T200",
          		"groupId": "10"
          	},
          	{
          		"id": "300",
          		"name": "M300",
          		"groupId": "10"
          	}
          ]`
          
**Delete user by ID = 300**
_DELETE_ `localhost:8080/user/300`
 