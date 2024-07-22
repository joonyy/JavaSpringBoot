package Practice.jpa_post.service;

import Practice.jpa_post.domain.Post;
import Practice.jpa_post.dto.PostDTO;
import Practice.jpa_post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPosts(){
        List<Post> posts = postRepository.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();

        for (Post post: posts) {
            PostDTO postDTO = convertToDto(post);
            postDTOs.add(postDTO);
        }
        return postDTOs;
    }

    public PostDTO getPostById(Integer id){
        Post post = postRepository.findById(id).orElse(null);
        if(post==null){
            throw new RuntimeException("User not found");
        }
        return convertToDto(post);
    }

    public void createPost(PostDTO postDTO){
        Post post = convertToEntity(postDTO);
        postRepository.save(post);
    }

    public void updatePost(Integer id, PostDTO postDTO){
        Post post = convertToEntityWithId(id, postDTO);
        postRepository.save(post);
    }

    public void deletePost(Integer id){postRepository.deleteById(id);}

    public List<PostDTO> getPostByWriter(String writer){
        List<Post> posts = postRepository.findByWriter(writer);
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Post post:posts){
            postDTOs.add(convertToDto(post));
        }
        return postDTOs;
    }

    public List<PostDTO> searchPosts(String keyword){
        List<Post> posts = postRepository.findByTitleContainingOrContentContaining(keyword);
        List<PostDTO> postDTOS = new ArrayList<>();
        for(Post post : posts){
            postDTOS.add(convertToDto(post));
        }
        return postDTOS;
    }

    public boolean isWriterExists(String writer){return postRepository.existsByWriter(writer);}

    private Post convertToEntityWithId(Integer id, PostDTO dto) {
       return Post.builder()
               .id(id)
               .writer(dto.getWriter())
               .title(dto.getTitle())
               .content(dto.getContent())
               .build();
    }

    private PostDTO convertToDto(Post post){
        return PostDTO.builder()
                .id(post.getId())
                .writer(post.getWriter())
                .content(post.getContent())
                .title(post.getTitle())
                .build();
    }

    //DTO => Entity
    private Post convertToEntity(PostDTO dto){
        return Post.builder()
                .id(dto.getId())
                .writer(dto.getWriter())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
    }
}
