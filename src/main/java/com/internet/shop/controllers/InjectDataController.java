package com.internet.shop.controllers;

import com.internet.shop.lib.Injector;
import com.internet.shop.model.Product;
import com.internet.shop.model.ShoppingCart;
import com.internet.shop.model.User;
import com.internet.shop.service.ProductService;
import com.internet.shop.service.ShoppingCartService;
import com.internet.shop.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inject")
public class InjectDataController extends HttpServlet {
    private static Injector injector = Injector.getInstance("com.internet.shop");
    private ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);
    private UserService userService =
            (UserService) injector.getInstance(UserService.class);
    private ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        User tod = new User("Tod", "Howard", "it`s just works");
        User alice = new User("Alice", "Madness", "returns");
        User john = new User("John", "Dou", "index");
        userService.create(tod);
        userService.create(alice);
        userService.create(john);

        Product iphoneX = new Product("Iphone X", 1000);
        productService.create(iphoneX);
        Product nokiaXxx = new Product("Nokia XXX", 150);
        productService.create(nokiaXxx);
        Product samsungS9 = new Product("Samsung S9", 500);
        productService.create(samsungS9);

        ShoppingCart aliceShoppingCart = new ShoppingCart(alice.getUserId());
        shoppingCartService.create(aliceShoppingCart);
        ShoppingCart johnShoppingCart = new ShoppingCart(john.getUserId());
        shoppingCartService.create(johnShoppingCart);
        ShoppingCart todShoppingCart = new ShoppingCart(tod.getUserId());
        shoppingCartService.create(todShoppingCart);

        req.getRequestDispatcher("/WEB-INF/views/inject.jsp").forward(req, resp);
    }
}
