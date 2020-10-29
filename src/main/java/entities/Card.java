package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {
    private String type;
    private String number;
    private int month;
    private int year;
    private String nameOnCard;

    public Card(String type, String number, int month, int year, String nameOnCard) {
        this.type = type;
        this.number = number;
        this.month = month;
        this.year = year;
        this.nameOnCard = nameOnCard;
    }
}
