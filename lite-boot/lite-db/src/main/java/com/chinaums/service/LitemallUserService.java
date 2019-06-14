package com.chinaums.service;

import com.chinaums.dao.LitemallUserMapper;
import com.chinaums.domain.LitemallUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zsl on 2019/3/8.
 */
@Service
public class LitemallUserService {
    @Resource
    private LitemallUserMapper userMapper;
    public LitemallUser findById(Integer userId){
        return userMapper.selectByPrimaryKey(userId);
    }

}
