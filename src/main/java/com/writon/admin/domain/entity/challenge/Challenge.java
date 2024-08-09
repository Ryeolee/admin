package com.writon.admin.domain.entity.challenge;

import com.writon.admin.domain.entity.organization.Organization;
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
@Table(name = "Challenge")
public class Challenge {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "challenge_id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = 40)
  private String name;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "start_at", nullable = false)
  private LocalDate startAt;

  @Column(name = "finish_at", nullable = false)
  private LocalDate finishAt;

  @Column(name = "deposit", nullable = false)
  private Integer deposit;


  @Column(name = "review_url")
  private String reviewUrl;


  @Column(name = "refund_conditions" , length = 10000)
  private String refundConditions;

  @Column(name = "restart")
  private Byte restart;

  @ManyToOne(fetch = FetchType.LAZY)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "organization_id")
  private Organization organization;

}