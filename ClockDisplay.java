 /**
 * Excercise 3.38
 * The ClockDisplay class implements a digital clock display for a
 * European-style 24 hour clock. The clock shows hours and minutes. The 
 * range of the clock is 00:00 (midnight) to 23:59 (one minute before 
 * midnight). 
 * a 12 hour internal representation with AM and PM representations
 * of the clock will change to display a 24 hour style clock.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Matthew Sheehan
 * @version 2020.02.10
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString; //simulates the actual display
    private boolean morning;// flag to show if morning
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }
    
    public void get24HourInternalDisplay()
    {
        
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
        if(hours.getValue()<12){
            if(morning){
            morning = true;
            }else{
            morning = false;
            }
           }
        }
        updateDisplay();
    }
    
    //public boolean morningCheck()
    
    /**
     * Set the time of the display to the specified hour and
     * minute in a 12 hour american standard clock type.
     */
    public void setTime(int hour, int minute)
    {
        if(hour == 0){
            hours.setValue(12);
            morning = true;
        } else if(hour == 12){
        hours.setValue(hour);
        morning = false;
        }else if(hour >12){
        hours.setValue(hour-12);
        morning = false;
        }else{
            morning = true;
        }
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * display AM if morning true else display PM
     */
    public String displayMorning()
    {
        if(morning){
            return "AM";
        }else{
            return "PM";
        }
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if(hours.getValue() > 12){
        int hour = hours.getValue();
        hours.setValue(hour-12);
        morning = false;
        }else if(hours.getValue() == 12){
        int hour = hours.getValue();
        hours.setValue(12);
        morning = true;
        
        }else{ 
        morning = true;
        }
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue()
                        +" " +displayMorning();
                        //hours.setValue(0);
     }
}
