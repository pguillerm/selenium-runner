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
package org.selenium.runner.exceptions;

import java.text.MessageFormat;

/**
 * SeleniumRunnerException
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class SeleniumRunnerException extends Exception {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -7574848469626747784L;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    public SeleniumRunnerException() {
        super();
    }

    public SeleniumRunnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeleniumRunnerException(String message) {
        super(message);
    }

    public SeleniumRunnerException(Throwable cause) {
        super(cause);
    }
    
    public SeleniumRunnerException(String message, Object... values) {
        super(MessageFormat.format(message, values));
    }

    public SeleniumRunnerException(String message, Throwable cause, Object... values) {
        super(MessageFormat.format(message, values), cause);
    }

}
