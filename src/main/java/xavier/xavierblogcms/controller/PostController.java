package xavier.xavierblogcms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xavier.xavierblogcms.models.Post;
import xavier.xavierblogcms.models.PostCategory;
import xavier.xavierblogcms.repository.PostCategoryRepository;
import xavier.xavierblogcms.service.impl.PostServiceImpl;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;


@Controller
@RequestMapping("/adminpage/post")
public class PostController {
    @Autowired
    private PostServiceImpl postServImpl;
    @Autowired
    private PostCategoryRepository postCatRepo;

//    Adding a Post
    @RequestMapping(value ="/add",method = RequestMethod.POST)
    public String createPost(
            @ModelAttribute("post") @Valid Post post,
            BindingResult errors,
            @RequestParam long categoryId,
            Model model,
            Principal principal
) { MultipartFile postImg = post.getPostImage();

        if(errors.hasErrors()){

            model.addAttribute("add",true);
            model.addAttribute("pageTitle","Xaiver Blog : Manage Post");
            model.addAttribute("post",post);
            model.addAttribute("postCategories",postCatRepo.findAll());
            model.addAttribute("loggedAdmin",principal.getName());
            model.addAttribute("posts",postServImpl.findAllPost());
            model.addAttribute("noCat",true);

            return "adminpage/managepost";
        }else{
        PostCategory cat = postCatRepo.getOne(categoryId);
        post.setPostCategory(cat);
        postServImpl.createPost(post);

       // MultipartFile postImg = post.getPostImage();
        try{
            byte[] imgBytes = postImg.getBytes();
            String name = post.getId() + ".jpg";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(new File("src/main/resources/static/images/" + name)));
            stream.write(imgBytes);
            stream.close();

        } catch (Exception e){
            e.printStackTrace();
    }


        return "redirect:/adminpage/managepost";}
   }

    @RequestMapping("/edit{id}")
    public String editPage(Model model,@PathVariable(name="id") Long id){
        Post post = postServImpl.findOne(id);
        model.addAttribute("post",post);
        model.addAttribute("postCategorie",postCatRepo.findAll());
        model.addAttribute("pageTitle","Xaiver Blog : Edit Post");
        return "adminpage/editPost";
    }

    @RequestMapping(value="/updatePost" , method=RequestMethod.POST)
    public String updatePost(Post post,@RequestParam long categoryId){
        PostCategory cat = postCatRepo.getOne(categoryId);
        post.setPostCategory(cat);
            postServImpl.createPost(post);
        return "redirect:/adminpage/managepost";
    }

    @RequestMapping("/view{id}")
    public String viewPost(Model model,@PathVariable(name="id") Long id){
        Post post = postServImpl.findOne(id);
        model.addAttribute("post",post);
        model.addAttribute("pageTitle","Xaiver Blog : "+ post.getPostName());
        return "viewPost";
    }

    @RequestMapping(value="/delete{id}", method=RequestMethod.GET)
    public String deleteTodo(@PathVariable(name="id") Long id, Post post){
        postServImpl.deletePost(id);
        String name = post.getId()+".jpg";
        try {
            Files.delete(Paths.get("src/main/resources/static/images/" + name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/adminpage/managepost";
    }
}
