package org.imlsw96.board.service;

import org.imlsw96.board.vo.UserVO;

public interface LoginService {

    int insertUser(UserVO uvo);
    int checkUser(String userid);
}
