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

/**
 * SeleniumActionType
 * 
 * @author pguillerm
 * @since 16 févr. 2015
 */
public enum SeleniumActionType {
    //@formatter:off
     storeEval,
     addLocationStrategy,
     addLocationStrategyAndWait,
     addScript,
     addScriptAndWait,
     addSelection,
     addSelectionAndWait,
     allowNativeXpath,
     allowNativeXpathAndWait,
     altKeyDown,
     altKeyDownAndWait,
     altKeyUp,
     altKeyUpAndWait,
     answerOnNextPrompt,
     assertAlert,
     assertAlertNotPresent,
     assertAlertPresent,
     assertAllButtons,
     assertAllFields,
     assertAllLinks,
     assertAllWindowIds,
     assertAllWindowNames,
     assertAllWindowTitles,
     assertAttribute,
     assertAttributeFromAllWindows,
     assertBodyText,
     assertChecked,
     assertConfirmation,
     assertConfirmationNotPresent,
     assertConfirmationPresent,
     assertCookie,
     assertCookieByName,
     assertCookieNotPresent,
     assertCookiePresent,
     assertCssCount,
     assertCursorPosition,
     assertEditable,
     assertElementHeight,
     assertElementIndex,
     assertElementNotPresent,
     assertElementPositionLeft,
     assertElementPositionTop,
     assertElementPresent,
     assertElementWidth,
     assertEval,
     assertExpression,
     assertHtmlSource,
     assertLocation,
     assertMouseSpeed,
     assertNotAlert,
     assertNotAllButtons,
     assertNotAllFields,
     assertNotAllLinks,
     assertNotAllWindowIds,
     assertNotAllWindowNames,
     assertNotAllWindowTitles,
     assertNotAttribute,
     assertNotAttributeFromAllWindows,
     assertNotBodyText,
     assertNotChecked,
     assertNotConfirmation,
     assertNotCookie,
     assertNotCookieByName,
     assertNotCssCount,
     assertNotCursorPosition,
     assertNotEditable,
     assertNotElementHeight,
     assertNotElementIndex,
     assertNotElementPositionLeft,
     assertNotElementPositionTop,
     assertNotElementWidth,
     assertNotEval,
     assertNotExpression,
     assertNotHtmlSource,
     assertNotLocation,
     assertNotMouseSpeed,
     assertNotOrdered,
     assertNotPrompt,
     assertNotSelectOptions,
     assertNotSelectedId,
     assertNotSelectedIds,
     assertNotSelectedIndex,
     assertNotSelectedIndexes,
     assertNotSelectedLabel,
     assertNotSelectedLabels,
     assertNotSelectedValue,
     assertNotSelectedValues,
     assertNotSomethingSelected,
     assertNotSpeed,
     assertNotTable,
     assertNotText,
     assertNotTitle,
     assertNotValue,
     assertNotVisible,
     assertNotWhetherThisFrameMatchFrameExpression,
     assertNotWhetherThisWindowMatchWindowExpression,
     assertNotXpathCount,
     assertOrdered,
     assertPrompt,
     assertPromptNotPresent,
     assertPromptPresent,
     assertSelectOptions,
     assertSelectedId,
     assertSelectedIds,
     assertSelectedIndex,
     assertSelectedIndexes,
     assertSelectedLabel,
     assertSelectedLabels,
     assertSelectedValue,
     assertSelectedValues,
     assertSomethingSelected,
     assertSpeed,
     assertTable,
     assertText,
     assertTextNotPresent,
     assertTextPresent,
     assertTitle,
     assertValue,
     assertVisible,
     assertWhetherThisFrameMatchFrameExpression,
     assertWhetherThisWindowMatchWindowExpression,
     assertXpathCount,
     assignId,
     assignIdAndWait,
     captureEntirePageScreenshot,
     captureEntirePageScreenshotAndWait,
     check,
     checkAndWait,
     chooseCancelOnNextConfirmation,
     chooseOkOnNextConfirmation,
     chooseOkOnNextConfirmationAndWait,
     click,
     clickAndWait,
     clickAt,
     clickAtAndWait,
     close,
     contextMenu,
     contextMenuAndWait,
     contextMenuAt,
     contextMenuAtAndWait,
     controlKeyDown,
     controlKeyDownAndWait,
     controlKeyUp,
     controlKeyUpAndWait,
     createCookie,
     createCookieAndWait,
     deleteAllVisibleCookies,
     deleteAllVisibleCookiesAndWait,
     deleteCookie,
     deleteCookieAndWait,
     deselectPopUp,
     deselectPopUpAndWait,
     doubleClick,
     doubleClickAndWait,
     doubleClickAt,
     doubleClickAtAndWait,
     dragAndDrop,
     dragAndDropAndWait,
     dragAndDropToObject,
     dragAndDropToObjectAndWait,
     dragdrop,
     dragdropAndWait,
     echo,
     fireEvent,
     fireEventAndWait,
     focus,
     focusAndWait,
     goBack,
     goBackAndWait,
     highlight,
     highlightAndWait,
     ignoreAttributesWithoutValue,
     ignoreAttributesWithoutValueAndWait,
     keyDown,
     keyDownAndWait,
     keyPress,
     keyPressAndWait,
     keyUp,
     keyUpAndWait,
     metaKeyDown,
     metaKeyDownAndWait,
     metaKeyUp,
     metaKeyUpAndWait,
     mouseDown,
     mouseDownAndWait,
     mouseDownAt,
     mouseDownAtAndWait,
     mouseDownRight,
     mouseDownRightAndWait,
     mouseDownRightAt,
     mouseDownRightAtAndWait,
     mouseMove,
     mouseMoveAndWait,
     mouseMoveAt,
     mouseMoveAtAndWait,
     mouseOut,
     mouseOutAndWait,
     mouseOver,
     mouseOverAndWait,
     mouseUp,
     mouseUpAndWait,
     mouseUpAt,
     mouseUpAtAndWait,
     mouseUpRight,
     mouseUpRightAndWait,
     mouseUpRightAt,
     mouseUpRightAtAndWait,
     open,
     openWindow,
     openWindowAndWait,
     pause,
     refresh,
     refreshAndWait,
     removeAllSelections,
     removeAllSelectionsAndWait,
     removeScript,
     removeScriptAndWait,
     removeSelection,
     removeSelectionAndWait,
     rollup,
     rollupAndWait,
     runScript,
     runScriptAndWait,
     select,
     selectAndWait,
     selectFrame,
     selectPopUp,
     selectPopUpAndWait,
     selectWindow,
     setBrowserLogLevel,
     setBrowserLogLevelAndWait,
     setCursorPosition,
     setCursorPositionAndWait,
     setMouseSpeed,
     setMouseSpeedAndWait,
     setSpeed,
     setSpeedAndWait,
     setTimeout,
     shiftKeyDown,
     shiftKeyDownAndWait,
     shiftKeyUp,
     shiftKeyUpAndWait,
     submit,
     submitAndWait,
     type,
     typeAndWait,
     typeKeys,
     typeKeysAndWait,
     uncheck,
     uncheckAndWait,
     useXpathLibrary,
     useXpathLibraryAndWait,
     verifyAlert,
     verifyAlertNotPresent,
     verifyAlertPresent,
     verifyAllButtons,
     verifyAllFields,
     verifyAllLinks,
     verifyAllWindowIds,
     verifyAllWindowNames,
     verifyAllWindowTitles,
     verifyAttribute,
     verifyAttributeFromAllWindows,
     verifyBodyText,
     verifyChecked,
     verifyConfirmation,
     verifyConfirmationNotPresent,
     verifyConfirmationPresent,
     verifyCookie,
     verifyCookieByName,
     verifyCookieNotPresent,
     verifyCookiePresent,
     verifyCssCount,
     verifyCursorPosition,
     verifyEditable,
     verifyElementHeight,
     verifyElementIndex,
     verifyElementNotPresent,
     verifyElementPositionLeft,
     verifyElementPositionTop,
     verifyElementPresent,
     verifyElementWidth,
     verifyEval,
     verifyExpression,
     verifyHtmlSource,
     verifyLocation,
     verifyMouseSpeed,
     verifyNotAlert,
     verifyNotAllButtons,
     verifyNotAllFields,
     verifyNotAllLinks,
     verifyNotAllWindowIds,
     verifyNotAllWindowNames,
     verifyNotAllWindowTitles,
     verifyNotAttribute,
     verifyNotAttributeFromAllWindows,
     verifyNotBodyText,
     verifyNotChecked,
     verifyNotConfirmation,
     verifyNotCookie,
     verifyNotCookieByName,
     verifyNotCssCount,
     verifyNotCursorPosition,
     verifyNotEditable,
     verifyNotElementHeight,
     verifyNotElementIndex,
     verifyNotElementPositionLeft,
     verifyNotElementPositionTop,
     verifyNotElementWidth,
     verifyNotEval,
     verifyNotExpression,
     verifyNotHtmlSource,
     verifyNotLocation,
     verifyNotMouseSpeed,
     verifyNotOrdered,
     verifyNotPrompt,
     verifyNotSelectOptions,
     verifyNotSelectedId,
     verifyNotSelectedIds,
     verifyNotSelectedIndex,
     verifyNotSelectedIndexes,
     verifyNotSelectedLabel,
     verifyNotSelectedLabels,
     verifyNotSelectedValue,
     verifyNotSelectedValues,
     verifyNotSomethingSelected,
     verifyNotSpeed,
     verifyNotTable,
     verifyNotText,
     verifyNotTitle,
     verifyNotValue,
     verifyNotVisible,
     verifyNotWhetherThisFrameMatchFrameExpression,
     verifyNotWhetherThisWindowMatchWindowExpression,
     verifyNotXpathCount,
     verifyOrdered,
     verifyPrompt,
     verifyPromptNotPresent,
     verifyPromptPresent,
     verifySelectOptions,
     verifySelectedId,
     verifySelectedIds,
     verifySelectedIndex,
     verifySelectedIndexes,
     verifySelectedLabel,
     verifySelectedLabels,
     verifySelectedValue,
     verifySelectedValues,
     verifySomethingSelected,
     verifySpeed,
     verifyTable,
     verifyText,
     verifyTextNotPresent,
     verifyTextPresent,
     verifyTitle,
     verifyValue,
     verifyVisible,
     verifyWhetherThisFrameMatchFrameExpression,
     verifyWhetherThisWindowMatchWindowExpression,
     verifyXpathCount,
     waitForAlert,
     waitForAlertNotPresent,
     waitForAlertPresent,
     waitForAllButtons,
     waitForAllFields,
     waitForAllLinks,
     waitForAllWindowIds,
     waitForAllWindowNames,
     waitForAllWindowTitles,
     waitForAttribute,
     waitForAttributeFromAllWindows,
     waitForBodyText,
     waitForChecked,
     waitForCondition,
     waitForConfirmation,
     waitForConfirmationNotPresent,
     waitForConfirmationPresent,
     waitForCookie,
     waitForCookieByName,
     waitForCookieNotPresent,
     waitForCookiePresent,
     waitForCssCount,
     waitForCursorPosition,
     waitForEditable,
     waitForElementHeight,
     waitForElementIndex,
     waitForElementNotPresent,
     waitForElementPositionLeft,
     waitForElementPositionTop,
     waitForElementPresent,
     waitForElementWidth,
     waitForExpression,
     waitForEval,
     waitForFrameToLoad,
     waitForHtmlSource,
     waitForLocation,
     waitForMouseSpeed,
     waitForNotAlert,
     waitForNotAllButtons,
     waitForNotAllFields,
     waitForNotAllLinks,
     waitForNotAllWindowIds,
     waitForNotAllWindowNames,
     waitForNotAllWindowTitles,
     waitForNotAttribute,
     waitForNotAttributeFromAllWindows,
     waitForNotBodyText,
     waitForNotChecked,
     waitForNotConfirmation,
     waitForNotCookie,
     waitForNotCookieByName,
     waitForNotCssCount,
     waitForNotCursorPosition,
     waitForNotEditable,
     waitForNotElementHeight,
     waitForNotElementIndex,
     waitForNotElementPositionLeft,
     waitForNotElementPositionTop,
     waitForNotElementWidth,
     waitForNotEval,
     waitForNotExpression,
     waitForNotHtmlSource,
     waitForNotLocation,
     waitForNotMouseSpeed,
     waitForNotOrdered,
     waitForNotPrompt,
     waitForNotSelectOptions,
     waitForNotSelectedId,
     waitForNotSelectedIds,
     waitForNotSelectedIndex,
     waitForNotSelectedIndexes,
     waitForNotSelectedLabel,
     waitForNotSelectedLabels,
     waitForNotSelectedValue,
     waitForNotSelectedValues,
     waitForNotSomethingSelected,
     waitForNotSpeed,
     waitForNotTable,
     waitForNotText,
     waitForNotTitle,
     waitForNotValue,
     waitForNotVisible,
     waitForNotWhetherThisFrameMatchFrameExpression,
     waitForNotWhetherThisWindowMatchWindowExpression,
     waitForNotXpathCount,
     waitForOrdered,
     waitForPageToLoad,
     waitForPopUp,
     waitForPrompt,
     waitForPromptNotPresent,
     waitForPromptPresent,
     waitForSelectOptions,
     waitForSelectedId,
     waitForSelectedIds,
     waitForSelectedIndex,
     waitForSelectedIndexes,
     waitForSelectedLabel,
     waitForSelectedLabels,
     waitForSelectedValue,
     waitForSelectedValues,
     waitForSomethingSelected,
     waitForSpeed,
     waitForTable,
     waitForText,
     waitForTextNotPresent,
     waitForTextPresent,
     waitForTitle,
     waitForValue,
     waitForVisible,
     waitForWhetherThisFrameMatchFrameExpression,
     waitForWhetherThisWindowMatchWindowExpression,
     waitForXpathCount,
     windowFocus,
     windowFocusAndWait,
     windowMaximize,
     windowMaximizeAndWait;
    //@formatter:on
    // =========================================================================
    // ENUM METHODS
    // =========================================================================
    private int hash = 0;

    private SeleniumActionType() {
        this.hash = name().hashCode();
    }

    /**
     * Gets the enum.
     *
     * @param name the name
     * @return the enum
     */
    public static SeleniumActionType getEnum(final String name) {
        SeleniumActionType res = null;
        if (name != null) {
            for (SeleniumActionType item : SeleniumActionType.values()) {
                if (item.name().equals(name)) {
                    res = item;
                    break;
                }
            }
        }
        return res;
    }

    public int getHash() {
        return hash;
    }

}
