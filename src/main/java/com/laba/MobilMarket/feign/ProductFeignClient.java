package com.laba.MobilMarket.feign;


import com.laba.MobilMarket.dto.ProductSaveReqestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ProductService")
public interface ProductFeignClient {

    @GetMapping("/product/save")
    void save(@RequestBody ProductSaveReqestDto productSaveReqestDto);

}
