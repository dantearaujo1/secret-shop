final class TemplateModel {
  final String content;

  TemplateModel(this.content);

  factory TemplateModel.fromJson(Map<String, dynamic> json) {
    return TemplateModel(
      json['content'],
    );
  }
}
