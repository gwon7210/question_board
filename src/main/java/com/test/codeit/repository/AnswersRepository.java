package com.test.codeit.repository;

import com.test.codeit.domain.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
}
