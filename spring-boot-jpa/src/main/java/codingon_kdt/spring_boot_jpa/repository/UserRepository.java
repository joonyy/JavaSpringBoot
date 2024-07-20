package codingon_kdt.spring_boot_jpa.repository;

import codingon_kdt.spring_boot_jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이 인텊페이스가 Repository 컴포넌트임을 명시.
public interface UserRepository extends JpaRepository<User, Long> {
    // ㄴ JpaRepository를 상속받아, 기본적인 CRUD 작업을 위한 메서드를 제공받음.
    // ex. findAll(), findById(), save(), deleteById()
}

