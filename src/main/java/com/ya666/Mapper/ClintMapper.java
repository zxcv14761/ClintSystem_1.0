package com.ya666.Mapper;

import com.ya666.Pojo.Clint;
import com.ya666.Pojo.User;
import com.ya666.Vo.ClintVo;

import java.util.List;

public interface ClintMapper {

    Clint queryClintByName(String clintname);
    List<Clint> queryClint();
    int addClint(Clint clint);

    int delClintByUid(Integer uid);

    Clint queryClintByUid(Integer uid);

    int updateClint( Clint clint);

    List<ClintVo> queryClintDailyByUid(Integer uid);

    List<Clint> queryClintBy(Clint clint);


}
