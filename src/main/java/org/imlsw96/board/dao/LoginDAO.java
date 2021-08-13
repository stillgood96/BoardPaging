package org.imlsw96.board.dao;

import org.imlsw96.board.vo.UserVO;

public interface LoginDAO {
    int insertUser(UserVO uvo);
    int checkUser(String user);
    int tryLogin(UserVO uvo);
}
