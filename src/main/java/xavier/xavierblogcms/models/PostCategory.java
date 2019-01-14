package xavier.xavierblogcms.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PostCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String categoryName;

    @OneToMany(mappedBy ="postCategory" )
    private List<Post> posts = new ArrayList();

    public PostCategory() {
    }

    public PostCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "PostCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", posts=" + posts +
                '}';
    }
}
