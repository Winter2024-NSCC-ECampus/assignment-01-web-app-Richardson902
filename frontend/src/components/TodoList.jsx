import React, { useState, useEffect } from "react";
import Todo from "./Todo";
import { getTodos, updateTodo, deleteTodo } from "../services/TodoService";
import AddTodo from "./AddTodo";

function TodoList() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    const fetchTodos = async () => {
      try {
        const response = await getTodos();
        console.log(response);
        setTodos(response.data);
      } catch (error) {
        console.error("Error fetching todos:", error);
      }
    };

    fetchTodos();
  }, []);

  const refreshTodos = async () => {
    try {
      const response = await getTodos();
      setTodos(response.data);
    } catch (error) {
      console.error("Error refreshing todos:", error);
    }
  };

  const handleUpdateTodo = async (id, updatedTodo) => {
    try {
      await updateTodo(id, updatedTodo);
      setTodos(todos.map((todo) => (todo.id === id ? updatedTodo : todo)));
    } catch (error) {
      console.error("Error updating todo:", error);
    }
  };

  const handleDeleteTodo = async (id) => {
    try {
      await deleteTodo(id);
      setTodos(todos.filter((todo) => todo.id !== id));
    } catch (error) {
      console.error("Error deleting todo:", error);
    }
  };

  return (
    <>
      <AddTodo onAddTodo={refreshTodos} />
      <div className="max-w-xl mx-auto bg-[#f1ece6] rounded-2xl p-4 shadow-md mt-8">
        {todos.length === 0 ? (
          <p className="text-[#dc892f] text-center">No todos available</p>
        ) : (
          todos.map((todo) => (
            <Todo
              key={todo.id}
              todo={todo}
              onUpdate={handleUpdateTodo}
              onDelete={handleDeleteTodo}
            />
          ))
        )}
      </div>
    </>
  );
}

export default TodoList;
