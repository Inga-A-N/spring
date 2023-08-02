package io.nology.portfoliobackend.post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional



public class PostService {
 // dependency injection
 	@Autowired
 	private PostRepository postRepository;
 	
 	@Autowired
 	private ModelMapper modelMapper;
 	
 	public Post create(CreatePostDTO data) {
 		// Business logic - I want to trim all string coming from data
 		// clean up data
// 	    One option:
// 		String postTitle = data.getTitle().trim();
// 		String postContent = data.getContent().trim();
// 		String postCategory = data.getCategory().trim();
// 		Date postCreatedAt = new Date();
 		
// 		Post newPost = new Post(
// 				postTitle,
// 				postCategory, 
// 				postContent,
// 				postCreatedAt
// 				);
 	    
// 	    Replacing the above with the mapper
 	    
 	   
 		
// 		Post newPost = new Post();
// 		newPost.setCategory(postCategory);
// 		newPost.setTitle(postTitle);
// 		newPost.setCreatedAt(postCreatedAt);
// 		newPost.setContent(postContent);
 	    	Post newPost = modelMapper.map(data, Post.class);
		newPost.setCreatedAt(new Date());
		Post createdPost = this.postRepository.save(newPost);
 		
 		return createdPost;
 	}
 	
 	public List<Post> findAll (){
 	   return this.postRepository.findAll(); 
 	}
 	
 	public Optional<Post> findById(Long id){
 	    Optional<Post> maybePost = this.postRepository.findById(id);
 	    return maybePost;
 	}
 	
 	public boolean deleteById(Long id){
 	    Optional<Post> maybePost = this.findById(id);
 	    if(maybePost.isEmpty()) {
 		return false;
 	    }
 	    this.postRepository.delete(maybePost.get());
 	    return true;
 	}
 	
 	public Optional<Post> updateById(Long id, UpdatePostDTO data) {
		
		// find the post I want to update
		Optional<Post> maybePost = this.findById(id);
		
		if(maybePost.isPresent()) {
			Post existingPost = maybePost.get();
			// I want this done in a nicer way - with model mapper
//			if(data.title != null) {
//				existingPost.setTitle(data.title.trim());
//				Post updatedPost = this.postRepository.save(existingPost);
//				return Optional.of(updatedPost);
//			}
			modelMapper.map(data, existingPost);
			return Optional.of(this.postRepository.save(existingPost));
		}
	
		return maybePost;
	}

}
