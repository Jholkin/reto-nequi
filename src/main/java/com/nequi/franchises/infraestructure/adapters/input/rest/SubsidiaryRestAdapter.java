package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.application.ports.input.SubsidiaryServicePort;
import com.nequi.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.SubsidiaryCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.SubsidiaryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subsidiaries")
@RequiredArgsConstructor
public class SubsidiaryRestAdapter {
    private final SubsidiaryServicePort subsidiaryServicePort;
    private final RestMapper subsidiaryMapper;

    @GetMapping("/{id}")
    public SubsidiaryResponse getFranchiseById(@PathVariable Long id) {
        return subsidiaryMapper.toSubsidiaryResponse(subsidiaryServicePort.findById(id));
    }

    @GetMapping
    public List<SubsidiaryResponse> findAllFranchises() {
        return subsidiaryMapper.toSubsidiaryResponseList(subsidiaryServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<SubsidiaryResponse> save(@RequestBody SubsidiaryCreateRequest subsidiary) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(subsidiaryMapper.toSubsidiaryResponse(subsidiaryServicePort.save(subsidiaryMapper.toSubsidiary(subsidiary))));
    }
}
