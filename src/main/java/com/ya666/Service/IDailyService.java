package com.ya666.Service;

import com.ya666.Pojo.DailyNote;

public interface IDailyService {

    DailyNote findDailyNote(Integer id);


    int OtDailySubmit(DailyNote dailyNote);

    int DailyModify(DailyNote dailyNote);

}
