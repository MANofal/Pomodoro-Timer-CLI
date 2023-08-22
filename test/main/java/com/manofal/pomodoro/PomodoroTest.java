package test.main.java.com.manofal.pomodoro;

import org.junit.Test;
import src.main.java.com.manofal.pomodoro.PomodoroTimer;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class PomodoroTest {
    @Test
    public void testPomodoroStatistics() {
        // Test case 1: Standard case
        var startTime1 = LocalTime.of(9, 0);
        var endTime1 = LocalTime.of(12, 0);
        var pomodoro1 = new PomodoroTimer(startTime1, endTime1);

        assertEquals(180, pomodoro1.getTotalTimeInMinutes());
        assertEquals(5, pomodoro1.getStudySessionCount());
        assertEquals(5, pomodoro1.getRestSessionCount());
        assertEquals(125, pomodoro1.getTotalStudyMinutes());
        assertEquals(45, pomodoro1.getTotalRestMinutes());
        assertEquals(10, pomodoro1.getExtraMinutes());

        // Test case 2: Corner case
        var startTime2 = LocalTime.of(9, 0);
        var endTime2 = LocalTime.of(11, 45);
        var pomodoro2 = new PomodoroTimer(startTime2, endTime2);

        assertEquals(165, pomodoro2.getTotalTimeInMinutes());
        assertEquals(5, pomodoro2.getStudySessionCount());
        assertEquals(4, pomodoro2.getRestSessionCount());
        assertEquals(125, pomodoro2.getTotalStudyMinutes());
        assertEquals(40, pomodoro2.getTotalRestMinutes());
        assertEquals(0, pomodoro2.getExtraMinutes());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidTimeRange() {
        LocalTime startTime = LocalTime.of(14, 0);
        LocalTime endTime = LocalTime.of(12, 0);
        PomodoroTimer pomodoro = new PomodoroTimer(startTime, endTime);
    }

}
