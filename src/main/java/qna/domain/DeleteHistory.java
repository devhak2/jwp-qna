package qna.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DeleteHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ContentType contentType;

	private Long contentId;

	@ManyToOne(cascade = CascadeType.ALL)
	private User eraser;

	private LocalDateTime createDate = LocalDateTime.now();

	protected DeleteHistory() {
		int[][] dp = new int[3][3];
		String[] stringArray = {"a", "b", "c"};
		// java.util.Arrays.ArrayList != java.util.ArrayLit, Arrays.ArrayList는 불변한 리스트를 리턴한다. add() 메소드 사용불가
	}

	public DeleteHistory(ContentType contentType, Long contentId, User eraser) {
		this.contentType = contentType;
		this.contentId = contentId;
		this.eraser = eraser;
	}

	public DeleteHistory(ContentType contentType, Long contentId, User eraser, LocalDateTime createDate) {
		this.contentType = contentType;
		this.contentId = contentId;
		this.eraser = eraser;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public User getEraser() {
		return eraser;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		DeleteHistory that = (DeleteHistory)o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "DeleteHistory{" +
			"id=" + id +
			", contentType=" + contentType +
			", contentId=" + contentId +
			", eraser=" + eraser +
			", createDate=" + createDate +
			'}';
	}
}
