package org.VTI.Entity.Enumerate;

public enum TypeName {
    Essay ("0"), MultiChoice ("1");

    private String value;

    private TypeName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static TypeName of(String value) {
        if (value == null)
            return null;

        for ( TypeName name :TypeName.values() ) {
            if (name.getValue().equals(value) )
                return name;
        }
        return null;
    }
}
