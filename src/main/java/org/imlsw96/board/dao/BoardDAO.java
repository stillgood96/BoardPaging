package org.imlsw96.board.dao;


import org.imlsw96.board.vo.BoardVO;

import java.util.List;

public interface BoardDAO {
    int countBoard();
    List<BoardVO> getContents(int snum);
}
