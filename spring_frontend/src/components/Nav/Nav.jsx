import React from "react";
import { NavLink } from "react-router-dom";
import styles from "./Nav.module.scss";

const Nav = () => {
  return (
    <nav>
      <NavLink to="/" className={styles.Nav}>
        Posts
      </NavLink>
      <NavLink to="/add-post" className={styles.Nav}>
        Add Post
      </NavLink>
    </nav>
  );
};

export default Nav;
