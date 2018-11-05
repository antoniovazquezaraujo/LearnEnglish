package phrasalverbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// @formatter:off
public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------- LEARNING ENGLISH -------------------------");
        System.out.println("(C) 2018 Antonio Vázquez Araújo  antoniovazquezaraujo@gmail.com");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("Phrasal verbs:");
        System.out.println();
        ask(PhrasePart.PREPOSITION);
        //        ask(PhrasePart.VERB);
    }
    private static void ask(PhrasePart part) {
        Phrase.phrases
        .stream()
        .collect(Collectors.groupingBy(t-> t.getPart(part)))
        .entrySet()
        .forEach(x->{
            Score partsScore = askParts(x, part);
            showScore(partsScore);
            System.out.println("-------------------------------------------------------------------------------");
        });
    }
    private static Score askParts(Entry<String, List<Phrase>> entry, PhrasePart part) {
        Score partsScore = new Score(entry.getKey());
        entry.getValue()
        .stream()
        .forEach(t -> {
            askPart(partsScore, t, part);
        });
        return partsScore;
    }

    private static void askPart(Score score, Phrase t, PhrasePart part) {
        PhrasePart counterPart = t.getCounterPart(part);
        PhrasePart[] wildCardPhraseParts = null;
        PhrasePart[] completeCardPhraseParts = null;
        PhrasePart[] noMeaningCardPhraseParts = null;
        completeCardPhraseParts = new PhrasePart[]{PhrasePart.MEANING, PhrasePart.VERB, PhrasePart.PREPOSITION};
        noMeaningCardPhraseParts = new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.NONE};
        switch(counterPart){
        case MEANING:
            wildCardPhraseParts = new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.WILDCARD};
            break;
        case PREPOSITION:
            wildCardPhraseParts = new PhrasePart[]{PhrasePart.VERB, PhrasePart.WILDCARD, PhrasePart.MEANING};
            break;
        case VERB:
            wildCardPhraseParts = new PhrasePart[]{PhrasePart.WILDCARD, PhrasePart.PREPOSITION, PhrasePart.MEANING};
            break;
        default:
            break;
        }
        showPhrase(t, wildCardPhraseParts);
        System.out.print(": ");
        try {
            String answer = readAnswer();
            if(answer.equals(t.getPart(counterPart))){
                System.out.print("OK:");
                score.addHit(t.getPart(counterPart));
                showPhrase(t, completeCardPhraseParts);
            }else{
                System.out.print("ERROR: ");
                score.addFail(t.getPart(part));
                showPhrase(t, noMeaningCardPhraseParts);
                System.out.println();
                for (int times = 0; times<5; times++){
                    clearScreen();
                    System.out.println("Memoriza la frase: ");
                    System.out.print(t.getMeaning());
                    System.out.print(": ");
                    showPhrase(t, noMeaningCardPhraseParts);
                    System.out.println();
                    showTimer(50);
                    clearScreen();
                    System.out.println("Ahora escríbela: ");
                    answer = readAnswer();
                    if(answer.equals(t.getMeaning()+": " + t.getVerb()+ " "+ t.getPreposition())){
                        System.out.print("OK:");
                        score.addHit(t.getPart(counterPart));
                        showPhrase(t, completeCardPhraseParts);
                        break;
                    }else{
                        score.addFail(t.getPart(counterPart));
                    }
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void askVerb(Score score, Phrase t) {
        showPhrase(t, new PhrasePart[]{PhrasePart.WILDCARD, PhrasePart.PREPOSITION, PhrasePart.MEANING});
        System.out.print(": ");
        try {
            String answer = readAnswer();
            if(answer.equals(t.getVerb())){
                System.out.print("OK:");
                score.addHit(t.getVerb());
                showPhrase(t, new PhrasePart[]{PhrasePart.MEANING, PhrasePart.VERB, PhrasePart.PREPOSITION});
            }else{
                System.out.print("ERROR: ");
                score.addFail(t.getVerb());
                showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.NONE});
                System.out.println();
                for (int times = 0; times<5; times++){
                    clearScreen();
                    System.out.println("Teclea la frase completa: ");
                    System.out.print(t.getMeaning());
                    System.out.print(": ");
                    showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.NONE});
                    System.out.println();
                    showTimer(50);
                    clearScreen();
                    System.out.println();
                    answer = readAnswer();
                    if(answer.equals(t.getMeaning()+": " + t.getVerb()+ " "+ t.getPreposition())){
                        System.out.print("OK:");
                        score.addHit(t.getVerb());
                        showPhrase(t, new PhrasePart[]{PhrasePart.MEANING, PhrasePart.VERB, PhrasePart.PREPOSITION});
                        break;
                    }else{
                        score.addFail(t.getVerb());
                    }
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String readAnswer() throws IOException {
        return new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
    private static void showScore(Score score){
        System.out.println("                                                      [ "+ score +" ]");
    }

    // @formatter:on

    public static void showPhrase(Phrase phrase, PhrasePart[] parts) {
        String[] partsContent = new String[3];
        for (int n = 0; n < parts.length; n++) {
            switch (parts[n]) {
            case VERB:
                partsContent[n] = phrase.getVerb();
                break;
            case PREPOSITION:
                partsContent[n] = phrase.getPreposition();
                break;
            case MEANING:
                if (n != 0) {
                    partsContent[n] = "=" + phrase.getMeaning();
                } else {
                    partsContent[n] = phrase.getMeaning() + "=";
                }
                break;
            case NONE:
                partsContent[n] = "";
                break;
            case WILDCARD:
                partsContent[n] = "\"?\"";
            default:
                break;
            }
        }
        String ret = partsContent[0];
        if (!partsContent[1].isEmpty()) {
            ret += " " + partsContent[1];
        }
        if (!partsContent[2].isEmpty()) {
            ret += " " + partsContent[2];
        }
        System.out.print(ret);
    }

    private static void showTimer(int times) {
        char[] chars = { '-', '\\', '|', '/', '-', '\\', '|', '/' };
        for (int n = 0; n < times; n++) {
            System.out.print(chars[n % 8]);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\b");
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

/**
 * Parts of a phrase, to show, not show or show as a question mark
 */

enum PhrasePart {
    VERB, PREPOSITION, MEANING, NONE, WILDCARD;
}
