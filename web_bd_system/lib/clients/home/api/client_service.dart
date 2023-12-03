import 'package:dio/dio.dart';
import 'package:web_bd_system/clients/home/api/client_model.dart';

abstract class ClientService {
  Future<List<ClientModel>> getClients();
  Future<void> delete(String clientId);
}

final class ClientServiceImpl implements ClientService {
  @override
  Future<List<ClientModel>> getClients() async {
    final dio = Dio();
    final response = await dio.get(
      'http://localhost:6969/api/v1/client',
    );
    try {
      List<ClientModel> clients = (response.data as List)
          .map(
            (data) => ClientModel.fromJson(data),
          )
          .toList();
      return clients;
    } catch (_) {
      throw TypeError();
    }
  }
  
  @override
  Future<void> delete(String clientId) async {
    final dio = Dio();
    final response = await dio.delete('http://localhost:6969/api/v1/client/$clientId');
    if (response.statusCode == 200) {
      return Future.value();
    } else {
      throw TypeError();
    }
  }
}
