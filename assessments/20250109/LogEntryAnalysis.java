import java.time.LocalDateTime;
import java.util.*;
        import java.util.stream.Collectors;

class LogEntry {
    private String userId;
    private LocalDateTime timestamp;
    private String action;
    private String status;
    private long processingTimeMs;

    public LogEntry(String userId, LocalDateTime timestamp, String action, String status, long processingTimeMs) {
        this.userId = userId;
        this.timestamp = timestamp;
        this.action = action;
        this.status = status;
        this.processingTimeMs = processingTimeMs;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }

    public String getStatus() {
        return status;
    }

    public long getProcessingTimeMs() {
        return processingTimeMs;
    }
}

class UserActivityStats {
    private double successRate;
    private double avgProcessingTime;
    private Set<String> distinctActions;

    public UserActivityStats(double successRate, double avgProcessingTime, Set<String> distinctActions) {
        this.successRate = successRate;
        this.avgProcessingTime = avgProcessingTime;
        this.distinctActions = distinctActions;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public double getAvgProcessingTime() {
        return avgProcessingTime;
    }

    public Set<String> getDistinctActions() {
        return distinctActions;
    }

    @Override
    public String toString() {
        return "User ActivityStats{" +
                "successRate=" + successRate +
                ", avgProcessingTime=" + avgProcessingTime +
                ", distinctActions=" + distinctActions +
                '}';
    }
}

public class LogEntryAnalysis {

    public static Map<String, UserActivityStats> analyzeUserActivity(List<LogEntry> logs) {
        return logs.stream()
                .collect(Collectors.groupingBy(LogEntry::getUserId))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() >= 5)
                .map(entry -> {
                    List<LogEntry> userLogs = entry.getValue();

                    // Calculate success rate
                    long totalLogs = entry.getValue().stream()
                            .collect(Collectors.counting());
                    long successCount = userLogs.stream()
                            .filter(log -> "SUCCESS".equals(log.getStatus()))
                            .count();
                    double successRate = (double) successCount / totalLogs * 100;

                    //calculate average proccessing time
                    double avgProcessingTime = userLogs.stream()
                            .filter(log -> "SUCCESS".equals(log.getStatus()))
                            .collect(Collectors.averagingLong(LogEntry::getProcessingTimeMs));

                    // Collect distinct actions
                    Set<String> distinctActions = userLogs.stream()
                            .map(LogEntry::getAction)
                            .collect(Collectors.toSet());
                    return new AbstractMap.SimpleEntry<>(entry.getKey(), new UserActivityStats(successRate, avgProcessingTime, distinctActions));
                })
                .filter(entry -> entry.getValue().getSuccessRate() > 90)
                .sorted(Comparator.comparingDouble(entry -> entry.getValue().getAvgProcessingTime())) 
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("user1", LocalDateTime.now(), "LOGIN", "SUCCESS", 100),
                new LogEntry("user1", LocalDateTime.now(), "UPLOAD", "SUCCESS", 150),
                new LogEntry("user1", LocalDateTime.now(), "DOWNLOAD", "FAILURE", 200),
                new LogEntry("user1", LocalDateTime.now(), "LOGOUT", "SUCCESS", 120),
                new LogEntry("user1", LocalDateTime.now(), "VIEW", "SUCCESS", 80),
                new LogEntry("user2", LocalDateTime.now(), "LOGOUT", "SUCCESS", 110),
                new LogEntry("user2", LocalDateTime.now(), "VIEW", "SUCCESS", 95),
                new LogEntry("user2", LocalDateTime.now(), "EDIT", "SUCCESS", 85),
                new LogEntry("user3", LocalDateTime.now(), "LOGIN", "SUCCESS", 110),
                new LogEntry("user3", LocalDateTime.now(), "EDIT", "SUCCESS", 95),
                new LogEntry("user3", LocalDateTime.now(), "VIEW", "SUCCESS", 85),
                new LogEntry("user1", LocalDateTime.now(), "EDIT", "SUCCESS", 90),
                new LogEntry("user2", LocalDateTime.now(), "DOWNLOAD", "SUCCESS", 90),
                new LogEntry("user2", LocalDateTime.now(), "UPLOAD", "FAILURE", 200),
                new LogEntry("user2", LocalDateTime.now(), "LOGIN", "SUCCESS", 150),
                new LogEntry("user3", LocalDateTime.now(), "LOGOUT", "SUCCESS", 90),
                new LogEntry("user3", LocalDateTime.now(), "UPLOAD", "SUCCESS", 200),
                new LogEntry("user3", LocalDateTime.now(), "DOWNLOAD", "SUCCESS", 150)
        );

        Map<String, UserActivityStats> result = analyzeUserActivity(logs);
        result.forEach((userId, statistics) -> System.out.println(userId + " -> " + statistics));
    }
}
