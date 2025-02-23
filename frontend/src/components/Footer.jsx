import React from "react";

function Footer() {
  return (
    <footer className="bg-[#f1ece6] text-[#6f6c6c] p-4 fixed bottom-0 left-0 w-full border-t-2 border-[#dc892f]">
      <div className="max-w-screen-xl mx-auto text-center">
        <p>
          <span className="text-[#dc892f]">
            &copy; {new Date().getFullYear()}
          </span>{" "}
          Nick's Todo App. All Rights Reserved.
        </p>
      </div>
    </footer>
  );
}

export default Footer;
