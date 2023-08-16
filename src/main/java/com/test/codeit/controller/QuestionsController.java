package com.test.codeit.controller;

import com.test.codeit.common.CommController;
import com.test.codeit.common.exception.BaseException;
import com.test.codeit.dto.answers.AnswersReqDto;
import com.test.codeit.dto.questions.QuestionsReqDto;
import com.test.codeit.dto.questions.QuestionsResDto;
import com.test.codeit.dto.questions.QuestionsSearchReqDto;
import com.test.codeit.service.QuestionsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Tag(name = "코드잇 과제 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionsController extends CommController {

    private final QuestionsService questionsService;

    @Operation(summary = "질문 리스트 조회",responses = {@ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = QuestionsResDto.class))))})
    @GetMapping()
    public ResponseEntity findQuestions(QuestionsSearchReqDto questionsSearchReqDto) throws BaseException {
        return findSuccessReturn(questionsService.findQuestions(questionsSearchReqDto));
    }

    @Operation(summary = "질문 저장", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = QuestionsReqDto.class)))})
    @PostMapping()
    public ResponseEntity saveQuestions(@RequestBody @Valid QuestionsReqDto reqDto){
        return saveSuccessReturn(questionsService.saveQuestions(reqDto));
    }

    @Operation(summary = "답변 저장", responses = {@ApiResponse(content = @Content(mediaType = "application/json", schema = @Schema(implementation = AnswersReqDto.class)))})
    @PostMapping("{questionId}/answers")
    public ResponseEntity saveAnswers(@RequestBody @Valid AnswersReqDto reqDto, @PathVariable Long questionId) throws BaseException {
        return saveSuccessReturn(questionsService.saveAnswers(reqDto,questionId));
    }

}
