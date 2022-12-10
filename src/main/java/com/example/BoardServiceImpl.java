package com.example;

import com.example.bean.BoardVO;
import com.example.board.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardDAO boardDAO;

    public int insertBoard(BoardVO vo){
        return boardDAO.insertBoard(vo);
    }

    @Override
    public int deleteBoard(int id) {
        return boardDAO.deleteBoard(id);
    }

    @Override
    public int updateBoard(BoardVO vo) {
        return boardDAO.updateBoard(vo);
    }

    public BoardVO getBoard(int seq){
        return boardDAO.getBoard(seq);
    }

    public List<BoardVO> getBoardList(){
        return boardDAO.getBoardList();
    }
}
