package com.ya666.Service;

import com.ya666.Pojo.Clint;
import com.ya666.Vo.ClintVo;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface IClintService {

    void addClint(Clint clint );

    List<Clint> queryClint();
    List<Clint> queryClintBy(Clint clint);

    int delClintByUid(Integer uid);

    Clint queryClintByUid(Integer uid);

    int updateClint( Clint clint);

    List<ClintVo> queryClintDailyByUid(Integer uid);


}
