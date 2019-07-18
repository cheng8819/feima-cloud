package com.feima.server.service.impl;

import com.feima.server.domain.FeimaPermission;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.feima.server.mapper.FeimaPermissionMapper;
import com.feima.server.service.FeimaPermissionService;

import java.util.List;

@Service
public class FeimaPermissionServiceImpl implements FeimaPermissionService{

    @Resource
    private FeimaPermissionMapper feimaPermissionMapper;

    @Override
    public List<FeimaPermission> selectByUserId(Long userId) {
        return feimaPermissionMapper.selectByUserId(userId);
    }
}
