package com.smhrd.web.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smhrd.web.entity.Board;
import com.smhrd.web.entity.SearchCriteria;

@Mapper
public interface BoardMapper {

	// 게시글을 전체 조회하는 메소드
	public ArrayList<Board> selectBoard();
	
	// 게시글을 추가하는 메소드
	public int insertBoard(Board board);

	// 게시글 하나를 조회하는 메소드
	// --> 비교적 간단한 sql 구문의 경우에는 굳이 xml 파일에 분리하지 않고 annotation으로 처리하기도 한다.
	@Select("select * from board where bnum = #{bnum}")
	public Board selectOne(int bnum);
	
	@Update("update board set bcnt=bcnt+1 where bnum = #{bnum}")
	public void count(int bnum);

	// 내용에 검색한 글자가 "포함"되어있는 모든 게시글을 조회해주는 쿼리
	// -> .xml 파일에 작성하기
	public List<Board> search(SearchCriteria cri);
	
}