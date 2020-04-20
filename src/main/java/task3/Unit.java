package task3;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Unit {
    private String name;

    private Map<String, UnitConversion> unitConversions = new HashMap<>();

    Unit(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void put(String name, UnitConversion unitConversion) {
        if (!unitConversions.containsKey(name)) {
            unitConversions.put(name, unitConversion);
        }
    }

    static String doubleToStringFormat(Double number){
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        return decimalFormat.format(number);
    }

    String calcConversion(String name, Double conversion, List<String> path) {
        UnitConversion unitConversion;
        if (unitConversions.containsKey(name)) {
            unitConversion = unitConversions.get(name);
            if (unitConversion.getUnitFirst().equals(this)) {
                return doubleToStringFormat(conversion * unitConversion.getConversionSecond() / unitConversion.getConversionFirst());
            } else {
                return doubleToStringFormat(conversion * unitConversion.getConversionFirst() / unitConversion.getConversionSecond());
            }
        } else {
            for (Map.Entry<String, UnitConversion> conversionEntry : unitConversions.entrySet()) {
                String result = "";

                unitConversion = conversionEntry.getValue();
                if (unitConversion.getUnitFirst().equals(this)) {
                    if (!path.contains(unitConversion.getUnitSecond().getName())) {
                        path.add(unitConversion.getUnitSecond().getName());
                        result = unitConversion.getUnitSecond().calcConversion(name, conversion * unitConversion.getConversionSecond() / unitConversion.getConversionFirst(), path);
                    }
                } else {
                    if (!path.contains(unitConversion.getUnitFirst().getName())) {
                        path.add(unitConversion.getUnitFirst().getName());
                        result = unitConversion.getUnitFirst().calcConversion(name, conversion * unitConversion.getConversionFirst() / unitConversion.getConversionSecond(), path);
                    }
                }
                if (!"".equals(result)) {
                    return result;
                }
            }
        }
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (this == o)
            return true;
        if (getClass() != o.getClass())
            return false;
        Unit unit = (Unit) o;
        return getName().equals(unit.getName());
    }
}
