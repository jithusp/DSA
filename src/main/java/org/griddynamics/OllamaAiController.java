package org.griddynamics;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class OllamaAiController {

    private final OllamaChatClient chatClient;

    @GetMapping("/ask")
    public String ask(@RequestParam String prompt) {
        return chatClient.call(prompt);
    }
}
