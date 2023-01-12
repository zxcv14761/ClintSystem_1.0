package com.ya666.Mapper;

import com.ya666.Pojo.DailyNote;

public interface DailyMapper {

    DailyNote findDailyNote(Integer id);

    int OtDailySubmit (DailyNote dailyNote);

    int DailyModify(DailyNote dailyNote);
}
