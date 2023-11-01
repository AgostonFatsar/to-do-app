import {NavLink} from "react-router-dom";

const Home = () => {
    return (
        <div className='home-container'>
            <div className='home-content'>
                <h1 className='home-title'>Welcome to My Todo App!</h1>
                <nav>
                    <NavLink to='/register' className='home-button'>Sign Up</NavLink>
                    <NavLink to='/login' className='home-button'>Login</NavLink>
                </nav>
            </div>
        </div>
    )
}

export default Home;