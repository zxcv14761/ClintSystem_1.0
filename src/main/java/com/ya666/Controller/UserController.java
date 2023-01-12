package com.ya666.Controller;


import com.ya666.Pojo.Clint;
import com.ya666.Pojo.User;
import com.ya666.Service.ServiceImpl.IUserServiceImpl;
import com.ya666.util.JsonResult;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Resource
    private IUserServiceImpl iUserService;


    @PostMapping
    public JsonResult<User> login(User user, HttpSession session){

        User LoginUser = iUserService.userLogin(user);

        session.setAttribute("uid",LoginUser.getUid());
        session.setAttribute("username",LoginUser.getUsername());
        session.setAttribute("userType",LoginUser.getUserType());


        User newUser = new User();
        newUser.setUsername(LoginUser.getUsername());
        newUser.setUid(LoginUser.getUid());
        newUser.setUserType(LoginUser.getUserType());


        return new JsonResult<>(OK,newUser);
    }
    @PostMapping("/reg")
    public JsonResult<Void> userRegister(User user) {

        //执行插入操作
        iUserService.addUser(user);

        return new JsonResult<>(OK);
    }


}
