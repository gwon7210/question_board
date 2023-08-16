package com.test.codeit.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long lessonId;

    private String title;

    private String content;

    @CreationTimestamp
    private Timestamp createdAt;

    @OneToMany(mappedBy = "questions", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval=true)
    @BatchSize(size = 100)
    private List<Answers> answers;

}
