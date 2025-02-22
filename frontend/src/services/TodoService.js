import axios from "axios";

export const getTodos = () => axios.get("/api/todos/");

export const addTodo = (todo) => axios.post("/api/todos/", todo);

export const updateTodo = (id, updatedTodo) =>
  axios.put(`/api/todos/${id}`, updatedTodo);

export const deleteTodo = (id) => axios.delete(`/api/todos/${id}`);
