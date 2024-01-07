package com.centum.userservice.service;

import com.centum.userservice.VO.MonthlySavings;
import com.centum.userservice.VO.ResponseTempleteVO;
import com.centum.userservice.model.User;
import com.centum.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of Userservice");// Implement validation or additional logic if needed1
        return userRepository.save(user);
    }

    public ResponseTempleteVO getUserWithMonthlySavings(Long userId){
        log.info("Inside UserWithMonthlySavings of Userservice");
        ResponseTempleteVO vo = new ResponseTempleteVO();
        User user = userRepository.findByUserId(userId);
        vo.setUser(user);
        vo.setMonthlysavings(restTemplate.getForObject("http://MONTHLYSAVINGS-SERVICE/monthlysavings/"+user.getUserId(), MonthlySavings.class));
        return vo;
    }



}
