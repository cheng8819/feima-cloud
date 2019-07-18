package com.feima.server.service.impl;

import com.feima.server.domain.FeimaUser;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.feima.server.mapper.FeimaUserMapper;
import com.feima.server.service.FeimaUserService;
import tk.mybatis.mapper.entity.Example;

@Service
public class FeimaUserServiceImpl implements FeimaUserService{

    @Resource
    private FeimaUserMapper feimaUserMapper;

    @Override
    public FeimaUser getByUsername(String username) {
        Example example = new Example(FeimaUser.class);
        example.createCriteria().andEqualTo("username",username);
        return feimaUserMapper.selectOneByExample(example);
    }
}
