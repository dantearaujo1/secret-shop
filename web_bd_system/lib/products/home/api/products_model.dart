class ProductsModel {
  final String id;
  final String name;
  final double price;
  final String description;
  final String brand;

  ProductsModel(this.id, this.name, this.price, this.description, this.brand);

  factory ProductsModel.fromJson(Map<String, dynamic> json) {
    return ProductsModel(
      json['id'],
      json['name'],
      (json['price']),
      (json['description']),
      (json['brand']),
    );
  }
}
