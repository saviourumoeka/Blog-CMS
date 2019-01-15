package xavier.xavierblogcms.service;

import xavier.xavierblogcms.models.Post;

import java.util.List;

public interface PostService {

    Post createPost(Post post);
    List<Post> findAllPost();
    Post editPost(Post post);
    void deletePost(Long id);
    Post findOne(Long id);
}
