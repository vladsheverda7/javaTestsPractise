package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageObject.components.Cart;
import pageObject.pages.LandingPage;
import pageObject.pages.ProductPage;

public class ProductAddingTest extends BaseTest {

    LandingPage landingPage = new LandingPage();
    ProductPage productPage = new ProductPage();
    Cart cart = new Cart();

    @Test
    void AddFirstMenJacket(){
        landingPage.open();
        landingPage.selectMenJackets();
        productPage.selectProductSize(1, "M");
        productPage.selectColor(1,"Blue");
        productPage.clickAddToCartButton(1);

        Assertions.assertEquals("1",cart.getCartQty());
    }

    @Test
    void AddSecondWomenTees(){
        landingPage.open();
        landingPage.selectWomenTees();
        productPage.selectProductSize(2, "M");
        productPage.selectColor(2,"Yellow");
        productPage.clickAddToCartButton(2);

        Assertions.assertEquals("1",cart.getCartQty());
    }

    @Test
    void AddThirdMenPants(){
        landingPage.open();
        landingPage.selectMenPants();
        productPage.selectProductSize(3, "34");
        productPage.selectColor(3,"Green");
        productPage.clickAddToCartButton(3);

        Assertions.assertEquals("1",cart.getCartQty());
    }
}
