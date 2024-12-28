package com.uit.website_ban_sach.service;

import com.uit.website_ban_sach.dto.dto_entity.TaiKhoanDTO;
import com.uit.website_ban_sach.entity.Role;
import com.uit.website_ban_sach.entity.TaiKhoan;
import com.uit.website_ban_sach.mapper.TaiKhoanMapper;
import com.uit.website_ban_sach.repository.RoleRepository;
import com.uit.website_ban_sach.repository.TaiKhoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaiKhoanService {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    private final TaiKhoanRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;

    @Value("${auth.token.expirationInMils}")
    private int jwtExpirationMs;

    public TaiKhoan registerUser(TaiKhoan user) throws Exception {
        if (userRepository.existsByEmail(user.getEmail())){
            throw new Exception("Email đã được sử dụng");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        user.setRoles(Collections.singletonList(userRole));
        return userRepository.save(user);
    }

    public List<TaiKhoanDTO> getAllTaiKhoan() {
        List<TaiKhoanDTO> res = new ArrayList<>();
        List<TaiKhoan> dstk = taiKhoanRepository.findAll();
        for(TaiKhoan tk: dstk){
            res.add(TaiKhoanMapper.mapToTaiKhoanDTO(tk));
        }
        return res;
    }

    public long getTotalTaiKhoan() {
        return taiKhoanRepository.count();
    }
}
