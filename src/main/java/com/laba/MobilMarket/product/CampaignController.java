package com.laba.MobilMarket.product;

import com.laba.MobilMarket.dto.ProductSaveReqestDto;
import com.laba.MobilMarket.feign.CampaignFeignClient;
import com.laba.MobilMarket.feign.ProductFeignClient;
import com.laba.MobilMarket.service.CampaignService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping("/getOffer")
    public void save(@RequestParam Long offerId, @RequestHeader String accessToken) {
        campaignService.getOffer(offerId, accessToken);
    }

}
