package com.cleosouza.budget_ai_api.controller;

import com.cleosouza.budget_ai_api.audio.TtsService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audio")
public class TtsController {

    private final TtsService ttsService;

    public TtsController(TtsService ttsService) {
        this.ttsService = ttsService;
    }

    @GetMapping(value = "/voz", produces = "audio/mpeg")
    public ResponseEntity<byte[]> gerarVoz(
            @RequestParam String texto) {

        byte[] audio = ttsService.gerarAudio(texto);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("audio/mpeg"))
                .body(audio);
    }
}
