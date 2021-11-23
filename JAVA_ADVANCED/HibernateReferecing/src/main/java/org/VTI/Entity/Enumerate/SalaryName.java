package org.VTI.Entity.Enumerate;

public enum SalaryName {
    Dev(600), Test(700), ScrumMaster(1500), PM(2000) ;

    private int value;

    private SalaryName(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SalaryName of(int value) {

        for ( SalaryName name :SalaryName.values() ) {
            if (name.getValue() == value )
                return name;
        }
        return null;
    }
}
