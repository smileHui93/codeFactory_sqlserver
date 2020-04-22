package util;

import java.util.HashMap;

public class TypeMap extends HashMap<String, String>{

    /**
     * 
     */
    private static final long serialVersionUID = 3378414940614932888L;
    
    public TypeMap() {
        this.put("bigint", "Long");
        this.put("int", "Integer");
        this.put("tinyint", "Integer");
        this.put("smallint", "Integer");
        this.put("varchar", "String");
        this.put("char", "String");
        this.put("datetime", "Date");
        this.put("bit", "Boolean");
        this.put("decimal", "BigDecimal");
        this.put("varbinary", "byte[]");
        this.put("float", "Double");
    }
}
