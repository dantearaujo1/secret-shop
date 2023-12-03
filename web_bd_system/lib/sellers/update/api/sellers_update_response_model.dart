class SellersUpdateResponseModel {
  final String id;

  SellersUpdateResponseModel(this.id);

  factory SellersUpdateResponseModel.fromJson(Map<String, dynamic> json) {
    return SellersUpdateResponseModel(json['id']);
  }
}
