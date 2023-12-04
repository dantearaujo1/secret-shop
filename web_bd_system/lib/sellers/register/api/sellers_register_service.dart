import 'package:dio/dio.dart';
import 'package:web_bd_system/sellers/register/api/sellers_post_model.dart';
import 'package:web_bd_system/sellers/register/api/sellers_post_response.dart';

abstract class SellersRegisterService {
  Future<String> createSellers(SellersPostModel model);
}

final class SellersRegisterServiceImpl implements SellersRegisterService {
  @override
  Future<String> createSellers(SellersPostModel model) async {
    final dio = Dio();
    Map<String, dynamic> requestData = {"name": model.nome};
    final response = await dio.post(
      'http://localhost/api/v1/seller/',
      data: requestData,
      options: Options(
        headers: {
          'Accept': '*/*',
          'Content-Type': 'application/json',
        },
      ),
    );
    try {
      final modelResponse = SellersPostResponseModel.fromJson(response.data);
      return modelResponse.id;
    } catch (e) {
      throw TypeError();
    }
  }
}
