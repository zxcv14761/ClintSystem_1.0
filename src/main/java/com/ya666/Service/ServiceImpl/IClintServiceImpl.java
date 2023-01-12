package com.ya666.Service.ServiceImpl;


import com.ya666.Mapper.ClintMapper;
import com.ya666.Mapper.UserMapper;
import com.ya666.Pojo.Clint;
import com.ya666.Service.IClintService;
import com.ya666.Service.exception.*;
import com.ya666.Vo.ClintVo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IClintServiceImpl implements IClintService {

    @Resource
    ClintMapper clintMapper;


    @Override
    public void addClint(Clint clint) {
        String clintName = clint.getName();

        Clint queryClint = clintMapper.queryClintByName(clintName);

        //個案姓名可能會重複
//        if(queryClint != null){
//            throw new ClintDuplicateException("資料庫中已有此個案");
//        }

        clint.setIsDelete(0);



        int addClint = clintMapper.addClint(clint);
        if (addClint != 1){
            throw new InsertException("處理添加個案過程中,伺服器發生異常");
        }

    }

    //搜尋所有個案
    @Override
    public List<Clint> queryClint() {
        List<Clint> clints = clintMapper.queryClint();

        return clints;
    }

    //條件搜尋所有個案
    @Override
    public List<Clint> queryClintBy(Clint clint) {
        List<Clint> clints = clintMapper.queryClintBy(clint);

        return clints;
    }


    //刪除個案 isdelete = 1
    @Override
    public int delClintByUid(Integer uid) {
        int delClint = clintMapper.delClintByUid(uid);

        if (delClint != 1){
            throw new DeleteException("處理刪除個案過程中,伺服器發生異常");
        }

        return delClint;
    }

    @Override
    public Clint queryClintByUid(Integer uid) {
        Clint clint = clintMapper.queryClintByUid(uid);


        return clint;
    }

    @Override
    public int updateClint( Clint clint) {
        int updateClintCount = clintMapper.updateClint( clint);

        if (updateClintCount != 1){
            throw new UpdateClintException();
        }

        return updateClintCount;
    }

    @Override
    public List<ClintVo> queryClintDailyByUid(Integer uid) {

        return  clintMapper.queryClintDailyByUid(uid);

    }
}
