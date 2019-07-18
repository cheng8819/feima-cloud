package com.feima.server.service;

import com.feima.server.domain.FeimaUser;

public interface FeimaUserService{
    FeimaUser getByUsername(String username);

}
