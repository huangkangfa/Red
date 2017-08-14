package app.temp.red.red.service.mqtt.entry;

/**
 * Created by huangkangfa on 2017/6/21.
 */

public enum RegisterTheme {
    ADD("REGISTERTHEMEADD"),
    REDUCE("REGISTERTHEMEREDUCE"),
    CLEAR("REGISTERTHEMECLEAR"),
    CLEAR_ADD("REGISTERTHEMECLEAR_ADD");
    private String val;
    RegisterTheme(String val){
        this.val=val;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
