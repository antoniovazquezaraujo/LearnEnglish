package phrasalverbs;

public class StringScore {
    int answers;
    int fails;

    public StringScore() {
        reset();
    }

    public void addHit() {
        this.answers++;
    }

    public void addFail() {
        this.fails++;
    }

    public float getScore() {
        if (this.fails == 0) {
            return 100;
        }
        if (this.answers == 0) {
            return 0;
        }
        return 100.0f / ((this.answers * 100.0f) / this.fails);
    }

    /*
     *
     * 8 4 100 / (100* 8/2) = 0.25
     *
     *
     */
    public void reset() {
        setAnswers(0);
        setFails(0);
    }

    public int getAnswers() {
        return this.answers;
    }

    public void setAnswers(int answers) {
        this.answers = answers;
    }

    public int getFails() {
        return this.fails;
    }

    public void setFails(int fails) {
        this.fails = fails;
    }
}
