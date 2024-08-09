package com.writon.admin.domain.entity.challenge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import java.time.LocalDate;
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
@Table(name = "~Function~")
public class Function {

  @Id
  @Column(name = "function_id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false, length = 45)
  private String name;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  // @ColumnDefault("CURRENT_TIMESTAMP")
  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}