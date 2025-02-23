import Header from "./components/Header";
import Footer from "./components/Footer";
import TodoList from "./components/TodoList";
import "./App.css";

//TODO: Currently there is a formatting issue when adding todo items with a long title
// Causing misalignments on smaller screen sizes (mobile).
// To fix this, I can spend additional time formatting the css, or I can limit the
// todo title character length in the backend and implement error popups to let the user know.

function App() {
  return (
    <>
      <Header />
      <TodoList />
      <Footer />
    </>
  );
}

export default App;
