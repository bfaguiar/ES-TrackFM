import React from 'react';
import logo from './logo.svg';
import './App.css';
import Index from './pages/index';
import Artist from './pages/artist';
import User from './pages/user';

import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/artist">
          <Artist />
        </Route>
        <Route path="/">
          <Index />
        </Route>
        <Route path="/user">
          <User/>
        </Route>
      </Switch>
  </Router>
  );
}

export default App;



