package com.laba.MobilMarket.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laba.MobilMarket.dto.UserInfoResponseDto;
import com.laba.MobilMarket.feign.CampaignFeignClient;
import com.laba.MobilMarket.feign.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CampaignService {

    private final RedissonClient redissonClient;
    private final CampaignFeignClient campaignFeignClient;
    private final StringRedisTemplate redisTemplate;

    public String getOffer(Long offerId, String accessToken){

        try {
            String user = redisTemplate.opsForValue().get(accessToken);
            ObjectMapper objectMapper = new ObjectMapper();
            UserInfoResponseDto userInfoResponseDto = objectMapper.readValue(user, UserInfoResponseDto.class);
            String phoneNumber = userInfoResponseDto.phoneNumber();
            RLock lock = redissonClient.getLock("campaign:" +phoneNumber);
            boolean tryLock = lock.tryLock(2, 60, TimeUnit.SECONDS);
            if (tryLock) {
                try {
                    System.out.println("başarılı");

                    return campaignFeignClient.getOffer(offerId);

                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Başka bir istek zaten işlenmekte.");
                throw new RuntimeException();

            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
