package xavier.xavierblogcms.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import xavier.xavierblogcms.models.Admin;
import xavier.xavierblogcms.models.PostCategory;
import xavier.xavierblogcms.models.Role;
import xavier.xavierblogcms.repository.AdminRepository;
import xavier.xavierblogcms.repository.PostCategoryRepository;
import xavier.xavierblogcms.repository.RoleRepository;
import xavier.xavierblogcms.service.impl.AdminServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    AdminRepository adminRepo;

    @Autowired
   private RoleRepository roleRepo;

    @Autowired
    private AdminServiceImpl adminServImpl;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private PostCategoryRepository postCatRepo;



// Creates a default Admin
    public void createDefaultAdmin(){
        Admin admin = new Admin();
        admin.setUserName("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword("admin");
        //ecncrypt password and save
        String pwd = admin.getPassword();
        String encoded = bcrypt.encode(pwd);
        admin.setPassword(encoded);

        Role role = new Role("admin");
        roleRepo.save(role);

        admin.setRole(role);

        adminServImpl.create(admin);
    }
    // Creates Default Categoties
    public void createDefaualtCategory(){
        List<PostCategory> postCategories = new ArrayList();

        PostCategory app = new PostCategory("App");
        PostCategory car = new PostCategory("Car");
        PostCategory laptop = new PostCategory("Laptop");
        PostCategory phone = new PostCategory("Phone");
        PostCategory others = new PostCategory("Others");

        postCategories.add(app);
        postCategories.add(car);
        postCategories.add(laptop);
        postCategories.add(phone);
        postCategories.add(others);

        for(PostCategory x : postCategories){
            postCatRepo.save(x);
        }

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Admin ad =    adminRepo.findByUserName("admin");
       List <PostCategory> postCat = postCatRepo.findAll();
        if (ad== null){
            createDefaultAdmin();
        }

        if (postCat.isEmpty()){
            createDefaualtCategory();
        }




    }
}
