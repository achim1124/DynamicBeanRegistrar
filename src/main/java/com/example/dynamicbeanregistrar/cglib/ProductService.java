package com.example.dynamicbeanregistrar.cglib;

public class ProductService {
	
	private ProductRepository productRepository = new ProductRepository();

	public Product findProductById(String id) {
		System.out.println("ProductService.findProductById");
		return new Product(id);
	}

	public boolean validate(Product product) {
		return true;
	}

	public class ProductRepository {
	}

	public class Product {
		private String productId;

		public Product(String productId) {
			this.productId = productId;
		}

		public String getProductId() {
			return productId;
		}
	}

}
