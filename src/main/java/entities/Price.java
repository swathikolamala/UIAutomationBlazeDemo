package entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private double basePrice;
    private double feesAndTaxes;
    private double totalPrice;
}
