package com.ya666.Service.ServiceImpl;

import com.ya666.Mapper.UserMapper;
import com.ya666.Pojo.User;
import com.ya666.Service.IUserService;
import com.ya666.Service.exception.InsertException;
import com.ya666.Service.exception.UserNotExistException;
import com.ya666.Service.exception.UsernameDuplicateException;
import com.ya666.Service.exception.WrongPasswordException;
import com.ya666.util.PasswordEncryptedUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    //處理登入
    @Override
    public User userLogin(User user) {

        //前端輸入
       String username = user.getUsername();
       String password = user.getPassword();

       //後端驗證
        User loginUser = userMapper.queryUserByUsername(username);

        if(loginUser == null){
            throw new UsernameDuplicateException("用戶名不存在");
        }
        String realPassword = loginUser.getPassword();
        Integer isDelete = loginUser.getIsDelete();
        String passwordByMD5 = PasswordEncryptedUtils.getPasswordByMD5(password, loginUser.getSalt());


        if (!realPassword.equals(passwordByMD5)){
            throw new WrongPasswordException("密碼不正確");
        }
        if (isDelete == 1){
            throw new UserNotExistException("該用户不存在");
        }
        return loginUser;



    }
    //註冊帳號
    @Override
    public void addUser(User user) {

        User queryUser = userMapper.queryUserByUsername(user.getUsername());

        if(queryUser != null){
            throw new UsernameDuplicateException("用戶名已被註冊");
        }
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();

        user.setSalt(salt);
        user.setGender(user.getGender());
        user.setPhone(user.getPhone());
        user.setEmail(user.getEmail());

        String md5Password = PasswordEncryptedUtils.getPasswordByMD5(oldPassword, salt);
        user.setPassword(md5Password);
        user.setIsDelete(0);

        Date currenTime = new Date();
        user.setCreateUser(user.getUsername());
        user.setCreateTime(currenTime);
        user.setModifieUser(user.getUsername());
        user.setModifieTime(currenTime);

        int result = userMapper.addUser(user);

        if(result != 1){
            throw new InsertException("處理用戶註冊過程中,伺服器發生異常");
        }


    }
}
