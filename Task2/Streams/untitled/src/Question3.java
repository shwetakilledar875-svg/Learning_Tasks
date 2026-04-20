import java.util.*;

class DataConnection {
    boolean active;
    int latency;

    DataConnection(boolean active, int latency) {
        this.active = active;
        this.latency = latency;
    }

    boolean isActive() {
        return active;
    }

    int getLatency() {
        return latency;
    }
}

public class Question3 {
    public static void main(String[] args) {
        List<DataConnection> connections = List.of(
                new DataConnection(false, 5),
                new DataConnection(true, 20),
                new DataConnection(true, 8),
                new DataConnection(true, 6)
        );

        Optional<DataConnection> result = connections.stream()
                .filter(DataConnection::isActive)
                .filter(c -> c.getLatency() < 10)
                .findFirst();

        System.out.println(result);
    }
}