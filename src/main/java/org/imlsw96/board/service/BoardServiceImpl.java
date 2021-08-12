package org.imlsw96.board.service;

import org.imlsw96.board.dao.BoardDAO;
import org.imlsw96.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("bsrv")
public class BoardServiceImpl implements BoardService{


    @Autowired
    BoardDAO bdao;

    @Override
    public int countBoard() {
        return bdao.countBoard();
    }

    @Override
    public List<BoardVO> getBoardContents(int cp) {
        int snum = (cp-1) * 5;
        return bdao.getContents(snum);
    }

    @Override
    public BoardVO selectOneBoard(int bno) {
        return bdao.selectOneBoard(bno);
    }
}
