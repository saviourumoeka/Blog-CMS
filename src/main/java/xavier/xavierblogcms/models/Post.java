package xavier.xavierblogcms.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post extends AuditModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Post Headline Can Not be Empty")
    private String postHeadline;

    @NotEmpty(message = "Post Name Can Not be Empty")
    private String postName;

    @Transient
    private MultipartFile postImage;


    @NotEmpty(message = "Post Body Can Not be Empty")
    @Column(columnDefinition="text")
    private String postBody;

    @ManyToOne
    private PostCategory postCategory;


    public Post() {
    }

    public Post(String postHeadline, String postName, MultipartFile postImage, String postBody) {
        this.postHeadline = postHeadline;
        this.postName = postName;
        this.postImage = postImage;
        this.postBody = postBody;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostHeadline() {
        return postHeadline;
    }

    public void setPostHeadline(String postHeadline) {
        this.postHeadline = postHeadline;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public MultipartFile getPostImages() {
        return postImage;
    }

    public void setPostImages(MultipartFile postImage) {
        this.postImage = postImage;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }


    public MultipartFile getPostImage() {
        return postImage;
    }

    public void setPostImage(MultipartFile postImage) {
        this.postImage = postImage;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postHeadline='" + postHeadline + '\'' +
                ", postName='" + postName + '\'' +
                ", postImage=" + postImage +
                ", postBody='" + postBody + '\'' +
                ", postCategory=" + postCategory +
                '}';
    }
}
