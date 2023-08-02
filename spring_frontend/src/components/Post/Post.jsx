import { deletePostById } from "../../services/posts";
import styles from "./Post.module.scss";

const Post = ({ post, setRefresh, refresh }) => {
  const { title, category, content, id } = post;

  const handleClick = async () => {
    try {
      await deletePostById(id);
      console.log("deleted");
      setRefresh(refresh + 1);
    } catch (e) {
      console.log(e);
    }
  };
  return (
    <div className={styles.Post}>
      <h3>{title.toUpperCase()}</h3>
      <p>{category}</p>
      <p>{content}</p>
      <button onClick={handleClick}>Delete Post</button>
    </div>
  );
};

export default Post;
