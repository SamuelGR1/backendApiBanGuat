package com.example.ParcialPractico.service;

import com.example.ParcialPractico.model.Solicitud;
import com.example.ParcialPractico.repository.SolicitudRepository;
import com.example.ParcialPractico.interceptors.SoapActionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;
import javax.xml.transform.*;
import java.io.StringWriter;
import java.time.LocalDateTime;
import javax.xml.transform.stream.StreamResult;

@Service
public class TipoCambioService {

    private final WebServiceTemplate webServiceTemplate;
    private final SolicitudRepository solicitudRepository;

    @Autowired
    public TipoCambioService(WebServiceTemplate webServiceTemplate, SolicitudRepository solicitudRepository) {
        this.webServiceTemplate = webServiceTemplate;
        this.solicitudRepository = solicitudRepository;
    }

    public String obtenerYGuardarTipoCambio() {
        String requestXml = "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
                "<Body>" +
                "<TipoCambioDiaString xmlns=\"http://www.banguat.gob.gt/variables/ws/\"/>" +
                "</Body>" +
                "</Envelope>";
        Source requestPayload = new StringSource(requestXml);

        String soapAction = "http://www.banguat.gob.gt/variables/ws/TipoCambioDiaString";

        String responsePayload = webServiceTemplate.sendSourceAndReceive(requestPayload,
                new SoapActionInterceptor(soapAction),
                source -> {
                    StringWriter writer = new StringWriter();
                    TransformerFactory.newInstance().newTransformer().transform(source, new StreamResult(writer));
                    return writer.toString();
                });

        Solicitud solicitud = new Solicitud();
        solicitud.setTipoCambio(responsePayload);
        solicitud.setFechaSolicitud(LocalDateTime.now());
        solicitudRepository.save(solicitud);

        return responsePayload;
    }
}