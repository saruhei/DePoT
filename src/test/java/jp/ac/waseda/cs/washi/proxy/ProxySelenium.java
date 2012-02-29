package jp.ac.waseda.cs.washi.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import jp.ac.waseda.cs.washi.automake.AbstractPage;

import com.thoughtworks.selenium.Selenium;

public class ProxySelenium implements Selenium{
	
	private AbstractPage<?> page;
	private Selenium selenium;

	public ProxySelenium(AbstractPage<?> page,Selenium selenium){
		this.page = page;
		this.selenium = selenium;
	}

	@Override
	public void setExtensionJs(String extensionJs) {
		doInvariantAssert();
		selenium.setExtensionJs(extensionJs);
	}

	@Override
	public void start() {
		doInvariantAssert();
		selenium.start();
	}

	@Override
	public void start(String optionsString) {
		doInvariantAssert();
		selenium.start(optionsString);
	}

	@Override
	public void start(Object optionsObject) {
		doInvariantAssert();
		selenium.start(optionsObject);
	}

	@Override
	public void stop() {
		doInvariantAssert();
		selenium.stop();
	}

	@Override
	public void showContextualBanner() {
		doInvariantAssert();
		selenium.showContextualBanner();
	}

	@Override
	public void showContextualBanner(String className, String methodName) {
		doInvariantAssert();
		selenium.showContextualBanner(className, methodName);
	}

	@Override
	public void click(String locator) {
		doInvariantAssert();
		selenium.click(locator);
	}

	@Override
	public void doubleClick(String locator) {
		doInvariantAssert();
		selenium.doubleClick(locator);
	}

	@Override
	public void contextMenu(String locator) {
		doInvariantAssert();
		selenium.contextMenu(locator);
	}

	@Override
	public void clickAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.clickAt(locator, coordString);
	}

	@Override
	public void doubleClickAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.doubleClickAt(locator, coordString);
	}

	@Override
	public void contextMenuAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.contextMenuAt(locator, coordString);
	}

	@Override
	public void fireEvent(String locator, String eventName) {
		doInvariantAssert();
		selenium.fireEvent(locator, eventName);
	}

	@Override
	public void focus(String locator) {
		doInvariantAssert();
		selenium.focus(locator);
	}

	@Override
	public void keyPress(String locator, String keySequence) {
		doInvariantAssert();
		selenium.keyPress(locator, keySequence);
	}

	@Override
	public void shiftKeyDown() {
		doInvariantAssert();
		selenium.shiftKeyDown();
	}

	@Override
	public void shiftKeyUp() {
		doInvariantAssert();
		selenium.shiftKeyUp();
	}

	@Override
	public void metaKeyDown() {
		doInvariantAssert();
		selenium.metaKeyDown();
	}

	@Override
	public void metaKeyUp() {
		doInvariantAssert();
		selenium.metaKeyUp();
	}

	@Override
	public void altKeyDown() {
		doInvariantAssert();
		selenium.altKeyDown();
	}

	@Override
	public void altKeyUp() {
		doInvariantAssert();
		selenium.altKeyUp();
	}

	@Override
	public void controlKeyDown() {
		doInvariantAssert();
		selenium.controlKeyDown();
	}

	@Override
	public void controlKeyUp() {
		doInvariantAssert();
		selenium.controlKeyUp();
	}

	@Override
	public void keyDown(String locator, String keySequence) {
		doInvariantAssert();
		selenium.keyDown(locator, keySequence);
	}

	@Override
	public void keyUp(String locator, String keySequence) {
		doInvariantAssert();
		selenium.keyUp(locator, keySequence);
	}

	@Override
	public void mouseOver(String locator) {
		doInvariantAssert();
		selenium.mouseOver(locator);
	}

	@Override
	public void mouseOut(String locator) {
		doInvariantAssert();
		selenium.mouseOut(locator);
	}

	@Override
	public void mouseDown(String locator) {
		doInvariantAssert();
		selenium.mouseDown(locator);
	}

	@Override
	public void mouseDownRight(String locator) {
		doInvariantAssert();
		selenium.mouseDownRight(locator);
		
	}

	@Override
	public void mouseDownAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.mouseDownAt(locator, coordString);
		
	}

	@Override
	public void mouseDownRightAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.mouseDownRightAt(locator, coordString);
		
	}

	@Override
	public void mouseUp(String locator) {
		doInvariantAssert();
		selenium.mouseUp(locator);
		
	}

	@Override
	public void mouseUpRight(String locator) {
		doInvariantAssert();
		selenium.mouseUpRight(locator);
	}

	@Override
	public void mouseUpAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.mouseUpAt(locator, coordString);
	}

	@Override
	public void mouseUpRightAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.mouseUpRightAt(locator, coordString);
	}

	@Override
	public void mouseMove(String locator) {
		doInvariantAssert();
		selenium.mouseMove(locator);
	}

	@Override
	public void mouseMoveAt(String locator, String coordString) {
		doInvariantAssert();
		selenium.mouseMoveAt(locator, coordString);
	}

	@Override
	public void type(String locator, String value) {
		doInvariantAssert();
		selenium.type(locator, value);
	}

	@Override
	public void typeKeys(String locator, String value) {
		doInvariantAssert();
		selenium.typeKeys(locator, value);
	}

	@Override
	public void setSpeed(String value) {
		doInvariantAssert();
		selenium.setSpeed(value);
	}

	@Override
	public String getSpeed() {
		doInvariantAssert();
		return selenium.getSpeed();
	}

	@Override
	public String getLog() {
		doInvariantAssert();
		return selenium.getLog();
	}

	@Override
	public void check(String locator) {
		doInvariantAssert();
		selenium.check(locator);
	}

	@Override
	public void uncheck(String locator) {
		doInvariantAssert();
		selenium.uncheck(locator);
	}

	@Override
	public void select(String selectLocator, String optionLocator) {
		doInvariantAssert();
		selenium.select(selectLocator, optionLocator);
	}

	@Override
	public void addSelection(String locator, String optionLocator) {
		doInvariantAssert();
		selenium.addSelection(locator, optionLocator);	
	}

	@Override
	public void removeSelection(String locator, String optionLocator) {
		doInvariantAssert();
		selenium.removeSelection(locator, optionLocator);
	}

	@Override
	public void removeAllSelections(String locator) {
		doInvariantAssert();
		selenium.removeAllSelections(locator);
	}

	@Override
	public void submit(String formLocator) {
		doInvariantAssert();
		selenium.submit(formLocator);
	}

	@Override
	public void open(String url, String ignoreResponseCode) {
		doInvariantAssert();
		selenium.open(url, ignoreResponseCode);
	}

	@Override
	public void open(String url) {
		doInvariantAssert();
		selenium.open(url);
	}

	@Override
	public void openWindow(String url, String windowID) {
		doInvariantAssert();
		selenium.openWindow(url, windowID);
	}

	@Override
	public void selectWindow(String windowID) {
		doInvariantAssert();
		selenium.selectWindow(windowID);
	}

	@Override
	public void selectPopUp(String windowID) {
		doInvariantAssert();
		selenium.selectPopUp(windowID);
	}

	@Override
	public void deselectPopUp() {
		doInvariantAssert();
		selenium.deselectPopUp();
	}

	@Override
	public void selectFrame(String locator) {
		doInvariantAssert();
		selenium.selectFrame(locator);
	}

	@Override
	public boolean getWhetherThisFrameMatchFrameExpression(
			String currentFrameString, String target) {
		doInvariantAssert();
		return selenium.getWhetherThisFrameMatchFrameExpression(currentFrameString, target);
	}

	@Override
	public boolean getWhetherThisWindowMatchWindowExpression(
			String currentWindowString, String target) {
		doInvariantAssert();
		return selenium.getWhetherThisWindowMatchWindowExpression(currentWindowString, target);
	}

	@Override
	public void waitForPopUp(String windowID, String timeout) {
		doInvariantAssert();
		selenium.waitForPopUp(windowID, timeout);
	}

	@Override
	public void chooseCancelOnNextConfirmation() {
		doInvariantAssert();
		selenium.chooseCancelOnNextConfirmation();
	}

	@Override
	public void chooseOkOnNextConfirmation() {
		doInvariantAssert();
		selenium.chooseOkOnNextConfirmation();
	}

	@Override
	public void answerOnNextPrompt(String answer) {
		doInvariantAssert();
		selenium.answerOnNextPrompt(answer);
	}

	@Override
	public void goBack() {
		doInvariantAssert();
		selenium.goBack();
	}

	@Override
	public void refresh() {
		doInvariantAssert();
		selenium.refresh();
	}

	@Override
	public void close() {
		doInvariantAssert();
		selenium.close();
	}

	@Override
	public boolean isAlertPresent() {
		doInvariantAssert();
		return selenium.isAlertPresent();
	}

	@Override
	public boolean isPromptPresent() {
		doInvariantAssert();
		return selenium.isPromptPresent();
	}

	@Override
	public boolean isConfirmationPresent() {
		doInvariantAssert();
		return selenium.isConfirmationPresent();
	}

	@Override
	public String getAlert() {
		doInvariantAssert();
		return selenium.getAlert();
	}

	@Override
	public String getConfirmation() {
		doInvariantAssert();
		return selenium.getConfirmation();
	}

	@Override
	public String getPrompt() {
		doInvariantAssert();
		return selenium.getPrompt();
	}

	@Override
	public String getLocation() {
		doInvariantAssert();
		return selenium.getLocation();
	}

	@Override
	public String getTitle() {
		doInvariantAssert();
		return selenium.getTitle();
	}

	@Override
	public String getBodyText() {
		doInvariantAssert();
		return selenium.getBodyText();
	}

	@Override
	public String getValue(String locator) {
		doInvariantAssert();
		return selenium.getValue(locator);
	}

	@Override
	public String getText(String locator) {
		doInvariantAssert();
		return selenium.getText(locator);
	}

	@Override
	public void highlight(String locator) {
		doInvariantAssert();
		selenium.highlight(locator);
	}

	@Override
	public String getEval(String script) {
		doInvariantAssert();
		return selenium.getEval(script);
	}

	@Override
	public boolean isChecked(String locator) {
		doInvariantAssert();
		return selenium.isChecked(locator);
	}

	@Override
	public String getTable(String tableCellAddress) {
		doInvariantAssert();
		return selenium.getTable(tableCellAddress);
	}

	@Override
	public String[] getSelectedLabels(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedLabels(selectLocator);
	}

	@Override
	public String getSelectedLabel(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedLabel(selectLocator);
	}

	@Override
	public String[] getSelectedValues(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedValues(selectLocator);
	}

	@Override
	public String getSelectedValue(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedValue(selectLocator);
	}

	@Override
	public String[] getSelectedIndexes(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedIndexes(selectLocator);
	}

	@Override
	public String getSelectedIndex(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedIndex(selectLocator);
	}

	@Override
	public String[] getSelectedIds(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedIds(selectLocator);
	}

	@Override
	public String getSelectedId(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectedId(selectLocator);
	}

	@Override
	public boolean isSomethingSelected(String selectLocator) {
		doInvariantAssert();
		return selenium.isSomethingSelected(selectLocator);
	}

	@Override
	public String[] getSelectOptions(String selectLocator) {
		doInvariantAssert();
		return selenium.getSelectOptions(selectLocator);
	}

	@Override
	public String getAttribute(String attributeLocator) {
		doInvariantAssert();
		return selenium.getAttribute(attributeLocator);
	}

	@Override
	public boolean isTextPresent(String pattern) {
		doInvariantAssert();
		return selenium.isTextPresent(pattern);
	}

	@Override
	public boolean isElementPresent(String locator) {
		doInvariantAssert();
		return selenium.isElementPresent(locator);
	}

	@Override
	public boolean isVisible(String locator) {
		doInvariantAssert();
		return selenium.isVisible(locator);
	}

	@Override
	public boolean isEditable(String locator) {
		doInvariantAssert();
		return selenium.isEditable(locator);
	}

	@Override
	public String[] getAllButtons() {
		doInvariantAssert();
		return selenium.getAllButtons();
	}

	@Override
	public String[] getAllLinks() {
		doInvariantAssert();
		return selenium.getAllLinks();
	}

	@Override
	public String[] getAllFields() {
		doInvariantAssert();
		return selenium.getAllFields();
	}

	@Override
	public String[] getAttributeFromAllWindows(String attributeName) {
		doInvariantAssert();
		return selenium.getAttributeFromAllWindows(attributeName);
	}

	@Override
	public void dragdrop(String locator, String movementsString) {
		doInvariantAssert();
		selenium.dragdrop(locator, movementsString);
	}

	@Override
	public void setMouseSpeed(String pixels) {
		doInvariantAssert();
		selenium.setMouseSpeed(pixels);
	}

	@Override
	public Number getMouseSpeed() {
		doInvariantAssert();
		return selenium.getMouseSpeed();
	}

	@Override
	public void dragAndDrop(String locator, String movementsString) {
		doInvariantAssert();
		selenium.dragAndDrop(locator, movementsString);
	}

	@Override
	public void dragAndDropToObject(String locatorOfObjectToBeDragged,
			String locatorOfDragDestinationObject) {
		doInvariantAssert();
		selenium.dragAndDropToObject(locatorOfObjectToBeDragged, locatorOfDragDestinationObject);
	}

	@Override
	public void windowFocus() {
		doInvariantAssert();
		selenium.windowFocus();
	}

	@Override
	public void windowMaximize() {
		doInvariantAssert();
		selenium.windowMaximize();
	}

	@Override
	public String[] getAllWindowIds() {
		doInvariantAssert();
		return selenium.getAllWindowIds();
	}

	@Override
	public String[] getAllWindowNames() {
		doInvariantAssert();
		return selenium.getAllWindowNames();
	}

	@Override
	public String[] getAllWindowTitles() {
		doInvariantAssert();
		return selenium.getAllWindowTitles();
	}

	@Override
	public String getHtmlSource() {
		doInvariantAssert();
		return selenium.getHtmlSource();
	}

	@Override
	public void setCursorPosition(String locator, String position) {
		doInvariantAssert();
		selenium.setCursorPosition(locator, position);
	}

	@Override
	public Number getElementIndex(String locator) {
		doInvariantAssert();
		return selenium.getElementIndex(locator);
	}

	@Override
	public boolean isOrdered(String locator1, String locator2) {
		doInvariantAssert();
		return selenium.isOrdered(locator1, locator2);
	}

	@Override
	public Number getElementPositionLeft(String locator) {
		doInvariantAssert();
		return selenium.getElementPositionLeft(locator);
	}

	@Override
	public Number getElementPositionTop(String locator) {
		doInvariantAssert();
		return selenium.getElementPositionTop(locator);
	}

	@Override
	public Number getElementWidth(String locator) {
		doInvariantAssert();
		return selenium.getElementWidth(locator);
	}

	@Override
	public Number getElementHeight(String locator) {
		doInvariantAssert();
		return selenium.getElementHeight(locator);
	}

	@Override
	public Number getCursorPosition(String locator) {
		doInvariantAssert();
		return selenium.getCursorPosition(locator);
	}

	@Override
	public String getExpression(String expression) {
		doInvariantAssert();
		return selenium.getExpression(expression);
	}

	@Override
	public Number getXpathCount(String xpath) {
		doInvariantAssert();
		return selenium.getXpathCount(xpath);
	}

	@Override
	public Number getCssCount(String css) {
		doInvariantAssert();
		return selenium.getCssCount(css);
	}

	@Override
	public void assignId(String locator, String identifier) {
		doInvariantAssert();
		selenium.assignId(locator, identifier);
	}

	@Override
	public void allowNativeXpath(String allow) {
		doInvariantAssert();
		selenium.allowNativeXpath(allow);
	}

	@Override
	public void ignoreAttributesWithoutValue(String ignore) {
		doInvariantAssert();
		selenium.ignoreAttributesWithoutValue(ignore);
	}

	@Override
	public void waitForCondition(String script, String timeout) {
		doInvariantAssert();
		selenium.waitForCondition(script, timeout);
	}

	@Override
	public void setTimeout(String timeout) {
		doInvariantAssert();
		selenium.setTimeout(timeout);
	}

	@Override
	public void waitForPageToLoad(String timeout) {
		doInvariantAssert();
		selenium.waitForPageToLoad(timeout);
	}

	@Override
	public void waitForFrameToLoad(String frameAddress, String timeout) {
		doInvariantAssert();
		selenium.waitForFrameToLoad(frameAddress, timeout);
	}

	@Override
	public String getCookie() {
		doInvariantAssert();
		return selenium.getCookie();
	}

	@Override
	public String getCookieByName(String name) {
		doInvariantAssert();
		return selenium.getCookieByName(name);
	}

	@Override
	public boolean isCookiePresent(String name) {
		doInvariantAssert();
		return selenium.isCookiePresent(name);
	}

	@Override
	public void createCookie(String nameValuePair, String optionsString) {
		doInvariantAssert();
		selenium.createCookie(nameValuePair, optionsString);
	}

	@Override
	public void deleteCookie(String name, String optionsString) {
		doInvariantAssert();
		selenium.deleteCookie(name, optionsString);
	}

	@Override
	public void deleteAllVisibleCookies() {
		doInvariantAssert();
		selenium.deleteAllVisibleCookies();
	}

	@Override
	public void setBrowserLogLevel(String logLevel) {
		doInvariantAssert();
		selenium.setBrowserLogLevel(logLevel);
	}

	@Override
	public void runScript(String script) {
		doInvariantAssert();
		selenium.runScript(script);
	}

	@Override
	public void addLocationStrategy(String strategyName,
			String functionDefinition) {
		doInvariantAssert();
		selenium.addLocationStrategy(strategyName, functionDefinition);
	}

	@Override
	public void captureEntirePageScreenshot(String filename, String kwargs) {
		doInvariantAssert();
		selenium.captureEntirePageScreenshot(filename, kwargs);
	}

	@Override
	public void rollup(String rollupName, String kwargs) {
		doInvariantAssert();
		selenium.rollup(rollupName, kwargs);
	}

	@Override
	public void addScript(String scriptContent, String scriptTagId) {
		doInvariantAssert();
		selenium.addScript(scriptContent, scriptTagId);
	}

	@Override
	public void removeScript(String scriptTagId) {
		doInvariantAssert();
		selenium.removeScript(scriptTagId);
	}

	@Override
	public void useXpathLibrary(String libraryName) {
		doInvariantAssert();
		selenium.useXpathLibrary(libraryName);
	}

	@Override
	public void setContext(String context) {
		doInvariantAssert();
		selenium.setContext(context);
	}

	@Override
	public void attachFile(String fieldLocator, String fileLocator) {
		doInvariantAssert();
		selenium.attachFile(fieldLocator, fileLocator);
	}

	@Override
	public void captureScreenshot(String filename) {
		doInvariantAssert();
		selenium.captureScreenshot(filename);
	}

	@Override
	public String captureScreenshotToString() {
		doInvariantAssert();
		return selenium.captureScreenshotToString();
	}

	@Override
	public String captureNetworkTraffic(String type) {
		doInvariantAssert();
		return selenium.captureNetworkTraffic(type);
	}

	@Override
	public void addCustomRequestHeader(String key, String value) {
		doInvariantAssert();
		selenium.addCustomRequestHeader(key, value);
	}

	@Override
	public String captureEntirePageScreenshotToString(String kwargs) {
		doInvariantAssert();
		return selenium.captureEntirePageScreenshotToString(kwargs);
	}

	@Override
	public void shutDownSeleniumServer() {
		doInvariantAssert();
		selenium.shutDownSeleniumServer();
	}

	@Override
	public String retrieveLastRemoteControlLogs() {
		doInvariantAssert();
		return selenium.retrieveLastRemoteControlLogs();
	}

	@Override
	public void keyDownNative(String keycode) {
		doInvariantAssert();
		selenium.keyDownNative(keycode);
	}

	@Override
	public void keyUpNative(String keycode) {
		doInvariantAssert();
		selenium.keyUpNative(keycode);
	}

	@Override
	public void keyPressNative(String keycode) {
		doInvariantAssert();
		selenium.keyPressNative(keycode);
	}
	
	public void doInvariantAssert(){
		if(!(new Throwable().getStackTrace()[3].getMethodName().equals("assertInvariant"))){
			Class<?> thisclass = page.getClass();
			try {
				Method assertmethod = thisclass.getDeclaredMethod("assertInvariant");
				assertmethod.setAccessible(true);
				assertmethod.invoke(page);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.out.println("invariant assertion have args or you have no invariant asssert method");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
	}

}
