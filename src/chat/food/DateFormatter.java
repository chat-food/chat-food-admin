/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.food;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
/**
 *
 * @author Laboratorio
 */
public class DateFormatter {
    private String dateTime;
    
    public DateFormatter(Date data){
        SimpleDateFormat formatter = new SimpleDateFormat(
            "dd/MM/YYYY HH:mm:ss"
        );
        
        // Saves formatted data to attribute dateTime
        dateTime = formatter.format(data);
    }
    
    /**
     * Get formatted date time 
     * 
     * @return String dd/MM/YYYY HH:mm:ss
     */
    public String getDateTime() {
        return dateTime;
    }
}
