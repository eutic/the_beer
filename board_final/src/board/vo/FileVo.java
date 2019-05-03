package board.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class FileVo {
	private int idx;
	private int boardIdx;
	private String origin;
	private String realName;
	private String regdate;
	
	public FileVo(String origin, String realName) {
		super();
		this.origin = origin;
		this.realName = realName;
	}
	
}
