package vn.edu.uit.lms_se347.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.uit.lms_se347.entity.Flashcard;

public interface FlashcardRepository extends JpaRepository<Flashcard, Long> {
}
