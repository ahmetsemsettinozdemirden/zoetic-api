package com.zoetic.ahmetsemsettinozdemidenassigment.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {

    private static LocalDateTime freezed;
    private static ZoneId zoneId = ZoneId.of("UTC");

    public static LocalDateTime now() {
        if(freezed != null) {
            return freezed;
        }
        return LocalDateTime.now(zoneId);
    }

    public static void freeze() {
        freeze(now());
    }

    public static void freeze(LocalDateTime localDateTime) {
        freezed = localDateTime;
    }

    public static void unfreeze() {
        freezed = null;
    }

}
