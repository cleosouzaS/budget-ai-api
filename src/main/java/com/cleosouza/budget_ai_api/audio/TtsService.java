package com.cleosouza.budget_ai_api.audio;

import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.stereotype.Service;

@Service
public class TtsService {

    private final OpenAiAudioSpeechModel speechModel;

    public TtsService(OpenAiAudioSpeechModel speechModel) {
        this.speechModel = speechModel;
    }

    public byte[] gerarAudio(String texto) {
        return speechModel.call(texto);
    }
}
