package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {
    private String fromPort;
    private String toPort;
    private String flightNumber;
    private String airline;
    private String departTime;
    private String arrivalTime;
    private Price price;

    public Flight(String fromPort, String toPort, String flightNumber) {
        this.fromPort = fromPort;
        this.toPort = toPort;
        this.flightNumber = flightNumber;
    }
}
