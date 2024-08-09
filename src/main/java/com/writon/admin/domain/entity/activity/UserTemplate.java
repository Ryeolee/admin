package com.writon.admin.domain.entity.activity;

import com.writon.admin.domain.entity.small_talk.SmallTalkComment;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "UserTemplate")
public class UserTemplate {

  @Id
  @Column(name = "user_template_id", nullable = false)
  private Integer id;

  @Column(name = "template_date")
  private LocalDate templateDate;

  @Column(name = "complete")
  private Boolean complete;

  @OneToMany(mappedBy = "userTemplate", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<Comment> comments = new ArrayList<>();

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}