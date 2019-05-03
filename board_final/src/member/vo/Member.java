package member.vo;

import lombok.Data;

@Data
public class Member {
	private int idx; // pk
	private String email; // id 
	private String pw; // 암호화
	private String name;
	private boolean admin;
	
}
