package com.smhrd.web.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity // 엔티티 클래스임을 나타내는 annotation
@Table(name="datamember") // (선택)
public class DataMember {
	// DB 테이블 자체를 의미하는 클래스
	
	// @Id : primary key 의미
	@Id //제공하는 package가 persistence여야함 다른 패키지랑 헷갈리지 말것
	// @Column : 해당하는 필드에 대응되는 테이블 컬럼의 디테일한 설정 가능
	@Column(name="id", length=100)
	private String id;
	@Column(name="pw", length= 100, nullable=false)
	private String pw;
	// default값 설정 필요
	@ColumnDefault("'users'")
	@Column(nullable=false, insertable=false)
	private String roles;
}
