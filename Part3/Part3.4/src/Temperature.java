import java.text.DecimalFormat;
import java.util.Objects;

public record Temperature(double value, Scale scale) {

    public enum Scale {
        CELSIUS("Celsius", 'C'), FAHRENHEIT("Fahrenheit", 'F'), KELVIN("Kelvin", 'K');

        final String type;
        final char unit;

        Scale(String type, char unit) {
            this.type = type;
            this.unit = unit;
        }
    }

    public Temperature {
        Objects.requireNonNull(scale, "Missing Scale");
    }

    @Override
    public String toString() {
        return value + "°" + scale.unit;
    }

    public Temperature converter(Scale toScale) {
        double convertedValue = switch (scale) {
            case CELSIUS -> switch (toScale) {
                case CELSIUS -> value;
                case FAHRENHEIT -> value * (9 / 5.0) + 32;
                case KELVIN -> value + 273.15;
            };
            case FAHRENHEIT -> switch (toScale) {
                case CELSIUS -> (value - 32) * (5 / 9.0);
                case FAHRENHEIT -> value;
                case KELVIN -> (value - 32) * (5 / 9.0) + 273.15;
            };
            case KELVIN -> switch (toScale) {
                case CELSIUS -> value - 273.15;
                case FAHRENHEIT -> (value - 273.15) * (9 / 5.0) + 32;
                case KELVIN -> value;
            };
        };
        return new Temperature(convertedValue, toScale);
    }

    public Temperature add(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).add(other);
        }

        double result = this.value + other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature minus(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).minus(other);
        }

        double result = this.value - other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature multi(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).multi(other);
        }

        double result = this.value * other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }

    public Temperature divide(Temperature other) {
        if (other.scale() != this.scale) {
            return converter(other.scale()).divide(other);
        }

        double result = this.value / other.value();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedResult = decimalFormat.format(result);
        return new Temperature(Double.parseDouble(formattedResult), other.scale);
    }
}