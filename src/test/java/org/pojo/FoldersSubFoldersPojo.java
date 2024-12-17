package org.pojo;

import java.util.List;

import org.base.BaseMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FoldersSubFoldersPojo extends BaseMethods{

	public FoldersSubFoldersPojo() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@id='folDropdownMenuLink']) [1]")
	private WebElement MainActions;
	
	@FindBy(xpath = "(//a[text()='Add Folder'])[1]")
	private WebElement MainAddFolder;
	
	@FindBy(xpath = "//input[@id='folder']")
	private WebElement NewFoldertxtbox;
	
	@FindBy(xpath = "//button[text()=' Create ']")
	private WebElement createbtn;
	
	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	private WebElement cancelbtn;
	
	@FindBy(xpath = "(//a[@class='close pull-right closeModal'])[2]")
	private WebElement closebtn;

	@FindBy(xpath = "(//i[@class='fa fa-angle-down'])[1]")
	private WebElement dropdownbtn;

	@FindBy(xpath = "//i[@class='fa fa-angle-down']")
	private WebElement DASHBOARDSdropdownbtn;
	

	@FindBy(xpath = "//span[text()=' DASHBOARDS ']")
	private WebElement DASHBOARDStxt;

	@FindBy(xpath = "//span[text()=' Testing ']/following::div[1]/child::div[1]/child::ul")
	private List<WebElement> TestingActionsList;

	public List<WebElement> getTestingActionsList() {
		return TestingActionsList;
	}

	@FindBy(xpath = "//span[text()=' Testing ']/following::div[1]/child::div[1]")
	private WebElement TestingActions;
	
	@FindBy(xpath = "//span[text()=' Test One1 ']/following::div[1]/child::div[1]")
	private WebElement Testing1Actions;
	
	public WebElement getTesting1Actions() {
		return Testing1Actions;
	}

	@FindBy(xpath = "(//a[text()='Add Folder'])[5]")
	private WebElement TestingAddFolder;
	
	@FindBy(xpath = "(//a[text()='Move Folder'])[5]")
	private WebElement TestingMoveFolder;
	
	@FindBy(xpath = "(//a[text()='Rename Folder'])[5]")
	private WebElement TestingRenameFolder;
	
	@FindBy(xpath = "(//a[text()='Delete Folder'])[5]")
	private WebElement TestingDeleteFolder;
	
	@FindBy(xpath = "(//button[text()='Cancel'])[3]")
	private WebElement TestingSDFCancel;
	
	@FindBy(xpath = "(//button[text()='Cancel'])[4]")
	private WebElement Testing1deleteCancel;
	
	public WebElement getTesting1deleteCancel() {
		return Testing1deleteCancel;
	}

	@FindBy(xpath = "//button[text()=' Move ']")
	private WebElement TestingSDFmove;
	
	@FindBy(xpath = "//span[text()='PathX - Sales Report']/following::a[1]")
	private WebElement PathXActionsbtn;
	
	@FindBy(xpath = "//span[text()='PathX - Sales Report']/following::ul[1]")
	private WebElement PathXActionsList;

	@FindBy(xpath = "(//a[text()='Add to Folder'])[2]")
	private WebElement PathXAddFolderbtn;
	
	@FindBy(xpath = "(//a[text()='Move File'])[2]")
	private WebElement PathXMoveFilebtn;
	
	public WebElement getPathXAddFolderbtn() {
		return PathXAddFolderbtn;
	}

	public WebElement getPathXMoveFilebtn() {
		return PathXMoveFilebtn;
	}

	public WebElement getPathXActionsbtn() {
		return PathXActionsbtn;
	}

	public WebElement getPathXActionsList() {
		return PathXActionsList;
	}

	@FindBy(xpath = "(//button[text()=' Update ']) [1]")
	private WebElement TestingUpdatebtn;
	
	@FindBy(xpath = "//button[text()=' Submit ']")
	private WebElement Testing1deletebtn;
	
	public WebElement getTesting1deletebtn() {
		return Testing1deletebtn;
	}

	public WebElement getTestingUpdatebtn() {
		return TestingUpdatebtn;
	}

	@FindBy(xpath = "(//i[@class='fa fa-folder-o f-14'])[1]/parent::div")
	private WebElement TestingSDFParentFolder;
	
	public WebElement getTestingSDFParentFolder() {
		return TestingSDFParentFolder;
	}

	@FindBy(xpath = "//div[@class='modal-body scroll-container']/child::div")
	private List<WebElement> Testingfolderlist;
	
	public List<WebElement> getTestingfolderlist() {
		return Testingfolderlist;
	}

	public WebElement getTestingSDFmove() {
		return TestingSDFmove;
	}

	public WebElement getTestingSDFCancel() {
		return TestingSDFCancel;
	}

	public WebElement getTestingAddFolder() {
		return TestingAddFolder;
	}

	public WebElement getTestingMoveFolder() {
		return TestingMoveFolder;
	}

	public WebElement getTestingRenameFolder() {
		return TestingRenameFolder;
	}

	public WebElement getTestingDeleteFolder() {
		return TestingDeleteFolder;
	}

	public WebElement getTestingActions() {
		return TestingActions;
	}

	public WebElement getDASHBOARDStxt() {
		return DASHBOARDStxt;
	}

	public WebElement getDASHBOARDSdropdownbtn() {
		return DASHBOARDSdropdownbtn;
	}

	public WebElement getMainActions() {
		return MainActions;
	}

	public WebElement getMainAddFolder() {
		return MainAddFolder;
	}

	public WebElement getNewFoldertxtbox() {
		return NewFoldertxtbox;
	}

	public WebElement getCreatebtn() {
		return createbtn;
	}

	public WebElement getCancelbtn() {
		return cancelbtn;
	}

	public WebElement getClosebtn() {
		return closebtn;
	}

	public WebElement getDropdownbtn() {
		return dropdownbtn;
	}
	
}
