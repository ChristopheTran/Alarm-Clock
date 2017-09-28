
/**
 * The Alarm class creates an alarm for a standard 12 hour clock 
 * It will allow the user to set the alarm time, get the alarm time, 
 * and to check whether the alarm is turned on or off.
 *
 * @author Christophe Tran
 * @version 2017.09.22
 */
public class Alarm
{
    private ClockDisplay12 alarmClock;
    private Boolean alarmState;
    
    /**
     * Constructor for class Alarm objects. This constructor creates a new alarm
     * set to 12:00 am and the alarm off.
     */
    public Alarm()
    {
        alarmClock = new ClockDisplay12();
        alarmState = false;
        
    }
    
    /**
     * Constructor for class Alarm objects. This constructor creates a new alarm
     * at the specified time and whether the alarm is on or off, specified by the 
     * parameters.
     * 
     * @param hour Hour of the alarm
     * @param minute Minute of the alarm
     * @param timeState a.m or p.m of the alarm
     * @param alarmChoice Whether the alarm is on or off
     */
    public Alarm(int hour, int minute, String timeState, Boolean alarmChoice)
    {
        alarmClock = new ClockDisplay12(hour,minute,timeState);
        alarmState = alarmChoice;
        
    }
    
    /**
     * Sets the time of the alarm to the specified hour and minute.
     * 
     * @param hour The hour of the alarm
     * @param minute The minute of the alaram
     * @param timeState a.m. or p.m. for the alarm
     */
    public void setTime(int hour, int minute, String timeState)
    {
        alarmClock.setTime(hour,minute,timeState);
    }
    
    /**
     * Turns the alarm on.
     */
    public void turnOn()
    {
        alarmState = true;
    }
    
    /**
     * Turns the alarm off.
     */
    public void turnOff()
    {
        alarmState = false;
    }
    
    /**
     * Returns the time of the alarm in the format HH:MM.
     * 
     * @return The time of the alarm
     */
    public String getTime()
    {
        return alarmClock.getTime();  
    }
    
    /**
     * Checks if the alarm is on or off.
     * 
     * @return true if alarm is on, false otherwise
     */
    public Boolean isSet()
    {
        return alarmState;
    }
}
