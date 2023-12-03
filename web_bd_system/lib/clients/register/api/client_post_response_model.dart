class ClientPostResponseModel {
  final String id;

  ClientPostResponseModel(this.id);

  factory ClientPostResponseModel.fromJson(Map<String, dynamic> json) {
    return ClientPostResponseModel(json['id']);
  }
}
