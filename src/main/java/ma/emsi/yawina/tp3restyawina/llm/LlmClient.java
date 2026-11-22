package ma.emsi.yawina.tp3restyawina.llm;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

@Dependent
public class LlmClient {

    private final GuideTouristique guideTouristique;

    public LlmClient() {
        String apiKey = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-3.5-flash-lite")
                .build();

        ChatMemory chatMemory =
                MessageWindowChatMemory.withMaxMessages(20);

        chatMemory.add(SystemMessage.from("""
                Tu es un guide touristique.
                Pour la ville ou le pays demandé, donne exactement deux
                endroits importants à visiter et le prix moyen d'un repas
                dans la devise locale.

                Réponds uniquement avec un objet JSON valide,
                sans Markdown, selon cette structure :
                {
                  "ville_ou_pays": "nom de la ville ou du pays",
                  "endroits_a_visiter": ["endroit 1", "endroit 2"],
                  "prix_moyen_repas": "<prix> <devise du pays>"
                }
                """));

        this.guideTouristique =
                AiServices.builder(GuideTouristique.class)
                        .chatModel(model)
                        .chatMemory(chatMemory)
                        .build();
    }

    public String endroitsDeVisite(String villeOuPays) {
        return guideTouristique.endroitsDeVisite(villeOuPays);
    }
}