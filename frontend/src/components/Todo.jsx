import React, { useState } from "react";

function Todo({ todo, onUpdate, onDelete }) {
  const handleCheckboxChange = () => {
    onUpdate(todo.id, { ...todo, completed: !todo.completed });
  };

  const handleDeleteClick = () => {
    onDelete(todo.id);
  };

  return (
    <div className="flex items-center justify-between p-4 border-b border-[#d1cbc4]">
      <label className="flex items-center space-x-3 flex-grow">
        <input
          type="checkbox"
          checked={todo.completed}
          onChange={handleCheckboxChange}
          className="appearance-none w-6 h-6 border-2 border-gray rounded-full checked:bg-orange-400 focus:ring-0 transition-all hover:cursor-pointer"
        />
        <span
          className={`text-lg break-words ${
            todo.completed ? "line-through text-gray-400" : "text-gray-900"
          }`}
        >
          {todo.title}
        </span>
      </label>

      <button
        onClick={handleDeleteClick}
        className="p-2 text-red-500 hover:text-red-700 hover:cursor-pointer"
      >
        🗑
      </button>
    </div>
  );
}

export default Todo;
