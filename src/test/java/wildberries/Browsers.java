package wildberries;

import java.util.List;

public class Browsers {
    String os;
    String os_version;
    String browser;
    String device;
    String browser_version;
    boolean real_mobile;


    public Browsers(String os, String os_version, String browser, String device, String browser_version, boolean real_mobile) {
        this.os = os;
        this.os_version = os_version;
        this.browser = browser;
        this.device = device;
        this.browser_version = browser_version;
        this.real_mobile = real_mobile;
    }

    public String getOs() {
        return os;
    }

    public String getOs_version() {
        return os_version;
    }

    public String getBrowser() {
        return browser;
    }

    public String getDevice() {
        return device;
    }

    public String getBrowser_version() {
        return browser_version;
    }

    public boolean isReal_mobile() {
        return real_mobile;
    }

    @Override
    public String toString() {
        return "Browsers{" +
                "os='" + os + '\'' +
                ", os_version='" + os_version + '\'' +
                ", browser='" + browser + '\'' +
                ", device='" + device + '\'' +
                ", browser_version='" + browser_version + '\'' +
                ", real_mobile=" + real_mobile +
                '}';
    }
}
