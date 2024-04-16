package com.laba.MobilMarket.product;

import com.laba.MobilMarket.dto.ProductSaveReqestDto;
import com.laba.MobilMarket.feign.ProductFeignClient;
import com.laba.MobilMarket.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserFeignClient userFeignClient;

    @PostMapping("/infoByNumber")
    public void save(@RequestHeader String phoneNumber) {
        userFeignClient.info(phoneNumber);
    }

}
