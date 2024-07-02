import React, { useContext } from 'react';
import { BrowserRouter as Router, Route, Switch, Redirect } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Estudiantes from './pages/Estudiantes';
import Matriculas from './pages/Matriculas';
import Docentes from './pages/Docentes';
import Asistencias from './pages/Asistencias';
import Reportes from './pages/Reportes';
import AuthContext from './context/AuthContext'; // Asegúrate de que AuthContext esté correctamente definido y exportado

const PrivateRoute = ({ component: Component, ...rest }) => {
    const { user } = useContext(AuthContext);
    return (
        <Route
            {...rest}
            render={props =>
                user ? <Component {...props} /> : <Redirect to="/login" />
            }
        />
    );
};

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/login" component={Login} />
                <PrivateRoute path="/estudiantes" component={Estudiantes} />
                <PrivateRoute path="/matriculas" component={Matriculas} />
                <PrivateRoute path="/docentes" component={Docentes} />
                <PrivateRoute path="/asistencias" component={Asistencias} />
                <PrivateRoute path="/reportes" component={Reportes} />
            </Switch>
        </Router>
    );
}

export default App;
