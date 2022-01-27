import React from 'react';
import { useNavigate } from 'react-router-dom';
import img from "../image/frigoLogo64.png";

const NavBar = () => {
  //for navigate to other page
  const navigate = useNavigate()

  return (
    <div>
      <nav className='navbar navbar-expand-lg navbar-success' style={{background: "#0f5434"}}>
        <div class="container-fluid">
          <div className='navbar-brand mb-0 fs-1'>
            <img src={img} alt='logo frigostock' height={64} title='logo frigostock'/>
            frigostock
          </div>
          <div className='d-flex'>
            <button type='button' className='btn btn-success me-2 fs-2 ms-lg-2 d-none d-sm-block' onClick={() => navigate("/")}>accueil</button>
            <button className='btn btn-success me-2 ms-lg-2 fs-2 d-none d-sm-block' onClick={() => navigate("list")}>mon frigo</button>
            <button className='btn btn-success me-2 fs-2 ms-lg-2 d-none d-sm-block' onClick={() => navigate("/create")}>ajouet un aliment</button>
            <div className="dropdown d-sm-none">
            <button className="btn btn-success dropdown-toggle fs-1" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
              menu
            </button>
            <ul className="dropdown-menu dropdown-menu-end" aria-labelledby="dropdownMenuButton1">
              <li><span className='dropdown-item' onClick={() => navigate("/")}>accueil</span></li>
              <li><span className="dropdown-item" onClick={() => navigate("/list")}>ma liste</span></li>
              <li><span className="dropdown-item" onClick={() => navigate("/create")}>ajouter un aliment</span ></li>
            </ul>
          </div>
          </div>
        </div>
      </nav>
    </div>
  );
};

export default NavBar;