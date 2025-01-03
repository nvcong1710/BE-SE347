package com.uit.website_ban_sach.service;

import com.uit.website_ban_sach.dto.dto_entity.DanhMucDTO;
import com.uit.website_ban_sach.dto.response.DanhMucResponse;
import com.uit.website_ban_sach.entity.DanhMuc;
import com.uit.website_ban_sach.mapper.DanhMucMapper;
import com.uit.website_ban_sach.repository.DanhMucRepository;
import com.uit.website_ban_sach.service.service_interface.IDanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DanhMucService implements IDanhMucService {
    @Autowired
    private DanhMucRepository danhMucRepository;

    public Optional<DanhMuc> getDanhMucById(Long id){
        return danhMucRepository.findById(id);
    }

    public DanhMucDTO createDanhMuc(String tenDanhMuc) {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setTenDanhMuc(tenDanhMuc);
        return DanhMucMapper.mapToDanhMucDTO(danhMucRepository.save(danhMuc));
    }

    public List<DanhMucResponse> getAllDanhMuc() {
        List<DanhMucResponse> danhMucDTOList = new ArrayList<>();
        List<DanhMuc> danhMucList = danhMucRepository.findAll();
        for(DanhMuc dm : danhMucList){
            danhMucDTOList.add(new DanhMucResponse(dm.getId(), dm.getTenDanhMuc(), dm.getSaches().stream().count()));
        }
        return danhMucDTOList;
    }

    public DanhMucDTO updateDanhMuc(Long id, DanhMucDTO danhMucDTO) {
        DanhMuc danhMuc = danhMucRepository.findById(id).get();
        danhMuc.setTenDanhMuc(danhMucDTO.getTenDanhMuc());
        return DanhMucMapper.mapToDanhMucDTO(danhMucRepository.save(danhMuc));
    }
}
