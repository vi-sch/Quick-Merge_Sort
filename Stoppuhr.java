/**
 * Stoppuhr zum Messen von Zeitperioden mit einer Aufl&ouml;sung von
 * Nanosekunden.
 * 
 * @author nsteger
 * 
 */
public class Stoppuhr {
    /**
     * Gibt an, ob die Uhr gerade l&auml;ft.
     */
    private boolean running;

    /**
     * Zeitstempel zu start().
     */
    private long startTime;

    /**
     * Zeitstempel zu stop.
     */
    private long endTime;

    /**
     * Erzeugt eine neue Stoppuhr..
     */
    public Stoppuhr() {
        running = false;
        startTime = 0;
        endTime = 0;
    }

    /**
     * Starte die Stoppuhr.
     */
    public void start() {
        if (!running) {
            startTime = currentTime();
            running = true;
        } else {
            throw new RuntimeException(
                    "Fehler in start: Uhr l&auml;ft bereits!");
        }
    }

    /**
     * Hole die aktuelle verstrichene Zeit, falls die Uhr l&auml;ft, sonst die
     * Zeit die die Uhr zuletzt gelaufen ist.
     * 
     * @return die verstrichene Zeit.
     */
    public long getTime() {
        if (running) {
            long curTime = currentTime();
            return curTime - startTime;
        } else {
            return endTime - startTime;
        }
    }

    /**
     * H&auml;lt die Uhr an und liefert die verstrichene Zeit seit start.
     * 
     * @return die verstrichene Zeit.
     */
    public long stop() {
        if (running) {
            endTime = currentTime();
            running = false;
            return endTime - startTime;
        } else {
            throw new RuntimeException("Fehler in stop: Uhr l&auml;ft nicht!");
        }
    }

    /**
     * L&auml;ft die Uhr gerade?
     * 
     * @return der Zustand der Uhr.
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Liefert den aktuellen Zeitstempel.
     * 
     * @return der aktuelle Zeitstempel.
     */
    private long currentTime() {
        return System.nanoTime();
    }
}