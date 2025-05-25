public class AuthService {
    private final UserRepository repository;

    public AuthService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean login(String username, String password) {
        User user = repository.getUser(username);
        if (repository.userExists(username)){
            return (user.getPassword().equals(password));
        }
        else{return false;}
    }

    public boolean register(String name, String username, String password) {
        if (repository.userExists(username)) {
            return false;}
        else {
            repository.addUser(new User(name, username, password));
            return true;}
    }
}

