package edu.eci.ieti.lab6.services;

import edu.eci.ieti.lab6.entities.Task;
import edu.eci.ieti.lab6.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceStub")
public class UserServiceStub implements UserService {

    private List<User> users = new ArrayList<>();


    public UserServiceStub() {
        users.add(new User("1", "Juan Frasica", "juan@mail.com", "s3b4stian"));
        users.add(new User("2", "Daniel López", "daniel@mail.com", "daniel123"));
        users.add(new User("3", "María Paez", "maria@mail.com", "m4ria12345"));
    }

    @Override
    public List<User> getAll() throws ServiceException {
        if (users.isEmpty()) {
            throw new ServiceException("There are no users");
        } else {
            return users;
        }
    }

    @Override
    public User getById(String userId) throws ServiceException {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new ServiceException("That user doesn´t exists");
    }

    @Override
    public User create(User user) throws ServiceException {
        for (User u : users) {
            if (u.getId().equals(user.getId())) {
                throw new ServiceException("User already registered");
            }
        }
        users.add(user);
        return user;
    }

    @Override
    public User update(String id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id)) {
                users.set(i, user);
            }
        }
        return user;
    }

    @Override
    public void remove(String userId) {
        users.removeIf(i -> i.getId().equals(userId));
    }

    @Override
    public void addTask(String userId, Task task) throws ServiceException {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                users.get(i).addTask(task);
            }
        }
        throw new ServiceException("That user doesn´t exists");
    }
}
