package com.writon.admin.domain.entity.activity;

import com.writon.admin.domain.entity.small_talk.SmallTalkComment;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class UserTemplate {

  @Id
  @Column(name = "user_template_id", nullable = false)
  private Integer id;

  @Column(name = "template_date")
  private LocalDate templateDate;

  @Column(name = "complete")
  private Boolean complete;

  @OneToMany(mappedBy = "userTemplete", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<Comment> comments = new ArrayList<>();

  @ColumnDefault("CURRENT_TIMESTAMP(6)")
  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @ColumnDefault("CURRENT_TIMESTAMP(6)")
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

}