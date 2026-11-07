import { useState } from 'react'
import './App.css'
import React from 'react'
import { BrowserRouter as Router,Routes,Route } from "react-router" 
import Login from './pages/auth/login'

function App() {
  const [count, setCount] = useState(0)

  return (
    <Router>
      <Routes>
        <Route path='/' element={<Login/>}/>
      </Routes>
    </Router>
  );
}

export default App
