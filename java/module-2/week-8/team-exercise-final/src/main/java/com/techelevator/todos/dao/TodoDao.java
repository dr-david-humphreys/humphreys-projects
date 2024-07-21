package com.techelevator.todos.dao;

import com.techelevator.todos.model.Todo;
import java.util.List;

public interface TodoDao {
    // Create
    Todo createTodo(Todo todo);
    // Read
    List<Todo> getTodos(String user);
    Todo getTodoById(int id);
    List<Todo> getTodosByTask(String searchTerm, String user);

    // Update
    Todo updateTodo(Todo todo);

    // Delete
    int deleteTodoById(int todoId);
}
