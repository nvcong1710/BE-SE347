package vn.edu.uit.lms_se347.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.uit.lms_se347.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
