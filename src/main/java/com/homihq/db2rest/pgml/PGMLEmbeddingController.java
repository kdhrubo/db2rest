package com.homihq.db2rest.pgml;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
//@ConditionalOnProperty(name = "spring.ai.postgresml.enabled", havingValue = "true")
public class PGMLEmbeddingController {

    private final EmbeddingClient embeddingClient;

    @GetMapping("/ai/embedding")
    public Map<String,EmbeddingResponse> embed(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {

        EmbeddingResponse embeddingResponse = this.embeddingClient.embedForResponse(List.of(message));



        return Map.of("embedding", embeddingResponse);
    }
}
