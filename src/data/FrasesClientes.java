package data;

import java.util.Random;

public class FrasesClientes {
    public static final Random rand = new Random();

    private static final String[] APRESSADO = {
            "Vai demorar muito? Preciso rápido!",
            "Apresse-se, não tenho tempo a perder!",
            "Pode agilizar, por favor?",
            "Isso está demorando demais!"
    };
    private static final String[] CALMO = {
            "Tudo bem, posso esperar.",
            "Não há problema, leve o tempo que precisar.",
            "Sem pressa, pode fazer com calma.",
            "Estou tranquilo, faça no seu ritmo."
    };
    private static final String[] EXIGENTE = {
            "Espero o melhor serviço possível.",
            "Não aceito menos que perfeito.",
            "Pode melhorar, não ficou bom.",
            "Quero que seja exatamente como pedi."
    };
    private static final String[] INDECISO = {
            "Não sei o que escolher...",
            "Talvez isso, ou será que aquilo?",
            "Pode me mostrar todas as opções de novo?",
            "Estou em dúvida, não consigo decidir.",
            "Acho que vou precisar de mais tempo para pensar."
    };

    public static String getFrase(String tipo){
        switch (tipo.toLowerCase()){
            case "apressado":
                return APRESSADO[rand.nextInt(APRESSADO.length)];
            case "calmo":
                return CALMO[rand.nextInt(CALMO.length)];
            case "exigente":
                return EXIGENTE[rand.nextInt(EXIGENTE.length)];
            case "indeciso":
                return INDECISO[rand.nextInt(INDECISO.length)];
            default:
                return "Cliente sem frase definida";
        }
    }

}
