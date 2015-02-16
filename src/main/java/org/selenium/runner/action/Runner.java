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
package org.selenium.runner.action;

import java.io.File;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.SeleniumParameters;
import org.selenium.runner.services.SeleniumService;
import org.selenium.runner.utils.XhtmlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;

/**
 * Runner
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class Runner {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final String      SELENIUM_RUN_INFO = "Run test %s .....";

    /** The selenium test. */
    private static Map<String, File> seleniumTest      = new LinkedHashMap<String, File>();

    /** The Constant LOGGER. */
    private final static Logger      LOGGER            = LoggerFactory.getLogger(Runner.class);

    /** The Constant XHTML. */
    private final static String      XHTML             = ".xhtml";

    private final static String      OPT_FILE          = "file";

    private final static String      OPT_BROWSER       = "browser";

    private final static String      OPT_OS            = "os";

    private final static String      OPT_BROWSER_URL   = "host";

    private String                   browserOpts       = null;

    private SeleniumParameters       parameters        = null;

    private String                   propertiesName;

    private String                   urlBrowser        = null;

    private boolean                  isWindows         = false;

    // =========================================================================
    // RUN
    // =========================================================================
    public void run(String[] args, String propertiesName) throws SeleniumRunnerException {

        this.propertiesName = propertiesName;

        final JSAP jsap = new JSAP();

        final FlaggedOption optFile = new FlaggedOption(OPT_FILE);
        optFile.setStringParser(JSAP.STRING_PARSER);
        optFile.setRequired(false);
        optFile.setShortFlag('f');
        optFile.setLongFlag(OPT_FILE);

        final FlaggedOption optBrowser = new FlaggedOption(OPT_BROWSER);
        optBrowser.setStringParser(JSAP.STRING_PARSER);
        optBrowser.setRequired(false);
        optBrowser.setShortFlag('b');
        optBrowser.setLongFlag(OPT_BROWSER);

        final FlaggedOption optOs = new FlaggedOption(OPT_OS);
        optOs.setStringParser(JSAP.STRING_PARSER);
        optOs.setRequired(false);
        optOs.setShortFlag('o');
        optOs.setLongFlag(OPT_OS);

        final FlaggedOption optHost = new FlaggedOption(OPT_BROWSER_URL);
        optHost.setStringParser(JSAP.STRING_PARSER);
        optHost.setRequired(false);
        optHost.setShortFlag('h');
        optHost.setLongFlag(OPT_BROWSER_URL);

        try {
            jsap.registerParameter(optFile);
            jsap.registerParameter(optBrowser);
            jsap.registerParameter(optOs);
            jsap.registerParameter(optHost);
        } catch (JSAPException e1) {
            LOGGER.error("Can't register parameter", e1);
        }

        JSAPResult config = jsap.parse(args);
        String fileName = config.getString(OPT_FILE);

        if (config.getString(OPT_BROWSER) != null) {
            browserOpts = config.getString(OPT_BROWSER);
        }

        if (config.getString(OPT_OS) != null) {
            String system = config.getString(OPT_OS);
            if ("WINDOWS".equals(system.toUpperCase(Locale.ENGLISH))) {
                isWindows = true;
            }
        }

        if (config.getString(OPT_BROWSER_URL) != null) {
            urlBrowser = config.getString(OPT_BROWSER_URL);
        }

        initialize();

        if (fileName == null) {
            runSelenium();
        } else {
            runSelenium(fileName);
        }

    }

    // =========================================================================
    // METHODS
    // =========================================================================
    protected void initialize() throws SeleniumRunnerException {

        ResourceBundle bundle = ResourceBundle.getBundle(propertiesName);
        parameters = new SeleniumParameters(bundle);

        parameters.setWindows(isWindows);

        if (urlBrowser != null) {
            parameters.setBrowserUrl(urlBrowser);
        }

        if (browserOpts != null) {
            parameters.setBrowserCommand(browserOpts);
        }

        File currentPath = new File(parameters.getTestPath());

        if (currentPath.exists()) {
            LOGGER.info("current path = {}", currentPath.getAbsolutePath());

        } else {
            LOGGER.error("Directory with selenium test not exists {}", currentPath.getAbsolutePath());
        }

        Collection<File> files = FileUtils.listFiles(currentPath, new XhtmlFilter(), null);

        if (files != null) {
            for (File file : files) {
                seleniumTest.put(file.getName(), file);
            }
        }

    }

    /**
     * Allow to run all selenium test case.
     */
    public void runSelenium() throws SeleniumRunnerException {
        boolean hasError = false;
        for (String testCase : seleniumTest.keySet()) {
            LOGGER.info(String.format(SELENIUM_RUN_INFO, testCase));

            try {
                new SeleniumService().run(seleniumTest.get(testCase), parameters);
            } catch (SeleniumRunnerException e) {
                LOGGER.error("Error in test {}", testCase, e);
                hasError = true;
            }
        }

        if (hasError) {
            throw new SeleniumRunnerException("one test has an error");
        }

    }

    /**
     * Allow to run one selenium test case identify by file name.
     * 
     * @param fileName the file name
     * @throws SeleniumRunnerException
     */
    public void runSelenium(String fileName) throws SeleniumRunnerException {

        if (fileName == null) {
            throw new SeleniumRunnerException("File name musn't be null !");
        }

        String fullFileName = fileName.endsWith(XHTML) ? fileName : fileName + XHTML;

        if (!seleniumTest.containsKey(fullFileName)) {
            throw new SeleniumRunnerException(String.format("This selenium test cas not exist : %s", fullFileName));
        }

        File file = seleniumTest.get(fullFileName);
        LOGGER.info(String.format(SELENIUM_RUN_INFO, fullFileName));
        try {
            new SeleniumService().run(file, parameters);
        } catch (SeleniumRunnerException exception) {
            LOGGER.error(String.format("Error in test %s", fileName), exception);
            throw exception;
        }
    }

}
