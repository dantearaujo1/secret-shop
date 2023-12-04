import 'package:dio/dio.dart';
import 'package:web_bd_system/categories/home/api/categories_model.dart';

abstract class CategoriesService {
  Future<List<CategoriesModel>> getCategories();
  Future<void> delete(String categoryId);
}

final class CategoriesServiceImpl implements CategoriesService {
  @override
  Future<List<CategoriesModel>> getCategories() async {
    final dio = Dio();
    final response = await dio.get(
      'http://localhost/api/v1/product/category',
    );
    try {
      List<CategoriesModel> categories = (response.data as List)
          .map(
            (data) => CategoriesModel.fromJson(data),
          )
          .toList();
      return categories;
    } catch (_) {
      throw TypeError();
    }
  }

  @override
  Future<void> delete(String categoryId) async {
    final dio = Dio();
    final response = await dio
        .delete('http://localhost/api/v1/product/category/$categoryId');
    if (response.statusCode == 200) {
      return Future.value();
    } else {
      throw TypeError();
    }
  }
}
