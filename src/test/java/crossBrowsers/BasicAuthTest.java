package crossBrowsers;

public class BasicAuthTest {
    public static void main(String[] args) {
        Browser.open("chrome");
        Browser.visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
