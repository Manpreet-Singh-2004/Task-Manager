package org.example.calendar;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static final String FILENAME = "calendar_save.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    // Save reminders to file
    public static void saveReminders(List<CalendarActivity> reminders) {
        try {
            mapper.writeValue(new File(FILENAME), reminders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load reminders from file
    public static List<CalendarActivity> loadReminders() {
        List<CalendarActivity> reminders = new ArrayList<>();
        try {
            reminders = mapper.readValue(new File(FILENAME), new TypeReference<List<CalendarActivity>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reminders;
    }
}
