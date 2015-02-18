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

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import org.apache.commons.lang3.text.StrBuilder;
import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.Instruction;
import org.selenium.runner.model.SeleniumActionType;
import org.selenium.runner.model.SeleniumParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * SeleniumRunner
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
@SuppressWarnings("deprecation")
public class SeleniumRunner {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final Logger                 LOGGER            = LoggerFactory.getLogger(SeleniumRunner.class);

    private final SeleniumParameters            parameters;

    private final Map<String, String>           storedValues      = new HashMap<String, String>();

    private SeleniumWrapper                     seleniumWrapper;

    private FastClass                           seleniumFastClass = null;

    private Map<SeleniumActionType, FastMethod> CACH_FAST_METHOD  = new HashMap<SeleniumActionType, FastMethod>();

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public SeleniumRunner(final WebDriverBackedSelenium selenium, final SeleniumParameters parameters) {
        super();
        this.parameters = parameters;
        seleniumFastClass = FastClass.create(WebDriverBackedSelenium.class);
        initilizeFastMethod();
        seleniumWrapper = new SeleniumWrapper(selenium, parameters);

    }

    private void initilizeFastMethod() {

        final Method[] methods = WebDriverBackedSelenium.class.getMethods();
        for (SeleniumActionType actionType : SeleniumActionType.values()) {

            FastMethod fast = seleniumFastClass.getMethod(findMethod(methods, actionType.name()));
        }
    }

    private Method findMethod(final Method[] methods, final String name) {
        Method result = null;
        for (Method method : methods) {
            if (method.getName().equals(name)) {
                result = method;
                break;
            }
        }
        return result;
    }

    // =========================================================================
    // METHODS
    // =========================================================================
    public void run(final Instruction instruction) throws SeleniumRunnerException {

        if (instruction == null) {
            throw new SeleniumRunnerException("instruction is null");
        }
        if (seleniumWrapper == null) {
            throw new SeleniumRunnerException("selenium must be initialized!");
        }

        LOGGER.info(instruction.toString());
        if (instruction.getValue() == null) {
            instruction.setValue("");
        } else if (instruction.getValue().indexOf('$') != -1) {
            instruction.setValue(injectValue(instruction.getValue()));
        }

        if (instruction.getTarget().indexOf('$') != -1) {
            instruction.setTarget(injectValue(instruction.getTarget()));
        }

        runMethod(instruction);
    }

    // =========================================================================
    // PROTECTED
    // =========================================================================

    protected String injectValue(final String instruction) throws SeleniumRunnerException {
        if (instruction == null) {
            throw new SeleniumRunnerException("can't inject value in null instruction !");
        }

        StrBuilder result = new StrBuilder(instruction);

        String keyPattern = null;
        for (String key : storedValues.keySet()) {
            keyPattern = "${" + key + "}";
            if (result.contains(keyPattern)) {
                result.replaceAll(keyPattern, storedValues.get(key));
            }
        }

        return result.toString();

    }

    /**
     * Run method.
     *
     * @param instruction the instruction
     * @param selenium the selenium
     * @param parameters the parameters
     * @param seleniumWrapper the selenium wrapper
     * @throws ClientException the client exception
     */
    protected void runMethod(final Instruction instruction) throws SeleniumRunnerException {
        if (instruction != null) {
            FastMethod method = CACH_FAST_METHOD.get(instruction.getType());

        }

    }

}
