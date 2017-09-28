
/**
 * The ClockDisplay12 class implements a digital clock display for a
 * 12 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 12:00 am (midnight) to 11:59 pm (one minute before 
 * midnight).
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Christophe Tran
 * @version 2017.09.22
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    private String timeState;
    public static final String AM = "a.m.";
    public static final String PM = "p.m.";
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 12:00a.m.
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        timeState = AM;
        hours.setValue(12);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters. Invalid inputs for hour and minute will default to 12
     * and invalid input for choice between a.m or p.m will default to a.m.
     * 
     * @param hour Hour of the clock
     * @param minute Minute of the clock
     * @param stateChoice a.m or p.m of the clock
     */
    public ClockDisplay12(int hour, int minute, String stateChoice)
    {
        hours = new NumberDisplay(12);      
        minutes = new NumberDisplay(60);      
        setTime(hour,minute,stateChoice);
        
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        
        if(hours.getValue() == 0 && minutes.getValue() == 0) { 
            if(timeState.equals(AM)) {
                timeState = PM;            //Changes a.m to p.m after 11:59a.m 
            }
            else if(timeState.equals(PM)) {
                timeState = AM;            //Changes p.m to a.m after 11:59p.m
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute. Invalid inputs for hour and minute will default to 12, and invalid
     * input for choice between a.m or p.m will default to a.m.
     * 
     * @param hour Hour for the clock
     * @param minute Minute for the clock
     * @param stateChoice a.m or p.m for the clock
     */
    public void setTime(int hour, int minute, String stateChoice)
    {
        if(hour>0 && hour<12) {
            hours.setValue(hour);
        }
        else {
            hours.setValue(0);
        }
        
        if(minute>=0 && minute<=60) {
            minutes.setValue(minute);
        }
        else {
            minutes.setValue(0);
        }
        
        if (stateChoice.equals(AM) || stateChoice.equals(PM)) { 
            timeState = stateChoice;
        } 
        else {
            timeState = AM;
        }
        updateDisplay();
            
    }

    /**
     * Return the current time of this display in the format HH:MM.
     * 
     * @return The current time of the clock
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if (hours.getValue() == 0) {
            displayString = "12" + ":" + 
                        minutes.getDisplayValue() + timeState;
        } else {
            displayString = hours.getValue() + ":" + 
            minutes.getDisplayValue() + timeState;
        }
    }
}
