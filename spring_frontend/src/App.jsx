import { useState, useEffect } from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import { getAllPosts } from "./services/posts";
import PostsList from "./containers/PostsList/PostsList";
import AddPostForm from "./components/AddPostForm/AddPostForm";
import Nav from "./components/Nav/Nav";

function App() {
  const [posts, setPosts] = useState([]);
  const [refresh, setRefresh] = useState(0);

  useEffect(() => {
    getAllPosts().then((res) => {
      setPosts(res);
      console.log(res);
    });
  }, [refresh]);

  return (
    <>
      <BrowserRouter>
        <Nav />
        <Routes>
          <Route
            path="/"
            element={
              <PostsList
                posts={posts}
                refresh={refresh}
                setRefresh={setRefresh}
              />
            }
          />
          <Route
            path="/add-post"
            element={
              <AddPostForm setRefresh={setRefresh} refresh={setRefresh} />
            }
          />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;

// CHALLENGE MVP
// make the delete button work, it should remove the record from the database
// and not display it on the frontend

// BACKEND
// add an authors table to the backend
// One author can create multiple posts
// One post has one author
// OneToMany/ManyToOne

// FRONTED
// display the actual error message coming from backend
// set up a route /posts/:id
// auto filled form will all the post data
// update the post in the database
