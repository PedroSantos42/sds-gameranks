import React from 'react';
import { ReactComponent as Logo } from '../../assets/logo.svg'
import './styles.css';

type Props = {
    message: string;
}

const Header = () => {
    return (
        <header className="main-header">
            <Logo />
            <div className="logo-text">
                <span className="logo-text-1">Game Ranks</span>
                <span className="logo-text-2"> Survey</span>
            </div>
        </header>
    );
}

export default Header;