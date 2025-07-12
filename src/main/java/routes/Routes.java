package routes;

public class Routes {
	
	public static String baserUrl ="https://fakestoreapi.com";
	
	
	// Products
    public static String getAllProducts = "/products";
    public static String getSingleProduct = "/products/{id}";
    public static String getProductCategories = "/products/categories";
    public static String getProductsByCategory = "/products/category/{category}";
    public static String getLimitedProducts = "/products?limit={limit}";
    public static String getSortedProducts = "/products?sort={sort}";
    public static String addNewProduct = "/products";
    public static String updateProduct = "/products/{id}";
    public static String patchProduct = "/products/{id}";
    public static String deleteProduct = "/products/{id}";
    
    // Carts
    public static String getAllCarts = "/carts";
    public static String getSingleCart = "/carts/{id}";
    public static String getLimitedCarts = "/carts?limit={limit}";
    public static String getSortedCarts = "/carts?sort={sort}";
    public static String getCartsByDate = "/carts?startdate={start}&enddate={end}";
    public static String getCartsByUser = "/carts/user/{userId}";
    public static String addNewCart = "/carts";
    public static String updateCart = "/carts/{id}";
    public static String patchCart = "/carts/{id}";
    public static String deleteCart = "/carts/{id}";

    // Users
    public static String getAllUsers = "/users";
    public static String getSingleUser = "/users/{id}";
    public static String getLimitedUsers = "/users?limit={limit}";
    public static String getSortedUsers = "/users?sort={sort}";
    public static String addNewUser = "/users";
    public static String updateUser = "/users/{id}";
    public static String patchUser = "/users/{id}";
    public static String deleteUser = "/users/{id}";

    // Authentication
    public static String login = "/auth/login";


}
