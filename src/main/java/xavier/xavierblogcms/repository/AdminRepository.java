package xavier.xavierblogcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xavier.xavierblogcms.models.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    Admin findByUserName(String username);
}

