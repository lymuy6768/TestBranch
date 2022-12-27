package stepDef;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import utilities.CommonMethod;

public class SearchTable extends CommonMethod {

	@Given("open browser")
	public void open_browser() {

		BaseClass.getDriver().get(BaseClass.getProperty("url"));
	}

	@When("User search for {string}")
	public void user_search_for(String string) {

		sendText(getSearchHomePage().searchBox, string);

	}

	@When("User click search button")
	public void user_click_search_button() {
		clickButton(getSearchHomePage().searchButton);

	}

	@Then("All the items with table name will show up")
	public void all_the_items_with_table_name_will_show_up() {

		List<WebElement> productList = getSearchHomePage().allProducts;

		for (int i = 0; i < productList.size(); i++) {

			Assert.assertTrue(productList.get(i).getText().contains("Table"));
		}
	}

	@Then("Add the last of found items to Cart")
	public void add_the_last_of_found_items_to_cart() {

		List<WebElement> productList = getSearchHomePage().allProducts;

		for (int i = 0; i < productList.size(); i++) {

			Assert.assertTrue(productList.get(i).getText().contains("Table"));
		}

		int lastProductIndex = productList.size() - 1;
		List<WebElement> addToCartButtons = getSearchHomePage().addToCart;
		scrollToElement(addToCartButtons.get(lastProductIndex));
		addToCartButtons.get(lastProductIndex).click();

	}

	@Then("Empty cart")
	public void empty_cart() {

		waitForinVisibility(getSearchHomePage().notificationPopUp);
		scrollToElement(getSearchHomePage().Cart);
		waitForVisibility(getSearchHomePage().Cart);
		waitForClickability(getSearchHomePage().Cart);

		jsClick(getSearchHomePage().Cart);

		jsClick(getSearchHomePage().emptyCartbutton);
		waitForVisibility(getSearchHomePage().greenEmptyCart);
		jsClick(getSearchHomePage().greenEmptyCart);

	}

	@Then("Your cart is Empty is displayed")
	public void your_cart_is_empty_is_displayed() {

		waitForVisibility(getSearchHomePage().yourCartIsEmpty);

		Assert.assertTrue("Failed!!Your cart is empty is not displayed on the page.",getSearchHomePage().yourCartIsEmpty.getText().equalsIgnoreCase("Your cart is empty."));
	}
}
