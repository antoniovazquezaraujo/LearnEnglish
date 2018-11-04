package phrasalverbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// @formatter:off
public class Main {
    public static void main(String[] args) {
        // Phrase.phrases.stream().map(t -> t.getMeaning()).forEach(System.out::println);

        //        Phrase.phrases.stream()
        //        .map(t -> t.getVerb() + " " + t.getPreposition() + ": " + t.getMeaning())
        //        .forEach(System.out::println);
        //        Phrase.phrases.stream()
        //        .collect(Collectors.groupingBy(Phrase::getVerb))
        //        .entrySet().forEach(entry -> {
        //            System.out.println(entry.getKey());
        //            entry.getValue().forEach(t -> System.out.println("\t" + t.getPreposition() + ":\t" + t.getMeaning()));
        //        });
        System.out.println("-------------------- LEARNING ENGLISH -------------------------");
        System.out.println("(C) 2018 Antonio Vázquez Araújo  antoniovazquezaraujo@gmail.com");
        System.out.println("---------------------------------------------------------------");
        System.out.println();
        System.out.println("Phrasal verbs:");
        System.out.println();
        askByPreposition();
        askByVerb();
    }
    //    private static void askByPreposition() {
    //        Phrase.phrases.stream()
    //        .collect(Collectors.groupingBy(Phrase::getPreposition))
    //        .entrySet().forEach(entry -> {
    //            System.out.println("------------- " + entry.getKey()+ " -------------------");
    //            entry.getValue().forEach(t -> {
    //                showPhrase(t, HiddenPart.VERB);
    //                try {
    //                    new BufferedReader(new InputStreamReader(System.in)).readLine();
    //                } catch (IOException e) {
    //                    e.printStackTrace();
    //                }
    //            });
    //        });
    //    }
    private static void askByPreposition() {
        Set<Phrase> correct = new HashSet<>();
        Phrase.phrases
        .stream()
        .collect(Collectors.groupingBy(Phrase::getPreposition))
        .entrySet().forEach(entry -> {
            correct.clear();
            correct.addAll(entry.getValue());
            while(!correct.isEmpty()){
                System.out.println("------------- " + entry.getKey()+ " :"+ correct.size() +" -------------------");
                entry.getValue()
                .stream()
                .filter(t-> correct.contains(t))
                .forEach(t -> {
                    showPhrase(t, new PhrasePart[]{PhrasePart.WILDCARD, PhrasePart.PREPOSITION, PhrasePart.MEANING});
                    System.out.print(": ");
                    try {
                        String answer = new BufferedReader(new InputStreamReader(System.in)).readLine();
                        if(answer.equals(t.getVerb())){
                            System.out.print("OK:");
                            showPhrase(t, new PhrasePart[]{PhrasePart.MEANING, PhrasePart.VERB, PhrasePart.PREPOSITION});
                            correct.remove(t);
                        }else{
                            System.out.print("ERROR: ");
                            showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.NONE});
                            System.out.println();
                            while (true){
                                clearScreen();
                                System.out.println("Teclea la frase completa: ");
                                System.out.print(t.getMeaning());
                                System.out.print(": ");
                                showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.NONE});
                                System.out.println();
                                showTimer(50);
                                clearScreen();
                                System.out.println();
                                answer = new BufferedReader(new InputStreamReader(System.in)).readLine();
                                if(answer.equals(t.getMeaning()+": " + t.getVerb()+ " "+ t.getPreposition())){
                                    System.out.print("OK:");
                                    showPhrase(t, new PhrasePart[]{PhrasePart.MEANING, PhrasePart.VERB, PhrasePart.PREPOSITION});
                                    correct.remove(t);
                                    break;
                                }
                            }
                        }
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
    }
    private static void askByVerb() {
        Set<Phrase> correct = new HashSet<>();
        Phrase.phrases
        .stream()
        .collect(Collectors.groupingBy(Phrase::getVerb))
        .entrySet().forEach(entry -> {
            correct.clear();
            correct.addAll(entry.getValue());
            while(!correct.isEmpty()){
                System.out.println("------------- " + entry.getKey()+ " :"+ correct.size() +" -------------------");
                entry.getValue()
                .stream()
                .filter(t-> correct.contains(t))
                .forEach(t -> {
                    showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.MEANING});
                    try {
                        String answer = new BufferedReader(new InputStreamReader(System.in)).readLine();
                        if(answer.equals(t.getPreposition())){
                            System.out.print("OK: ");
                            correct.remove(t);
                        }else{
                            System.out.print("ERROR: ");
                        }
                        showPhrase(t, new PhrasePart[]{PhrasePart.VERB, PhrasePart.PREPOSITION, PhrasePart.MEANING});
                        System.out.println();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        });
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

    private static void showTimer(int time) {
        char[] chars = { '-', '\\', '|', '/', '-', '\\', '|', '/' };
        for (int n = 0; n < time; n++) {
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

/*
 * Partes que se desean mostrar y en qué orden MEANING, VERB, PREPOSITION hacer esto: get away VERB, PREPOSITION,
 * MEANING get away: hacer esto WILDCARD, PREPOSITION, MEANING "?" away: hacer esto VERB, WILDCARD, MEANING get "?" :
 * hacer esto VERB, WILDCARD, NONE get "?" WILDCARD, PREPOSITION, NONE "?" away NONE, NONE, MEANING hacer esto VERB,
 * NONE, NONE get NONE, PREPOSITION, NONE away NONE, NONE, MEANING hacer esto
 */

enum PhrasePart {
    VERB, PREPOSITION, MEANING, NONE, WILDCARD;
}
