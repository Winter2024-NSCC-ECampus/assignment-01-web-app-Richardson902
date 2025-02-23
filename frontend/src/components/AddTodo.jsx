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
    <div className="max-w-xl mx-auto">
      <form onSubmit={handleSubmit} className="flex mb-4">
        <input
          type="text"
          value={text}
          onChange={(e) => setText(e.target.value)}
          placeholder="What do you need to do?"
          className="flex-1 p-3 text-gray-500 bg-[#f1ece6] rounded-l-full focus:outline-none"
        />
        <button
          type="submit"
          className="px-6 py-3 text-white bg-[#76b7cd] rounded-r-full hover:bg-[#7ab0c4]"
          disabled={!text.trim()}
        >
          Add
        </button>
      </form>
    </div>
  );
}

export default AddTodo;
