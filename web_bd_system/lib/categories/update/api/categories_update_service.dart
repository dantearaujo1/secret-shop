import 'package:dio/dio.dart';
import 'package:web_bd_system/categories/update/api/categories_update_model.dart';
import 'package:web_bd_system/categories/update/api/categories_update_response_model.dart';

abstract class CategoriesUpdateService {
  Future<String> update(CategoriesUpdateModel model);
}

final class CategoriesUpdateServiceImpl implements CategoriesUpdateService {
  @override
  Future<String> update(CategoriesUpdateModel model) async {
    final dio = Dio();
    final id = model.id;

    Map<String, dynamic> requestData = {
      "categoryID": id,
      "name": model.name,
      "description": model.description,
    };

    final response = await dio.put(
      'http://localhost/api/v1/product/category/$id',
      data: requestData,
      options: Options(
        headers: {
          'Accept': '*/*',
          'Content-Type': 'application/json',
        },
      ),
    );

    try {
      final modelResponse = CategoriesUpdateResponseModel.fromJson(response.data);
      return modelResponse.id;
    } catch (e) {
      throw TypeError();
    }
  }
}
