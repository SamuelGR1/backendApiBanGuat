package com.example.ParcialPractico.controller;

import com.example.ParcialPractico.model.Solicitud;
import com.example.ParcialPractico.repository.SolicitudRepository;
import com.example.ParcialPractico.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/api/tipoCambio")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoCambioController {

    private final TipoCambioService tipoCambioService;
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public TipoCambioController(TipoCambioService tipoCambioService, SolicitudRepository solicitudRepository) {
        this.tipoCambioService = tipoCambioService;
        this.solicitudRepository = solicitudRepository;
    }

    @GetMapping("/datoscambio")
    public ResponseEntity<String> obtenerTipoCambioActual() {
        String tipoCambio = tipoCambioService.obtenerYGuardarTipoCambio();
        return ResponseEntity.ok(tipoCambio);
    }

    @GetMapping("/registros")
    public ResponseEntity<List<Solicitud>> obtenerHistorial() {
        return ResponseEntity.ok(solicitudRepository.findAll());
    }
}
