package com.ict.pretzel_admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ict.pretzel_admin.mapper.AdminMapper;
import com.ict.pretzel_admin.vo.AdminVO;

@Service
public class AdminDetailsService implements UserDetailsService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String admin_id) throws UsernameNotFoundException {
        AdminVO admin = adminMapper.login(admin_id);
        if (admin == null) {
            throw new UsernameNotFoundException("admin not found : " + admin_id);
        }
        return new User(admin.getAdmin_id(), admin.getPwd(), new ArrayList<>());
    }
    
    // 개인정보 추출 (/api/userInfo 후 AuthController 에서 호출)
    public AdminVO getAdminDetail(String admin_id) throws Exception{
        AdminVO admin = adminMapper.login(admin_id);
        return admin;
    }

}
