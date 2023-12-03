class CategoriesUpdateResponseModel {
  final String id;

  CategoriesUpdateResponseModel(this.id);

  factory CategoriesUpdateResponseModel.fromJson(Map<String, dynamic> json) {
    return CategoriesUpdateResponseModel(json['id']);
  }
}
