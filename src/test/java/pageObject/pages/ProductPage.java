package pageObject.pages;

import pageObject.components.Product;

public class ProductPage {

    private Product product = new Product();

    public void selectProduct(int productId, String productSize){
        product.selectSize(productId, productSize);
    }

    public void selectColor(int productId, String productColor){
        product.selectColor(productId, productColor);
    }

    public void clickAddToCartButton(int productId){
        product.addToCart(productId);
    }
}
