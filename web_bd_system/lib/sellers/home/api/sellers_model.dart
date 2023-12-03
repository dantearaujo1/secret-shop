class SellersModel {
  final String id;
  final String name;
  final List<String> sales;

  SellersModel(this.id, this.name, this.sales);

  factory SellersModel.fromJson(Map<String, dynamic> json) {
    return SellersModel(
      json['id'],
      json['name'],
      (json['sales'] as List).map((e) => e as String).toList(),
    );
  }
}
