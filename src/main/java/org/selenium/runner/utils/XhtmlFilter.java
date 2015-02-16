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
package org.selenium.runner.utils;

import java.io.File;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * XhtmlFilter
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class XhtmlFilter implements IOFileFilter {
    // =========================================================================
    // METHODS
    // =========================================================================

    /**
     * {@inheritDoc}
     */
    public boolean accept(File file) {
        boolean result = false;

        if (file != null && file.exists() && file.isFile()) {
            final String name = file.getName();
            if (name.length() > 5 && name.endsWith(".xhtml")) {
                result = true;
            }
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean accept(File dir, String name) {
        return false;
    }

}
