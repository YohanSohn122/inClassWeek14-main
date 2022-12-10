package com.example;

import com.example.bean.BoardVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public int insertBoard(BoardVO vo);
    public int deleteBoard(int id);
    public int updateBoard(BoardVO vo);
    public BoardVO getBoard(int seq);
    public List<BoardVO> getBoardList();
}
