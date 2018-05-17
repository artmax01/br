package enums;

public enum ProductTypes {

    MATTRESS("Tomorrow Hybrid Mattress"),
    MONITOR("Tomorrow Sleeptracker® Monitor"),
    DRAPES("Tomorrow Blackout Curtains"),
    FOAM_PILLOW("Tomorrow Cooling Memory Foam Pillow"),
    PLUSH_PILLOW("Tomorrow Hypoallergenic Plush Pillow"),
    COMFORTER("Tomorrow White Comforter"),
    MATTRESS_PROTECTOR("Tomorrow Waterproof Mattress Protector"),
    SHEETSET("Tomorrow White Sheet Set"),
    ADJUSTABLE_BASE("Tomorrow Adjustable Bed"),
    FOUNDATION("Tomorrow Platform Bed");


    private String value;

    ProductTypes (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static ProductTypes getEnum(String value) {
        for(ProductTypes v : values())
            if(v.getValue().equalsIgnoreCase(value)) return v;
        throw new IllegalArgumentException("Can't find Product type " + value);
    }


}
