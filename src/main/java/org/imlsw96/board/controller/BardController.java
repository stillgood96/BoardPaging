package org.imlsw96.board.controller;


import org.imlsw96.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BardController {

    @Autowired
    BoardService bsrv;

    @GetMapping("/board")
    public ModelAndView index(ModelAndView mv, @RequestParam String cp) {
        int realCP = Integer.parseInt(cp);
        mv.setViewName("index");
        mv.addObject("cp", cp);
        mv.addObject("bdCnt", bsrv.countBoard() );
        mv.addObject("bdInfo", bsrv.getBoardContents(realCP) );

        return mv;
    }

    @GetMapping("/board/view")
    public ModelAndView view(ModelAndView mv, @RequestParam String bno){
        int intBno = Integer.parseInt(bno);
        mv.setViewName("boardView");
        mv.addObject("bno",bno);
        mv.addObject("boardInfo", bsrv.selectOneBoard(intBno));
        mv.addObject("bdCnt", bsrv.countBoard() );
        return mv;
    }
}
