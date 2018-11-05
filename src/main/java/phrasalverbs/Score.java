package phrasalverbs;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Score {
    String groupValue;
    Map<String,StringScore> score;

    public Score() {
        this(null);
    }
    public Score(String groupValue) {
        this.groupValue = groupValue;
        this.score = new HashMap<>();
    }

    @Override
    public String toString() {
        return ((this.groupValue == null) || this.groupValue.isEmpty() ? "" : "Grupo: \"" + this.groupValue) + "\" "
                + "(" + new DecimalFormat("#,##0.##").format(getScore()) + ")";

    }

    public StringScore getScore(String part) {
        return this.score.get(part);
    }

    public float getScore() {
        // valor promedio
        if ((this.score.values() == null) || this.score.values().isEmpty()) {
            return 0;
        }
        return this.score.values().stream().map(t -> t.getScore()).reduce(0f, (x, y) -> x + y)
                / this.score.values().size();
    }
    public void reset(){
        this.score.values().forEach(t -> t.reset());
    }

    public void addHit(String part){
        StringScore stringScore = this.score.get(part);
        if(stringScore == null){
            this.score.put(part, new StringScore());
        }
        this.score.get(part).addHit();
    }

    public void addFail(String part) {
        StringScore stringScore = this.score.get(part);
        if (stringScore == null) {
            this.score.put(part, new StringScore());
        }
        this.score.get(part).addFail();
    }
}