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

import java.util.HashMap;
import java.util.Map;

import org.selenium.runner.exceptions.SeleniumRunnerException;
import org.selenium.runner.model.Instruction;
import org.selenium.runner.model.SeleniumParameters;
import org.selenium.runner.services.functional.WaitFor;
import org.selenium.runner.utils.OperatingSystemUtils;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

/**
 * SeleniumWrapper.
 *
 * @author pguillerm
 * @since 18 févr. 2015
 */
public class SeleniumWrapper {

    // =========================================================================
    // ATTRIBUTES
    // =========================================================================
    /** The values. */
    private final static Map<String, String> values                = new HashMap<String, String>();

    private final static String              INTERRUPTED_EXCEPTION = "Thread interrupted exception";

    /** The Constant timeout. */
    private static final String              TIMEOUT               = "30000";

    /** The Constant sixty. */
    private static final int                 SIXTY                 = 60;

    /** The Constant fail. */
    private static final String              FAIL                  = "timeout";

    /** The Constant sleep. */
    private static final int                 SLEEP                 = 1000;

    /** The selenium. */
    private final WebDriverBackedSelenium    selenium;

    /** The parameters. */
    private final SeleniumParameters         parameters;

    // =========================================================================
    // CONSTRUCTORS
    // =========================================================================
    /**
     * Instantiates a new selenium wrapper.
     *
     * @param selenium the selenium
     * @param parameters the parameters
     */
    public SeleniumWrapper(final WebDriverBackedSelenium selenium, final SeleniumParameters parameters) {
        this.selenium = selenium;
        this.parameters = parameters;
    }

    // =========================================================================
    // METHODS
    // =========================================================================

    /**
     * Gets the stored values.
     *
     * @return the stored values
     */
    public Map<String, String> getStoredValues() {
        return values;
    }

    /**
     * Store eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void storeEval(Instruction instruction) throws SeleniumRunnerException {
        String value = selenium.getEval(instruction.getTarget());
        values.put(instruction.getValue(), value);
    }

    private void isTimeout(int second) throws SeleniumRunnerException {
        if (second >= SIXTY) {
            fail(FAIL);
        }
    }

    private void sleep() throws SeleniumRunnerException {
        try {
            Thread.sleep(SLEEP);
        } catch (InterruptedException e) {
            throw new SeleniumRunnerException(INTERRUPTED_EXCEPTION, e);
        }
    }

    protected void waitingFor(WaitFor condition) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (condition.waitFor()) {
                break;
            }
            sleep();
        }
    }

    private void fail(String message) throws SeleniumRunnerException {
        // TODO Auto-generated method stub

    }

    private void assertEquals(String target, String alert) {
        // TODO Auto-generated method stub

    }

    private void assertFalse(boolean alertPresent) {
        // TODO Auto-generated method stub

    }

    private void assertTrue(boolean alertPresent) {
        // TODO Auto-generated method stub

    }

    private String join(String[] allButtons, char c) {
        // TODO Auto-generated method stub
        return null;
    }

    private void assertEquals(String value, Number cssCount) {
        // TODO Auto-generated method stub

    }

    private void assertNotEquals(String target, String alert) {
        // TODO Auto-generated method stub

    }

    private void assertNotEquals(String value, Number cssCount) {
        // TODO Auto-generated method stub

    }

    private void verifyEquals(String target, String alert) {
        // TODO Auto-generated method stub

    }

    private void verifyFalse(boolean alertPresent) {
        // TODO Auto-generated method stub

    }

    private void verifyTrue(boolean alertPresent) {
        // TODO Auto-generated method stub

    }

    private void verifyEquals(String value, Number cssCount) {
        // TODO Auto-generated method stub

    }

    private void verifyNotEquals(String target, String alert) {
        // TODO Auto-generated method stub

    }

    private void verifyNotEquals(String value, Number cursorPosition) {
        // TODO Auto-generated method stub

    }

    // =========================================================================
    // DELEGATE
    // =========================================================================

    /**
     * Adds the location strategy.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addLocationStrategy(Instruction instruction) throws SeleniumRunnerException {
        selenium.addLocationStrategy(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Adds the location strategy and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addLocationStrategyAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.addLocationStrategy(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Adds the script.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addScript(Instruction instruction) throws SeleniumRunnerException {
        selenium.addScript(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Adds the script and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addScriptAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.addScript(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Adds the selection.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addSelection(Instruction instruction) throws SeleniumRunnerException {
        selenium.addSelection(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Adds the selection and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void addSelectionAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.addSelection(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Allow native xpath.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void allowNativeXpath(Instruction instruction) throws SeleniumRunnerException {
        selenium.allowNativeXpath(instruction.getTarget());
    }

    /**
     * Allow native xpath and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void allowNativeXpathAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.allowNativeXpath(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Alt key down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void altKeyDown(Instruction instruction) throws SeleniumRunnerException {
        selenium.altKeyDown();
    }

    /**
     * Alt key down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void altKeyDownAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.altKeyDown();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Alt key up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void altKeyUp(Instruction instruction) throws SeleniumRunnerException {
        selenium.altKeyUp();
    }

    /**
     * Alt key up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void altKeyUpAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.altKeyUp();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Answer on next prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void answerOnNextPrompt(Instruction instruction) throws SeleniumRunnerException {
        selenium.answerOnNextPrompt(instruction.getTarget());
    }

    /**
     * Assert alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAlert(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getAlert());
    }

    /**
     * Assert alert not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAlertNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isAlertPresent());
    }

    /**
     * Assert alert present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAlertPresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isAlertPresent());
    }

    /**
     * Assert all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllButtons(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllButtons(), ','));
    }

    /**
     * Assert all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllFields(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllFields(), ','));
    }

    /**
     * Assert all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllLinks(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllLinks(), ','));
    }

    /**
     * Assert all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllWindowIds(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllWindowIds(), ','));
    }

    /**
     * Assert all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllWindowNames(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllWindowNames(), ','));
    }

    /**
     * Assert all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), join(selenium.getAllWindowTitles(), ','));
    }

    /**
     * Assert attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAttribute(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getAttribute(instruction.getTarget()));
    }

    /**
     * Assert attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','));
    }

    /**
     * Assert body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertBodyText(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getBodyText());
    }

    /**
     * Assert checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertChecked(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isChecked(instruction.getTarget()));
    }

    /**
     * Assert confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertConfirmation(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getConfirmation());
    }

    /**
     * Assert confirmation not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertConfirmationNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isConfirmationPresent());
    }

    /**
     * Assert confirmation present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertConfirmationPresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isConfirmationPresent());
    }

    /**
     * Assert cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCookie(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getCookie());
    }

    /**
     * Assert cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCookieByName(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getCookieByName(instruction.getTarget()));
    }

    /**
     * Assert cookie not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCookieNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isCookiePresent(instruction.getTarget()));
    }

    /**
     * Assert cookie present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCookiePresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isCookiePresent(instruction.getTarget()));
    }

    /**
     * Assert css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCssCount(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getCssCount(instruction.getTarget()));
    }

    /**
     * Assert cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertCursorPosition(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getCursorPosition(instruction.getTarget()));
    }

    /**
     * Assert editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertEditable(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isEditable(instruction.getTarget()));
    }

    /**
     * Assert element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementHeight(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getElementHeight(instruction.getTarget()));
    }

    /**
     * Assert element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementIndex(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getElementIndex(instruction.getTarget()));
    }

    /**
     * Assert element not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isElementPresent(instruction.getTarget()));
    }

    /**
     * Assert element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getElementPositionLeft(instruction.getTarget()));
    }

    /**
     * Assert element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementPositionTop(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getElementPositionTop(instruction.getTarget()));
    }

    /**
     * Assert element present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementPresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isElementPresent(instruction.getTarget()));
    }

    /**
     * Assert element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertElementWidth(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getElementWidth(instruction.getTarget()));
    }

    /**
     * Assert eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertEval(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getEval(instruction.getTarget()));
    }

    /**
     * Assert expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertExpression(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getExpression(instruction.getTarget()));
    }

    /**
     * Assert html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertHtmlSource(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getHtmlSource());
    }

    /**
     * Assert location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertLocation(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getLocation());
    }

    /**
     * Assert mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertMouseSpeed(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getMouseSpeed());
    }

    /**
     * Assert not alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAlert(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getAlert());
    }

    /**
     * Assert not all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllButtons(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllButtons(), ','));
    }

    /**
     * Assert not all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllFields(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllFields(), ','));
    }

    /**
     * Assert not all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllLinks(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllLinks(), ','));
    }

    /**
     * Assert not all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllWindowIds(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllWindowIds(), ','));
    }

    /**
     * Assert not all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllWindowNames(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllWindowNames(), ','));
    }

    /**
     * Assert not all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), join(selenium.getAllWindowTitles(), ','));
    }

    /**
     * Assert not attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAttribute(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getAttribute(instruction.getTarget()));
    }

    /**
     * Assert not attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','));
    }

    /**
     * Assert not body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotBodyText(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getBodyText());
    }

    /**
     * Assert not checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotChecked(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isChecked(instruction.getTarget()));
    }

    /**
     * Assert not confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotConfirmation(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getConfirmation());
    }

    /**
     * Assert not cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotCookie(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getCookie());
    }

    /**
     * Assert not cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotCookieByName(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getCookieByName(instruction.getTarget()));
    }

    /**
     * Assert not css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotCssCount(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getCssCount(instruction.getTarget()));
    }

    /**
     * Assert not cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotCursorPosition(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getCursorPosition(instruction.getTarget()));
    }

    /**
     * Assert not editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotEditable(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isEditable(instruction.getTarget()));
    }

    /**
     * Assert not element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotElementHeight(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getElementHeight(instruction.getTarget()));
    }

    /**
     * Assert not element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotElementIndex(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getElementIndex(instruction.getTarget()));
    }

    /**
     * Assert not element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getElementPositionLeft(instruction.getTarget()));
    }

    /**
     * Assert not element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotElementPositionTop(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getElementPositionTop(instruction.getTarget()));
    }

    /**
     * Assert not element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotElementWidth(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getElementWidth(instruction.getTarget()));
    }

    /**
     * Assert not eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotEval(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getEval(instruction.getTarget()));
    }

    /**
     * Assert not expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotExpression(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getExpression(instruction.getTarget()));
    }

    /**
     * Assert not html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotHtmlSource(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getHtmlSource());
    }

    /**
     * Assert not location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotLocation(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getLocation());
    }

    /**
     * Assert not mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotMouseSpeed(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getMouseSpeed());
    }

    /**
     * Assert not ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotOrdered(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isOrdered(instruction.getTarget(), instruction.getValue()));
    }

    /**
     * Assert not prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotPrompt(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getPrompt());
    }

    /**
     * Assert not select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectOptions(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getSelectOptions(instruction.getTarget()), ','));
    }

    /**
     * Assert not selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedId(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getSelectedId(instruction.getTarget()));
    }

    /**
     * Assert not selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedIds(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getSelectedIds(instruction.getTarget()), ','));
    }

    /**
     * Assert not selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedIndex(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getSelectedIndex(instruction.getTarget()));
    }

    /**
     * Assert not selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedIndexes(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getSelectedIndexes(instruction.getTarget()), ','));
    }

    /**
     * Assert not selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedLabel(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getSelectedLabel(instruction.getTarget()));
    }

    /**
     * Assert not selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedLabels(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getSelectedLabels(instruction.getTarget()), ','));
    }

    /**
     * Assert not selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedValue(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getSelectedValue(instruction.getTarget()));
    }

    /**
     * Assert not selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSelectedValues(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), join(selenium.getSelectedValues(instruction.getTarget()), ','));
    }

    /**
     * Assert not something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSomethingSelected(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isSomethingSelected(instruction.getTarget()));
    }

    /**
     * Assert not speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotSpeed(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getSpeed());
    }

    /**
     * Assert not table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotTable(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getTable(instruction.getTarget()));
    }

    /**
     * Assert not text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotText(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getText(instruction.getTarget()));
    }

    /**
     * Assert not title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotTitle(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getTarget(), selenium.getTitle());
    }

    /**
     * Assert not value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotValue(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getValue(instruction.getTarget()));
    }

    /**
     * Assert not visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotVisible(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isVisible(instruction.getTarget()));
    }

    /**
     * Assert not xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotXpathCount(Instruction instruction) throws SeleniumRunnerException {
        assertNotEquals(instruction.getValue(), selenium.getXpathCount(instruction.getTarget()));
    }

    /**
     * Assert ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertOrdered(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isOrdered(instruction.getTarget(), instruction.getValue()));
    }

    /**
     * Assert prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertPrompt(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getPrompt());
    }

    /**
     * Assert prompt not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertPromptNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isPromptPresent());
    }

    /**
     * Assert prompt present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertPromptPresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isPromptPresent());
    }

    /**
     * Assert select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectOptions(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getSelectOptions(instruction.getTarget()), ','));
    }

    /**
     * Assert selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedId(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getSelectedId(instruction.getTarget()));
    }

    /**
     * Assert selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedIds(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getSelectedIds(instruction.getTarget()), ','));
    }

    /**
     * Assert selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedIndex(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getSelectedIndex(instruction.getTarget()));
    }

    /**
     * Assert selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedIndexes(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getSelectedIndexes(instruction.getTarget()), ','));
    }

    /**
     * Assert selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedLabel(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getSelectedLabel(instruction.getTarget()));
    }

    /**
     * Assert selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedLabels(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getSelectedLabels(instruction.getTarget()), ','));
    }

    /**
     * Assert selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedValue(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getSelectedValue(instruction.getTarget()));
    }

    /**
     * Assert selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSelectedValues(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), join(selenium.getSelectedValues(instruction.getTarget()), ','));
    }

    /**
     * Assert something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSomethingSelected(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isSomethingSelected(instruction.getTarget()));
    }

    /**
     * Assert speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertSpeed(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getSpeed());
    }

    /**
     * Assert table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertTable(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getTable(instruction.getTarget()));
    }

    /**
     * Assert text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertText(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getText(instruction.getTarget()));
    }

    /**
     * Assert text not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertTextNotPresent(Instruction instruction) throws SeleniumRunnerException {
        assertFalse(selenium.isTextPresent(instruction.getTarget()));
    }

    /**
     * Assert text present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertTextPresent(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isTextPresent(instruction.getTarget()));
    }

    /**
     * Assert title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertTitle(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getTarget(), selenium.getTitle());
    }

    /**
     * Assert value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertValue(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getValue(instruction.getTarget()));
    }

    /**
     * Assert visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertVisible(Instruction instruction) throws SeleniumRunnerException {
        assertTrue(selenium.isVisible(instruction.getTarget()));
    }

    /**
     * Assert xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertXpathCount(Instruction instruction) throws SeleniumRunnerException {
        assertEquals(instruction.getValue(), selenium.getXpathCount(instruction.getTarget()));
    }

    /**
     * Assign id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assignId(Instruction instruction) throws SeleniumRunnerException {
        selenium.assignId(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Assign id and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assignIdAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.assignId(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Capture entire page screenshot.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void captureEntirePageScreenshot(Instruction instruction) throws SeleniumRunnerException {
        final String path = OperatingSystemUtils.getInstance().getSpecificPath(instruction.getTarget(),
                parameters.isWindows(), parameters.getDriverMapping());
        String instructionValule = "";

        if (instruction.getValue() != null) {
            instructionValule = instruction.getValue();
        }

        selenium.captureEntirePageScreenshot(path, instructionValule);
    }

    /**
     * Capture entire page screenshot and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void captureEntirePageScreenshotAndWait(Instruction instruction) throws SeleniumRunnerException {
        captureEntirePageScreenshot(instruction);
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Check.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void check(Instruction instruction) throws SeleniumRunnerException {
        selenium.check(instruction.getTarget());
    }

    /**
     * Check and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void checkAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.check(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Choose cancel on next confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void chooseCancelOnNextConfirmation(Instruction instruction) throws SeleniumRunnerException {
        selenium.chooseCancelOnNextConfirmation();
    }

    /**
     * Choose ok on next confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void chooseOkOnNextConfirmation(Instruction instruction) throws SeleniumRunnerException {
        selenium.chooseOkOnNextConfirmation();
    }

    /**
     * Choose ok on next confirmation and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void chooseOkOnNextConfirmationAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.chooseOkOnNextConfirmation();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Click.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void click(Instruction instruction) throws SeleniumRunnerException {
        selenium.click(instruction.getTarget());
    }

    /**
     * Click and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void clickAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.click(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Click at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void clickAt(Instruction instruction) throws SeleniumRunnerException {
        selenium.clickAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Click at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void clickAtAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.clickAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Close.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void close(Instruction instruction) throws SeleniumRunnerException {
        selenium.close();
    }

    /**
     * Context menu.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void contextMenu(Instruction instruction) throws SeleniumRunnerException {
        selenium.contextMenu(instruction.getTarget());
    }

    /**
     * Context menu and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void contextMenuAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.contextMenu(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Context menu at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void contextMenuAt(Instruction instruction) throws SeleniumRunnerException {
        selenium.contextMenuAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Context menu at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void contextMenuAtAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.contextMenuAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Control key down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void controlKeyDown(Instruction instruction) throws SeleniumRunnerException {
        selenium.controlKeyDown();
    }

    /**
     * Control key down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void controlKeyDownAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.controlKeyDown();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Control key up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void controlKeyUp(Instruction instruction) throws SeleniumRunnerException {
        selenium.controlKeyUp();
    }

    /**
     * Control key up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void controlKeyUpAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.controlKeyUp();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Creates the cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void createCookie(Instruction instruction) throws SeleniumRunnerException {
        selenium.createCookie(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Creates the cookie and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void createCookieAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.createCookie(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Delete all visible cookies.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deleteAllVisibleCookies(Instruction instruction) throws SeleniumRunnerException {
        selenium.deleteAllVisibleCookies();
    }

    /**
     * Delete all visible cookies and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deleteAllVisibleCookiesAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.deleteAllVisibleCookies();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Delete cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deleteCookie(Instruction instruction) throws SeleniumRunnerException {

        selenium.deleteCookie(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Delete cookie and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deleteCookieAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.deleteCookie(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Deselect pop up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deselectPopUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.deselectPopUp();
    }

    /**
     * Deselect pop up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void deselectPopUpAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.deselectPopUp();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Double click.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void doubleClick(Instruction instruction) throws SeleniumRunnerException {
        selenium.doubleClick(instruction.getTarget());
    }

    /**
     * Double click and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void doubleClickAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.doubleClick(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Double click at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void doubleClickAt(Instruction instruction) throws SeleniumRunnerException {
        selenium.doubleClickAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Double click at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void doubleClickAtAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.doubleClickAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Drag and drop.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragAndDrop(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragAndDrop(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Drag and drop and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragAndDropAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragAndDrop(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Drag and drop to object.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragAndDropToObject(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragAndDropToObject(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Drag and drop to object and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragAndDropToObjectAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragAndDropToObject(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Dragdrop.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragdrop(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragdrop(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Dragdrop and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void dragdropAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.dragdrop(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Fire event.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void fireEvent(Instruction instruction) throws SeleniumRunnerException {

        selenium.fireEvent(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Fire event and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void fireEventAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.fireEvent(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Focus.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void focus(Instruction instruction) throws SeleniumRunnerException {

        selenium.focus(instruction.getTarget());
    }

    /**
     * Focus and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void focusAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.focus(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Go back.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void goBack(Instruction instruction) throws SeleniumRunnerException {

        selenium.goBack();
    }

    /**
     * Go back and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void goBackAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.goBack();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Highlight.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void highlight(Instruction instruction) throws SeleniumRunnerException {

        selenium.highlight(instruction.getTarget());
    }

    /**
     * Highlight and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void highlightAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.highlight(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Ignore attributes without value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void ignoreAttributesWithoutValue(Instruction instruction) throws SeleniumRunnerException {

        selenium.ignoreAttributesWithoutValue(instruction.getTarget());
    }

    /**
     * Ignore attributes without value and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void ignoreAttributesWithoutValueAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.ignoreAttributesWithoutValue(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Key down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyDown(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyDown(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Key down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyDownAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyDown(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Key press.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyPress(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyPress(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Key press and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyPressAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyPress(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Key up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyUp(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Key up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void keyUpAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.keyUp(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Meta key down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void metaKeyDown(Instruction instruction) throws SeleniumRunnerException {

        selenium.metaKeyDown();
    }

    /**
     * Meta key down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void metaKeyDownAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.metaKeyDown();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Meta key up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void metaKeyUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.metaKeyUp();
    }

    /**
     * Meta key up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void metaKeyUpAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.metaKeyUp();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDown(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDown(instruction.getTarget());
    }

    /**
     * Mouse down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDown(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse down at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownAt(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Mouse down at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownAtAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse down right.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownRight(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownRight(instruction.getTarget());
    }

    /**
     * Mouse down right and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownRightAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownRight(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse down right at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownRightAt(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownRightAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Mouse down right at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseDownRightAtAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseDownRightAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse move.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseMove(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseMove(instruction.getTarget());
    }

    /**
     * Mouse move and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseMoveAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseMove(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse move at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseMoveAt(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseMoveAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Mouse move at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseMoveAtAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseMoveAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse out.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseOut(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseOut(instruction.getTarget());
    }

    /**
     * Mouse out and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseOutAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseOut(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse over.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseOver(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseOver(instruction.getTarget());
    }

    /**
     * Mouse over and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseOverAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseOver(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUp(instruction.getTarget());
    }

    /**
     * Mouse up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUp(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse up at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpAt(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Mouse up at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpAtAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse up right.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpRight(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpRight(instruction.getTarget());
    }

    /**
     * Mouse up right and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpRightAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpRight(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Mouse up right at.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpRightAt(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpRightAt(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Mouse up right at and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void mouseUpRightAtAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.mouseUpRightAt(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Open.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void open(Instruction instruction) throws SeleniumRunnerException {

        selenium.open(instruction.getTarget());
    }

    /**
     * Open window.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void openWindow(Instruction instruction) throws SeleniumRunnerException {

        selenium.openWindow(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Open window and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void openWindowAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.openWindow(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Pause.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void pause(Instruction instruction) throws SeleniumRunnerException {
        try {
            Thread.sleep(Integer.parseInt(instruction.getTarget()));
        } catch (NumberFormatException e) {
            throw new SeleniumRunnerException("number format exception !", e);
        } catch (InterruptedException e) {
            throw new SeleniumRunnerException("thread interrupted exception !", e);
        }
    }

    /**
     * Refresh.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void refresh(Instruction instruction) throws SeleniumRunnerException {

        selenium.refresh();
    }

    /**
     * Refresh and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void refreshAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.refresh();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Removes the all selections.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeAllSelections(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeAllSelections(instruction.getTarget());

    }

    /**
     * Removes the all selections and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeAllSelectionsAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeAllSelections(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Removes the script.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeScript(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeScript(instruction.getTarget());
    }

    /**
     * Removes the script and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeScriptAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeScript(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Removes the selection.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeSelection(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeSelection(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Removes the selection and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void removeSelectionAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.removeSelection(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Rollup.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void rollup(Instruction instruction) throws SeleniumRunnerException {

        selenium.rollup(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Rollup and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void rollupAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.rollup(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Run script.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void runScript(Instruction instruction) throws SeleniumRunnerException {

        selenium.runScript(instruction.getTarget());
    }

    /**
     * Run script and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void runScriptAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.runScript(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Select.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void select(Instruction instruction) throws SeleniumRunnerException {

        selenium.select(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Select and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void selectAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.select(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Select frame.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void selectFrame(Instruction instruction) throws SeleniumRunnerException {

        selenium.selectFrame(instruction.getTarget());
    }

    /**
     * Select pop up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void selectPopUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.selectPopUp(instruction.getTarget());
    }

    /**
     * Select pop up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void selectPopUpAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.selectPopUp(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Select window.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void selectWindow(Instruction instruction) throws SeleniumRunnerException {

        selenium.selectWindow(instruction.getTarget());
    }

    /**
     * Sets the browser log level.
     *
     * @param instruction the new browser log level
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setBrowserLogLevel(Instruction instruction) throws SeleniumRunnerException {

        selenium.setBrowserLogLevel(instruction.getTarget());
    }

    /**
     * Sets the browser log level and wait.
     *
     * @param instruction the new browser log level and wait
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setBrowserLogLevelAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.setBrowserLogLevel(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Sets the cursor position.
     *
     * @param instruction the new cursor position
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setCursorPosition(Instruction instruction) throws SeleniumRunnerException {

        selenium.setCursorPosition(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Sets the cursor position and wait.
     *
     * @param instruction the new cursor position and wait
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setCursorPositionAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.setCursorPosition(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Sets the mouse speed.
     *
     * @param instruction the new mouse speed
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setMouseSpeed(Instruction instruction) throws SeleniumRunnerException {

        selenium.setMouseSpeed(instruction.getTarget());
    }

    /**
     * Sets the mouse speed and wait.
     *
     * @param instruction the new mouse speed and wait
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setMouseSpeedAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.setMouseSpeed(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Sets the speed.
     *
     * @param instruction the new speed
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setSpeed(Instruction instruction) throws SeleniumRunnerException {

        selenium.setSpeed(instruction.getTarget());
    }

    /**
     * Sets the speed and wait.
     *
     * @param instruction the new speed and wait
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setSpeedAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.setSpeed(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Sets the timeout.
     *
     * @param instruction the new timeout
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void setTimeout(Instruction instruction) throws SeleniumRunnerException {

        selenium.setTimeout(instruction.getTarget());
    }

    /**
     * Shift key down.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void shiftKeyDown(Instruction instruction) throws SeleniumRunnerException {

        selenium.shiftKeyDown();
    }

    /**
     * Shift key down and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void shiftKeyDownAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.shiftKeyDown();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Shift key up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void shiftKeyUp(Instruction instruction) throws SeleniumRunnerException {

        selenium.shiftKeyUp();
    }

    /**
     * Shift key up and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void shiftKeyUpAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.shiftKeyUp();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    public void submit(Instruction instruction) throws SeleniumRunnerException {

        selenium.submit(instruction.getTarget());
    }

    /**
     * Submit and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void submitAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.submit(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Type.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void type(Instruction instruction) throws SeleniumRunnerException {

        selenium.type(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Type and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void typeAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.type(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Type keys.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void typeKeys(Instruction instruction) throws SeleniumRunnerException {

        selenium.typeKeys(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Type keys and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void typeKeysAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.typeKeys(instruction.getTarget(), instruction.getValue());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Uncheck.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void uncheck(Instruction instruction) throws SeleniumRunnerException {

        selenium.uncheck(instruction.getTarget());
    }

    /**
     * Uncheck and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void uncheckAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.uncheck(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Use xpath library.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void useXpathLibrary(Instruction instruction) throws SeleniumRunnerException {

        selenium.useXpathLibrary(instruction.getTarget());
    }

    /**
     * Use xpath library and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void useXpathLibraryAndWait(Instruction instruction) throws SeleniumRunnerException {

        selenium.useXpathLibrary(instruction.getTarget());
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Verify alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAlert(Instruction instruction) throws SeleniumRunnerException {
        verifyEquals(instruction.getTarget(), selenium.getAlert());
    }

    /**
     * Verify alert not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAlertNotPresent(Instruction instruction) throws SeleniumRunnerException {
        verifyFalse(selenium.isAlertPresent());
    }

    /**
     * Verify alert present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAlertPresent(Instruction instruction) throws SeleniumRunnerException {
        verifyTrue(selenium.isAlertPresent());
    }

    /**
     * Verify all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllButtons(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllButtons(), ','));
    }

    /**
     * Verify all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllFields(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllFields(), ','));
    }

    /**
     * Verify all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllLinks(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllLinks(), ','));
    }

    /**
     * Verify all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllWindowIds(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllWindowIds(), ','));
    }

    /**
     * Verify all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllWindowNames(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllWindowNames(), ','));
    }

    /**
     * Verify all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), join(selenium.getAllWindowTitles(), ','));
    }

    /**
     * Verify attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAttribute(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getAttribute(instruction.getTarget()));
    }

    /**
     * Verify attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','));
    }

    /**
     * Verify body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyBodyText(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getBodyText());
    }

    /**
     * Verify checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyChecked(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isChecked(instruction.getTarget()));
    }

    /**
     * Verify confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyConfirmation(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getConfirmation());
    }

    /**
     * Verify confirmation not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyConfirmationNotPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isConfirmationPresent());
    }

    /**
     * Verify confirmation present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyConfirmationPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isConfirmationPresent());
    }

    /**
     * Verify cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCookie(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getCookie());
    }

    /**
     * Verify cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCookieByName(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getCookieByName(instruction.getTarget()));
    }

    /**
     * Verify cookie not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCookieNotPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isCookiePresent(instruction.getTarget()));
    }

    /**
     * Verify cookie present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCookiePresent(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isCookiePresent(instruction.getTarget()));
    }

    /**
     * Verify css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCssCount(Instruction instruction) throws SeleniumRunnerException {
        verifyEquals(instruction.getValue(), selenium.getCssCount(instruction.getTarget()));
    }

    /**
     * Verify cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyCursorPosition(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getCursorPosition(instruction.getTarget()));
    }

    /**
     * Verify editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyEditable(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isEditable(instruction.getTarget()));
    }

    /**
     * Verify element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementHeight(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getElementHeight(instruction.getTarget()));
    }

    /**
     * Verify element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementIndex(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getElementIndex(instruction.getTarget()));
    }

    /**
     * Verify element not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementNotPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isElementPresent(instruction.getTarget()));
    }

    /**
     * Verify element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getElementPositionLeft(instruction.getTarget()));
    }

    /**
     * Verify element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementPositionTop(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getElementPositionTop(instruction.getTarget()));
    }

    /**
     * Verify element present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isElementPresent(instruction.getTarget()));
    }

    /**
     * Verify element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyElementWidth(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getElementWidth(instruction.getTarget()));
    }

    /**
     * Verify eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyEval(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getEval(instruction.getTarget()));
    }

    /**
     * Verify expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyExpression(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getExpression(instruction.getTarget()));
    }

    /**
     * Verify html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyHtmlSource(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getHtmlSource());
    }

    /**
     * Verify location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyLocation(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getLocation());
    }

    /**
     * Verify mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyMouseSpeed(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getMouseSpeed());
    }

    /**
     * Verify not alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAlert(Instruction instruction) throws SeleniumRunnerException {
        verifyNotEquals(instruction.getTarget(), selenium.getAlert());
    }

    /**
     * Verify not all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllButtons(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllButtons(), ','));
    }

    /**
     * Verify not all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllFields(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllFields(), ','));
    }

    /**
     * Verify not all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllLinks(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllLinks(), ','));
    }

    /**
     * Verify not all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllWindowIds(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllWindowIds(), ','));
    }

    /**
     * Verify not all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllWindowNames(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllWindowNames(), ','));
    }

    /**
     * Verify not all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), join(selenium.getAllWindowTitles(), ','));
    }

    /**
     * Verify not attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAttribute(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getAttribute(instruction.getTarget()));
    }

    /**
     * Verify not attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','));
    }

    /**
     * Verify not body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotBodyText(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getBodyText());
    }

    /**
     * Verify not checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotChecked(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isChecked(instruction.getTarget()));
    }

    /**
     * Verify not confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotConfirmation(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getConfirmation());
    }

    /**
     * Verify not cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotCookie(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getCookie());
    }

    /**
     * Verify not cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotCookieByName(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getCookieByName(instruction.getTarget()));
    }

    /**
     * Verify not css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotCssCount(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getCssCount(instruction.getTarget()));
    }

    /**
     * Verify not cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotCursorPosition(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getCursorPosition(instruction.getTarget()));
    }

    /**
     * Verify not editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotEditable(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isEditable(instruction.getTarget()));
    }

    /**
     * Verify not element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotElementHeight(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getElementHeight(instruction.getTarget()));
    }

    /**
     * Verify not element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotElementIndex(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getElementIndex(instruction.getTarget()));
    }

    /**
     * Verify not element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getElementPositionLeft(instruction.getTarget()));
    }

    /**
     * Verify not element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotElementPositionTop(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getElementPositionTop(instruction.getTarget()));
    }

    /**
     * Verify not element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotElementWidth(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getElementWidth(instruction.getTarget()));
    }

    /**
     * Verify not eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotEval(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getEval(instruction.getTarget()));
    }

    /**
     * Verify not expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotExpression(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getExpression(instruction.getTarget()));
    }

    /**
     * Verify not html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotHtmlSource(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getHtmlSource());
    }

    /**
     * Verify not location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotLocation(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getLocation());
    }

    /**
     * Verify not mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotMouseSpeed(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getMouseSpeed());
    }

    /**
     * Verify not ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotOrdered(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isOrdered(instruction.getTarget(), instruction.getValue()));
    }

    /**
     * Verify not prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotPrompt(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getPrompt());
    }

    /**
     * Verify not select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectOptions(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getSelectOptions(instruction.getTarget()), ','));
    }

    /**
     * Verify not selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedId(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getSelectedId(instruction.getTarget()));
    }

    /**
     * Verify not selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedIds(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getSelectedIds(instruction.getTarget()), ','));
    }

    /**
     * Verify not selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedIndex(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getSelectedIndex(instruction.getTarget()));
    }

    /**
     * Verify not selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedIndexes(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getSelectedIndexes(instruction.getTarget()), ','));
    }

    /**
     * Verify not selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedLabel(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getSelectedLabel(instruction.getTarget()));
    }

    /**
     * Verify not selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedLabels(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getSelectedLabels(instruction.getTarget()), ','));
    }

    /**
     * Verify not selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedValue(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getSelectedValue(instruction.getTarget()));
    }

    /**
     * Verify not selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSelectedValues(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), join(selenium.getSelectedValues(instruction.getTarget()), ','));
    }

    /**
     * Verify not something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSomethingSelected(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isSomethingSelected(instruction.getTarget()));
    }

    /**
     * Verify not speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotSpeed(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getSpeed());
    }

    /**
     * Verify not table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotTable(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getTable(instruction.getTarget()));
    }

    /**
     * Verify not text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotText(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getText(instruction.getTarget()));
    }

    /**
     * Verify not title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotTitle(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getTarget(), selenium.getTitle());
    }

    /**
     * Verify not value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotValue(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getValue(instruction.getTarget()));
    }

    /**
     * Verify not visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotVisible(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isVisible(instruction.getTarget()));
    }

    /**
     * Verify not whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Verify not whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotWhetherThisWindowMatchWindowExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Verify not xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyNotXpathCount(Instruction instruction) throws SeleniumRunnerException {

        verifyNotEquals(instruction.getValue(), selenium.getXpathCount(instruction.getTarget()));
    }

    /**
     * Verify ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyOrdered(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isOrdered(instruction.getTarget(), instruction.getValue()));
    }

    /**
     * Verify prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyPrompt(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getPrompt());
    }

    /**
     * Verify prompt not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyPromptNotPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isPromptPresent());
    }

    /**
     * Verify prompt present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyPromptPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isPromptPresent());
    }

    /**
     * Verify select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectOptions(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getSelectOptions(instruction.getTarget()), ','));
    }

    /**
     * Verify selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedId(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getSelectedId(instruction.getTarget()));
    }

    /**
     * Verify selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedIds(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getSelectedIds(instruction.getTarget()), ','));
    }

    /**
     * Verify selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedIndex(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getSelectedIndex(instruction.getTarget()));
    }

    /**
     * Verify selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedIndexes(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getSelectedIndexes(instruction.getTarget()), ','));
    }

    /**
     * Verify selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedLabel(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getSelectedLabel(instruction.getTarget()));
    }

    /**
     * Verify selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedLabels(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getSelectedLabels(instruction.getTarget()), ','));
    }

    /**
     * Verify selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedValue(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getSelectedValue(instruction.getTarget()));
    }

    /**
     * Verify selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySelectedValues(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), join(selenium.getSelectedValues(instruction.getTarget()), ','));
    }

    /**
     * Verify something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySomethingSelected(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isSomethingSelected(instruction.getTarget()));
    }

    /**
     * Verify speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifySpeed(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getSpeed());
    }

    /**
     * Verify table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyTable(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getTable(instruction.getTarget()));
    }

    /**
     * Verify text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyText(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getText(instruction.getTarget()));
    }

    /**
     * Verify text not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyTextNotPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyFalse(selenium.isTextPresent(instruction.getTarget()));
    }

    /**
     * Verify text present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyTextPresent(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isTextPresent(instruction.getTarget()));
    }

    /**
     * Verify title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyTitle(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getTarget(), selenium.getTitle());
    }

    /**
     * Verify value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyValue(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getValue(instruction.getTarget()));
    }

    /**
     * Verify visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyVisible(Instruction instruction) throws SeleniumRunnerException {

        verifyTrue(selenium.isVisible(instruction.getTarget()));
    }

    /**
     * Verify whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Verify whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyWhetherThisWindowMatchWindowExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Verify xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void verifyXpathCount(Instruction instruction) throws SeleniumRunnerException {

        verifyEquals(instruction.getValue(), selenium.getXpathCount(instruction.getTarget()));
    }

    // w

    /**
     * Wait for alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAlert(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getAlert())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for alert not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAlertNotPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (!selenium.isAlertPresent()) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for alert present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAlertPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isAlertPresent()) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllButtons(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllButtons(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllFields(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllFields(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllLinks(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllLinks(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllWindowIds(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllWindowIds(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllWindowNames(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllWindowNames(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(join(selenium.getAllWindowTitles(), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAttribute(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getAttribute(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForBodyText(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getBodyText())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForChecked(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isChecked(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for condition.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCondition(Instruction instruction) throws SeleniumRunnerException {

        selenium.waitForCondition(instruction.getTarget(), instruction.getValue());

    }

    /**
     * Wait for confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForConfirmation(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getConfirmation())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for confirmation not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForConfirmationNotPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (!selenium.isConfirmationPresent()) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for confirmation present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForConfirmationPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isConfirmationPresent()) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCookie(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getCookie())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCookieByName(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getCookieByName(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for cookie not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCookieNotPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (!selenium.isCookiePresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for cookie present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCookiePresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isCookiePresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCssCount(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getCssCount(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForCursorPosition(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getCursorPosition(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForEditable(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isEditable(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementHeight(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getElementHeight(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementIndex(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getElementIndex(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementNotPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (!selenium.isElementPresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getElementPositionLeft(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementPositionTop(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getElementPositionTop(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementPresent(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isElementPresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForElementWidth(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getElementWidth(instruction.getTarget()))) {
                break;
            }

            sleep();
        }

    }

    /**
     * Wait for expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForExpression(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getExpression(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForEval(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getEval(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for frame to load.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForFrameToLoad(Instruction instruction) throws SeleniumRunnerException {

        selenium.waitForFrameToLoad(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Wait for html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForHtmlSource(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getHtmlSource())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForLocation(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getLocation())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForMouseSpeed(Instruction instruction) throws SeleniumRunnerException {

        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getMouseSpeed())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for not alert.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAlert(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (!instruction.getTarget().equals(selenium.getAlert())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not all buttons.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllButtons(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllButtons(), ','))));
    }

    /**
     * Wait for not all fields.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllFields(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllFields(), ','))));
    }

    /**
     * Wait for not all links.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllLinks(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllLinks(), ','))));
    }

    /**
     * Wait for not all window ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllWindowIds(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllWindowIds(), ','))));
    }

    /**
     * Wait for not all window names.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllWindowNames(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllWindowNames(), ','))));
    }

    /**
     * Wait for not all window titles.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAllWindowTitles(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(join(selenium.getAllWindowTitles(), ','))));
    }

    /**
     * Wait for not attribute.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAttribute(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getAttribute(instruction.getTarget()))));
    }

    /**
     * Wait for not attribute from all windows.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotAttributeFromAllWindows(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(
                join(selenium.getAttributeFromAllWindows(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not body text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotBodyText(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getBodyText())));
    }

    /**
     * Wait for not checked.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotChecked(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!selenium.isChecked(instruction.getTarget())));
    }

    /**
     * Wait for not confirmation.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotConfirmation(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getConfirmation())));
    }

    /**
     * Wait for not cookie.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotCookie(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getCookie())));
    }

    /**
     * Wait for not cookie by name.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotCookieByName(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getCookieByName(instruction.getTarget()))));
    }

    /**
     * Wait for not css count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotCssCount(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getCssCount(instruction.getTarget()))));
    }

    /**
     * Wait for not cursor position.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotCursorPosition(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getCursorPosition(instruction.getTarget()))));
    }

    /**
     * Wait for not editable.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotEditable(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!selenium.isEditable(instruction.getTarget())));
    }

    /**
     * Wait for not element height.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotElementHeight(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getElementHeight(instruction.getTarget()))));
    }

    /**
     * Wait for not element index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotElementIndex(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getElementIndex(instruction.getTarget()))));
    }

    /**
     * Wait for not element position left.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotElementPositionLeft(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getElementPositionLeft(instruction.getTarget()))));
    }

    /**
     * Wait for not element position top.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotElementPositionTop(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getElementPositionTop(instruction.getTarget()))));
    }

    /**
     * Wait for not element width.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotElementWidth(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getElementWidth(instruction.getTarget()))));
    }

    /**
     * Wait for not eval.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotEval(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getEval(instruction.getTarget()))));
    }

    /**
     * Wait for not expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotExpression(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getExpression(instruction.getTarget()))));
    }

    /**
     * Wait for not html source.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotHtmlSource(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getHtmlSource())));
    }

    /**
     * Wait for not location.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotLocation(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getLocation())));
    }

    /**
     * Wait for not mouse speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotMouseSpeed(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getMouseSpeed())));
    }

    /**
     * Wait for not ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotOrdered(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!selenium.isOrdered(instruction.getTarget(), instruction.getValue())));
    }

    /**
     * Wait for not prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotPrompt(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getTarget().equals(selenium.getPrompt())));
    }

    /**
     * Wait for not select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectOptions(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(join(selenium.getSelectOptions(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedId(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getSelectedId(instruction.getTarget()))));
    }

    /**
     * Wait for not selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedIds(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(join(selenium.getSelectedIds(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedIndex(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getSelectedIndex(instruction.getTarget()))));
    }

    /**
     * Wait for not selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedIndexes(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(join(selenium.getSelectedIndexes(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedLabel(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getSelectedLabel(instruction.getTarget()))));
    }

    /**
     * Wait for not selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedLabels(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(join(selenium.getSelectedLabels(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedValue(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(selenium.getSelectedValue(instruction.getTarget()))));
    }

    /**
     * Wait for not selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSelectedValues(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!instruction.getValue().equals(join(selenium.getSelectedValues(instruction.getTarget()), ','))));
    }

    /**
     * Wait for not something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSomethingSelected(Instruction instruction) throws SeleniumRunnerException {
        waitingFor(() -> (!selenium.isSomethingSelected(instruction.getTarget())));
    }

    /**
     * Wait for not speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotSpeed(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (!instruction.getTarget().equals(selenium.getSpeed())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotTable(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!instruction.getValue().equals(selenium.getTable(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotText(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!instruction.getValue().equals(selenium.getText(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotTitle(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!instruction.getTarget().equals(selenium.getTitle())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotValue(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!instruction.getValue().equals(selenium.getValue(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotVisible(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (!selenium.isVisible(instruction.getTarget())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for not xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotXpathCount(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!instruction.getValue().equals(selenium.getXpathCount(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for ordered.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForOrdered(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isOrdered(instruction.getTarget(), instruction.getValue())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for page to load.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForPageToLoad(Instruction instruction) throws SeleniumRunnerException {
        selenium.waitForPageToLoad(instruction.getTarget());
    }

    /**
     * Wait for pop up.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForPopUp(Instruction instruction) throws SeleniumRunnerException {
        selenium.waitForPopUp(instruction.getTarget(), instruction.getValue());
    }

    /**
     * Wait for prompt.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForPrompt(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getPrompt())) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for prompt not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForPromptNotPresent(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (!selenium.isPromptPresent()) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for prompt present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForPromptPresent(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (selenium.isPromptPresent()) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for select options.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectOptions(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (instruction.getValue().equals(join(selenium.getSelectOptions(instruction.getTarget()), ','))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected id.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedId(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (instruction.getValue().equals(selenium.getSelectedId(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected ids.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedIds(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(join(selenium.getSelectedIds(instruction.getTarget()), ','))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected index.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedIndex(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getSelectedIndex(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected indexes.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedIndexes(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(join(selenium.getSelectedIndexes(instruction.getTarget()), ','))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected label.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedLabel(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getSelectedLabel(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected labels.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedLabels(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(join(selenium.getSelectedLabels(instruction.getTarget()), ','))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedValue(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getSelectedValue(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Wait for selected values.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSelectedValues(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(join(selenium.getSelectedValues(instruction.getTarget()), ','))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for something selected.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSomethingSelected(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isSomethingSelected(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for speed.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForSpeed(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getSpeed())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for table.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForTable(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getTable(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for text.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForText(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getText(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for text not present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForTextNotPresent(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (!selenium.isTextPresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for text present.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForTextPresent(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isTextPresent(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for title.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForTitle(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getTarget().equals(selenium.getTitle())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for value.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForValue(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (instruction.getValue().equals(selenium.getValue(instruction.getTarget()))) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for visible.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForVisible(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);

            if (selenium.isVisible(instruction.getTarget())) {
                break;
            }

            sleep();
        }
    }

    /**
     * Wait for xpath count.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForXpathCount(Instruction instruction) throws SeleniumRunnerException {
        for (int second = 0;; second++) {
            isTimeout(second);
            if (instruction.getValue().equals(selenium.getXpathCount(instruction.getTarget()))) {
                break;
            }
            sleep();
        }
    }

    /**
     * Window focus.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void windowFocus(Instruction instruction) throws SeleniumRunnerException {
        selenium.windowFocus();
    }

    /**
     * Window focus and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void windowFocusAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.windowFocus();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Window maximize.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void windowMaximize(Instruction instruction) throws SeleniumRunnerException {
        selenium.windowMaximize();
    }

    /**
     * Window maximize and wait.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void windowMaximizeAndWait(Instruction instruction) throws SeleniumRunnerException {
        selenium.windowMaximize();
        selenium.waitForPageToLoad(TIMEOUT);
    }

    /**
     * Wait for whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {
    }

    /**
     * Wait for whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForWhetherThisWindowMatchWindowExpression(Instruction instruction) throws SeleniumRunnerException {
    }

    /**
     * Assert not whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Assert not whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertNotWhetherThisWindowMatchWindowExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Assert whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Assert whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void assertWhetherThisWindowMatchWindowExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Echo.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void echo(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Wait for not whether this frame match frame expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotWhetherThisFrameMatchFrameExpression(Instruction instruction) throws SeleniumRunnerException {

    }

    /**
     * Wait for not whether this window match window expression.
     *
     * @param instruction the instruction
     * @throws SeleniumRunnerException the selenium runner exception
     */
    public void waitForNotWhetherThisWindowMatchWindowExpression(Instruction instruction)
            throws SeleniumRunnerException {
    }

}
