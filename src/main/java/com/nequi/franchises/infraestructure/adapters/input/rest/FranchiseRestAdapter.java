package com.nequi.franchises.infraestructure.adapters.input.rest;

import com.nequi.franchises.application.ports.input.FranchiseServicePort;
import com.nequi.franchises.infraestructure.adapters.input.rest.mapper.FranchiseRestMapper;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.request.FranchiseCreateRequest;
import com.nequi.franchises.infraestructure.adapters.input.rest.model.response.FranchiseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/franchises")
@RequiredArgsConstructor
public class FranchiseRestAdapter {

    private final FranchiseServicePort franchiseServicePort;
    private final FranchiseRestMapper franchiseMapper;

    @GetMapping
    public ResponseEntity sayHello() {
        return ResponseEntity.ok("Hello!!");
    }

    @GetMapping("/{id}")
    public FranchiseResponse getFranchiseById(@PathVariable Long id) {
        return franchiseMapper.toFranchiseResponse(franchiseServicePort.findById(id));
    }

    @PostMapping
    public ResponseEntity<FranchiseResponse> save(@RequestBody FranchiseCreateRequest franchise) {
        return ResponseEntity.status(HttpStatus.CREATED)
                        .body(franchiseMapper.toFranchiseResponse(franchiseServicePort.save(franchiseMapper.toFranchise(franchise))));
    }
}
