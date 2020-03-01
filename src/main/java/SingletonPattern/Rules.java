package SingletonPattern;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Rules {
    public static int SUNDAY = 1, MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, THURSDAY = 5, FRIDAY = 6, SATURDAY = 7;

    private static Rules rules;
    public static final String RULE_ONE = "File extension equals mp4 AND fileName contains cat";
    public static final String RULE_TWO = "File extension equals mp4 OR file extension equals mkv AND created greater than 24/12/2019 00;00;00";

    public static Map<String, Calendar> dates = new HashMap<>();

    public static Rules getInstance(){
        if(rules == null)
            return new Rules();
        else
            return rules;
    }
    public static void addDate(String days, int hour, int minute, int second){
        Calendar now = Calendar.getInstance();
        now.set(Calendar.HOUR, hour);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, second);
        dates.put(days, now);


    }
    public static Calendar getDate(String key){
        return dates.get(key);
    }
    public static boolean isToday(int day){
        boolean res = false;
        Calendar calendar = Calendar.getInstance();
        if (calendar.get(Calendar.DAY_OF_WEEK) == day) {
            res = true;
        }
        return res;
    }
    public static boolean isHour(Calendar calendar){
        boolean res = false;
        try{
            Calendar currentTime = Calendar.getInstance();
            String ct = currentTime.get(Calendar.HOUR)+":"+currentTime.get(Calendar.MINUTE)+":"+currentTime.get(Calendar.SECOND);
            String pt = calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
            if(pt.equalsIgnoreCase(ct)){
                res = true;
            }

            System.out.println("Current time: "+ct + " - past time: "+pt);
        }catch (Exception e){

        }
        return res;
    }
}
