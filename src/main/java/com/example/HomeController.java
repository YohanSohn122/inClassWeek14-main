package com.example;

import com.example.bean.BoardVO;
import com.example.board.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @Autowired
    private BoardDAO boardDAO;

    @RequestMapping("/")
    public String home(){ return "home"; }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model) {
        model.addAttribute("list", boardDAO.getBoardList());
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "addpostform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVO vo) {
        int i = boardDAO.insertBoard(vo);
        if (i == 0) System.out.println("데이터 추가 실패 ");
        else System.out.println("데이터 추가 성공!");
        return "redirect:list";
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model){
        BoardVO boardVO = boardDAO.getBoard(id);
        model.addAttribute("boardVO",boardVO);
        return "editform";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo){
        int i = boardDAO.updateBoard(vo);
        if (i == 0) System.out.println("데이터 수정 실패 ");
        else System.out.println("데이터 수정 성공!");
        return "redirect:list";
    }

    @RequestMapping("/deleteok/{id}")
    public String deletePost(@PathVariable("id") int id, Model model) {
        int i = boardDAO.deleteBoard(id);
        if (i == 0) System.out.println("데이터 수정 실패 ");
        else System.out.println("데이터 수정 성공!");
        return "redirect:list";
    }
}
