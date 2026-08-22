package com.cleosouza.budget_ai_api.controller;

import com.cleosouza.budget_ai_api.audio.AudioService;
import com.cleosouza.budget_ai_api.audio.TtsService;
import com.cleosouza.budget_ai_api.service.IAService;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/audio")
public class AudioController {

    private final AudioService audioService;
    private final IAService iaService;
    private final TtsService ttsService;

    public AudioController(
            AudioService audioService,
            IAService iaService,
            TtsService ttsService) {

        this.audioService = audioService;
        this.iaService = iaService;
        this.ttsService = ttsService;
    }

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = "audio/mpeg"
    )
    public ResponseEntity<byte[]> processarAudio(
            @RequestParam("arquivo") MultipartFile arquivo)
            throws Exception {

        // 1. Áudio → texto
        ByteArrayResource resource =
                new ByteArrayResource(arquivo.getBytes()) {

                    @Override
                    public String getFilename() {
                        return arquivo.getOriginalFilename();
                    }
                };

        String pergunta = audioService.transcrever(resource);

        // 2. Texto → IA → Tools → MariaDB → resposta
        String resposta = iaService.perguntar(pergunta);

        // 3. Resposta da IA → áudio
        byte[] audioResposta = ttsService.gerarAudio(resposta);

        // 4. Retorna o áudio
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(audioResposta);
    }
}
