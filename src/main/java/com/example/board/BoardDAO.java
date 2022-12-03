package com.example.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.example.bean.BoardVO;
import com.mysql.cj.result.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	private JdbcTemplate template;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.template = jdbcTemplate;
	}

	private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo){
		return template.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	public int deleteBoard(int id){
		return template.update(BOARD_DELETE, id);
	}
	public int updateBoard(BoardVO vo){
		return template.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq());
	}
	public BoardVO getBoard(int seq){
		return template.queryForObject(BOARD_GET, new Object[]{seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
	}
	public List<BoardVO> getBoardList(){
		return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
			@Override
			public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVO data = new BoardVO();
				data.setSeq(rs.getInt("seq"));
				data.setTitle(rs.getString("title"));
				data.setRegdate(rs.getDate("regdate"));
				data.setWriter(rs.getString("writer"));
				data.setContent(rs.getString("content"));
				data.setCnt(rs.getInt("cnt"));
				return data;
			}
		});
	}

	public void setTemplate(JdbcTemplate template) { this.template = template;
	}
}