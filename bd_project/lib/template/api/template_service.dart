import 'package:bd_project/template/api/template_model.dart';
import 'package:dio/dio.dart';

abstract class TemplateService {
  Future<String> getQuote();
}

final class TemplateServiceImpl implements TemplateService {
  @override
  Future<String> getQuote() async {
    final dio = Dio();
    final response = await dio.get('https://api.quotable.io/random');
    try {
      final quote = TemplateModel.fromJson(response.data);
      return quote.content;
    } catch (_) {
      throw TypeError();
    }
  }
}
