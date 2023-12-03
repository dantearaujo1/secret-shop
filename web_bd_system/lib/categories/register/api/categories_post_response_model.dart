class CategoriesPostResponseModel {
  final String id;

  CategoriesPostResponseModel(this.id);

  factory CategoriesPostResponseModel.fromJson(Map<String, dynamic> json) {
    return CategoriesPostResponseModel(json['id']);
  }
}
