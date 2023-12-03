import 'package:equatable/equatable.dart';

abstract class ProductsEvent extends Equatable {
  const ProductsEvent();

  @override
  List<Object?> get props => [];
}

final class ProductsRequestEvent extends ProductsEvent {}

final class ProductsRequestDeleteEvent extends ProductsEvent {
  final String id;

  const ProductsRequestDeleteEvent(this.id);

  @override
  List<Object?> get props => [id];
}