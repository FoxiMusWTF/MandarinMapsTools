package ru.mandarinteam.mandarinmapstools.utils.time;

public class Time {

    private static int customHours = 12;
    private static int customMinutes = 00;

    private static int tickCounter = 0;
    private static boolean isTimeFrozen = false;

    private static int TICKS_PER_MINUTES = 20;

    //get
    public static int getHours() {return customHours;}
    public static int getMinutes() {return customMinutes;}
    public static int getTicksPerMinutes() {return TICKS_PER_MINUTES;}
    public static String getTime() {return String.format("%02d:%02d", customHours, customMinutes);}

    //set
    public static void setTimeFrozen(boolean frozen){
        isTimeFrozen = frozen;
    }
    public static void setCustomHours(int hours){
        customHours = hours;
    }
    public static void setCustomMinutes(int minutes){
        customMinutes = minutes;
    }
    public static void setTicksPerMinutes(int ticksPerMinutes){
        TICKS_PER_MINUTES = ticksPerMinutes;
    }

    public static boolean isFrozen() {
        return isTimeFrozen;
    }

    public static void tick() {
        if (isTimeFrozen) {
            return;
        }

        tickCounter++;
        if (tickCounter >= TICKS_PER_MINUTES) {
            tickCounter = 0;
            customMinutes++;

            if (customMinutes >= 60) {
                customMinutes = 0;
                customHours++;
                if (customHours >= 24) {
                    customHours = 0;
                }
            }

        }
    }

}
