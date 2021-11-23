package org.VTI.Entity.Enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConvert  implements AttributeConverter<SalaryName,Integer> {
    @Override
    public Integer convertToDatabaseColumn(SalaryName salary) {
        return salary.getValue();
    }

    @Override
    public SalaryName convertToEntityAttribute(Integer value) {
        return SalaryName.of(value);
    }
}
