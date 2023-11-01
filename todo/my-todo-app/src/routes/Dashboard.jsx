import Logout from "./Logout.jsx";

const Dashboard = () => {

    const getUsers = async () => {
        const response = await fetch('/api/user');
        const data = await response.json();
        console.log(data);
    }
    getUsers();
    return (
        <div>
            <h1>Dashboard</h1>
            <Logout />

        </div>

    )
}

export default Dashboard;