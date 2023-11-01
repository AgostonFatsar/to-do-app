import './App.css'
import {Routes, Route} from 'react-router-dom'
import Home from "./routes/Home.jsx";
import Login from "./routes/Login.jsx";
import Register from "./routes/Register.jsx";
import Dashboard from "./routes/Dashboard.jsx";
import Logout from "./routes/Logout.jsx";

function App() {

  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/logout"  element={<Logout />} />
        <Route path="/dashboard" element={<Dashboard />} />
      </Routes>
    </>
  )
}

export default App
