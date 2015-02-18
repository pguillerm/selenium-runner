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
package org.selenium.runner.services;

import java.io.File;
import java.util.List;

import org.selenium.runner.dao.ParserDAOFile;
import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.Instruction;
import org.selenium.runner.model.SeleniumParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * SeleniumService
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class SeleniumService {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private final static Logger LOGGER = LoggerFactory.getLogger(SeleniumService.class);

    // =========================================================================
    // METHODS
    // =========================================================================
    /**
     * Run.
     * 
     * @param file the file
     * @throws ClientException the client exception
     */
    public void run(final File file, final SeleniumParameters parameters) throws SeleniumRunnerException {
        LOGGER.info("start run process for {}", file);
        checkInput(file, parameters);

        if (parameters.isDryRun()) {
            LOGGER.info("====================================================");
            LOGGER.info("Running in Dry run mode ");
            LOGGER.info("====================================================");
        }

        List<Instruction> instructions = null;

        final ParserDAOFile daoFile = ParserDAOFile.getInstance();
        try {
            instructions = daoFile.parse(file);
        } catch (SeleniumRunnerException e) {
            throw new SeleniumRunnerException("daoFile.parse(file) failed", e);
        }
        LOGGER.info("get new Selenium instance");

        final WebDriverBackedSelenium selenium = new WebDriverBackedSelenium(parameters.getWebdriver(),
                parameters.getBaseUrl());

        LOGGER.info("selenium launch...");
        if (!parameters.isDryRun()) {
            selenium.start();
        }
        LOGGER.info("selenium started");

        final SeleniumRunner selRunner = new SeleniumRunner(selenium, parameters);

        for (Instruction currentInstruction : instructions) {
            try {
                selRunner.run(currentInstruction);
            } catch (SeleniumRunnerException e) {
                if (!parameters.isDryRun()) {
                    selenium.stop();
                }
                throw new SeleniumRunnerException(e.getMessage(), e);
            }
        }
        LOGGER.info("stop selenium instance...");
        if (!parameters.isDryRun()) {
            selenium.stop();
        }
        LOGGER.info("Selenium stoped");
        LOGGER.info("Test SUCCESSFUL : {}", file.getName());
    }

    protected void checkInput(final File file, final SeleniumParameters parameters) throws SeleniumRunnerException {
        if (file == null || !file.exists()) {
            throw new SeleniumRunnerException("Selenium test case file don't exists");
        }
        if (parameters == null) {
            throw new SeleniumRunnerException("Selenium parameters musn't be null");
        }

        if (parameters.getBrowserCommand() == null) {
            throw new SeleniumRunnerException("Parameters browser command musn't be null");
        }

        if (parameters.getBaseUrl() == null) {
            throw new SeleniumRunnerException("Parameters browser url musn't be null");
        }
        if (parameters.getHost() == null) {
            throw new SeleniumRunnerException("Parameters host musn't be null");
        }

    }
}
