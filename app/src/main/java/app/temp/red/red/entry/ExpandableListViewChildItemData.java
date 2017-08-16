package app.temp.red.red.entry;

/**
 * Created by huangkangfa on 2017/8/16.
 */

public class ExpandableListViewChildItemData {
    private String name;
    private boolean isSelected;

    public ExpandableListViewChildItemData(String name, boolean isSelected) {
        this.name = name;
        this.isSelected = isSelected;
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

    @Override
    public String toString() {
        return "ExpandableListViewChildItemData{" +
                "name='" + name + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }
}
