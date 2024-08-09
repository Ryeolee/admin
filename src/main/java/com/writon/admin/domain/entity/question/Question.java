package com.writon.admin.domain.entity.question;

import com.writon.admin.domain.entity.challenge.Challenge;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "Question")
public class Question {

  @Id
  @Column(name = "question_id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @Column(name = "question", nullable = false)
  private String question;

  @Column(name = "category", nullable = false, length = 10)
  private String category;

  @Column(name = "keyword_id")
  private Integer keywordId;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}