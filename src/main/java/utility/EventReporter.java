package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventReporter implements WebDriverEventListener {

    private int DELAY_IN_MILLISECONDS = 500;

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
//        System.out.println("Clicking on " + webElement.getText());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        try {
            Thread.sleep(DELAY_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
