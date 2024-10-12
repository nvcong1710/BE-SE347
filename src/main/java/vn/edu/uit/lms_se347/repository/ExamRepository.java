package vn.edu.uit.lms_se347.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.uit.lms_se347.entity.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
