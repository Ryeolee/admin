package com.writon.admin.domain.entity.challenge;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "ChallengeFunction")
public class ChallengeFunction {

  @Id
  @Column(name = "challenge_function_id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "function_id", nullable = false)
  private Function function;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}