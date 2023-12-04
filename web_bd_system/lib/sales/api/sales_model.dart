class SalesModel {
  final String id;
  final double total;

  SalesModel(this.id, this.total);

  factory SalesModel.fromJson(Map<String, dynamic> json) {
    return SalesModel(
      json['id'],
      json['total'],
    );
  }
}
