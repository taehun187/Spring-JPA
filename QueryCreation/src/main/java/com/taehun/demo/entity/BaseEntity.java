package com.taehun.demo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
	
	protected String createdBy;
	
	@CreationTimestamp
	protected LocalDateTime creationDate;
	
	protected String lastModifiedBy;
	
	@UpdateTimestamp
	protected LocalDateTime lastModifiedDate;

}
