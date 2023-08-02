package io.nology.portfoliobackend.post;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class CreatePostDTO {
    
    @NotBlank
    @Getter
    @Setter
    String title;
    
    @NotBlank
    @Getter
    @Setter
    String content;
    
    @NotBlank
    @Getter
    @Setter
    String category;
    
    public CreatePostDTO(String title, String content, String category) {
	this.title = title;
	this.content = content;
	this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

}
