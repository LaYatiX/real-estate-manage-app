package pl.gpiwosz.estate.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EstateType {
    APARTMENT("Mieszkanie"),
    BUNGALOW("Dom wypoczynkowy"),
    CASTLE("Zamek"),
    FLAT("Mieszkanie"),
    HOTEL("Hotel"),
    MANSION("Pałac"),
    TERRACED_HOUSE("Dom szeregowy");

    private String description;
}
