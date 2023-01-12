package com.ya666.Controller;

import com.ya666.Service.exception.*;
import com.ya666.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpSession;


/**
 * @author hcxs1986
 * @version 1.0
 * @description: 基類Controller
 * @date 2022/7/11 0:23
 */
public class BaseController {
    //操作成功的状态码
    public static final int OK = 200;

    /**
     * 1.当出现了value内的异常之一，就会将下方的方法作为新的控制器方法进行执行
     * 因此该方法的返回值也同时是返回给前端的页面
     * 2.此外还自动将异常对象传递到此方法的参数列表中，这里使用Throwable e来接收
     **/
    @ExceptionHandler({ServiceException.class}) //统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicateException) {
            result.setStatus(4000); //表示用户名重复
        } else if (e instanceof UserNotExistException) {
            result.setStatus(5002); //表示用户数据不存在
        } else if (e instanceof WrongPasswordException) {
            result.setStatus(5003); //表示密码错误
        }else if (e instanceof InsertException){
            result.setStatus(5004);//插入數據異常
        }else if (e instanceof ClintDuplicateException) {
            result.setStatus(4001);//個案名重複
        } else if (e instanceof  DeleteException) {
            result.setStatus(5005);//刪除異常
        } else if (e instanceof UpdateClintException) {
            result.setStatus(5006);//個案更新時異常
        } else if (e instanceof DailyNoteInsertException) {
            result.setStatus(4002);//daily插入異常
        }else if (e instanceof DailyNoteUpdateException) {
            result.setStatus(4003);//daily更新異常
        }
        //返回异常处理结果
        return result;
    }

    /**
     * 從session中獲取用户uid
     * @param session
     * @return
     */
    public final Integer getUserIdFromSession(HttpSession session) {
        String uidStr = session.getAttribute("uid").toString();

        return Integer.valueOf(uidStr);
    }

    /**
     * 從session中獲取用户username
     * @param session
     * @return
     */
    public final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }
    public final String getUsertypeFromSession(HttpSession session) {
        return session.getAttribute("userType").toString();
    }

}

