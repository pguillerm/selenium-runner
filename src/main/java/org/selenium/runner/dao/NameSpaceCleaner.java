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
package org.selenium.runner.dao;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.VisitorSupport;
import org.dom4j.tree.DefaultElement;

/**
 * NameSpaceCleaner.
 *
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class NameSpaceCleaner extends VisitorSupport {

    // =========================================================================
    // METHODS
    // =========================================================================

    /**
     * {@inheritDoc}
     */
    public void visit(Document document) {
        ((DefaultElement) document.getRootElement()).setNamespace(Namespace.NO_NAMESPACE);
        document.getRootElement().additionalNamespaces().clear();
    }

    /**
     * {@inheritDoc}
     */
    public void visit(Namespace namespace) {
        namespace.detach();
    }

    /**
     * {@inheritDoc}
     */
    public void visit(Attribute node) {
        if (node.toString().contains("xmlns") || node.toString().contains("xsi:")) {
            node.detach();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visit(Element node) {
        if (node instanceof DefaultElement) {
            ((DefaultElement) node).setNamespace(Namespace.NO_NAMESPACE);
        }
    }
}
