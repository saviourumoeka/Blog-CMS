package xavier.xavierblogcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xavier.xavierblogcms.models.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
