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

import java.io.Serializable;

/**
 * Instruction
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class Instruction implements Serializable {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The Constant serialVersionUID. */
    private static final long  serialVersionUID = -3742224276483643997L;

    /**
     * the Selenium action. must not be null or empty
     */
    private SeleniumActionType type;

    /**
     * Selenium selector
     */
    private String             target;

    /**
     * target value
     */
    private String             value;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * the default empty constructor
     * */
    public Instruction() {
        super();
    }

    /**
     * Constructor with parameters
     * 
     * @param type an enum SeleniumActionType
     * @param target a String
     * @param value a String
     * */
    public Instruction(final SeleniumActionType type, final String target, final String value) {
        super();
        this.type = type;
        this.target = target;
        this.value = value;
    }

    // =========================================================================
    // OVERRIDES
    // =========================================================================

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((target == null) ? 0 : target.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = this == obj;

        Instruction other = null;
        if (!result && obj != null && obj instanceof Instruction) {
            other = (Instruction) obj;
        }

        if (other != null) {
            //@formatter:off
            result = (type   == other.getType()) && 
                     (target == null? other.getTarget()==null: target.equals(other.getTarget()))&& 
                     (value  == null? other.getValue() ==null:  value.equals(other.getValue()));
            //@formatter:on
        }

        return result;
    }

    // =========================================================================
    // GETTERS & SETTERS
    // =========================================================================

    public SeleniumActionType getType() {
        return type;
    }

    public void setType(SeleniumActionType type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
