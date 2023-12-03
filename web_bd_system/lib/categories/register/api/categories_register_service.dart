import 'package:dio/dio.dart';
import 'package:uuid/uuid.dart';
import 'package:web_bd_system/categories/register/api/categories_post_model.dart';
import 'package:web_bd_system/categories/register/api/categories_post_response_model.dart';

abstract class CategoriesRegisterService {
  Future<String> createCategories(CategoriesPostModel model);
}

final class CategoriesRegisterServiceImpl implements CategoriesRegisterService {
  @override
  Future<String> createCategories(CategoriesPostModel model) async {
    final dio = Dio();
    const uuid = Uuid();
    final id = uuid.v4();
    
    Map<String, dynamic> requestData = {
      "categoryID": id,
      "name": model.name,
      "description": model.description,
    };

    final response = await dio.post(
      'http://localhost:6969/api/v1/product/category',
      data: requestData,
      options: Options(
        headers: {
          'Accept': '*/*',
          'Content-Type': 'application/json',
        },
      ),
    );

    try {
      final modelResponse = CategoriesPostResponseModel.fromJson(response.data);
      return modelResponse.id;
    } catch (e) {
      throw TypeError();
    }
  }
}
