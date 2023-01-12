package com.ya666.Service.ServiceImpl;

import com.ya666.Mapper.DailyMapper;
import com.ya666.Pojo.DailyNote;
import com.ya666.Service.IDailyService;
import com.ya666.Service.exception.DailyNoteInsertException;
import com.ya666.Service.exception.DailyNoteUpdateException;
import com.ya666.Service.exception.InsertException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class IDailyServiceImpl implements IDailyService {

    @Resource
    DailyMapper dailyMapper;

    @Override
    public DailyNote findDailyNote(Integer id) {
        return dailyMapper.findDailyNote(id);
    }

    @Override
    public int OtDailySubmit(DailyNote dailyNote) {

        int otDailySubmit = dailyMapper.OtDailySubmit(dailyNote);

        if (otDailySubmit != 1){
            throw new DailyNoteInsertException();
        }

        return otDailySubmit;
    }

    @Override
    public int DailyModify(DailyNote dailyNote) {
        int dailyModify = dailyMapper.DailyModify(dailyNote);

        if (dailyModify != 1){
            throw new DailyNoteUpdateException();
        }

        return dailyModify;
    }
}
