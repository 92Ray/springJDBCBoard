package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.board.domain.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insertBoard(Board board) {
		String query ="INSERT INTO JDBCBOARD VALUES(JDBCBOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
		
		int count = jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
		
		return count;
	}

	public List<Board> boardList() {
		String query = "SELECT * FROM JDBCBOARD WHERE NO > 0 ORDER BY NO DESC, REG_DATE DESC";
		
		List<Board> boardList = jdbcTemplate.query(query, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REG_DATE"));
				
				return board;
			}
		});
		
		return boardList;
	}

	public Board selectByNo(Board b) {
		String query = "select * from jdbcboard where no = ?";
		
		List<Board> board = jdbcTemplate.query(query, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REG_DATE"));
				
				return board;
			}
		}, b.getNo());
		
		return board.isEmpty() ? null : board.get(0);
	}

	public int deleteBoard(Board board) {
		
		String query = "delete from jdbcboard where no = ?";
		
		int count = jdbcTemplate.update(query, board.getNo());
		
		return count;
	}

	public int updateBoard(Board board) {
		String query = "update jdbcboard set writer = ?, title = ?, content = ? where no = ?";
		
		int count = jdbcTemplate.update(query, board.getWriter(), board.getTitle(), board.getContent(), board.getNo());
		
		return count;
	}

	public List<Board> boardSerch(Board board) {
		String callName = board.getSearchType();
		
		String query = "SELECT * FROM JDBCBOARD WHERE " +callName+" LIKE ? ORDER BY NO DESC, REG_DATE DESC";
		
		List<Board> boardList = jdbcTemplate.query(query, new RowMapper<Board>() {
			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				
				board.setNo(rs.getInt("NO"));
				board.setTitle(rs.getString("TITLE"));
				board.setContent(rs.getString("CONTENT"));
				board.setWriter(rs.getString("WRITER"));
				board.setRegDate(rs.getDate("REG_DATE"));
				
				return board;
			}
		}, "%"+board.getKeyword()+"%");
		
		return boardList;
	}
	
}
