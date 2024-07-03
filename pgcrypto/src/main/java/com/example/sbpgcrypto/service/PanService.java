package com.example.sbpgcrypto.service;

import com.example.sbpgcrypto.dto.BulkPansDto;
import com.example.sbpgcrypto.entity.Pan;
import com.example.sbpgcrypto.repository.PanRepository;
import com.example.sbpgcrypto.repository.BulkPanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanService {


    final BulkPanRepository bulkPanRepository;

    final PanRepository panRepository;

    public void bulkUpload(BulkPansDto bulkPansDto, String pan_type, String status) {
        bulkPanRepository.savePans(bulkPansDto, pan_type, status);
    }

    public Pan createPan(Pan excludePan) {
        return panRepository.save(excludePan);
    }

    public List<Pan> getPans() {
        return panRepository.findAll();
    }


    public List<Pan> getPansByType(String type) {
        return panRepository.findByType(type);
    }

    public List<Pan> getPansByStatus(String status) {
        return panRepository.findByStatus(status);
    }

    public List<String> getPanByReadLimit(Long panReadLimit) {
        return panRepository.findPansByReadLimit(panReadLimit);
    }

}
