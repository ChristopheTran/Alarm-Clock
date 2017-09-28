
/**
 * The AlarmClock class creates an alarm clock for a standard 12 hour clock. The 
 * alarm clock will display the clock time, along with the alarm time. If the clock
 * time matches with the alarm time, the alarm will ring. The ringing is
 * simulated by outputting "RING RING RING" to the console (via System.out.println()).
 *
 * @author Christophe Tran
 * @version 2017.09.22
 */
public class AlarmClock
{
    private ClockDisplay12 clock;
    private Alarm alarmClock;

    /**
     * Constructor for objects of class AlarmClock. This constructor creates a clock
     * set to 12:00a.m and an alarm set to 12:00a.m with the alarm turned off.
     */
    public AlarmClock()
    {
        clock = new ClockDisplay12();
        alarmClock = new Alarm();
        
    }
    
    /**
     * Constructor for objects of class AlarmClock. This constructor creates a clock
     * and alarm set to the time specified in the parameters along with whether the alarm is on or off.
     * 
     * @param clockHour Hour of the clock
     * @param clockMin Minute of the clock
     * @param clockAmPm a.m or p.m for the clock
     * @param alarmHour Hour of the alarm
     * @param alarmMin Minute of the alarm
     * @param alarmAmPm a.m or p.m for the alarm
     * @param alarmState Whether the alarm is on or off
     */
    public AlarmClock(int clockHour, int clockMin, String clockAmPm, int alarmHour, int alarmMin, String alarmAmPm, Boolean alarmState)
    {
        clock = new ClockDisplay12(clockHour,clockMin,clockAmPm);
        alarmClock = new Alarm(alarmHour,alarmMin,alarmAmPm,alarmState);
    }
    
    /**
     * Set the time of the clock to the time specified in the parameters.
     * 
     * @param hour The hour of the clock
     * @param minute The minute of the clock
     * @param timeState a.m or p.m for the clock
     */
    public void setTime(int hour, int minute, String timeState)
    {
        clock.setTime(hour,minute,timeState);
    }
    
    /**
     * Set the time of the alarm to the time specified in the parameters.
     * 
     * @param hour The hour of the alarm
     * @param minute The minute of the alarm
     * @param timeState a.m or p.m for the alarm
     */
    public void setAlarmTime(int hour, int minute, String timeState)
    {
        alarmClock.setTime(hour,minute,timeState);
    }
    
    /**
     * Makes the clock display go one minute forward. If the clock time matches the 
     * alarm time, the alarm will ring and then be turned off.
     */
    public void clockTick()
    {
        clock.timeTick();
        if(clock.getTime().equals(alarmClock.getTime()) && alarmClock.isSet()) {
            System.out.println("RING RING RING");
            alarmClock.turnOff();
        }
            
    }
    
    /**
     * Turns the alarm of the alarm clock on.
     */
    public void setAlarm()
    {
        alarmClock.turnOn();
    }
    
    /**
     * Turns the alarm of the alarm clock off.
     */
    public void unsetAlarm()
    {
        alarmClock.turnOff();
    }
    
    /**
     * Returns the current time of the clock in the format HH:MM.
     * 
     * @return The current time of the clock
     */
    public String getTime()
    {
        return clock.getTime();
    }
    
    /**
     * Returns the time of the alarm in the format HH:MM.
     * 
     * @return The current time of the alarm
     */
    public String getAlarmTime()
    {
        return alarmClock.getTime();
    }
    
    /**
     * Checks if the alarm is turned on or not.
     * 
     * @return true if alarm is turned on, false otherwise
     */
    public Boolean isAlarmSet()
    {
        return alarmClock.isSet();
    }
}
