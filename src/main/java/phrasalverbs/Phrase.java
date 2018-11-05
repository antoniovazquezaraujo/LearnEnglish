package phrasalverbs;

import java.util.ArrayList;
import java.util.List;

public class Phrase {

    private String verb;
    private String preposition;
    private String meaning;

    public String getPart(PhrasePart part) {
        switch (part) {
        case MEANING:
            return this.meaning;
        case PREPOSITION:
            return this.preposition;
        case VERB:
            return this.verb;
        default:
            return null;
        }
    }

    public PhrasePart getCounterPart(PhrasePart part) {
        switch (part) {
        case PREPOSITION:
            return PhrasePart.VERB;
        case VERB:
            return PhrasePart.PREPOSITION;
        default:
            return null;
        }
    }
    public String getVerb() {
        return this.verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getPreposition() {
        return this.preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getMeaning() {
        return this.meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    private Phrase(String verb, String preposition, String meaning) {
        super();
        this.verb = verb;
        this.preposition = preposition;
        this.meaning = meaning;
    }

    static List<Phrase> phrases = new ArrayList<>();;
    private static void addPhrase(String verb, String preposition, String meaning) {
        phrases.add(new Phrase(verb, preposition, meaning));
    }

    static {
        addPhrase("ask", "about", "Preguntar por (un asunto)");
        addPhrase("bring", "about", "Provocar, ocasionar");
        addPhrase("come", "about", "Suceder");
        addPhrase("go", "about", "Comportarse");
        addPhrase("see", "about", "Encargarse");
        addPhrase("come", "across", "Encontrarse con");
        addPhrase("get", "across", "Hacerse entender");
        addPhrase("put", "across", "Comunicar");
        addPhrase("ask", "after", "Preguntar por la salud");
        addPhrase("look", "after", "Cuidar");
        addPhrase("get", "ahead", "Progresar");
        addPhrase("go", "ahead", "Continuar");
        addPhrase("ask", "along", "Invitar");
        addPhrase("carry", "along", "Llevar en brazos");
        addPhrase("come", "along", "Aparecer, presentarse");
        addPhrase("get", "along", "Llevarse bien");
        addPhrase("hurry", "along", "Apresurarse");
        addPhrase("move", "along", "Circular");
        addPhrase("fly", "around", "Revolotear");
        addPhrase("get", "around", "Viajar, desplazarse");
        addPhrase("talk", "around", "Dar rodeos");
        addPhrase("come", "at", "Embestir");
        addPhrase("fly", "at", "Abalanzarse");
        addPhrase("get", "at", "Insinuar");
        addPhrase("look", "at", "Mirar");
        addPhrase("back", "away", "Retroceder");
        addPhrase("break", "away", "Soltarse");
        addPhrase("clear", "away", "Recoger");
        addPhrase("come", "away", "Apartarse");
        addPhrase("die", "away", "Cesar poco a poco");
        addPhrase("do", "away", "Quitar, eliminar");
        addPhrase("drive", "away", "Ahuyentar");
        addPhrase("eat", "away", "Erosionar");
        addPhrase("fly", "away", "Salir volando");
        addPhrase("get", "away", "Escapar");
        addPhrase("give", "away", "Regalar");
        addPhrase("go", "away", "Marcharse");
        addPhrase("keep", "away", "Mantener alejado");
        addPhrase("move", "away", "Alejarse");
        addPhrase("pass", "away", "Fallecer");
        addPhrase("pull", "away", "Arrancar");
        addPhrase("put", "away", "Guardar");
        addPhrase("run", "away", "Salir corriendo");
        addPhrase("stay", "away", "Mantenerse alejado");
        addPhrase("take", "away", "Llevarse");
        addPhrase("talk", "away", "Hablar demasiado");
        addPhrase("throw", "away", "Tirar");
        addPhrase("turn", "away", "Impedir la entrada");
        addPhrase("walk", "away", "Marcharse");
        addPhrase("answer", "back", "Contestar de malos modos");
        addPhrase("ask", "back", "Volver a invitar");
        addPhrase("bring", "back", "Traer (consigo)");
        addPhrase("buy", "back", "Volver a comprar algo");
        addPhrase("call", "back", "Devolver una llamada telefónica");
        addPhrase("draw", "back", "Retroceder");
        addPhrase("drop", "back", "Rezagarse");
        addPhrase("get", "back", "Regresar");
        addPhrase("give", "back", "Devolver");
        addPhrase("go", "back", "Regresar");
        addPhrase("hold", "back", "Contener, retener");
        addPhrase("keep", "back", "Permanecer alejado");
        addPhrase("look", "back", "Mirar atrás");
        addPhrase("pay", "back", "Devolver un préstamo");
        addPhrase("phone", "back", "Devolver una llamada");
        addPhrase("play", "back", "Reproducir una grabación");
        addPhrase("put", "back", "Poner en su sitio");
        addPhrase("send", "back", "Devolver");
        addPhrase("step", "back", "Retroceder");
        addPhrase("throw", "back", "Devolver");
        addPhrase("turn", "back", "Regresar");
        addPhrase("get", "by", "Pasar");
        addPhrase("go", "by", "Pasar");
        addPhrase("pass", "by", "Pasar");
        addPhrase("stand", "by", "Mantenerse al margen");
        addPhrase("stop", "by", "Pasarse por");
        addPhrase("back", "down", "Admitir estar equivocado");
        addPhrase("blow", "down", "Derrumbar por el viento");
        addPhrase("break", "down", "Estropearse, averiarse");
        addPhrase("bring", "down", "Bajar (algo o a alguien)");
        addPhrase("burn", "down", "Quemarse completamente");
        addPhrase("call", "down", "Llamar (a alguien) para que baje");
        addPhrase("calm", "down", "Tranquilizarse, calmarse");
        addPhrase("close", "down", "Cerrar una empresa");
        addPhrase("come", "down", "Bajar");
        addPhrase("cut", "down", "Reducir");
        addPhrase("drag", "down", "Deprimirse");
        addPhrase("draw", "down", "Bajar");
        addPhrase("fall", "down", "Caerse");
        addPhrase("get", "down", "Bajar");
        addPhrase("go", "down", "Bajar");
        addPhrase("keep", "down", "Controlar");
        addPhrase("knock", "down", "Derribar");
        addPhrase("let", "down", "Decepcionar");
        addPhrase("lie", "down", "Acostarse");
        addPhrase("look", "down", "Mirar abajo");
        addPhrase("pull", "down", "Derribar");
        addPhrase("put", "down", "Anotar, bajar (algo)");
        addPhrase("run", "down", "Atropellar");
        addPhrase("send", "down", "Encarcelar");
        addPhrase("set", "down", "Dejar, poner");
        addPhrase("shut", "down", "Cerrar, clausurar");
        addPhrase("sit", "down", "Sentarse");
        addPhrase("step", "down", "Dimitir");
        addPhrase("take", "down", "Bajar");
        addPhrase("throw", "down", "Arrojar");
        addPhrase("turn", "down", "Rechazar");
        addPhrase("write", "down", "Anotar");
        addPhrase("answer", "for", "Responder de");
        addPhrase("ask", "for", "Pedir, preguntar por");
        addPhrase("call", "for", "Pedir, exigir");
        addPhrase("come", "for", "Venir por (en busca de)");
        addPhrase("cry", "for", "Pedir a gritos");
        addPhrase("listen", "for", "Escuchar atentamente");
        addPhrase("look", "for", "Buscar");
        addPhrase("run", "for", "Presentarse como candidato");
        addPhrase("send", "for", "Llamar");
        addPhrase("speak", "for", "Hablar en nombre de");
        addPhrase("bring", "forward", "Adelantar");
        addPhrase("step", "forward", "Dar un paso al frente");
        addPhrase("look", "forward to", "Desear");
        addPhrase("come", "from", "Venir de");
        addPhrase("ask", "in", "Invitar a entrar");
        addPhrase("break", "in", "Irrumpir, interrumpir");
        addPhrase("bring", "in", "Introducir, obtener beneficio");
        addPhrase("buy", "in", "Abastecerse");
        addPhrase("call", "in", "Pasarse por un lugar");
        addPhrase("come", "in", "Entrar");
        addPhrase("count", "in", "Incluir");
        addPhrase("cut", "in", "Interrumpir");
        addPhrase("draw", "in", "Acortarse");
        addPhrase("drop", "in", "Pasar");
        addPhrase("fill", "in", "Rellenar");
        addPhrase("get", "in", "Llegar");
        addPhrase("hand", "in", "Entregar");
        addPhrase("join", "in", "Participar");
        addPhrase("jump", "in", "Zambullirse");
        addPhrase("leave", "in", "Conservar");
        addPhrase("move", "in", "Mudarse (de domicilio)");
        addPhrase("pay", "in", "Ingresar (dinero)");
        addPhrase("phone", "in", "Llamar al trabajo");
        addPhrase("plug", "in", "Enchufar");
        addPhrase("put", "in", "Poner");
        addPhrase("shut", "in", "Encerrar");
        addPhrase("sleep", "in", "Levantarse tarde");
        addPhrase("stay", "in", "Quedarse en casa");
        addPhrase("stop", "in", "Quedarse en casa");
        addPhrase("take", "in", "Comprender");
        addPhrase("throw", "in", "Incluir");
        addPhrase("tune", "in", "Sintonizar");
        addPhrase("walk", "in", "Irrumpir");
        addPhrase("go", "in / into", "Entrar");
        addPhrase("eat", "into", "Desgastar");
        addPhrase("get", "into", "Entrar");
        addPhrase("look", "into", "Investigar");
        addPhrase("run", "into", "Chocar");
        addPhrase("walk", "into", "Tropezar");
        addPhrase("back", "off", "Distanciarse de una situación");
        addPhrase("blow", "off", "Llevar, arrastrar el viento");
        addPhrase("break", "off", "Romper(se)");
        addPhrase("brush", "off", "Ignorar a alguien, cepillar");
        addPhrase("burn", "off", "Quitar algo con fuego");
        addPhrase("buy", "off", "Sobornar");
        addPhrase("buzz", "off", "Largarse, irse");
        addPhrase("call", "off", "Suspender, cancelar algo");
        addPhrase("carry", "off", "Llevarse algo, ganar un premio");
        addPhrase("clear", "off", "Marcharse");
        addPhrase("come", "off", "Desprenderse");
        addPhrase("cry", "off", "Echarse atrás");
        addPhrase("cut", "off", "Cortar");
        addPhrase("dash", "off", "Irse a toda prisa");
        addPhrase("draw", "off", "Drenar");
        addPhrase("drop", "off", "Quedarse dormido");
        addPhrase("dry", "off", "Secar, Secarse");
        addPhrase("fall", "off", "Desprenderse, despegarse");
        addPhrase("fight", "off", "Defenderse");
        addPhrase("get", "off", "Apearse, bajarse");
        addPhrase("give", "off", "Despedir (humo, olor)");
        addPhrase("go", "off", "Irse");
        addPhrase("keep", "off", "Abstenerse, evitar");
        addPhrase("kick", "off", "Comenzar");
        addPhrase("live", "off", "Vivir de algo");
        addPhrase("move", "off", "Partir, marcharse");
        addPhrase("pay", "off", "Saldar (una deuda)");
        addPhrase("play", "off", "Desempatar");
        addPhrase("pull", "off", "Quitar");
        addPhrase("put", "off", "Aplazar");
        addPhrase("run", "off", "Escapar corriendo");
        addPhrase("see", "off", "Despedir");
        addPhrase("send", "off", "Enviar");
        addPhrase("set", "off", "Salir, partir");
        addPhrase("stand", "off", "Mantenerse alejado");
        addPhrase("switch", "off", "Apagar");
        addPhrase("take", "off", "Despegar");
        addPhrase("turn", "off", "Desconectar");
        addPhrase("walk", "off", "Marcharse");
        addPhrase("call", "on", "Visitar, ir a ver a alguien");
        addPhrase("carry", "on", "Continuar");
        addPhrase("come", "on", "¡Vamos! (en imperativo)");
        addPhrase("count", "on", "Contar con");
        addPhrase("follow", "on", "Consecuencia");
        addPhrase("get", "on", "Llevarse bien");
        addPhrase("go", "on", "Continuar");
        addPhrase("hang", "on", "Esperar un momento");
        addPhrase("have", "on", "Llevar puesto");
        addPhrase("hold", "on", "Conservar");
        addPhrase("look", "on", "Observar");
        addPhrase("move", "on", "Continuar");
        addPhrase("put", "on", "Ponerse (una prenda)");
        addPhrase("set", "on", "Agredir");
        addPhrase("stay", "on", "Quedarse");
        addPhrase("switch", "on", "Encender");
        addPhrase("take", "on", "Contratar");
        addPhrase("try", "on", "Probarse ropa");
        addPhrase("turn", "on", "Conectar");
        addPhrase("get", "onto", "Contactar");
        addPhrase("ask", "out", "Invitar a salir");
        addPhrase("back", "out", "Echarse atrás, desdecirse");
        addPhrase("blow", "out", "Apagar (soplando)");
        addPhrase("break", "out", "Declararse, iniciarse (guerra, etc.)");
        addPhrase("bring", "out", "Hacer salir, publicar");
        addPhrase("burn", "out", "Extinguirse, consumirse (el fuego)");
        addPhrase("call", "out", "Gritar");
        addPhrase("carry", "out", "Llevar a cabo");
        addPhrase("clear", "out", "Irse, abandonar un lugar");
        addPhrase("come", "out", "Salir");
        addPhrase("cut", "out", "Recortar");
        addPhrase("die", "out", "Extinguirse");
        addPhrase("draw", "out", "Prolongar");
        addPhrase("drop", "out", "Abandonar");
        addPhrase("drum", "out", "Expulsar");
        addPhrase("farm", "out", "Subcontratar");
        addPhrase("fill", "out", "Engordar");
        addPhrase("find", "out", "Averiguar");
        addPhrase("fork", "out", "Pagar");
        addPhrase("freeze", "out", "Excluir");
        addPhrase("get", "out", "Salir");
        addPhrase("give", "out", "Repartir");
        addPhrase("go", "out", "Salir");
        addPhrase("hand", "out", "Distribuir");
        addPhrase("hang", "out", "Tender, colgar");
        addPhrase("hold", "out", "Resistir");
        addPhrase("knock", "out", "Dejar sin conocimiento");
        addPhrase("leave", "out", "Excluir");
        addPhrase("look", "out", "Tener cuidado");
        addPhrase("make", "out", "Distinguir, divisar");
        addPhrase("move", "out", "Desalojar");
        addPhrase("pass", "out", "Desmayarse");
        addPhrase("pick", "out", "Elegir");
        addPhrase("point", "out", "Señalar");
        addPhrase("pull", "out", "Sacar");
        addPhrase("put", "out", "Apagar");
        addPhrase("run", "out", "Acabarse");
        addPhrase("see", "out", "Acompañar hasta la puerta");
        addPhrase("send", "out", "Enviar masivamente");
        addPhrase("set", "out", "Exponer");
        addPhrase("speak", "out", "Expresar la opinión");
        addPhrase("stand", "out", "Destacar");
        addPhrase("stay", "out", "Quedarse fuera");
        addPhrase("step", "out", "Salir");
        addPhrase("turn", "out", "Apagar la luz");
        addPhrase("watch", "out", "Tener cuidado");
        addPhrase("work", "out", "Calcular");
        addPhrase("blow", "over", "Resolver un conflicto");
        addPhrase("call", "over", "Llamar a alguien");
        addPhrase("fall", "over", "Tropezar");
        addPhrase("get", "over", "Recuperarse");
        addPhrase("go", "over", "Repasar");
        addPhrase("look", "over", "Echar un vistazo");
        addPhrase("pass", "over", "Pasar por alto");
        addPhrase("run", "over", "Atropellar");
        addPhrase("take", "over", "Encargarse");
        addPhrase("think", "over", "Reflexionar");
        addPhrase("turn", "over", "Dar la vuelta");
        addPhrase("get", "past", "Adelantar");
        addPhrase("cut", "through", "Atravesar, atajar");
        addPhrase("get", "through", "Abrirse paso");
        addPhrase("go", "through", "Examinar en detalle");
        addPhrase("look", "through", "Ignorar");
        addPhrase("talk", "through", "Explicar");
        addPhrase("awake", "to", "Darse cuenta de algo");
        addPhrase("come", "to", "Ascender a (una cantidad)");
        addPhrase("stick", "to", "Atenerse a algo");
        addPhrase("move", "towards", "Aproximarse");
        addPhrase("add", "up", "Incrementar, tener sentido");
        addPhrase("back", "up", "Reforzar, respaldar");
        addPhrase("blow", "up", "Volar (con explosivos)");
        addPhrase("break", "up", "Desintegrarse, romper una relación");
        addPhrase("bring", "up", "Criar, educar");
        addPhrase("burn", "up", "Consumirse (por calor intenso)");
        addPhrase("call", "up", "Telefonear");
        addPhrase("clear", "up", "Aclararse (el tiempo, un misterio)");
        addPhrase("close", "up", "Cerrar");
        addPhrase("come", "up", "Subir");
        addPhrase("count", "up", "Calcular");
        addPhrase("cut", "up", "Cortar en trozos");
        addPhrase("do", "up", "Abrochar");
        addPhrase("draw", "up", "Redactar");
        addPhrase("dream", "up", "Planear");
        addPhrase("eat", "up", "Acabar la comida");
        addPhrase("end", "up", "Terminar, acabar");
        addPhrase("fill", "up", "Llenar");
        addPhrase("fix", "up", "Arreglar");
        addPhrase("get", "up", "Levantarse");
        addPhrase("give", "up", "Darse por vencido");
        addPhrase("go", "up", "Aumentar, subir");
        addPhrase("grow", "up", "Crecer");
        addPhrase("hang", "up", "Colgar el teléfono");
        addPhrase("hurry", "up", "Darse prisa");
        addPhrase("jump", "up", "Levantarse de repente");
        addPhrase("keep", "up", "Mantener, seguir");
        addPhrase("make", "up", "Inventar");
        addPhrase("match", "up", "Coincidir");
        addPhrase("move", "up", "Ascender");
        addPhrase("pay", "up", "Pagar, abonar");
        addPhrase("pick", "up", "Recoger");
        addPhrase("pop", "up", "Aparecer");
        addPhrase("power", "up", "Poner en marcha");
        addPhrase("put", "up", "Construir");
        addPhrase("run", "up", "Izar");
        addPhrase("send", "up", "Encarecer");
        addPhrase("shut", "up", "Callarse");
        addPhrase("sit", "up", "Incorporarse");
        addPhrase("speak", "up", "Hablar en voz alta");
        addPhrase("stand", "up", "Ponerse de pie");
        addPhrase("step", "up", "Incrementar");
        addPhrase("take", "up", "Empezar");
        addPhrase("tear", "up", "Romper en pedazos");
        addPhrase("think", "up", "Inventar, imaginar");
        addPhrase("turn", "up", "Llegar");
        addPhrase("wake", "up", "Despertar");
        addPhrase("walk", "up", "Acercarse");
        addPhrase("warm", "up", "Calentar");
        addPhrase("work", "up", "Expresar un sentimiento");
        addPhrase("add", "up to", "Ascender, alcanzar un total");
        addPhrase("come", "up to", "Llegar a");
        addPhrase("count", "up to", "Contar hasta");
        addPhrase("put", "upon", "Abusar de la confianza");
        addPhrase("go", "with", "Acompañar");
        addPhrase("do", "without", "Pasarse sin (carecer de)");
        addPhrase("go", "without", "Privarse");
    }

}
