package task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class UnitConversionList {
    private Map<String, Unit> unitMap = new HashMap<>();

    Map<String, Unit> getUnitMap() {
        return unitMap;
    }

    void add(String inputString) {
        String[] strings = stringToArray(inputString);

        Unit unitFirst = findUnit(strings[1]);
        Unit unitSecond = findUnit(strings[4]);
        UnitConversion unitConversion = UnitConversion.builder()
                .conversionFirst(Double.valueOf(strings[0]))
                .unitFirst(unitFirst)
                .conversionSecond(Double.valueOf(strings[3]))
                .unitSecond(unitSecond)
                .build();
        unitFirst.put(unitSecond.getName(), unitConversion);
        unitSecond.put(unitFirst.getName(), unitConversion);
    }

    private Unit findUnit(String name) {
        if (unitMap.containsKey(name)) {
            return unitMap.get(name);
        } else {
            Unit unit = new Unit(name);
            unitMap.put(name, unit);
            return unit;
        }
    }

    static String[] stringToArray(String inputString) {
        return Stream.of(inputString.split(" "))
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }

    String conversion(String inputString) {
        String[] strings = stringToArray(inputString);
        String result;
        result = findUnit(strings[1]).calcConversion(strings[4], Double.valueOf(strings[0]), new ArrayList<>());

        if (result.equals("")) {
            return "Conversion not possible.";
        } else {
            return strings[0] + " " + strings[1] + " " + strings[2] + " " + result + " " + strings[4];
        }
    }
}
