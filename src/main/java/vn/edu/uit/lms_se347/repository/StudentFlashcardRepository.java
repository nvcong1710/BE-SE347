package vn.edu.uit.lms_se347.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.uit.lms_se347.entity.StudentFlashcard;

public interface StudentFlashcardRepository extends JpaRepository<StudentFlashcard, Long> {
}
