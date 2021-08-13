package org.imlsw96.board.dao;

import org.apache.ibatis.session.SqlSession;
import org.imlsw96.board.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ldao")
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public int insertUser(UserVO uvo) {
        return sqlSession.insert("user.insertUser", uvo);
    }

    @Override
    public int checkUser(String userId) {
        return sqlSession.selectOne("user.checkUser", userId);
    }

    @Override
    public int tryLogin(UserVO uvo) {
        return sqlSession.selectOne("user.tryLogin", uvo);
    }
}
