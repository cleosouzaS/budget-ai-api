package com.cleosouza.budget_ai_api.audio;

import org.springframework.ai.audio.transcription.TranscriptionModel;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class AudioService {

    private final TranscriptionModel transcriptionModel;

    public AudioService(TranscriptionModel transcriptionModel) {
        this.transcriptionModel = transcriptionModel;
    }

    public String transcrever(Resource audio) {
        return transcriptionModel.transcribe(audio);
    }
}
