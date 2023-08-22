package src.main.java.com.manofal.pomodoro;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class PomodoroTimer {

    private final LocalTime startTime;
    private final LocalTime endTime;
    private long totalTimeInMinutes;
    private long remainingTime;
    private int studySessionCount;
    private int restSessionCount;
    private int totalStudyMinutes;
    private int totalRestMinutes;
    private long extraMinutes;

    private static final int STUDY_POMODORO_DURATION = 25;
    private static final int SHORT_REST_POMODORO_DURATION = 5;
    private static final int LONG_REST_POMODORO_DURATION = 25;

    public PomodoroTimer(LocalTime startTime, LocalTime endTime){

        validateTimeRange(startTime, endTime);

        this.startTime = startTime;
        this.endTime = endTime;

        calculateStatistics();
    }

    private void validateTimeRange(LocalTime start, LocalTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("The start time is after the end time.");
        }
    }

    private void calculateStatistics() {

        calculateTotalTimeInMinutes();
        remainingTime = totalTimeInMinutes;

        while (shouldStudy()) {

            study();

            if (shouldTakeLongRest() && remainingTime >= LONG_REST_POMODORO_DURATION) {
                takeRest(LONG_REST_POMODORO_DURATION);
            } else if (shouldTakeLongRest()) {
                takeRest(remainingTime);
            } else if (remainingTime >= SHORT_REST_POMODORO_DURATION) {
                takeRest(SHORT_REST_POMODORO_DURATION);
            }
            // Consider a corner case: if the remaining time is zero, avoid increasing the rest session count.
            else if (remainingTime > 0) {
                takeRest(remainingTime);
            }

        }

       calcExtraMinutes();
    }

    private void calculateTotalTimeInMinutes() {
        totalTimeInMinutes = ChronoUnit.MINUTES.between(startTime, endTime);
    }

    private boolean shouldStudy() {
        return remainingTime >= STUDY_POMODORO_DURATION;
    }

    private void study() {
        studySessionCount++;
        totalStudyMinutes += STUDY_POMODORO_DURATION;
        remainingTime -= STUDY_POMODORO_DURATION;
    }

    private boolean shouldTakeLongRest() {
        return studySessionCount % 4 == 0;
    }

    private void takeRest(long restDuration) {
        restSessionCount++;
        totalRestMinutes += restDuration;
        remainingTime -= restDuration;
    }

    private void calcExtraMinutes() {
        extraMinutes = totalTimeInMinutes - totalStudyMinutes - totalRestMinutes;
    }

    public void printStatistics() {
        String summary =
                "=========================================\n" +
                        "Pomodoro statistics (" + startTime.truncatedTo(ChronoUnit.MINUTES) + " to " + endTime.truncatedTo(ChronoUnit.MINUTES) + ")\n" +
                        "=========================================\n" +
                        "Total Time:\t\t\t " + totalTimeInMinutes + " minutes (" + totalTimeInMinutes / 60 + "h:" + totalTimeInMinutes % 60 + "m)\n" +
                        "Study Sessions:\t\t " + studySessionCount + "\n" +
                        "Rest Sessions:\t\t " + restSessionCount + "\n" +
                        "Total Study Time:\t " + totalStudyMinutes + " minutes (" + totalStudyMinutes / 60 + "h:" + totalStudyMinutes % 60 + "m)\n" +
                        "Total Rest Time:\t " + totalRestMinutes + " minutes (" + totalRestMinutes / 60 + "h:" + totalRestMinutes % 60 + "m)\n" +
                        "Extra minutes:\t\t " + extraMinutes + " minutes\n" +
                        "=========================================";
        System.out.println(summary);
    }

    public long getTotalTimeInMinutes() {
        return totalTimeInMinutes;
    }

    public int getStudySessionCount() {
        return studySessionCount;
    }

    public int getRestSessionCount() {
        return restSessionCount;
    }

    public int getTotalStudyMinutes() {
        return totalStudyMinutes;
    }

    public int getTotalRestMinutes() {
        return totalRestMinutes;
    }

    public long getExtraMinutes() {
        return extraMinutes;
    }

}
