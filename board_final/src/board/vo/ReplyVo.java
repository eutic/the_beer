package board.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class ReplyVo {
	private int idx;
	private int boardIdx;
	private String content;
	private String writer;
	private String regdate;
	private int writerIdx;
	
}
