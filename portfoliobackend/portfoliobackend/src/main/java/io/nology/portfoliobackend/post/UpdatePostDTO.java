package io.nology.portfoliobackend.post;

import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.Size;

public class UpdatePostDTO {
//    @Size(min = 1)
    @Pattern(regexp = "(?=\\S).*$", message = "Title cannot be an empty string")
    String title;
    
//    @Size(min = 1)
    @Pattern(regexp = "(?=\\S).*$", message = "Category cannot be an empty string")
    String category;
    
//    @Size(min = 1)
    @Pattern(regexp = "(?=\\S).*$", message = "Content cannot be an empty string")
    String content;
    
    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
    	this.title = title;
    }

    public String getCategory() {
    	return category;
    }
    
    public void setCategory(String category) {
    	this.category = category;
    }
    
    public String getContent() {
    	return content;
    }
    
    public void setContent(String content) {
    	this.content = content;
    }

}
