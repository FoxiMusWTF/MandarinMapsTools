package ru.mandarinteam.mandarinmapstools.utils.time;

public class Time {

    private static int customHours = 12;
    private static int customMinutes = 00;

    private static int tickCounter = 0;
    private static boolean isTimeFrozen = false;

    private static final int TICKS_PER_MINUTES = 20;

    public static int getHours() {return customHours;}
    public static int getMinutes() {return customMinutes;}
    public static String getTime() {return String.format("%02d:%02d", customHours, customMinutes);}

    public static void setTimeFrozen(boolean frozen){
        isTimeFrozen = frozen;
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
