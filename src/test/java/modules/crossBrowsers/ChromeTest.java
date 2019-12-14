package modules.crossBrowsers;

import static supports.Browser.*;

public class ChromeTest {
    public static void main(String[] args) {
        open("chrome");
        visit("https://google.com");

    }
}
