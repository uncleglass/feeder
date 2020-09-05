package pl.uncleglass.feeder.persistence.converters;

import pl.uncleglass.feeder.domain.ProductUnit;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductUnitConverter implements AttributeConverter<ProductUnit, Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductUnit unit) {
        if (unit == null) {
            return null;
        }
        return unit.getCode();
    }

    @Override
    public ProductUnit convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(ProductUnit.values())
                .filter(productUnit -> productUnit.getCode() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
