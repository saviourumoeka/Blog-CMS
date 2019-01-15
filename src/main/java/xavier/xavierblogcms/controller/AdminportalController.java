package xavier.xavierblogcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xavier.xavierblogcms.models.Post;
import xavier.xavierblogcms.repository.PostCategoryRepository;

import xavier.xavierblogcms.service.impl.PostServiceImpl;

import java.security.Principal;

@Controller
@RequestMapping("/adminpage")
public class AdminportalController {
    @Autowired
    private PostCategoryRepository postCatRepo;

    @Autowired
    private PostServiceImpl postSerImpl;

    //Returns Homepage
   @RequestMapping( value = "/" , method = RequestMethod.GET)
         public String homePage(Model model){
       model.addAttribute("pageTitle","Xaiver Blog : Dashboard Home");
             return "adminpage/dashboardHome";
         }

    public String index(Model model, Principal principal){

        model.addAttribute("home",true);
        model.addAttribute("loggedAdmin",principal.getName());
        return "adminpage/common/dashBoard";

    }

    @RequestMapping("/managepost")
    public String addPostPage(Model model,Principal principal){
        model.addAttribute("pageTitle","Xaiver Blog : Manage Post");
        Post post = new Post();
        model.addAttribute("post",post);
        model.addAttribute("postCategories",postCatRepo.findAll());
        model.addAttribute("loggedAdmin",principal.getName());
        model.addAttribute("posts",postSerImpl.findAllPost());
        model.addAttribute("view",true);
        return "adminpage/managePost";

    }
        //Returns login page
    @RequestMapping(value="/login" ,method=RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("pageTitle","Xaiver Blog : Admin Login");
       return"adminpage/login";
    }
}
