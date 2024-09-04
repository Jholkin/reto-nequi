package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.application.ports.input.FranchiseServicePort;
import com.nequi.franchises.infraestructure.adapters.input.rest.mapper.RestMapper;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/franchises")
@RequiredArgsConstructor
public class FranchiseRestAdapter {

    private final FranchiseServicePort franchiseServicePort;
    private final RestMapper franchiseMapper;

    @GetMapping("/{id}")
    public FranchiseResponse getFranchiseById(@PathVariable Long id) {
        return franchiseMapper.toFranchiseResponse(franchiseServicePort.findById(id));
    }

    @GetMapping
    public List<FranchiseResponse> findAllFranchises() {
        return franchiseMapper.toFranchiseResponseList(franchiseServicePort.findAll());
    }

    @PostMapping
    public ResponseEntity<FranchiseResponse> save(@RequestBody FranchiseCreateRequest franchise) {
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(franchiseMapper.toFranchiseResponse(franchiseServicePort.save(franchiseMapper.toFranchise(franchise))));
    }
}
