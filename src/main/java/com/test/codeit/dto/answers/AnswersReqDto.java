package com.test.codeit.dto.answers;

import lombok.*;
import javax.validation.constraints.NotNull;

@Getter
public class AnswersReqDto {

    @NotNull
    private String title;

    @NotNull
    private String content;
}
