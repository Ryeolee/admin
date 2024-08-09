package com.writon.admin.domain.entity.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import java.time.LocalDateTime;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@Entity
@Table(name = "User")
public class User {

  @Id
  @Column(name = "user_id", nullable = false)
  private Integer id;

  @Column(name = "role", nullable = false, length = 20)
  private String role;

  @Column(name = "identifier", nullable = false, length = 40)
  private String identifier;

  @Column(name = "password")
  private String password;

  @Column(name = "email", nullable = false, length = 40)
  private String email;

  @Column(name = "profile", length = 500)
  private String profile;

  @Column(name = "account_number", length = 40)
  private String accountNumber;

  @Column(name = "bank", length = 20)
  private String bank;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}