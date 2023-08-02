package io.nology.portfoliobackend.post;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="posts")
public class Post {
    
//    Add a property that will be a primary key
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    All the properties added here will be columns in the database and 
    @Column
    @Getter
    @Setter
    private String title;
    
//category can be done as a separate table in future   
    @Column
    @Getter
    @Setter
    private String category;
    @Column
    @Getter
    @Setter
    private String content;
    @Column
    @Getter
    @Setter
    private Date createdAt;
    
    

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    
    public Post() {}
    
    public Post(String title, String category, String content, Date createdAt) {
     this.title = title;
     this.category = category;
     this.content = content;
     this.createdAt = createdAt;
    }

    
    

}
