package Practice.jpa_post.controller;

import Practice.jpa_post.dto.PostDTO;
import Practice.jpa_post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> listPosts(){ return postService.getAllPosts();}

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable int id){return postService.getPostById(id);}

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);
        return postDTO;
    }

    @PutMapping("/{id}")
    public PostDTO updatePost(@PathVariable int id, @RequestBody PostDTO postDTO){
        postService.updatePost(id, postDTO);
        return postDTO;
    }
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id){ postService.deletePost(id); }

    @GetMapping("/writer")
    public List<PostDTO> getPostByWriter(@RequestParam String writer){
        return postService.getPostByWriter(writer);
    }

    @GetMapping("/search")
    public List<PostDTO> searchPosts(@RequestParam String keyword){
        return postService.searchPosts(keyword);
    }

    @GetMapping("/exists")
    public boolean isWriterExists(@RequestParam String writer){return postService.isWriterExists(writer);}

}
