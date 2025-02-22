import React from "react";

function Footer() {
  return (
    <footer className="bg-gray-900 text-white p-4 fixed bottom-0 left-0 w-full">
      <div className="max-w-screen-xl mx-auto text-center">
        <p>
          &copy; {new Date().getFullYear()} Nick's Todo App. All Rights
          Reserved.
        </p>
      </div>
    </footer>
  );
}

export default Footer;
