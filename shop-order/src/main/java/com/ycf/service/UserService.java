package com.ycf.service;

import com.ycf.model.User;
import com.ycf.service.fallback.UserServiceFallback;
import com.ycf.service.fallback.UserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(
        value = "service-user",
        //fallback = UserServiceFallback.class   //这种比较少用，因为拿不到异常的信息，还是要用FallbackFactory
        fallbackFactory = UserServiceFallbackFactory.class
)
public interface UserService {

    @RequestMapping("/user/getById/{id}")
    User getUserById(@PathVariable Integer id);
}
