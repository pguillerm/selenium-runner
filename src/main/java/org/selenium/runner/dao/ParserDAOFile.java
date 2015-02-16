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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.Instruction;
import org.selenium.runner.model.SeleniumActionType;
import org.selenium.runner.services.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ParserDAOFile
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public class ParserDAOFile {

    // =========================================================================
    // ATTRIBUTS
    // =========================================================================
    /** The Constant LOGGER. */
    private final static Logger        LOGGER   = LoggerFactory.getLogger(ParserDAOFile.class);

    /** the unique instance of the class */
    private final static ParserDAOFile INSTANCE = new ParserDAOFile();

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /** the private empty constructor for the Singleton */
    private ParserDAOFile() {
    }

    /**
     * @return the unique instance of ParserDAOFile
     */
    public static synchronized ParserDAOFile getInstance() {
        return INSTANCE;
    }

    // =========================================================================
    // PUBLICS METHODS
    // =========================================================================
    /**
     * this method will open a XML file (generated from Selenium IDE) and store
     * the instructions into a List
     * 
     * @param file the file
     * @return an Instruction object list
     * @throws ClientException if the file is not well formated
     */
    public List<Instruction> parse(final File file) throws SeleniumRunnerException {
        /** all the instructions extract from the XML file */

        List<Instruction> res;

        if (file == null) {
            throw new SeleniumRunnerException("file is null");
        }
        LOGGER.info("read file {}", file.getAbsoluteFile());

        // ----------------------------------------------------------------------
        res = new ArrayList<Instruction>();

        Source source = null;

        // creation of a JDOM document -----------------------------------------
        try {
            InputStream input = new FileInputStream(file);
            source = new Source(input);
            input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        source.fullSequentialParse();

        LOGGER.info("parsing file {}", file.getName());
        // get selenium tbody --------------------------------------------------
        Element root = source.getFirstElement("tbody"); // selectSingleNode("//tbody");

        // at this point we really got a list of <tr> Element
        final List<Element> listTr = root.getAllElements("tr"); // selectNodes("tr");

        LOGGER.info("generating instructions blocs");
        for (Element currentNode : listTr) {
            res.add(parseBloc(currentNode));
        }
        LOGGER.info("reading file finish");
        return res;
    }

    // =========================================================================
    // PROTECTED METHODS
    // =========================================================================
    /**
     * this method will store the instructions into a object
     * 
     * @return a single Instruction object
     * @param node an Element holding the tr tag content
     * @throws ClientException if the node is null
     */
    protected Instruction parseBloc(final Element node) throws SeleniumRunnerException {
        if (node == null) {
            throw new SeleniumRunnerException("node is null");
        }
        // we retrieve the 3 <td> Element
        final List<Element> listTd = node.getAllElements("td");// selectNodes("td");

        final Iterator<Element> iteratorTd = listTd.iterator();

        Element type;
        Element target;
        Element value;

        // the first <td> Element
        type = iteratorTd.next();
        // the second <td> Element
        target = iteratorTd.next();
        // the third <td> Element
        value = iteratorTd.next();

        if (type == null) {
            throw new SeleniumRunnerException("type is null");
        }

        // we instantiate a new instruction
        SeleniumActionType itemType = SeleniumActionType.getEnum(type.getTextExtractor().toString());

        String itemTarget = null;
        if (!StringUtils.getInstance().isEmpty(target.getTextExtractor().toString())) {
            itemTarget = target.getTextExtractor().toString();
        }

        String itemValue = null;
        if (!StringUtils.getInstance().isEmpty(value.getTextExtractor().toString())) {
            itemValue = value.getTextExtractor().toString();
        }

        final Instruction instruction = new Instruction(itemType, itemTarget, itemValue);

        return instruction;
    }
}
