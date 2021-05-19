package com.ycf.service.fallback;

import com.ycf.model.User;
import com.ycf.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        System.out.println("=========" + throwable.getMessage() + "========");
        System.out.println("=========" + throwable.toString() + "========");
        return new UserService() {
            @Override
            public User getUserById(Integer id) {
                User user = new User();
                user.setId(-999);
                user.setName("用户服务出问题了");
                return user;
            }
        };
    }
}
