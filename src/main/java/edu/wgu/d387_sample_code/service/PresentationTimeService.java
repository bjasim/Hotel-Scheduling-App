package edu.wgu.d387_sample_code.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PresentationTimeService {
    public String getPresentationTimes(String localTime) {
        // localTime format: "yyyy-MM-dd'T'HH:mm" (e.g., "2025-05-30T15:00")
        LocalDateTime ldt = LocalDateTime.parse(localTime);
        ZonedDateTime etTime = ldt.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime mtTime = etTime.withZoneSameInstant(ZoneId.of("America/Denver"));
        ZonedDateTime utcTime = etTime.withZoneSameInstant(ZoneId.of("UTC"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        DateTimeFormatter utcFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return String.format(
            "Join us for an online live presentation held at the London Hotel on August 15, 2025 at %s Eastern Time, %s Mountain Time, %s UTC.",
            etTime.format(formatter),
            mtTime.format(formatter),
            utcTime.format(utcFormatter)
        );
    }
} 