import logo from './logo.svg';
import './App.css';
import Home from "./components/Home";
import details from "./components/details";
import { Provider } from "react-redux";
import store from "./redux/store";
import { BrowserRouter as Router,Route,Switch } from "react-router-dom";
function App() {

  return (
    <Router>
    <Provider store={store}>
      <div className="App">
        <Switch>
        <Route path='/' exact component={Home}/>
        <Route path='/details' exact component={details}/>
        </Switch>
      </div>
    </Provider>
    </Router>
  );
}

export default App;
