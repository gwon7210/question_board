package com.test.codeit.dto.questions;

import com.test.codeit.domain.Questions;
import com.test.codeit.dto.answers.AnswersResDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Schema(description = "질문 리스트 응답Dto")
@Getter
public class QuestionsResDto {

    private Long id;
    private Long lessonId;
    private String title;
    private String content;
    private Timestamp createdAt;
    @Schema(description = "답변 리스트")
    private List<AnswersResDto> answers;

    public QuestionsResDto(Questions entity){
        this.id = entity.getId();
        this.lessonId = entity.getLessonId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
        this.answers = entity.getAnswers().stream()
                .map(AnswersResDto::new)
                .collect(Collectors.toList());
    }

}
