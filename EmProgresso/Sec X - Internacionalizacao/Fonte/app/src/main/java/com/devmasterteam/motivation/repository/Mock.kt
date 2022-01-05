package com.devmasterteam.motivation.repository

import com.devmasterteam.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int, val language: String)

class Mock {

    private val ALL = MotivationConstants.PHRASEFILTER.ALL
    private val HAPPY = MotivationConstants.PHRASEFILTER.HAPPY
    private val MORNING = MotivationConstants.PHRASEFILTER.MORNING
    private val EN = MotivationConstants.LANGUAGE.English
    private val PT = MotivationConstants.LANGUAGE.Portuguese
    private val FR = MotivationConstants.LANGUAGE.French

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY, PT),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY, PT),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY, PT),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            HAPPY,
            PT
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY, PT),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            HAPPY,
            PT
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", MORNING, PT),
        Phrase("Você perde todas as chances que você não aproveita.", MORNING, PT),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", MORNING, PT),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", MORNING, PT),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", MORNING, PT),
        Phrase("Se você acredita, faz toda a diferença.", MORNING, PT),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            MORNING,
            PT
        ),

        Phrase("Not knowing it was impossible, he went there and did it.", HAPPY, EN),
        Phrase("You are not defeated when you lose, you are defeated when you give up!", HAPPY, EN),
        Phrase("When it's darker, we see more stars!", HAPPY, EN),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            HAPPY,
            EN
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", HAPPY, EN),
        Phrase("What can you do now that has the biggest impact on your success?", HAPPY, EN),
        Phrase("The best way to predict the future is to invent it.", MORNING, EN),
        Phrase("You lose every chance you don't take.", MORNING, EN),
        Phrase("Failure is the spice that flavors success.", MORNING, EN),
        Phrase(" As long as we are not committed, there will be hesitation!", MORNING, EN),
        Phrase("If you don't know where you want to go, any way will do.", MORNING, EN),
        Phrase("If you believe, it makes all the difference.", MORNING, EN),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            MORNING,
            EN
        ),

        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", HAPPY, FR),
        Phrase("Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!", HAPPY, FR),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", HAPPY, FR),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            HAPPY,
            FR
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", HAPPY, FR),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            HAPPY,
            FR
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", MORNING, FR),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", MORNING, FR),
        Phrase("L'échec est l'épice qui parfume le succès.", MORNING, FR),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", MORNING, FR),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            MORNING,
            FR
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", MORNING, FR),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            MORNING,
            FR
        )
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int, language: String): String {

        // Caso a língua do usuário não esteja entre as disponíveis
        var langFilter = language.lowercase()
        if (language !in listOf(EN, PT, FR)) {
            langFilter = PT
        }

        val filtered = mListPhrases.filter {
            (it.category == value || value == ALL) && (it.language == langFilter)
        }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }

}