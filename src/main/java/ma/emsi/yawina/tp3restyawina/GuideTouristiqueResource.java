
package ma.emsi.yawina.tp3restyawina;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.yawina.tp3restyawina.llm.LlmClient;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    /**
     * Retourne deux endroits à visiter et le prix moyen d'un repas.
     *
     * @param villeOuPays ville ou pays demandé
     * @return informations touristiques au format JSON
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

        return llmClient.endroitsDeVisite(villeOuPays);
    }

    /**
     * Retourne le nombre demandé d'endroits à visiter.
     *
     * @param villeOuPays ville ou pays demandé
     * @param nombre nombre d'endroits à visiter
     * @return informations touristiques au format JSON
     */
    @GET
    @Path("lieu/{ville_ou_pays}/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public String endroitsDeVisiteAvecNombre(
            @PathParam("ville_ou_pays") String villeOuPays,
            @PathParam("nombre") int nombre) {

        return llmClient.endroitsDeVisite(villeOuPays, nombre);
    }
}
