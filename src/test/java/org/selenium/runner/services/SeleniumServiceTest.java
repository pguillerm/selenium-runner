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

import org.junit.Test;
import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.SeleniumParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SeleniumServiceTest
 * 
 * @author pguillerm
 * @since 18 févr. 2015
 */
public class SeleniumServiceTest {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private final static Logger LOGGER         = LoggerFactory.getLogger(SeleniumServiceTest.class);

    private File                PATH_RESOURCES = initializeTargerFolder();

    private File initializeTargerFolder() {
        final File file = new File(".");
        final File folder = file.getAbsoluteFile().getParentFile();

        final StringBuilder path = new StringBuilder();
        path.append(folder.getAbsoluteFile());
        path.append(File.separator);
        path.append("src");
        path.append(File.separator);
        path.append("test");
        path.append(File.separator);
        path.append("resources");
        return new File(path.toString());
    }

    // =========================================================================
    // METHODS
    // =========================================================================
    @Test
    public void testRun() throws SeleniumRunnerException {
        LOGGER.info("test begin....");
        final File seleniumTest = new File(PATH_RESOURCES.getAbsolutePath() + File.separator + "test01.xhtml");
        SeleniumParameters params = new SeleniumParameters();
        params.setDryRun(true);
        params.setBaseUrl("http://en.wikipedia.org/wiki/");

        SeleniumService service = new SeleniumService();
        service.run(seleniumTest, params);
    }

}
