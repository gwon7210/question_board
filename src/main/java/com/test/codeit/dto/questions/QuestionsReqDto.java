package com.test.codeit.dto.questions;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class QuestionsReqDto {

    private Long lessonId;

    @NotNull
    private String title;

    @NotNull
    private String content;
}
