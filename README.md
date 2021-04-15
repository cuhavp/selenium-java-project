# Selenium Java Foundation Course



## Objectives 

Repo này chứa những bài tập và phần cấu hình sẵn cơ bản để bắt đầu làm việc với Selenium.

## What you should already know
* Working with IDEs - IntelliJ
* Java programing fundamentals
* Testing fundamentals(test case, test plan, test suite ...)

## Setting up the development environment
* Java
    - Cài đặt [Java JDK](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
    - Thiết lập biến môi trường JAVA_HOME
    * Cho [Windows 7](https://medium.com/@tushar0618/setting-java-home-variable-on-windows-7-bab344b6f3c4)
    * Cho [Windows 10](https://mkyong.com/java/how-to-set-java_home-on-windows-10/)
    * Cho [Linux](https://www.baeldung.com/linux/path-variable)
    * Cho MAC OS
        ~~~
        From OS X 10.5, Apple introduced a command line tool (/usr/libexec/java_home) which dynamically finds the top Java version specified in Java Preferences for the current user.
        
        Open ~/.bash_profile in any text editor and add:
        
        {% highlight bash %}
        export JAVA_HOME=$(/usr/libexec/java_home)
        {% endhighlight %}
        
        
        Save and close the file.
        
        Open a Terminal and run the source command to apply the changes:
        
        {% highlight bash %}
        source ~/.bash_profile
        {% endhighlight %}
        
        
        Now we can check the value of the JAVA_HOME variable:
        
        {% highlight bash %}
        echo $JAVA_HOME
        {% endhighlight %}
        
        The result should be the path to the JDK installation:
        {% highlight bash %}
        /Library/Java/JavaVirtualMachines/jdk1.8.0_111.jdk/Contents/Home
        {% endhighlight %}
        ~~~
* Download [apache-maven-3.6.3](https://mirror.downloadvn.com/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip).

    - Sau đó giải nén file zip.
    - Thêm đường dẫn **your-dir/apache-maven-3.6.3/bin** vào biến **PATH**

## Test case: 
---
1. [Login successful with valid credentials](https://cuhavp.github.io/form-authentication/)
* Open browser
* Navigate to https://the-internet.herokuapp.com/login
* Fill in username with **tomsmith**
* Fill in the password with **SuperSecretPassword!**
* Click on Login button
* And the home page is appear
---
2. [Check to a box](https://cuhavp.github.io/checkboxes/)
* Open browser
* Navigate to https://the-internet.herokuapp.com/checkboxes
* Check on "checkbox1"
* Verify "checkbox1" is checked
* Check on "checkbox2"
* Verify "checkbox2" is checked
---
3. [Select option](https://cuhavp.github.io/drop-down/)
* Open browser
* Navigate to https://the-internet.herokuapp.com/dropdown
* Select "option 1"
* Validate "option 1" is selected
---
4. [Hyperlink - link text](https://cuhavp.github.io/link-text/)
* Open browser
* Navigate to https://the-internet.herokuapp.com/status_codes
* Click on "200"
* Then "200 status code" page appear
* Click on "go here"
* Click on "301"
* Then "301 status code" page appear
* Click on "go here"
* Click on "404"
* Then "404 status code" page appear
* Click on "go here"
* Click on "500"
* Then "500 status code" page appear
* Click on "go here"
---
5. [Validate largest due person from a table](https://cuhavp.github.io/java8-web-table/)
   * Open browser
   * Navigate to https://the-internet.herokuapp.com/tables
   * Focus on table 1
   * The person who has largest due is "Doe Jacson"
---
6. [Nested frames](https://cuhavp.github.io/iframe/)
* Open browser
* Navigate to https://the-internet.herokuapp.com/nested_frames
* Verify Text present:
      ```
      LEFT
      RIGHT
      MIDDLE
      BOTTOM
      ```
---
7. JavaScript Alerts
* Open browser
* Navigate to https://the-internet.herokuapp.com/javascript_alerts
* When click on "Click For JS Alert" button
* Then the Popup is displayed.
---
8. Hover elements
* Open browser
* Navigate to https://the-internet.herokuapp.com/hovers
* When user hover on user 1 avatar
* Then the "name: user1" label is present.
---
9. Right click - Context menu
* Open browser
* Navigate to https://the-internet.herokuapp.com/context_menu
* Right click on square box
* The context menu is displayed
---
10. Page object model
* Open browser
* Navigate to https://www.calculator.net/bmi-calculator.html
* Select metric unit tab
* Fill calculator with age,gender, weight, height
* Validate result is correct
---
11. Verify user able create a new todo list
* Open browser
* Navigate to https://todomvc.com/examples/vanillajs/
* Enter a new todo name
* Verify a todo added
---