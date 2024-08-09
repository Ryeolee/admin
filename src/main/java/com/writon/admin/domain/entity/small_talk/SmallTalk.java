package com.writon.admin.domain.entity.small_talk;

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
@Table(name = "SmallTalk")
public class SmallTalk {

  @EmbeddedId
  private SmallTalkId id;

  @MapsId("challengeId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @Lob
  @Column(name = "question", length = 300000, nullable = false)
  private String question;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}