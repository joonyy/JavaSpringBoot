package practice.mybatis_on_my_own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.mybatis_on_my_own.dto.PostDTO;
import practice.mybatis_on_my_own.service.PostService;

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
    @PostMapping("/{id}")
    public void reportUser(@PathVariable int id){
        postService.reportPost(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){ postService.deletePost(id);}
}

