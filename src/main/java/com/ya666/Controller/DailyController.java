package com.ya666.Controller;


import com.ya666.Pojo.DailyNote;
import com.ya666.Service.IDailyService;
import com.ya666.util.JsonResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("daily")
public class DailyController extends BaseController{

    @Resource
    IDailyService iDailyService;

    @GetMapping("/queryClintDailyById")
    public JsonResult<DailyNote> findClintDaily(int id){
        DailyNote dailyNote = iDailyService.findDailyNote(id);


        return new JsonResult<>(OK,dailyNote);
    }

    @PostMapping("/OtDailySubmit")
    public JsonResult<Void> DailySubmit(DailyNote dailyNote, HttpSession session){



        String uname = getUsernameFromSession(session);
        Date date = new Date();
        dailyNote.setCreateUser(uname);
        dailyNote.setCreateTime(date);
        dailyNote.setModifieUser(uname);
        dailyNote.setModifieTime(date);
        iDailyService.OtDailySubmit(dailyNote);

        return new JsonResult<>(OK);
    }
    @PostMapping("/DailyModify")
    public JsonResult<Void> DailyModify(DailyNote dailyNote, HttpSession session){

        String uname = getUsernameFromSession(session);
        Date date = new Date();

        dailyNote.setModifieUser(uname);
        dailyNote.setModifieTime(date);

        iDailyService.DailyModify(dailyNote);

        return new JsonResult<>(OK);
    }

}
