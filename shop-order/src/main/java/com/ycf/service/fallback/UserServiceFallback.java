package com.ycf.service.fallback;

import com.ycf.model.User;
import com.ycf.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallback implements UserService {
    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setId(-1);
        user.setName("远程服务出错");
        return user;
    }
}
