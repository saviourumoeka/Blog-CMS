package xavier.xavierblogcms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xavier.xavierblogcms.models.Admin;
import xavier.xavierblogcms.repository.AdminRepository;
import xavier.xavierblogcms.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepo;

    @Override
    public Admin create(Admin admin) {
        return adminRepo.save(admin);
    }
}
