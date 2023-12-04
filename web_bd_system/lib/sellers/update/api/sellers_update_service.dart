import 'package:dio/dio.dart';
import 'package:web_bd_system/sellers/update/api/sellers_update_model.dart';
import 'package:web_bd_system/sellers/update/api/sellers_update_response_model.dart';

abstract class SellersUpdateService {
  Future<String> update(SellersUpdateModel model);
}

final class SellersUpdateServiceImpl implements SellersUpdateService {
  @override
  Future<String> update(SellersUpdateModel model) async {
    final dio = Dio();
    final id = model.id;

    Map<String, dynamic> requestData = {
      "name": model.name,
    };

    final response = await dio.put(
      'http://localhost/api/v1/seller/$id',
      data: requestData,
      options: Options(
        headers: {
          'Accept': '*/*',
          'Content-Type': 'application/json',
        },
      ),
    );

    try {
      final modelResponse = SellersUpdateResponseModel.fromJson(response.data);
      return modelResponse.id;
    } catch (e) {
      throw TypeError();
    }
  }
}
