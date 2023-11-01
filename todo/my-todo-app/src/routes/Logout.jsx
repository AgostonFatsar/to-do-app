import {useNavigate} from "react-router-dom";

const Logout = () => {

    const navigate = useNavigate();
    const handleLogout = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch('/api/auth/logout', {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
            });
            console.log(response)
            navigate('/');
        } catch (error) {
            console.log(error);
        }
    }
    return (
        <button onClick={handleLogout}>Logout</button>
    );
}

export default Logout;