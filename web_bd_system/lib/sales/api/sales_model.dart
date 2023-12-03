class SalesModel {
  final String id;
  final String name;
  final String description;

  SalesModel(this.id, this.name, this.description);

  factory SalesModel.fromJson(Map<String, dynamic> json) {
    return SalesModel(
      json['id'],
      json['name'],
      json['description'],
    );
  }
}
