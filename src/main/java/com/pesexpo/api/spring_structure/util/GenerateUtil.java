package com.pesexpo.api.spring_structure.util;

import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateUtil {

    private GenerateUtil() {
        // Utility class
    }

    public static String generateRandomCode() {

        // Example output: ISTAD-PRO-MAFV3K-384271
        // - timePart: base36 seconds since epoch (short but changes over time)
        // - randomPart: 6 digits (reduces collision risk across concurrent requests)
        final String prefix = "ISTAD-PRO-";
        final String timePart = Long.toString(Instant.now().getEpochSecond(), 36).toUpperCase();
        final int randomPart = ThreadLocalRandom.current().nextInt(0, 1_000_000);
        return prefix + timePart + "-" + String.format("%06d", randomPart);
    }
}
