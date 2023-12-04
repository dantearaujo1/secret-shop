import 'package:dio/dio.dart';
import 'package:web_bd_system/sellers/home/api/sellers_model.dart';

abstract class SellersService {
  Future<List<SellersModel>> getSellerss();
  Future<void> delete(String sellersId);
}

final class SellersServiceImpl implements SellersService {
  @override
  Future<List<SellersModel>> getSellerss() async {
    final dio = Dio();
    final response = await dio.get(
      'http://localhost/api/v1/seller',
    );
    try {
      List<SellersModel> sellers = (response.data as List)
          .map(
            (data) => SellersModel.fromJson(data),
          )
          .toList();
      return sellers;
    } catch (_) {
      throw TypeError();
    }
  }

  @override
  Future<void> delete(String sellersId) async {
    final dio = Dio();
    final response = await dio.delete(
      'http://localhost/api/v1/seller/$sellersId',
    );
    if (response.statusCode == 200) {
      return Future.value();
    } else {
      throw TypeError();
    }
  }
}
