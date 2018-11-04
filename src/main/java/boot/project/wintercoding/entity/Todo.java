package boot.project.wintercoding.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Setter
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(length=100, nullable=false)
	private String title;
	
	@Column(length=300, nullable=false)
	private String content;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate deadline;
	
	@Column(length=1)
	private String complete;
	private int priority;
}
