package xavier.xavierblogcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xavier.xavierblogcms.models.Post;
import xavier.xavierblogcms.models.PostCategory;
import xavier.xavierblogcms.repository.PostCategoryRepository;
import xavier.xavierblogcms.repository.PostRepository;
import xavier.xavierblogcms.service.impl.PostServiceImpl;

import java.util.List;


@Controller
public class FrontPageController {

@Autowired
private PostServiceImpl postSerImpl;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private PostCategoryRepository postCatRepo;

    @RequestMapping("/home")
    public String index(Model model){
        model.addAttribute("poss",postSerImpl.findAllPost());
        model.addAttribute("postCat",postCatRepo.findAll());
        return "home";
    }

    @RequestMapping("/category")
    public String showCategories(Model model){
        model.addAttribute("postCat",postCatRepo.findAll());
        model.addAttribute("pageTitle","Xaiver Blog : Post Categories");
        return "postCategories";
    }

    @RequestMapping("/view{id}")
    public String viewPost(Model model,@PathVariable(name="id") Long id){
        Post post = postSerImpl.findOne(id);
        model.addAttribute("post",post);
        model.addAttribute("pageTitle","Xaiver Blog : "+post.getPostName());
        return "viewPost";
    }

    @RequestMapping(value="/postCat{id}", method=RequestMethod.GET)
    public String category(Model model, @PathVariable(name="id") Long id){
        PostCategory cat = postCatRepo.getOne(id);
        List<Post> posts = cat.getPosts();
        model.addAttribute("posts",posts);
        model.addAttribute("title", "Posts in category: "+ cat.getCategoryName());
        if (posts.isEmpty()){model.addAttribute("emptyCat",true);
        }
        model.addAttribute("pageTitle","Xaiver Blog : Posts in Category "+cat.getCategoryName());
        return"postCategory";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("pageTitle","Xaiver Blog : About Page");
        return "about";
    }
}
