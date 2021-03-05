package edu.eci.ieti.lab6.services;

import edu.eci.ieti.lab6.entities.Task;
import edu.eci.ieti.lab6.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAll() throws ServiceException;

    User getById(String userId) throws ServiceException;

    User create(User user) throws ServiceException;

    User update(String id, User user);

    void remove(String userId);

    void addTask(String userId, Task task) throws ServiceException;

}
