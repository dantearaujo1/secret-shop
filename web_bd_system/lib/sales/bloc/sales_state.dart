import 'package:equatable/equatable.dart';
import 'package:web_bd_system/sales/api/sales_model.dart';

abstract class SalesState extends Equatable {
  const SalesState();

  @override
  List<Object?> get props => [];
}

final class SalesLoadingState extends SalesState {}

final class SalesErrorState extends SalesState {}

final class SalesSuccessState extends SalesState {
  final List<SalesModel> sales;

  const SalesSuccessState(this.sales);

  @override
  List<Object?> get props => [sales];
}

final class SalesDeletionSuccess extends SalesState {}

final class SalesDeletionError extends SalesState {}
