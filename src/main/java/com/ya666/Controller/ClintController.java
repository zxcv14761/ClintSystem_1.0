package com.ya666.Controller;

import com.ya666.Pojo.Clint;
import com.ya666.Pojo.User;
import com.ya666.Service.IClintService;
import com.ya666.Vo.ClintVo;
import com.ya666.util.JsonResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/clint")
public class ClintController extends BaseController {

    @Resource
    IClintService iClintService;


    @PostMapping("/addClint")
    public JsonResult<Void> addClint(Clint clint, HttpSession session) throws ParseException {

        if (clint.getTherapyOt() == null) {
            clint.setTherapyOt(1);
        }
        if (clint.getTherapyPt() == null) {
            clint.setTherapyPt(1);
        }
        if (clint.getTherapySt() == null) {
            clint.setTherapySt(1);
        }

        String s = clint.getBirth();
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date birth = sdf.parse(s);

        int duration = (int) ((today.getTime() - birth.getTime()) / (24 * 60 * 60 * 1000)) / 365;
        clint.setAge(duration);


        String uname = getUsernameFromSession(session);

        Date date = new Date();
        clint.setCreateUser(uname);
        clint.setCreateTime(date);
        clint.setModifieUser(uname);
        clint.setModifieTime(date);

        iClintService.addClint(clint);

        return new JsonResult<>(OK);
    }

    @GetMapping("/searchClint")
    public JsonResult<Clint> serechClint() {

        List<Clint> clints = iClintService.queryClint();

        return new JsonResult(200, clints);
    }
    @GetMapping("/searchClintBy")
    public JsonResult<Clint> serechClintByName( Clint clint) {
        if (clint.getName() == null || clint.getName() == ""){
            clint.setName("");
        }

        List<Clint> clints = iClintService.queryClintBy(clint);


        return new JsonResult(200, clints);
    }



    @PostMapping("/deleteClint")
    public JsonResult<Void> deleteClint(Integer uid,HttpSession session,Clint clint) {

        String uname = getUsernameFromSession(session);
        Date date = new Date();
        clint.setCreateUser(uname);
        clint.setCreateTime(date);
        clint.setModifieUser(uname);
        clint.setModifieTime(date);

        iClintService.delClintByUid(uid);

        return new JsonResult<>(OK);
    }


    @GetMapping("/queryClintByUid")
    public JsonResult<Clint> queryClintByUid(Integer uid) {


        Clint queryClint = iClintService.queryClintByUid(uid);



        return new JsonResult<>(OK,queryClint);
    }

    @GetMapping("/queryClintDailyByUid")
    public JsonResult<List<ClintVo>> queryClintDailyByUid(Integer uid) {

        List<ClintVo> clintVos = iClintService.queryClintDailyByUid(uid);

        return new JsonResult<>(OK,clintVos);
    }

    @PostMapping("/updateClint")
    public JsonResult<Void>  updateClintByUid (Clint clint,HttpSession session) throws ParseException {


        if (clint.getTherapyOt() == null) {
            clint.setTherapyOt(1);
        }
        if (clint.getTherapyPt() == null) {
            clint.setTherapyPt(1);
        }
        if (clint.getTherapySt() == null) {
            clint.setTherapySt(1);
        }

        String uname = getUsernameFromSession(session);
        Date date = new Date();
        clint.setCreateUser(uname);
        clint.setCreateTime(date);
        clint.setModifieUser(uname);
        clint.setModifieTime(date);

        String s = clint.getBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse(s);
        int duration = (int) ((date.getTime() - birth.getTime()) / (24 * 60 * 60 * 1000)) / 365;
        clint.setAge(duration);


        iClintService.updateClint(clint);

        return new JsonResult<>(OK);
    }

}
