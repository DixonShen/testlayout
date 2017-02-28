package com.example.dixonshen.testlayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Z003R98D on 2/28/2017.
 */

public class InfoItem {

    private boolean hasSubItem = false; //note whether the item has sub-items, false notes negative

    private String attribute;

    /**
     * if hsaSubItems is true then the sub-items are stored in val1,
     * or in val2.
     */
    private Map<String, Object> val1 = new HashMap<>();
    private String val2 = "";

    public InfoItem(boolean itemType, String attr, Object val) {
        if (itemType) {
            hasSubItem = itemType;
            this.attribute = attr;
            this.val1 = (Map<String, Object>) val;
        }
        else {
            hasSubItem = itemType;
            this.attribute = attr;
            this.val2 = (String) val;
        }
    }

    public boolean getHasSubItem(){
        return hasSubItem;
    }

    public void setHasSubItem(boolean b) {
        this.hasSubItem = b;
    }

    public String getAttribute(){
        return attribute;
    }

    public Object getVal(){
        if (hasSubItem)
            return val1;
        else return val2;
    }
}
