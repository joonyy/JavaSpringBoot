package Batis_post_system.batis_post.service;

import Batis_post_system.batis_post.domain.Post;
import Batis_post_system.batis_post.dto.PostDTO;
import Batis_post_system.batis_post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    //모든 post의 list 가져오기
    public List<PostDTO> getPosts(){
        List<Post> posts = postMapper.findAll();
        List<PostDTO> postDTOs = new ArrayList<>();

        for(Post post : posts){
            PostDTO postDTO = convertToDto(post);
            postDTOs.add(postDTO);
        }

        return postDTOs;
    }

    //post검색
    public List<PostDTO> searchPosts(String keyword){
        List<Post> posts = postMapper.findByTitleOrContent(keyword);
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Post post : posts){
            postDTOs.add(convertToDto(post));
        }
        return postDTOs;
    }

    public List<PostDTO> searchPostsByWriter(String writer) {
        List<Post> posts = postMapper.findByWriter(writer);
        List<PostDTO> postDTOs = new ArrayList<>();
        for(Post post : posts){
            postDTOs.add(convertToDto(post));
        }
        return postDTOs;
    }

    //특정 ID의 post 검색
    public PostDTO getPostById(int id){
        Post post = postMapper.findById(id);
        return convertToDto(post);
    }

    //새로운 post 작성
    public void createPost(PostDTO postDTO){
        Post post = convertToEntity(postDTO);
        postMapper.create(post);
    }

    //post 수정
    public void updatePost(PostDTO postDTO){
        Post post = convertToEntity(postDTO);
        postMapper.update(post);
    }

    //post 삭제
    public void deletePost(int id){
        postMapper.delete(id);
    }

    //Entity => DTO
    private PostDTO convertToDto(Post post){
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setWriter(post.getWriter());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());

        return dto;
    }

    //DTO => Entity
    private Post convertToEntity(PostDTO dto){
        Post post = new Post();
        post.setId(dto.getId());
        post.setWriter(dto.getWriter());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());

        return post;
    }
}
