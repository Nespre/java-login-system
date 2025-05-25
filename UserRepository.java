import java.util.HashMap;

public class UserRepository {
    //Retem uma chave (username) e o valor (class User com todas as infos)
    private HashMap<String, User> loginsInfo = new HashMap<>();

    //Adiciona users ao repositorio
    public void addUser(User user){
        loginsInfo.put(user.getUsername(), user);
    }

    //Obter o User através do username
    public User getUser(String username) {
        return loginsInfo.get(username);
    }

    //Verifica se User já existe
    public boolean userExists(String username) {
        return loginsInfo.containsKey(username);
    }
}

