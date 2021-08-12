package org.imlsw96.board.dao;


import org.apache.ibatis.session.SqlSession;
import org.imlsw96.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bdao")
public class BoardDAOImpl implements BoardDAO{

    @Autowired
    SqlSession sqlSession;


    @Override
    public int countBoard() {
        return sqlSession.selectOne("board.selectBno");
    }

    @Override
    public List<BoardVO> getContents(int snum) {
        return sqlSession.selectList("board.selectContents", snum);
    }

    @Override
    public BoardVO selectOneBoard(int bno) {
        return sqlSession.selectOne("board.selectOneBoard", bno);
    }
}
