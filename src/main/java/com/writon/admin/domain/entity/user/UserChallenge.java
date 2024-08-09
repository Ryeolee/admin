package com.writon.admin.domain.entity.user;

import com.writon.admin.domain.entity.challenge.Challenge;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
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
@Table(name = "UserChallenge")
public class UserChallenge {

  @EmbeddedId
  private UserChallengeId id;

  @MapsId("challengeId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "challenge_id", nullable = false)
  private Challenge challenge;

  @MapsId("AffiliationId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "affiliation_id", nullable = false, referencedColumnName = "affiliation_id")
  @JoinColumn(name = "organization_id", nullable = false, referencedColumnName = "organization_id")
  @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
  private Affiliation affiliation;

  @Column(name = "user_deposit", nullable = false)
  private Integer userDeposit;

  @Column(name = "review", nullable = false)
  private Byte review;

  @Column(name = "check_count")
  private Integer checkCount;

  @Column(name = "re_engagement")
  private Byte reEngagement;

  @Column(name = "cheering_phrase")
  private String cheeringPhrase;

  @Column(name = "cheering_phrase_date")
  private LocalDate cheeringPhraseDate;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}