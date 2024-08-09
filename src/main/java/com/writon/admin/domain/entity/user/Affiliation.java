package com.writon.admin.domain.entity.user;

import com.writon.admin.domain.entity.activity.Comment;
import com.writon.admin.domain.entity.activity.Like;
import com.writon.admin.domain.entity.organization.Organization;
import com.writon.admin.domain.entity.small_talk.SmallTalkComment;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Entity
@Table(name = "Affiliation")
public class Affiliation {

  @EmbeddedId
  private AffiliationId id;

  @MapsId("organizationId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "organization_id", nullable = false)
  private Organization organization;

  @MapsId("userId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "hire_date")
  private LocalDate hireDate;

  @Column(name = "position", length = 20)
  private String position;

  @Column(name = "position_introduce", length = 300)
  private String positionIntroduce;

  @Column(name = "nickname", nullable = false, length = 191)
  private String nickname;

  @Column(name = "company", length = 50)
  private String company;

  @Column(name = "company_public")
  private Boolean companyPublic;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "affiliation", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<UserChallenge> userChallenges = new ArrayList<>();

  @OneToMany(mappedBy = "affiliation", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<Like> likes = new ArrayList<>();

  @OneToMany(mappedBy = "affiliation", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<Comment> comments = new ArrayList<>();

  @OneToMany(mappedBy = "affiliation", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
  @Builder.Default
  private List<SmallTalkComment> smallTalkComments = new ArrayList<>();


}