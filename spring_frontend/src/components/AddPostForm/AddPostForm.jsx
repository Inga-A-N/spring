import { useState } from "react";
import styles from "./AddPostForm.module.scss";
import { createPost } from "../../services/posts";
import { useNavigate } from "react-router-dom";

const AddPostForm = ({ refresh, setRefresh }) => {
  const initialData = {
    title: "",
    content: "",
    category: "",
  };
  const [newPostData, setNewPostData] = useState(initialData);
  const [error, setError] = useState(false);

  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(newPostData, "data to send");
    try {
      if (error) {
        setError(false);
      }
      await createPost(newPostData);
      setRefresh(refresh + 1);
      navigate("/");
    } catch (e) {
      setError(true);
      console.log(e);
    }
  };

  const handleChange = (e) => {
    console.log(e.target.value);
    console.log(e.target.id);
    const { id, value } = e.target;
    setNewPostData({ ...newPostData, [id]: value });
  };

  return (
    <>
      <h1>Add new post</h1>
      <form onSubmit={handleSubmit}>
        <div className={styles.Form_Element}>
          <label>Title: </label>
          <input type="text" required id="title" onChange={handleChange} />
        </div>
        <div className={styles.Form_Element}>
          <label>Content: </label>
          <textarea
            cols="30"
            rows="10"
            required
            id="content"
            onChange={handleChange}
          />
        </div>
        <div className={styles.Form_Element}>
          <label>Category: </label>
          <select id="category" onChange={handleChange} required>
            <option value="" hidden>
              select one...
            </option>
            <option>coding</option>
            <option>frontend</option>
            <option>backend</option>
            <option>lifestyle</option>
          </select>
        </div>
        <button type="submit">Add Post</button>
      </form>
      {error && <p>Could not create a post</p>}
    </>
  );
};

export default AddPostForm;
