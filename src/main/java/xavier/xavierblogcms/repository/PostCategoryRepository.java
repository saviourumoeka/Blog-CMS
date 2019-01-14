package xavier.xavierblogcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xavier.xavierblogcms.models.PostCategory;
@Repository
public interface PostCategoryRepository extends JpaRepository<PostCategory,Long> {
}
