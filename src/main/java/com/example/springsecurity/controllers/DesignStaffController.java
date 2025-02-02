package com.example.springsecurity.controllers;

import com.example.springsecurity.model.dto.DesignRecordDto;
import com.example.springsecurity.model.payload.request.DesignRecordForm;
import com.example.springsecurity.model.payload.response.ResponseData;
import com.example.springsecurity.service.DesignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/designs")
public class DesignStaffController {
    @Autowired
    private DesignRecordService designRecordService;

    // TẠO HỒ SƠ THIẾT KẾ BẢN VẼ
    @PostMapping("/create/{customerId}")
    public ResponseEntity<ResponseData<DesignRecordDto>> createDesignRecord(@RequestBody DesignRecordForm form, @PathVariable Long customerId) {
        return ResponseEntity.ok(designRecordService.createDesignCord(form, customerId));
    }

    // CẬP NHẬT BẢN VẼ HOẶC GHI CHÚ MỚI
    @PutMapping("/update/{recordId}")
    public ResponseEntity<ResponseData<DesignRecordDto>> updateDesignRecord(@PathVariable Long recordId, @RequestBody DesignRecordForm form) {
        return ResponseEntity.ok(designRecordService.updateDesignRecord(recordId, form));
    }

    @DeleteMapping("/delete/{recordId}")
    public ResponseEntity<ResponseData<DesignRecordDto>> deleteRecord(@PathVariable Long recordId){
        return ResponseEntity.ok(designRecordService.deleteRecord(recordId));
    }
}
