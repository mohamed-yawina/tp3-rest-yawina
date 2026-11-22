# IA.md — TP3 REST

## Utilisation de l'IA

Pour ce TP, je me suis principalement basé sur le cours et sur le code du TP2.

J'ai utilisé ChatGPT pour m'aider sur certaines étapes, surtout pour comprendre et adapter le code au nouveau projet.

## Exemples de prompts et réponses

### 1. Adaptation du code LangChain4j

**Prompt :** Comment adapter mon `LlmClient` du TP2 pour l'utiliser dans le TP3 avec un guide touristique ?

**Réponse de l'IA :** Réutiliser la configuration Gemini du TP2 et créer une interface `GuideTouristique` pour demander les endroits à visiter et le prix moyen d'un repas.

**Ce que j'ai retenu :** J'ai compris comment réutiliser LangChain4j dans un service REST.

### 2. Problème de déploiement Payara

**Prompt :** J'ai l'erreur `Command list-components failed` avec Payara 7. Comment résoudre ce problème ?

**Réponse de l'IA :** Vérifier le déploiement avec `asadmin` et utiliser la commande `redeploy` après la compilation Maven.

**Ce que j'ai retenu :** J'ai appris à redéployer mon application manuellement.

### 3. Bonus du TP

**Prompt :** Comment ajouter un paramètre dans l'URL pour choisir le nombre d'endroits à visiter ?

**Réponse de l'IA :** Ajouter un deuxième endpoint REST avec `@Path("lieu/{ville_ou_pays}/{nombre}")` et transmettre le nombre demandé à Gemini.

**Ce que j'ai retenu :** J'ai compris comment utiliser plusieurs paramètres dans une URL REST.

## Vérification du travail

J'ai compilé et déployé le projet, puis testé les deux endpoints :

- `/api/guide/lieu/Nice` : 2 endroits retournés.
- `/api/guide/lieu/Paris/4` : 4 endroits retournés.

J'ai vérifié les réponses JSON et publié le projet sur GitHub.

## Conclusion

Ce TP m'a permis de mieux comprendre les services REST avec Jakarta EE, l'utilisation de LangChain4j avec Gemini et le passage de paramètres dans une URL.