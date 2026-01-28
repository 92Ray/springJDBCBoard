package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.Board;
import com.board.domain.User;
import com.board.service.BoardService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/insertForm")
	public String boardInsertForm(Model model, HttpSession session) {
	    User loginUser = (User) session.getAttribute("loginUser");

	    if(loginUser != null) {
	        // 회원이면 작성자 자동 세팅
	        model.addAttribute("writer", loginUser.getNickName());
	        model.addAttribute("isMember", true);
	    } else {
	        // 비회원이면 작성자 입력 가능
	        model.addAttribute("isMember", false);
	    }

	    return "board/insertForm";
	}

	@PostMapping("/insert")
	public String boardInsert(Board board, HttpSession session, Model model) {
	    // 로그인 여부 확인
	    User loginUser = (User) session.getAttribute("loginUser");
	    if(loginUser != null) {
	        board.setWriter(loginUser.getNickName()); // 회원이면 작성자 자동 세팅
	    }

	    try {
	        int count = boardService.insertBoard(board);
	        if(count > 0) {
	            return "redirect:/board/boardlist";
	        } else {
	            model.addAttribute("message", "게시글 등록 실패");
	            return "board/failed";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        model.addAttribute("message", "게시글 등록 중 오류 발생: " + e.getMessage());
	        return "board/failed";
	    }
	}

	
	@GetMapping("/boardlist")
	public String boardList(Model model) {
	    try {
	        List<Board> boardList = boardService.boardList();

	        // 로그 확인
	        if(boardList == null || boardList.isEmpty()) {
	            log.info(">>> boardList is EMPTY!");
	        } else {
	            for(Board b : boardList) {
	                log.info("board no: " + b.getNo() + ", title: " + b.getTitle() + ", writer: " + b.getWriter());
	            }
	        }

	        model.addAttribute("boardList", boardList);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "board/boardList";
	}
	
	
	@GetMapping("/detail")
	public String boardDetail(Board b, Model model) {
	    log.info("boardDetail board = "+b.toString());
	    
	    try {
	        Board board = boardService.selectByNo(b);
	        if(board == null) {
	            return "board/failed";
	        }
	        model.addAttribute("board",board);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return "board/detail";
	}
	
	@GetMapping("/delete")
	public String boardDelete(Board board, Model model) {
		log.info("boardDetail board = "+board.toString());
		
		try {
			int count = boardService.deleteBoard(board);
			if(count > 0) {
				model.addAttribute("message", "%d 님의 정보가 삭제되었습니다.".formatted(board.getNo()));
				return "board/success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("message", "%d 님의 정보 삭제가 실패하였습니다.".formatted(board.getNo()));
		return "board/failed";
	}
	
	@GetMapping("/updateForm")
	public String boardUpdateForm(Board b, Model model) {
	    log.info("updateForm board = "+b.toString());
	    
	    try {
	        Board board = boardService.selectByNo(b);
	        if(board == null) {
	            model.addAttribute("message", "%d 님의 정보가 없습니다".formatted(b.getNo()));
	            return "board/failed";
	        }
	        model.addAttribute("board", board);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return "board/updateForm";
	}
	
	@PostMapping("/update")
	public String updateBoard(Model model, Board board) {
	    log.info("updateBoard board = "+board.toString());

	    try {
	        int count = boardService.updateBoard(board);
	        if(count > 0) {
	            return "redirect:/board/boardlist";
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    model.addAttribute("message", "수정 실패");
	    return "board/failed";
	}
	
	@GetMapping("/search")
	public String boardSearch(Model model, Board board) {
		log.info("search board = " + board.toString());
		
		try {
			List<Board> boardList = boardService.boardSerch(board);
			
			model.addAttribute("boardList",boardList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "board/boardList";
	}
	
	
}






