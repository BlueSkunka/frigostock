import React from 'react';
import List from '../component/List';
import NavBar from '../component/NavBar';

const Home = () => {
  return (
    <div>
      <NavBar/>
      <h1 className="text-center">accueil</h1>
      <List/>
    </div>
  );
};

export default Home;