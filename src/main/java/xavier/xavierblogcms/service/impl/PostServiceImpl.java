package xavier.xavierblogcms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xavier.xavierblogcms.models.Post;
import xavier.xavierblogcms.repository.PostRepository;
import xavier.xavierblogcms.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public List<Post> findAllPost() {
        return postRepo.findAll();
    }

    @Override
    public Post editPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

    @Override
    public Post findOne(Long id) {
        return postRepo.getOne(id);
    }
}
