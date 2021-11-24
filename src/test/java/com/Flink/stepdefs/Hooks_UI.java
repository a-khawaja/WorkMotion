package com.Flink.stepdefs;

import com.Flink.weathershopper.PageContainer;
import com.Flink.utilities.GetConfig;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.getProperty;

public class Hooks_UI {
    protected int dataIndex = 0;
    protected Logger log = Logger.getLogger(String.valueOf(Hooks_UI.class));
    static String scenarioName, platform;
    public static Map<String, String> data = null;
    public static PageContainer container;
    public static WebDriver driver;

    //public String browser = "chrome";
    public String browser;


    @Before
    public void beforeEveryTest(Scenario scenario) throws Exception {

        String featureName = scenario.getSourceTagNames().toArray()[0].toString().split("@")[1];
        scenarioName = scenario.getName();
        log.info("==================> Started executing the test - " + scenarioName + " <==================");

        browser = getProperty("browser");

        GetConfig.updateProperties("browser", browser);
        GetConfig.updateProperties("ScenarioName", scenarioName);

        platform = getProperty("os.name");
        data = getTestData(scenarioName, featureName);
        initDriver();
        setLogger();
    }


    /**
     * Method to initiate the driver based on platform & browser
     *
     * @throws ConfigurationException
     */
    public void initDriver() throws ConfigurationException {

        if (platform.toLowerCase().contains("win")) {
            windowsDriverSetup();
        } else if (platform.toLowerCase().contains("mac")) {
            macDriverSetup();
        } else if (platform.toLowerCase().contains("lin")) {
            firefoxDriverSetup();
        }
        container = new PageContainer(driver);
    }


    private void windowsDriverSetup() {
        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);

        prefsMap.put("download.prompt_for_download", false);
        prefsMap.put("safebrowsing.enabled", "false");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions win_Options = new ChromeOptions();
            win_Options.setExperimentalOption("prefs", prefsMap);
            win_Options.addArguments("window-size=1920x1080");
            win_Options.addArguments("--start-maximized");
            win_Options.addArguments("--disable-gpu");
            win_Options.addArguments("--disable-extensions");
            win_Options.addArguments("--no-sandbox");
            win_Options.addArguments("acceptSslCerts=true");
            win_Options.addArguments("acceptInsecureCerts=true");
            win_Options.addArguments("--allow-running-insecure-content");
            //win_Options.addArguments("--headless");
            log.info("Running on Windows Operating System with " + browser + " browser");
            driver = WebDriverManager.chromedriver().capabilities(win_Options).create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions win_Options = new FirefoxOptions();
//                win_Options.setExperimentalOption("prefs", prefsMap);
            win_Options.addArguments("window-size=1920x1080");

            win_Options.addArguments("--disable-gpu");
            win_Options.addArguments("--disable-extensions");
            //win_Options.addArguments("--headless");
            log.info("Running on Windows Operating System with " + browser + " browser");
            driver = WebDriverManager.firefoxdriver().capabilities(win_Options).create();
        }
    }

    private void macDriverSetup() {
        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        //prefsMap.put("download.default_directory", loc);
        prefsMap.put("download.prompt_for_download", false);
        prefsMap.put("safebrowsing.enabled", "false");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions mac_options = new ChromeOptions();
            mac_options.setExperimentalOption("prefs", prefsMap);
            mac_options.addArguments("test-type");
            mac_options.addArguments("--kiosk");
//            mac_options.addArguments("--headless");
            mac_options.addArguments("acceptSslCerts=true");
            mac_options.addArguments("acceptInsecureCerts=true");
            System.out.println("Running on Mac Operating System with " + browser + " browser");
            driver = WebDriverManager.chromedriver().capabilities(mac_options).create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions mac_options = new FirefoxOptions();
//                mac_options.setExperimentalOption("prefs", prefsMap);
            mac_options.addArguments("test-type");
            System.out.println("Running on Mac Operating System with " + browser + " browser");
            driver = WebDriverManager.firefoxdriver().capabilities(mac_options).create();
        }
    }

    private void firefoxDriverSetup() {
        Map<String, Object> prefsMap = new HashMap<String, Object>();
        prefsMap.put("profile.default_content_settings.popups", 0);
        prefsMap.put("download.prompt_for_download", false);
        prefsMap.put("safebrowsing.enabled", "false");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions lin_options = new ChromeOptions();
            lin_options.setExperimentalOption("prefs", prefsMap);
            lin_options.addArguments("test-type");
            lin_options.addArguments("window-size=1920x1080");
            lin_options.addArguments("--disable-gpu");
            lin_options.addArguments("--disable-extensions");
            lin_options.addArguments("--no-sandbox");
            lin_options.addArguments("acceptSslCerts=true");
            lin_options.addArguments("acceptInsecureCerts=true");
            lin_options.addArguments("--allow-running-insecure-content");
            lin_options.addArguments("--disable-dev-shm-usage");
            lin_options.addArguments("--headless");
            System.out.println("Running on Mac Operating System with " + browser + " browser");
            driver = WebDriverManager.chromedriver().capabilities(lin_options).create();
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions lin_options = new FirefoxOptions();
            lin_options.addArguments("test-type");
            lin_options.addArguments("window-size=1920x1080");
            lin_options.addArguments("--disable-gpu");
            lin_options.addArguments("--disable-extensions");
            lin_options.addArguments("--no-sandbox");
            lin_options.addArguments("acceptSslCerts=true");
            lin_options.addArguments("acceptInsecureCerts=true");
            lin_options.addArguments("--allow-running-insecure-content");
            lin_options.addArguments("--disable-dev-shm-usage");
            lin_options.addArguments("--headless");
            System.out.println("Running on Mac Operating System with " + browser + " browser");
            driver = WebDriverManager.firefoxdriver().capabilities(lin_options).create();
        }
    }


    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            try {
                File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
                FileUtils.copyFile(sourcePath, destinationPath);
            } catch (IOException e) {
            }
        }
    }


    @After(order = 0)
    public void afterEveryTest() throws ConfigurationException, IOException {
        log.info("==================> Finished executing the test - " + scenarioName + " <==================");
        quitDriver();
    }


    /**
     * Method to quit the driver
     */
    public void quitDriver() {
        driver.quit();
    }


    /**
     * Method to set the logger
     *
     * @throws ConfigurationException
     */
    private void setLogger() throws ConfigurationException {
        PropertyConfigurator.configure(getProperty("user.dir") + "/src/main/resources/Log4j.properties");
        ConsoleAppender console = new ConsoleAppender();
        String PATTERN = "%d [%p|%c|%C{1}] %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.INFO);
        console.activateOptions();
        Logger.getRootLogger().addAppender(console);
        FileAppender fa = new FileAppender();
        fa.setFile(getProperty("user.dir") + GetConfig.getProperties("start.log") + scenarioName + "_log.txt");
        fa.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
        fa.setThreshold(Level.INFO);
        fa.setAppend(false);
        fa.activateOptions();
        Logger.getRootLogger().addAppender(fa);
    }


    /**
     * Method to get the test data from the workbook.
     *
     * @param testName Test which is to be run
     * @return
     * @throws BiffException
     * @throws IOException
     * @throws ConfigurationException
     */
    protected Map<String, String> getTestData(String testName, String featureName)
            throws BiffException, IOException, ConfigurationException {
        Sheet dataSheet = null;
        if (dataIndex == -1) {
            return data;
        }
        data = new HashMap<String, String>();
        log.info("Fetching test data for test - " + testName);


        dataSheet = Workbook
                .getWorkbook(new File(getProperty("user.dir") + GetConfig.getProperties("Testdata_TESTM")))
                .getSheet(featureName);

        if (dataSheet == null) {
            log.error("The required sheet " + featureName + " is not present in the Testdata excel");
        }
        dataIndex = dataSheet.findCell(testName).getRow();
        for (int i = 0; i < dataSheet.getColumns(); i++) {
            String key = dataSheet.getCell(i, 0).getContents();
            String value = dataSheet.getCell(i, dataIndex).getContents();
            data.put(key, value);
        }
        return data;
    }
}