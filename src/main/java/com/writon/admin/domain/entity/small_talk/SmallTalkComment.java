package com.writon.admin.domain.entity.small_talk;

import com.writon.admin.domain.entity.user.Affiliation;
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
@Table(name = "SmallTalkComment")
public class SmallTalkComment {

  @EmbeddedId
  private SmallTalkCommentId id;

  @MapsId("AffiliationId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "affiliation_id", nullable = false, referencedColumnName = "affiliation_id")
  @JoinColumn(name = "organization_id", nullable = false, referencedColumnName = "organization_id")
  @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
  private Affiliation affiliation;

  @Lob
  @Column(name = "content",length = 2000, nullable = false)
  private String content;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}