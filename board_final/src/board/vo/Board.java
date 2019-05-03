package board.vo;

import lombok.Data;

@Data
public class Board {
	private int idx; // pk
	private String title; // id 
	private String content; 
	private String writer;
	private String regdate;
	private int count;
	private int reco;
	private int category;
	private int fileCount;
	private int commentCount;
	private int writerIdx;
	
}
