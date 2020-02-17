
/**
Excercise 3.38
 * The ClockDisplay class implements an internal digital clock with a
 * 12 hour internal representation will display with AM and PM changing 
 * depending on time of day
 * 
 * from the 24 hour external clock will display when updating display 
 * European-style 24 hour clock.The range of the clock is 
 * 00:00 (midnight) to 23:59 (one minute before midnight). 
 * 
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
    private String displayString;    // simulates the actual display
    //added fields
    private String internalString;
    private boolean isMorning;
    private int displayHour;
    
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
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
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
     * Display AM or PM depending on state of isMorning
     */
    private String Meridian(){
    if(isMorning){
    return "AM";}
    return "PM";

    }
    /**
     * Update the display string that represents the display in 00:00 
     * 24 hour time.
     */
    private void updateDisplay()
    {   
            if(hours.getValue() == 24){
        displayString = "00:" + 
                        minutes.getDisplayValue();  
      }else{
        displayString = hours.getDisplayValue()+ ":" + 
                        minutes.getDisplayValue(); 
    }
        
    
    }
       
    /**
     * displays a 12 hour internal Clock Display keeping track of AM and PM
     */
    public String get12HourInternalDisplay()
    {
    if(hours.getValue() == 24 || hours.getValue() == 0){ //midnight
        isMorning = true;
        displayHour = 12;
      }else if(hours.getValue()>12 && hours.getValue()<24){ //PM
        isMorning = false;
        displayHour = hours.getValue()-12;
      }else if(hours.getValue() == 12){  //noon 
        isMorning = false;
        displayHour = 12;
      }else{
        isMorning = true;
        displayHour = hours.getValue();
        }

        internalString = ""+displayHour+ ":" + 
                        minutes.getDisplayValue() +" "+ Meridian();
        return internalString;
    }
}
