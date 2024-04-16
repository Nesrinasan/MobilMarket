package com.laba.MobilMarket.feign;


import com.laba.MobilMarket.dto.ProductSaveReqestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CampaignService")
public interface CampaignFeignClient {

    @GetMapping("/campaign/getOffer")
    String getOffer(@RequestParam Long offerId);

}
