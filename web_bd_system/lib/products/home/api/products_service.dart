import 'package:dio/dio.dart';
import 'package:web_bd_system/products/home/api/products_model.dart';

abstract class ProductsService {
  Future<List<ProductsModel>> getProducts();
  Future<void> delete(String productId);
}

final class ProductsServiceImpl implements ProductsService {
  @override
  Future<List<ProductsModel>> getProducts() async {
    final dio = Dio();
    final response = await dio.get(
      'http://localhost/api/v1/product',
    );
    try {
      List<ProductsModel> products = (response.data as List)
          .map(
            (data) => ProductsModel.fromJson(data),
          )
          .toList();
      return products;
    } catch (_) {
      throw TypeError();
    }
  }

  @override
  Future<void> delete(String productsId) async {
    final dio = Dio();
    final response =
        await dio.delete('http://localhost/api/v1/product/$productsId');
    if (response.statusCode == 200) {
      return Future.value();
    } else {
      throw TypeError();
    }
  }
}
