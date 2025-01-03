package com.uit.website_ban_sach.dto.response;

import com.uit.website_ban_sach.dto.dto_entity.SachDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SachPhanTrang {
    List<SachDTO> listSach;
    Integer tongSoTrang;
}
