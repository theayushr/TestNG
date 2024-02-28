import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends Abstract{

    WebDriver driver;

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".col-lg-4.col-md-6") //find the products list
    List<WebElement> products;

    @FindBy(css = ".col-lg-4.col-md-6")
    WebElement showProduct;

    public List<WebElement> getProductsList() throws InterruptedException {
        waitToAppear(showProduct);
        Thread.sleep(2000);
        return products;
    }

    public WebElement getProductByName(String productName) throws InterruptedException {
        WebElement product = getProductsList().stream().filter(item ->
                item.findElement(By.cssSelector("b")).getText().
                        equals(productName)).findFirst().orElse(null);

        return product;
    }

    public void selectProduct(WebElement product) throws InterruptedException {
        Thread.sleep(5000);
        product.findElement(By.cssSelector("button:last-of-type")).click();
    }

    public void addToCart() throws InterruptedException{
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
    }
}
