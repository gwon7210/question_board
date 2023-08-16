package com.test.codeit.repository;

import com.test.codeit.domain.Questions;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    List<Questions> findAllByLessonId(PageRequest page, Long lessonId);
}
