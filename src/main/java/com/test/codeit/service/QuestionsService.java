package com.test.codeit.service;


import com.test.codeit.common.code.ApiCode;
import com.test.codeit.common.exception.BaseException;
import com.test.codeit.domain.Answers;
import com.test.codeit.domain.Questions;
import com.test.codeit.dto.answers.AnswersReqDto;
import com.test.codeit.dto.questions.QuestionsReqDto;
import com.test.codeit.dto.questions.QuestionsResDto;
import com.test.codeit.dto.questions.QuestionsSearchReqDto;
import com.test.codeit.repository.AnswersRepository;
import com.test.codeit.repository.QuestionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class QuestionsService {

    private final QuestionsRepository questionsRepository;

    private final AnswersRepository answersRepository;

    public List<QuestionsResDto> findQuestions(QuestionsSearchReqDto questionsSearchReqDto) throws BaseException {

        PageRequest page = PageRequest.of(questionsSearchReqDto.getPage(), questionsSearchReqDto.getSize(), Sort.by("createdAt").descending());
        List<QuestionsResDto> questions;

        if(questionsSearchReqDto.getLessonId() != null){
            questions = questionsRepository.findAllByLessonId(page, questionsSearchReqDto.getLessonId()).stream()
                    .map(QuestionsResDto::new)
                    .collect(Collectors.toList());
        }else{
            questions = questionsRepository.findAll(page).stream()
                    .map(QuestionsResDto::new)
                    .collect(Collectors.toList());
        }

        if(questions.size() <1 || questions ==null){
            throw new BaseException(ApiCode.DATA_NOT_FOUND);
        }

        return questions;
    }

    public Long saveQuestions(QuestionsReqDto reqDto) {

        Questions questions = Questions.builder()
                .lessonId(reqDto.getLessonId())
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .build();

        Long Id = questionsRepository.save(questions).getId();

        return Id;
    }

    @Transactional
    public Long saveAnswers(AnswersReqDto reqDto, Long questionId) throws BaseException {

        Questions questions = questionsRepository.findById(questionId).orElseThrow(() ->
                new BaseException(ApiCode.QUESTIONS_NOT_FOUND));

        Answers answers = Answers.builder()
                .questions(questions)
                .title(reqDto.getTitle())
                .content(reqDto.getContent())
                .build();

        Long Id = answersRepository.save(answers).getId();

        return Id;
    }

}
