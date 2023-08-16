package com.test.codeit.dto.answers;


import com.test.codeit.domain.Answers;
import com.test.codeit.domain.Questions;
import lombok.Getter;


@Getter
public class AnswersResDto {

    private Long id;
    private String title;
    private String content;

    public AnswersResDto(Answers answers){
        this.id = answers.getId();
        this.title = answers.getTitle();
        this.content = answers.getContent();
    }

}
