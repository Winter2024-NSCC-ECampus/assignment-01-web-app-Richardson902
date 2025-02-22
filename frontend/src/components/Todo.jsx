import React, { useState } from "react";

function Todo({ todo, onUpdate, onDelete }) {
  const handleCheckboxChange = () => {
    onUpdate(todo.id, { ...todo, completed: !todo.completed });
  };

  const handleDeleteClick = () => {
    onDelete(todo.id);
  };

  return (
    <div className="flex items-center justify-between p-2 border-b border-gray-300">
      <label className="flex items-center space-x-2">
        <input
          type="checkbox"
          checked={todo.isCompleted}
          onChange={handleCheckboxChange}
          className="form-checkbox"
        />
        <span
          className={`text-lg ${
            todo.completed ? "line-through text-gray-500" : ""
          }`}
        >
          {todo.title}
        </span>
      </label>

      <button
        onClick={handleDeleteClick}
        className="ml-4 px-3 py-1 text-white bg-red-500 hover:bg-red-600 rounded-md"
      >
        Delete
      </button>
    </div>
  );
}

export default Todo;
