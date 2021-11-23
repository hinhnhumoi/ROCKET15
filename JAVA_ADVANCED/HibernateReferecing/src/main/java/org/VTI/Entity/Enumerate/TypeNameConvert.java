package org.VTI.Entity.Enumerate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeNameConvert implements AttributeConverter<TypeName,String> {
    @Override
    public String convertToDatabaseColumn (TypeName typeName) {
        if (typeName == null)
            return null;
        return typeName.getValue();
    }

    @Override
    public TypeName convertToEntityAttribute (String value) {

        return TypeName.of(value);
    }
}
