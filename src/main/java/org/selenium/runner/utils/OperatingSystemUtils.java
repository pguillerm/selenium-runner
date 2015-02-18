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

/**
 * OperatingSystemUtils.
 *
 * @author pguillerm
 * @since 18 févr. 2015
 */
public class OperatingSystemUtils {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant INSTANCE. */
    private static final OperatingSystemUtils INSTANCE = new OperatingSystemUtils();

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * Instantiates a new operating system utils.
     */
    private OperatingSystemUtils() {
        super();
    }

    /**
     * Gets the single instance of OperatingSystemUtils.
     *
     * @return single instance of OperatingSystemUtils
     */
    public static synchronized OperatingSystemUtils getInstance() {
        return INSTANCE;
    }

    // =========================================================================
    // METHODS
    // =========================================================================
    /**
     * Gets the specific path.
     *
     * @param path the path
     * @param isWindows the is windows
     * @param driveMapper the drive mapper
     * @return the specific path
     */
    public String getSpecificPath(String path, boolean isWindows, String driveMapper) {
        if (path == null || !isWindows) {
            return path;
        }

        final StringBuilder result = new StringBuilder();
        result.append(driveMapper);
        result.append(":");
        result.append(path);

        return result.toString().replaceAll("/", "\\");
    }
}
