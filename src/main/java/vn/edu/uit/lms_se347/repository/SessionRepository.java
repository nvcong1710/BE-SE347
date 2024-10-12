package vn.edu.uit.lms_se347.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.uit.lms_se347.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
