package org.imlsw96.board.service;

import org.imlsw96.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    int countBoard();
    List<BoardVO> getBoardContents(int cp);
    BoardVO selectOneBoard(int bno);

}
