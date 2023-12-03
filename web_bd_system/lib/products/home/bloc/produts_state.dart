import 'package:equatable/equatable.dart';
import 'package:web_bd_system/products/home/api/products_model.dart';

abstract class ProductsState extends Equatable {
  const ProductsState();

  @override
  List<Object?> get props => [];
}

final class ProductsLoadingState extends ProductsState {}

final class ProductsErrorState extends ProductsState {}

final class ProductsSuccessState extends ProductsState {
  final List<ProductsModel> products;

  const ProductsSuccessState(this.products);

  @override
  List<Object?> get props => [products];
}

final class ProductsDeletionSuccess extends ProductsState {}


final class ProductsDeletionError extends ProductsState {}