import Post from "../../components/Post/Post";
import styles from "./PostsList.module.scss";

const PostsList = ({ posts, refresh, setRefresh }) => {
  return (
    <div className={styles.Wrapper}>
      <h1>Developer's blog</h1>
      <div className={styles.PostsList}>
        {posts.length > 0 &&
          posts.map((post) => {
            return (
              <Post
                key={post.id}
                post={post}
                setRefresh={setRefresh}
                refresh={refresh}
              />
            );
          })}
      </div>
    </div>
  );
};

export default PostsList;
