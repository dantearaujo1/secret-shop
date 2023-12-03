class CategoriesProduct {
  final String id;
  final double price;
  final String name;
  final String description;
  final String brand;

  factory CategoriesProduct.fromJson(Map<String, dynamic> json) {
    return CategoriesProduct(
      json['id'],
      json['price'],
      json['name'],
      json['description'],
      json['brand'],
    );
  }

  CategoriesProduct(
      this.id, this.price, this.name, this.description, this.brand);
}

class CategoriesModel {
  final String id;
  final String name;
  final String description;
  final List<CategoriesProduct> products;

  CategoriesModel(this.id, this.name, this.description, this.products);

  factory CategoriesModel.fromJson(Map<String, dynamic> json) {
    return CategoriesModel(
      json['id'],
      json['name'],
      json['description'],
      (json['products'] as List)
          .map((contact) => CategoriesProduct.fromJson(contact))
          .toList(),
    );
  }
}
