package com.uit.website_ban_sach.service.service_interface;

import com.uit.website_ban_sach.dto.dto_entity.DanhMucDTO;
import com.uit.website_ban_sach.dto.response.DanhMucResponse;
import com.uit.website_ban_sach.entity.DanhMuc;

import java.util.List;
import java.util.Optional;

public interface IDanhMucService {
    public Optional<DanhMuc> getDanhMucById(Long id);
    public DanhMucDTO createDanhMuc(String tenDanhMuc);
    public List<DanhMucResponse> getAllDanhMuc();
    public DanhMucDTO updateDanhMuc(Long id, DanhMucDTO danhMucDTO);
}
