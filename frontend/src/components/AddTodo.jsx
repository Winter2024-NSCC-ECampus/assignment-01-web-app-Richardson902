import React, { useState } from "react";
import { addTodo } from "../services/TodoService";

function AddTodo({ onAddTodo }) {
  const [text, setText] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!text.trim()) return;

    try {
      await addTodo({ title: text });
      setText("");
      onAddTodo();
    } catch (error) {
      console.error("Error adding todo:", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="flex gap-2 mb-4">
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="Add a new task..."
        className="flex-1 p-2 border rounded-md focus-outline-none focus:ring-2-blue-500"
      />
      <button
        type="submit"
        className="px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-600 disabled:bg-gray-400"
        disabled={!text.trim()}
      />
    </form>
  );
}

export default AddTodo;
