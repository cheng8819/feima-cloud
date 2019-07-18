package com.feima.server.mapper;

import com.feima.server.domain.FeimaPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

public interface FeimaPermissionMapper extends MyMapper<FeimaPermission> {
    List<FeimaPermission> selectByUserId(@Param("userId") Long userId);
}