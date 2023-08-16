package com.test.codeit.dto.questions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionsSearchReqDto {

    private int page = 0;

    private int size = 100;

    private Long lessonId = null;
}
