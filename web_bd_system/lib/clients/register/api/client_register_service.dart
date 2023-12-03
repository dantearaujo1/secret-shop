import 'package:dio/dio.dart';
import 'package:web_bd_system/clients/register/api/client_post_model.dart';
import 'package:web_bd_system/clients/register/api/client_post_response_model.dart';

abstract class ClientRegisterService {
  Future<String> createClient(ClientPostModel model);
}

final class ClientRegisterServiceImpl implements ClientRegisterService {
  @override
  Future<String> createClient(ClientPostModel model) async {
    final dio = Dio();
    Map<String, dynamic> requestData = {
      "name": model.nome,
      "ddd": [model.ddd],
      "phone": [model.phone],
    };
    final response = await dio.post(
      'http://localhost:6969/api/v1/client/',
      data: requestData,
      options: Options(
        headers: {
          'Accept': '*/*',
          'Content-Type': 'application/json',
        },
      ),
    );
    try {
      final modelResponse = ClientPostResponseModel.fromJson(response.data);
      return modelResponse.id;
    } catch (e) {
      throw TypeError();
    }
  }
}
