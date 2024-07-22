package Practice.jpa_post.repository;

import Practice.jpa_post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    @Query("SELECT p from Post p WHERE p.writer LIKE %:writer% ")
    List<Post> findByWriter(@Param("writer") String writer);

    @Query("SELECT p from Post p WHERE p.title LIKE %:keyword% OR p.content LIKE %:keyword%")
    List<Post> findByTitleContainingOrContentContaining(@Param("keyword") String keyword);

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Post p WHERE p.writer = %:writer%")
    boolean existsByWriter(@Param("writer") String writer);
}
