/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *  
        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.selenium.runner.model;

import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * SeleniumParameters
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class SeleniumParameters {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant PROPERTIE_TEST_PATH. */
    public final static String PROPERTIE_TEST_PATH             = "test.path";

    /** The Constant PROPERTIE_SERVER_HOST. */
    public final static String PROPERTIE_SERVER_HOST           = "server.host";

    /** The Constant PROPERTIE_SERVER_PORT. */
    public final static String PROPERTIE_SERVER_PORT           = "server.port";

    /** The Constant PROPERTIE_BROWSER_START_COMMAND. */
    public final static String PROPERTIE_BROWSER_START_COMMAND = "browser.start.command";

    /** The Constant PROPERTIE_BROWSER_URL. */
    public final static String PROPERTIE_BASE_URL              = "base.url";

    /** The test path, defaut : target/seleniumTestCase. */
    private String             testPath                        = "target/seleniumTestCase";

    /** The host, default : localhost. */
    private String             host                            = "localhost";

    /** The port, default :4444. */
    private int                port                            = 4444;

    /** The browser command, default : *firefox. */
    private String             browserCommand                  = "*firefox";

    /** The browser url, default : localhost:8080. */
    private String             baseUrl                         = "localhost:8080";

    private WebDriver          webdriver                       = new FirefoxDriver();

    /** The is windows. */
    private boolean            windows                         = false;

    private boolean            dryRun                          = false;

    private String             driverMapping                   = "c";

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * Instantiates a new selenium parameters.
     */
    public SeleniumParameters() {
        super();
    }

    /**
     * Instantiates a new selenium parameters.
     * 
     * @param testPath the test path
     * @param host the host
     * @param port the port
     * @param browserCommand the browser command
     * @param browserUrl the browser url
     */
    public SeleniumParameters(String testPath, String host, int port, String browserCommand, String browserUrl) {
        super();
        this.testPath = testPath;
        this.host = host;
        this.port = port;
        this.browserCommand = browserCommand;
        this.baseUrl = browserUrl;
    }

    /**
     * Instantiates a new selenium parameters.
     * 
     * @param bundle the bundle
     */
    public SeleniumParameters(ResourceBundle bundle) {
        super();
        if (bundle != null) {
            if (bundle.containsKey(PROPERTIE_TEST_PATH)) {
                testPath = bundle.getString(PROPERTIE_TEST_PATH);
            }

            if (bundle.containsKey(PROPERTIE_SERVER_HOST)) {
                host = bundle.getString(PROPERTIE_SERVER_HOST);
            }

            if (bundle.containsKey(PROPERTIE_SERVER_PORT)) {
                port = Integer.parseInt(bundle.getString(PROPERTIE_SERVER_PORT));
            }

            if (bundle.containsKey(PROPERTIE_BROWSER_START_COMMAND)) {
                browserCommand = bundle.getString(PROPERTIE_BROWSER_START_COMMAND);
            }

            if (bundle.containsKey(PROPERTIE_BASE_URL)) {
                baseUrl = bundle.getString(PROPERTIE_BASE_URL);
            }
        }
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("SeleniumParameters [");
        final String strNull = "null";

        result.append("testPath=");
        if (testPath == null) {
            result.append(strNull);
        } else {
            result.append(testPath);
        }

        result.append(", host=");
        if (host == null) {
            result.append(strNull);
        } else {
            result.append(host);
        }

        result.append(", port=");
        result.append(port);

        result.append(", browserCommand=");
        if (browserCommand == null) {
            result.append(strNull);
        } else {
            result.append(browserCommand);
        }

        result.append(", browserUrl=");
        if (baseUrl == null) {
            result.append(strNull);
        } else {
            result.append(baseUrl);
        }

        result.append("]");

        return result.toString();
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================

    /**
     * Gets the test path.
     * 
     * @return the test path
     */
    public String getTestPath() {
        return testPath;
    }

    /**
     * Sets the test path.
     * 
     * @param testPath the new test path
     */
    public void setTestPath(String testPath) {
        this.testPath = testPath;
    }

    /**
     * Gets the host.
     * 
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     * 
     * @param host the new host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Gets the port.
     * 
     * @return the port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the port.
     * 
     * @param port the new port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Gets the browser command.
     * 
     * @return the browser command
     */
    public String getBrowserCommand() {
        return browserCommand;
    }

    /**
     * Sets the browser command.
     * 
     * @param browserCommand the new browser command
     */
    public void setBrowserCommand(String browserCommand) {
        this.browserCommand = browserCommand;
    }

    /**
     * Gets the browser url.
     * 
     * @return the browser url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets the browser url.
     * 
     * @param baseUrl the new browser url
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Checks if is windows.
     *
     * @return true, if is windows
     */
    public boolean isWindows() {
        return windows;
    }

    /**
     * Sets the windows.
     *
     * @param isWindows the new windows
     */
    public void setWindows(boolean isWindows) {
        this.windows = isWindows;
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }

    public void setWebdriver(WebDriver webdriver) {
        this.webdriver = webdriver;
    }

    public boolean isDryRun() {
        return dryRun;
    }

    public void setDryRun(boolean dryRun) {
        this.dryRun = dryRun;
    }

    public String getDriverMapping() {
        return driverMapping;
    }

    public void setDriverMapping(String driverMapping) {
        this.driverMapping = driverMapping;
    }

}
