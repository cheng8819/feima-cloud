package com.feima.server.service;

import com.feima.server.domain.FeimaPermission;

import java.util.List;

public interface FeimaPermissionService {

    List<FeimaPermission> selectByUserId(Long userId);

}
