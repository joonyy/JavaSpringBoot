package Batis_post_system.batis_post.controller;


import Batis_post_system.batis_post.dto.PostDTO;
import Batis_post_system.batis_post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    //포스트 목록보기
    @GetMapping
    public List<PostDTO> listPosts(){ return postService.getPosts();}

    @PostMapping
    public PostDTO createPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);
        return postDTO;
    }

    @GetMapping("/{id}")
    public PostDTO getPost(@PathVariable int id){return postService.getPostById(id);}

    @PutMapping("/{id}")
    public PostDTO editPost(@PathVariable int id, @RequestBody PostDTO postDTO){
        postDTO.setId(id);
        postService.updatePost(postDTO);
        return postDTO;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){ postService.deletePost(id);}

    @GetMapping("/search")
    public  List<PostDTO> searchPosts(@RequestParam String keyword){
        return postService.searchPosts(keyword);
    }
    @GetMapping("/writer")
    public  List<PostDTO> searchWriter(@RequestParam String writer){
        return postService.searchPostsByWriter(writer);
    }
}

