#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package pages

import org.jbehave.web.selenium.WebDriverProvider
import org.jbehave.web.selenium.GroovyGebFluentWebDriverPage
import org.openqa.selenium.By

class CartContents extends GroovyGebFluentWebDriverPage {

  Site site

  def CartContents(WebDriverProvider webDriverProvider) {
    super(webDriverProvider)
  }

  def hasItem(String item) {
    go "http://www.etsy.com/cart"
    try {
      ${symbol_dollar}("div${symbol_pound}listing-${symbol_dollar}item")
    } catch (ex) {
      return false // could also be that html has changed
    }
    return true
  }

  def removeItem() {
    go "http://www.etsy.com/cart"
    findElement(By.cssSelector("li.action-remove")).findElement(By.tagName("a")).click()
  }
}