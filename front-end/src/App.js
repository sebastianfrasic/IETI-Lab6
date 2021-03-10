import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Typography from '@material-ui/core/Typography';
import { Users } from './components/Users';

function App() {

  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios.get("http://lab6-ieti-frasica.southcentralus.azurecontainer.io:8080/users")
      .then(response => {
        let result = response.data;
        setUsers(result);
      }).catch(error => {
        alert("Error al cargar los usuarios");
      });
  }, []);

  return (
    <div>
      <br />
      <Typography variant="h2" style={{ textAlign: "center" }}>Usuarios:</Typography>
      <br></br>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center"
        }}
      >
        <Users list={users}></Users>
      </div>
    </div>
  );
}

export default App;
