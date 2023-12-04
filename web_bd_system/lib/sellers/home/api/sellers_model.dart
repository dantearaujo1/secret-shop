class SellersModel {
  final String id;
  final String name;

  SellersModel(this.id, this.name);

  factory SellersModel.fromJson(Map<String, dynamic> json) {
    return SellersModel(
      json['id'],
      json['name'],
    );
  }
}
