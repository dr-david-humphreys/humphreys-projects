package com.techelevator.todos.controller;

import com.techelevator.todos.dao.TodoDao;
import com.techelevator.todos.exception.DaoException;
import com.techelevator.todos.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class TodoController {
    private final TodoDao todoDao;

    public TodoController(TodoDao dao) {
        this.todoDao = dao;
    }

    @RequestMapping(path = "/todos", method = RequestMethod.GET)
    public List<Todo> list(Principal user) {
        return todoDao.getTodos(user.getName());
    }

    @RequestMapping(path = "/todos/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable int id, Principal user) {
        Todo result = todoDao.getTodoById(id);
        if (result == null) {
            // 404 Not found
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }

        // Ensure user is the creator or a collaborator
        if (result.userHasPermission(user.getName())) {
            return result;
        } else {
            // 403 Forbidden
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not creator or collaborator");
        }
    }

    @RequestMapping(path = "/todos/search", method = RequestMethod.GET)
    public List<Todo> getByTask(@RequestParam String task, Principal user) {
        return todoDao.getTodosByTask(task, user.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/todos", method = RequestMethod.POST)
    public Todo add(@Valid @RequestBody Todo todo, Principal user) {
        String username = user.getName();
        todo.setCreatedBy(username);
        Todo newTodo = todoDao.createTodo(todo);
        return newTodo;
    }

    @RequestMapping(path = "/todos/{id}", method = RequestMethod.PUT)
    public Todo update(@Valid @PathVariable int id, @RequestBody Todo todo, Principal user) {
        // Confirm the id's match
        if (todo.getId() != id) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Todo id must match id in path");
        }

        // Ensure the Todo exists and the user is authorized to access it
        Todo retrievedTodo = todoDao.getTodoById(id);
        if (retrievedTodo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
        if (!retrievedTodo.userHasPermission(user.getName())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have access to this Todo");
        }

        // If made it here, user is allowed to update the Todo
        try {
            Todo updatedTodo = todoDao.updateTodo(todo);
            return updatedTodo;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error updating todo", e);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/todos/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        if (todoDao.deleteTodoById(id) == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found");
        }
    }
}

