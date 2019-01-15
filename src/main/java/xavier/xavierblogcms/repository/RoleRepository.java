package xavier.xavierblogcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xavier.xavierblogcms.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String role);
}
