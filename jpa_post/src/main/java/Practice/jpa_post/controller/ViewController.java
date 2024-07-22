package Practice.jpa_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String redirectToPosts(){return "redirect:/posts";}

    @GetMapping("/posts")
    public String listPosts(){ return "postList";}

    @GetMapping("/posts/new")
    public String newPostForm(){return "postForm";}

    @GetMapping("/posts/{id}/edit")
    public String editPostForm(){return "postForm";}

    @GetMapping("/posts/{id}")
    public String post(){return "post";}
}
