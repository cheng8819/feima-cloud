package com.feima.config.service;

import com.feima.server.domain.FeimaPermission;
import com.feima.server.domain.FeimaUser;
import com.feima.server.service.FeimaPermissionService;
import com.feima.server.service.FeimaUserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private FeimaUserService userService;
    @Autowired
    private FeimaPermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        FeimaUser user = userService.getByUsername(username);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (user != null){
            List<FeimaPermission> permissions = permissionService.selectByUserId(user.getId());
            permissions.forEach(Permission->{
                grantedAuthorities.add(new SimpleGrantedAuthority(Permission.getEnname()));
            });
        }
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
