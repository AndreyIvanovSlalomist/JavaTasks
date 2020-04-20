package task3;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class UnitConversion {
    private Unit unitFirst;
    private Double conversionFirst;

    private Unit unitSecond;
    private Double conversionSecond;

}
