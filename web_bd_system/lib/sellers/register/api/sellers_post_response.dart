class SellersPostResponseModel {
  final String id;

  SellersPostResponseModel(this.id);

  factory SellersPostResponseModel.fromJson(Map<String, dynamic> json) {
    return SellersPostResponseModel(json['id']);
  }
}
