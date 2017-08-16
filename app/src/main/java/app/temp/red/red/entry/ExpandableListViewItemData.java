package app.temp.red.red.entry;

import java.util.List;

/**
 * Created by huangkangfa on 2017/8/16.
 */

public class ExpandableListViewItemData {
    private String name;
    private boolean isSelected;
    private List<ExpandableListViewChildItemData> data;

    public ExpandableListViewItemData(String name, boolean isSelected, List<ExpandableListViewChildItemData> data) {
        this.name = name;
        this.isSelected = isSelected;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public List<ExpandableListViewChildItemData> getData() {
        return data;
    }

    public void setData(List<ExpandableListViewChildItemData> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExpandableListViewItemData{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                ", data=" + data +
                '}';
    }
}
