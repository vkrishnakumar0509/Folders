package org.pojo;

import java.util.List;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPojo extends BaseMethods {

	public FavoritesPojo() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()=' Favorites']")
	private WebElement FavoritesLM;

	public WebElement getFavoritesLM() {
		return FavoritesLM;

	}

	@FindBy(xpath = "//table[@id='tableData']")
	private List<WebElement> FavoritesTable;

	public List<WebElement> getFavoritesTable() {
		return FavoritesTable;
	}

	@FindBy(xpath = "//li[@class='nav-item']/child::div")
	private List<WebElement> FavoritesViewIcons;

	public List<WebElement> getFavoritesViewIcons() {
		return FavoritesViewIcons;
	}
	
	@FindBy(xpath = "//ul[@id='select2-dt-length-1-results']/child::li")
	private List<WebElement> FavoritesPageEntriesDropdownValues;

	public List<WebElement> getFavoritesPageEntriesDropdownValues() {
		return FavoritesPageEntriesDropdownValues;
	}
	
	@FindBy(xpath = "(//span[@class='selection']) [4]")
	private WebElement FavoritesDropdownBtn;

	public WebElement getFavoritesDropdownBtn() {
		return FavoritesDropdownBtn;
	}
	
	@FindBy(xpath = "//div[@class='dt-length']/child::select")
	private WebElement FavoritesPageSelectDropdown;

	public WebElement getFavoritesPageSelectDropdown() {
		return FavoritesPageSelectDropdown;
	}
	
	@FindBy(xpath = "//div[@class='dt-search']/child::input")
	private WebElement searchBoxFav;

	public WebElement getSearchBoxFav() {
		return searchBoxFav;
	}	
}
