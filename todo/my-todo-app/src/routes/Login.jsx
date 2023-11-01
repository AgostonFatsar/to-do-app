import {useState} from "react";
import { useNavigate } from 'react-router-dom';

const Login = () => {

    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('/api/auth/authenticate', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify({username, password})
            });
            console.log(response)
            if (response.status === 200) {
                navigate('/dashboard');
            } else {
                console.log('Login failed.');
            }
        } catch (error) {
            console.log(error);
        }
    }
    return (
        <div className="form-container">
            <form onSubmit={handleSubmit}>
                <label>
                    Username:
                    <input type="text" value={username} onChange={handleUsernameChange} />
                </label>
                <label>
                    Password:
                    <input type="password" value={password} onChange={handlePasswordChange} />
                </label>
                <button type="submit">Submit</button>
            </form>
        </div>
    )
}

export default Login;