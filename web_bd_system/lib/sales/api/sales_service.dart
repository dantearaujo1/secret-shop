import 'package:dio/dio.dart';
import 'package:web_bd_system/sales/api/sales_model.dart';

abstract class SalesService {
  Future<List<SalesModel>> getSales();
}

final class SalesServiceImpl implements SalesService {
  @override
  Future<List<SalesModel>> getSales() async {
    final dio = Dio();
    final response = await dio.get(
      'http://localhost/api/v1/sell',
    );
    try {
      List<SalesModel> sales = (response.data as List)
          .map(
            (data) => SalesModel.fromJson(data),
          )
          .toList();
      return sales;
    } catch (_) {
      throw TypeError();
    }
  }
}
