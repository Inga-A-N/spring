export const getAllPosts = async () => {
  // fetch the data
  const response = await fetch("http://localhost:8080/posts");
  return await response.json();
};

export const deletePostById = async (id) => {
  const response = await fetch(`http://localhost:8080/posts/${id}`, {
    method: "DELETE",
  });

  // error handling
  if (!response.ok) {
    throw new Error("Could not delete post");
  }
};

export const createPost = async (data) => {
  const response = await fetch("http://localhost:8080/posts", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  });

  if (!response.ok) {
    throw new Error("Could not create a post");
  }
};
