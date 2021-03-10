import React from 'react';
import CircularProgress from '@material-ui/core/CircularProgress';
import Box from '@material-ui/core/Box';
import { User } from './User';

export const Users = (props) => {
    let usuarios = (
        <CircularProgress />
    );
    if (props.list.length > 0) {
        usuarios = props.list.map(user =>
        (<User
            key={user.id}
            id={user.id}
            email={user.email}
            name={user.name}
            password={user.password}
        />));
    }
    return (
        <div>
            <Box justifyContent="center"
                alignItems="flex-start"
                display="flex"
            >
                {usuarios}
            </Box>
        </div>
    );
};