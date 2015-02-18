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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import org.selenium.runner.model.SeleniumActionType;
import org.selenium.runner.model.SeleniumParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * SeleniumProxy
 * 
 * @author pguillerm
 * @since 18 févr. 2015
 */
public class SeleniumProxy implements InvocationHandler {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    private static final Logger           LOGGER = LoggerFactory.getLogger(SeleniumProxy.class);

    private final WebDriverBackedSelenium selenium;

    private final SeleniumParameters      parameters;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================

    /**
     * Instantiates a new selenium proxy.
     *
     * @param selenium the selenium
     * @param parameters the parameters
     * @param seleniumFastClass the selenium fast class
     * @param cacheFastMethod the cache fast method
     */
    public SeleniumProxy(final WebDriverBackedSelenium selenium, final SeleniumParameters parameters) {
        super();
        this.selenium = selenium;
        this.parameters = parameters;
    }

    // =========================================================================
    // INTERCEPT
    // =========================================================================
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {

        return null;
    }

}
