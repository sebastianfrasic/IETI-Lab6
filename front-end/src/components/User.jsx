import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import Box from '@material-ui/core/Box';



export const User = (props) => {


    return (
        <Box m={1} p={5}>
            <Card variant="outlined">
                <CardContent>
                    <Typography align="center" variant="h4" component="h2">
                        {props.name}
                    </Typography>
                    <Typography align="center" color="textSecondary">
                        {props.email}
                    </Typography>
                    <br/>
                    <Typography align="center" variant="body" component="p" gutterBottom>
                        <Typography align="center" variant="h6" component="p" gutterBottom> Contraseña: </Typography>
                        {props.password}
                    </Typography>
                </CardContent>
            </Card>
        </Box>
    );
};