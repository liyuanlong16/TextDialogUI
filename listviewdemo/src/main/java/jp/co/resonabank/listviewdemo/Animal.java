package jp.co.resonabank.listviewdemo;

/**
 * Created by smyhvae on 2015/5/7.
 */
public class Animal {
    private String aname;
    private String aSpake;
    private int aIcon;

    public Animal(String aname, String aSpake, int aIcon) {
        this.aname = aname;
        this.aSpake = aSpake;
        this.aIcon = aIcon;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getaSpake() {
        return aSpake;
    }

    public void setaSpake(String aSpake) {
        this.aSpake = aSpake;
    }

    public int getaIcon() {
        return aIcon;
    }

    public void setaIcon(int aIcon) {
        this.aIcon = aIcon;
    }
}
