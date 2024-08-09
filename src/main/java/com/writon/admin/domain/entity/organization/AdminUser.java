package com.writon.admin.domain.entity.organization;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Entity
@Table(name = "AdminUser")
public class AdminUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "admin_user_id", nullable = false)
  private Integer id;

  @Column(name = "identifier", nullable = false, length = 45)
  private String identifier;

  @Column(name = "password", nullable = false)
  private String password;

 // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

 // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}